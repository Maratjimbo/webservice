package com.suai.webservice.repos;

import com.suai.webservice.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticleRepo extends CrudRepository<Article, Long> {

}
