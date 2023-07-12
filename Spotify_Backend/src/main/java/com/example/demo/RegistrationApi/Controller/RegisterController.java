package com.example.demo.RegistrationApi.Controller;

import com.example.demo.RegistrationApi.Model.RegistrationModel;
import com.example.demo.RegistrationApi.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotifyClone")
public class RegisterController {

    @Autowired
    private RegistrationService service;

    @PostMapping(value = "/addUser")
    public ResponseEntity<RegistrationModel> addUser(@RequestBody RegistrationModel model){
        RegistrationModel newUser=service.addUser(model);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping(value = "/logIn")
    public ResponseEntity<RegistrationModel> logIn(@RequestBody RegistrationModel model) throws Exception {
        String tempUserName = model.getUserName();
        String tempPassword = model.getPassword();

        RegistrationModel registrationModel = null;

        if (tempUserName != null && tempPassword != null){
            registrationModel = service.logIn(model.getUserName(), model.getPassword());
        }
        if (registrationModel==null){
            throw new Exception("Wrong Credentials, Please enter valid Credentials");
        }
        System.out.println("Welcome "+registrationModel.getUserName());
        return new ResponseEntity<>(registrationModel, HttpStatus.OK);
    }
}
