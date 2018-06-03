package com.example.spring_boot_server.Controller;

import com.example.spring_boot_server.Dao.SignInDao;
import com.example.spring_boot_server.Dao.SignUpDao;
import com.example.spring_boot_server.Model.SignIn;
import com.example.spring_boot_server.Model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private SignUpDao signUpDao;

    @Autowired
    private SignInDao signInDao;

    @RequestMapping("/")
    private String index() {
        return "Hello Spring Boot +JPA + Hibernate + PostGreSQL Demo World";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    private String add(@RequestParam(name = "username") String username,
                       @RequestParam(name = "email") String email,
                       @RequestParam(name = "phoneNo") String phoneNo,
                       @RequestParam(name = "gender") String gender,
                       @RequestParam(name = "country") String country,
                       @RequestParam(name = "password") String password) {
        signUpDao.save(new SignUp(username, email, phoneNo, gender, country, password));
        return "Saved Record Successfully";
    }

    @RequestMapping("/get")
    private String get(@RequestParam Long id) {
        return signUpDao.findById(id).toString();
    }

    @RequestMapping("/getAll")
    private String getAll() {
        return signUpDao.findAll().toString();
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    private String signIn(@RequestParam(name = "email") String email,
                          @RequestParam(name = "password") String password) {
        return signInDao.save(new SignIn(email, password)).toString();
    }

}
