package com.example.mongodb;

import org.springframework.data.annotation.Id;

public class SysUser {
	
	@Id
    private String id;

    private String account;
    private String passwd;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
    
    
}
