package com.example.manytomany;


import com.example.manytomany.model.Article;
import com.example.manytomany.model.User;
import com.example.manytomany.repo.ArticleRepo;
import com.example.manytomany.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RelazioniApiController {

    @Autowired
    UserRepo repo;

    @Autowired
    ArticleRepo articleRepo;

    @GetMapping("/api/v1/users")
    ArrayList<User> userList(){
        ArrayList<User> users = (ArrayList<User>) repo.findAll();
        return users;
    }

    @PostMapping("/api/v1/users")
    User newUser(@RequestBody User user){
        User userSave = repo.save(user);
        for (Article article : user.getArticles()){
            ArrayList<User> users =  new ArrayList<>();
            users.add(userSave);
            article.setUsers(users);
            articleRepo.save(article);
        }
        return userSave;
    }

    @GetMapping("/api/v1/users/{id}")
    User getUser(@PathVariable Long id){
        return repo.findById(id).get();
    }

}
