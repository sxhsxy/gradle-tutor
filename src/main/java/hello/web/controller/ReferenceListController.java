package hello.web.controller;

import hello.domain.Commodity;
import hello.domain.Customer;
import hello.domain.Staff;
import hello.domain.Supplier;
import hello.repository.CommodityRepository;
import hello.repository.CustomerRepository;
import hello.repository.StaffRepository;
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
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * Created by xiaohu on 2015/2/13.
 */
@Controller
@RequestMapping("/reference")
public class ReferenceListController {
    @Autowired
    CommodityRepository commodityRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    StaffRepository staffRepository;

    @RequestMapping(value = "/commodity", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Commodity> listCommodity() {
        return commodityRepository.findAll();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/supplier", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Supplier> listSupplier() {
        return supplierRepository.findAll();
    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Staff> listStaff() {
        return staffRepository.findAll();
    }
}

