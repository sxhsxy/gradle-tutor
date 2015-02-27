package hello.web.controller;/**
 * Created by Xiaohu on 2015/2/27.
 */

import hello.domain.Staff;
import hello.repository.StaffRepository;
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
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffRepository staffRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Staff> listStaff(Pageable page) {
        return staffRepository.findAll(page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Staff read(@PathVariable("id") Long id) {
        return staffRepository.findOne(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff) {
        if (staffRepository.exists(id)) {
            staff.setId(id);
            staffRepository.save(staff);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createStaff(HttpServletRequest request, @RequestBody Staff staff) {
        staffRepository.saveAndFlush(staff);
        final Long id = staff.getId();

        URI uri = new UriTemplate("{requestUrl}/{id}").expand(request.getRequestURL().toString(), id);
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", singletonList(uri.toASCIIString()));
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStaff(@PathVariable("id") Long id) {
        staffRepository.delete(id);
    }
}
