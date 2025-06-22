package com.niladri.spring_boot_rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niladri.spring_boot_rest.Model.User;


public interface UserRepo extends JpaRepository<User,Integer>{
 User findByUsername(String username);
}
