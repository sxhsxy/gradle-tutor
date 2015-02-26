package hello.web.controller;

import hello.domain.Commodity;
import hello.repository.CommodityRepository;
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
import java.awt.print.Book;
import java.net.URI;

import static java.util.Collections.singletonList;

/**
 * Created by xiaohu on 2015/2/13.
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    CommodityRepository commodityRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Commodity> listCommodity(Pageable page) {
        return commodityRepository.findAll(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Commodity read(@PathVariable("id") Long id) {
        return commodityRepository.findOne(id);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCommodity(@PathVariable("id") Long id, @RequestBody Commodity commodity) {
        if (commodityRepository.exists(id)) {
            commodity.setId(id);
            commodityRepository.save(commodity);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createCommodity(HttpServletRequest request, @RequestBody Commodity commodity) {
        commodityRepository.saveAndFlush(commodity);
        final Long id = commodity.getId();

        URI uri = new UriTemplate("{requestUrl}/{id}").expand(request.getRequestURL().toString(), id);
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", singletonList(uri.toASCIIString()));
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommodity(@PathVariable("id") Long id) {
        commodityRepository.delete(id);
    }
}
