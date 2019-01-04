package com.suai.webservice.controller;


import com.suai.webservice.domain.Article;
import com.suai.webservice.repos.ArticleRepo;
import com.suai.webservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/search")
    public String searchArticle(Map<String, Object> model,
                                @RequestParam (required = false, defaultValue = "") String authorName,
                                @RequestParam (required = false, defaultValue = "") String date,
                                @RequestParam (required = false, defaultValue = "") String word,
                                @RequestParam (required = false, defaultValue = "") String title){
        Iterable<Article> articles = articleRepo.findAll();

        ArrayList<Article> cur_articles = new ArrayList<Article>();

        if(date != null && !date.isEmpty()){
            for(Article article : articles){
                if(article.getDate() == null){
                    continue;
                }
                if (article.getDate().toString().equalsIgnoreCase(date)){
                    cur_articles.add(article);
                }
            }
        }

        else if(authorName != null && !authorName.isEmpty()){
            for(Article article : articles){
                if (article.getAuthorName().equalsIgnoreCase(authorName)){
                    cur_articles.add(article);
                }
            }
        }

        else if(title != null && !title.isEmpty()){
            for(Article article : articles){
                if (article.getTitle().equalsIgnoreCase(title)){
                    cur_articles.add(article);
                }
            }
        }

        else if(word != null && !word.isEmpty()){
            String [] words = word.split("[,:;.!?\\s]+");
            for(Article article : articles){
                for(String cur_word : words){
                    if(article.findWord(cur_word)){
                        cur_articles.add(article);
                    }
                }
            }
        }

        if(cur_articles.size() != 0) {
            model.put("articles", cur_articles);
        }
        else {
            model.put("message", "Не найдено ни одной статьи");
        }
        return "search";
    }

}
