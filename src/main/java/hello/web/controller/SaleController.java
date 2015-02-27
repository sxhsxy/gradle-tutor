package hello.web.controller;

import hello.domain.Sale;
import hello.repository.SaleRepository;
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

import static java.util.Collections.singletonList;

/**
 * Created by xiaohu on 2015/2/13.
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleRepository saleRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Sale> listSale(Pageable page) {
        return saleRepository.findAll(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Sale read(@PathVariable("id") Long id) {
        return saleRepository.findOne(id);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSale(@PathVariable("id") Long id, @RequestBody Sale sale) {
        if (saleRepository.exists(id)) {
            sale.setId(id);
            saleRepository.save(sale);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createSale(HttpServletRequest request, @RequestBody Sale sale) {
        saleRepository.saveAndFlush(sale);
        final Long id = sale.getId();

        URI uri = new UriTemplate("{requestUrl}/{id}").expand(request.getRequestURL().toString(), id);
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", singletonList(uri.toASCIIString()));
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable("id") Long id) {
        saleRepository.delete(id);
    }
}
