package com.example.mongodb;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysUserRepository extends MongoRepository<SysUser, String> {
	
	public SysUser findByAccount(String account);
	
    
}
