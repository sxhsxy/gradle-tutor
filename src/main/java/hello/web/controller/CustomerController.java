package hello.web.controller;/**
 * Created by Xiaohu on 2015/2/27.
 */

import hello.domain.Customer;
import hello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Customer> listCustomer(Pageable page) {
        return customerRepository.findAll(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Customer read(@PathVariable("id") Long id) {
        return customerRepository.findOne(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        if (customerRepository.exists(id)) {
            customer.setId(id);
            customerRepository.save(customer);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createCustomer(HttpServletRequest request, @RequestBody Customer customer) {
        customerRepository.saveAndFlush(customer);
        final Long id = customer.getId();

        URI uri = new UriTemplate("{requestUrl}/{id}").expand(request.getRequestURL().toString(), id);
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", singletonList(uri.toASCIIString()));
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerRepository.delete(id);
    }
}
