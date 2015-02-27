package hello.web.controller;/**
 * Created by Xiaohu on 2015/2/27.
 */

import hello.domain.Supplier;
import hello.repository.SupplierRepository;
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
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierRepository supplierRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Supplier> listSupplier(Pageable page) {
        return supplierRepository.findAll(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Supplier read(@PathVariable("id") Long id) {
        return supplierRepository.findOne(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSupplier(@PathVariable("id") Long id, @RequestBody Supplier supplier) {
        if (supplierRepository.exists(id)) {
            supplier.setId(id);
            supplierRepository.save(supplier);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createSupplier(HttpServletRequest request, @RequestBody Supplier supplier) {
        supplierRepository.saveAndFlush(supplier);
        final Long id = supplier.getId();

        URI uri = new UriTemplate("{requestUrl}/{id}").expand(request.getRequestURL().toString(), id);
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", singletonList(uri.toASCIIString()));
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupplier(@PathVariable("id") Long id) {
        supplierRepository.delete(id);
    }
}
