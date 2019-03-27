package com.crk.springdatajpa.service;

import com.crk.springdatajpa.dao.UserDAO;
import com.crk.springdatajpa.entity.TUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService{

    @Autowired
    private UserDAO userDAO;

    public List<TUser> findAll(){
        return userDAO.findAll();
    }
    public TUser findTUserById(long id){
        TUser user = userDAO.findTUserById(id);
        log.info("-----"+user);
        return user;
    }

}
