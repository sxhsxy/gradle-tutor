package hello.web.controller;

import hello.domain.Commodity;
import hello.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Page<Commodity> listCommodity(Pageable pageRequest) {
        return commodityRepository.findAll(pageRequest);
    }
}
