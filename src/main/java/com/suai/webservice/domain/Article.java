package com.suai.webservice.domain;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String text;

    private ArrayList<String>keyWords;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Article() {
    }

    public Article(String text, String title, User user){
        this.text = text;
        this.title = title;
        this.author = user;
        this.keyWords = new ArrayList<>();
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords.add(keyWords);
    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean findWord(String word){
        for (String a : keyWords){
            if (a.equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }
}
