package com.example.spring_boot_server.Dao;

import com.example.spring_boot_server.Model.SignIn;
import org.springframework.data.repository.CrudRepository;

public interface SignInDao extends CrudRepository<SignIn, Long> {
}
