package hello.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by xiaohu on 2015/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp/WEB-INF/springmvc-servlet.xml")
@ContextConfiguration()
public class MockMvcTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void getJsonData() throws Exception
    {
        System.out.println("返回json。。。。。。。。。。。");


        ResultActions actions = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/data.json").param("name", "DDDDDDD").accept(
                        MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());


        System.out.println("测试成功");

    }
}
