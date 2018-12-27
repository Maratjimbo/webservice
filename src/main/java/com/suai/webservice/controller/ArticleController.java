package com.suai.webservice.controller;

import com.suai.webservice.domain.Article;
import com.suai.webservice.domain.User;
import com.suai.webservice.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepo articleRepo;

    @GetMapping("/article")
    public String article(Map<String, Object> model){
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "article";
    }

    @PostMapping("/article")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) throws IOException {

        if(text.isEmpty()){
            Iterable<Article> articles = articleRepo.findAll();

            model.put("articles", articles);

            return "article";
        }

        Article article = new Article(text, user);

        articleRepo.save(article);

        Iterable<Article> articles = articleRepo.findAll();

        model.put("articles", articles);

        return "article";
    }
}
