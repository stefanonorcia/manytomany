package com.example.manytomany.repo;

import com.example.manytomany.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
