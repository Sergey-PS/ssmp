package mn;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlatformControllerTest {
    @Autowired
    private MockMvc mvc;

    public PlatformControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    public void getLanguages1() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/platform/languages")
                .accept(MediaType.APPLICATION_JSON_UTF8).param("language","an").param("offset","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error", Matchers.is("done")))
                .andExpect(jsonPath("$.total", Matchers.is(4)))
                .andExpect(jsonPath("$.offset",Matchers.is(1)))
                .andExpect(jsonPath("$.perPage",Matchers.is(20)))
                .andExpect(jsonPath("$.data[0].id",Matchers.is(3)));
    }

    @Test
    public void getLanguages2() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/platform/languages")
                .accept(MediaType.APPLICATION_JSON_UTF8).param("language","an").param("offset","5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total", Matchers.is(4)))
                .andExpect(jsonPath("$.offset",Matchers.is(5)))
                .andExpect(jsonPath("$.perPage",Matchers.is(20)))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    public void getLanguages3() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/platform/languages")
                .accept(MediaType.APPLICATION_JSON_UTF8).param("language","").param("itemPerPage","2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error", Matchers.is("done")))
                .andExpect(jsonPath("$.total", Matchers.is(4)))
                .andExpect(jsonPath("$.offset",Matchers.is(0)))
                .andExpect(jsonPath("$.perPage",Matchers.is(2)))
                .andExpect(jsonPath("$.data.size()").value(2));
    }

}
