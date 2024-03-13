package com.example.demo.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.nimbusds.jose.JOSEException;

import JWT.jwtUtil;

@Repository
public class accountDaoImpl implements accountDao{

	@Autowired
	private RedisTemplate template;
	private HashOperations hashOperations;
	
	public accountDaoImpl(RedisTemplate template) {
		this.template = template;
		this.hashOperations=template.opsForHash();
	}
	
	public void AddAccount(String key,String field,Account a)throws ParseException, JOSEException  {
		// TODO Auto-generated method stub
		hashOperations.put(key, a.getId(),a);
		hashOperations.put("JWT",a.getId(),new jwtUtil().createJWT(a.getId(),a.getUser(),a.getPass(),3600000));
		System.out.println("");
	}

	@Override
	public List<Account> getAll(String key) {
		// TODO Auto-generated method stub
		System.out.println("List Acount: ");
		System.out.println(hashOperations.values(key));
		System.out.println("List Acount: ");
		System.out.println(hashOperations.values("JWT"));
		return hashOperations.values(key);
	}

	

	@Override
	public void login(String key, String field, Account a) {
		// TODO Auto-generated method stub
		
	}

}
