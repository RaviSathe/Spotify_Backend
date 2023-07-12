package com.example.demo.RegistrationApi.Service;

import com.example.demo.RegistrationApi.Model.RegistrationModel;
import com.example.demo.RegistrationApi.Repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private UserRepository repository;

    public RegistrationModel addUser(RegistrationModel model){
        model.setUserName(model.getFirstName()+model.getLastName());
        return repository.save(model);
    }

    public RegistrationModel logIn(String userName, String password){
        return repository.findByUserNameAndPassword(userName, password);
    }
}
