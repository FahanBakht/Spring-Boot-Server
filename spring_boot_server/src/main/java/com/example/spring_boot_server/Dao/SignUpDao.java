package com.example.spring_boot_server.Dao;

import com.example.spring_boot_server.Model.SignUp;
import org.springframework.data.repository.CrudRepository;

public interface SignUpDao extends CrudRepository<SignUp, Long> {
}
