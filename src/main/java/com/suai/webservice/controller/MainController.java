package com.suai.webservice.controller;

import com.suai.webservice.domain.Article;
import com.suai.webservice.repos.ArticleRepo;
import com.suai.webservice.repos.MessageRepo;
import com.suai.webservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private UserRepo userRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "main";
    }
}