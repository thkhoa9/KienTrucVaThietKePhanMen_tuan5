package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Account")
public class Account implements Serializable{
    
	private String id;
	private String user;
	private String pass;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String id, String user, String pass) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + "]";
	}

	
	
}
