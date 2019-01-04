package com.suai.webservice.controller;

import com.suai.webservice.domain.Article;
import com.suai.webservice.domain.User;
import com.suai.webservice.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepo articleRepo;

    @Value("${upload.path}")
    private String uploadPath;

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

        if(cur_article.getTitle() != null){
            model.put("title", cur_article.getTitle());
        }
        model.put("author", cur_article.getAuthorName());
        if(cur_article.getDate() != null){
            model.put("date", cur_article.getDate().toString());
        }
        if(cur_article.getFilename() != null){
            model.put("file", cur_article.getFilename());
        }

        return "one";
    }

    @PostMapping("/article")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam Long date,
            @RequestParam String tag,
            @RequestParam ("file") MultipartFile file
    ) throws IOException {

        if(title.isEmpty()){
            return "article";
        }

        Article article = new Article(title, user, date);

        String [] words = tag.split("[,:;.!?\\s]+");
        for (String word : words){
            article.setKeyWords(word);
        }

        if(file != null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);

            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            article.setFilename(resultFilename);
        }
        articleRepo.save(article);

        return "article";
    }

    @GetMapping("/article")
    public String article(){
        return "article";
    }

    @GetMapping("/allArticle")
    public String allArticle(@AuthenticationPrincipal User user,
                             Map<String, Object> model){
        Iterable<Article> articles = articleRepo.findAll();
        ArrayList<Article> myArticles = new ArrayList<>();

        for(Article article : articles){
            if(article.getAuthorName().equalsIgnoreCase(user.getUsername())){
                myArticles.add(article);
            }
        }

        if(!myArticles.isEmpty()) {
            model.put("articles", myArticles);
        }else{
            model.put("message", "У вас нет ни одной опубликованной статьи");
        }
        return "allArticle";
    }

    @PostMapping("/allArticle")
    public String delete(@RequestParam Long id){
        articleRepo.deleteById(id);
        return "redirect:/allArticle";
    }
}
