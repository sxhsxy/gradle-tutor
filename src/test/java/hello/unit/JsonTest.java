package hello.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.domain.Commodity;
import hello.repository.CommodityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Xiaohu on 2015/2/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class JsonTest {
    @Autowired
    private CommodityRepository commodityRepository;
    @Test
    public void prepareData() {
        Page<Commodity> page = commodityRepository.findAll(new PageRequest(0,2));
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new String();
        try {
            jsonString = mapper.writeValueAsString(page);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);
    }
}
