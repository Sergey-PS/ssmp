package mn;

import mn.api.response.PlatformLanguageApi;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlatformControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getMessage1() throws Exception {
        List<PlatformLanguageApi> listLanguage = new ArrayList<>();

        listLanguage.add(new PlatformLanguageApi(1,"Russian"));


        mvc.perform(MockMvcRequestBuilders.get("/api/v1/platform/languages?language=eng").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error", Matchers.is("done")))
                .andExpect(jsonPath("$.total", Matchers.is(3)))
                .andExpect(jsonPath("$.offset",Matchers.is(0)))
                .andExpect(jsonPath("$.perPage",Matchers.is(20)))
                .andExpect(jsonPath("$.data[0].id",Matchers.is(1)));
    }


}
