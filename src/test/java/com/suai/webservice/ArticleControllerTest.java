package com.suai.webservice;

import com.suai.webservice.repos.ArticleRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("Marat")
public class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addArticlePageTest() throws Exception {
        this.mockMvc.perform(get("/article"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated());
    }


    @Test
    public void allArticlePageTest() throws Exception{
        this.mockMvc.perform(get("/allArticle"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated());
    }

}


