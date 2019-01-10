package com.suai.webservice.domain;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Long date;
    private ArrayList<String>keyWords =  new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Article() {
    }

    public Article(String title, User user, Long date){
        this.title = title;
        this.author = user;
        this.date = date;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean findWord(String word){
        if(keyWords == null){
            return false;
        }
        for (String a : keyWords){
            if (a.equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }

    public void deleteWords(){
        keyWords.clear();
    }
}
