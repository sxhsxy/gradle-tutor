package hello.web.controller;

import hello.domain.Receipt;
import hello.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.sql.Timestamp;

import static java.util.Collections.singletonList;

/**
 * Created by xiaohu on 2015/2/13.
 */
@Controller
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    ReceiptRepository receiptRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Receipt> listReceipt(Pageable page) {
        return receiptRepository.findAll(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Receipt read(@PathVariable("id") Long id) {
        return receiptRepository.findOne(id);
    }


//TODO: nested json object deserialization.
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReceipt(@PathVariable("id") Long id, @RequestBody Receipt receipt) {
        if (receiptRepository.exists(id)) {
            receipt.setId(id);
            receipt.setCreateTime(new Timestamp(System.currentTimeMillis()));
            receiptRepository.save(receipt);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createReceipt(HttpServletRequest request, @RequestBody Receipt receipt) {
        receipt.setCreateTime(new Timestamp(System.currentTimeMillis()));
        receiptRepository.saveAndFlush(receipt);
        final Long id = receipt.getId();

        URI uri = new UriTemplate("{requestUrl}/{id}").expand(request.getRequestURL().toString(), id);
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", singletonList(uri.toASCIIString()));
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReceipt(@PathVariable("id") Long id) {
        receiptRepository.delete(id);
    }
}
