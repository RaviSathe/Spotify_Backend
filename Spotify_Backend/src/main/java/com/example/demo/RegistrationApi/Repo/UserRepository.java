package com.example.demo.RegistrationApi.Repo;

import com.example.demo.RegistrationApi.Model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<RegistrationModel, Long> {

    public RegistrationModel findByUserNameAndPassword(String userName, String password);
}
