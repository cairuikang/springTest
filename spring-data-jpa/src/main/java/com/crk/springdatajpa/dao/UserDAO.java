package com.crk.springdatajpa.dao;

import com.crk.springdatajpa.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<TUser, Long> {

    List<TUser> findAll();
    TUser findTUserById(long id);

}
