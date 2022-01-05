package com.example.manytomany.repo;

import com.example.manytomany.model.Article;
import com.example.manytomany.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Long> {
}
