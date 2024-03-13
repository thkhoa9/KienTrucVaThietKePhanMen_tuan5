package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.accountDao;
import com.example.demo.entity.Account;
import com.nimbusds.jose.JOSEException;

@RestController
public class accountController {
     @Autowired
     private accountDao accountDao;
     
     @GetMapping("/add")
     public void addAccount(@RequestBody Account a,@RequestParam("key") String key)throws ParseException, JOSEException{
    	 accountDao.AddAccount(key,a.getUser(),a);
     }
     @GetMapping("/findAll")
     public List<Account> getAllAccount(@RequestParam("key")String key){
    	 return accountDao.getAll(key);
     }
}
