package com.example.advancelearningapp.datamodel.repo;

import com.example.advancelearningapp.datamodel.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User,String> {
    User findByEmailAndPassword(String email, String password);
}
