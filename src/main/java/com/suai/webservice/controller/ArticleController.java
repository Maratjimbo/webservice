package com.suai.webservice.controller;

import com.suai.webservice.domain.Article;
import com.suai.webservice.domain.User;
import com.suai.webservice.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepo articleRepo;

    @PostMapping("/showArticle")
    public String show(Map<String, Object> model,
                          @RequestParam Long id){
        Iterable<Article> articles = articleRepo.findAll();
        Article cur_article = null;

        for(Article article : articles){
            if(article.getId() == id){
                cur_article = article;
                break;
            }
        }
        model.put("title", cur_article.getTitle());
        model.put("author", cur_article.getAuthorName());
        model.put("text", cur_article.getText());
        return "one";
    }

    @PostMapping("/article")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) throws IOException {

        if(text.isEmpty() || title.isEmpty()){
            Iterable<Article> articles = articleRepo.findAll();

            model.put("articles", articles);

            return "article";
        }

        Article article = new Article(text, title, user);

        String [] words = tag.split("[,:;.!?\\s]+");
        for (String word : words){
            article.setKeyWords(word);
        }

        articleRepo.save(article);

        Iterable<Article> articles = articleRepo.findAll();

        model.put("articles", articles);

        return "article";
    }
}
