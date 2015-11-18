package com.example.mongodb;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * REST
 * 
 * @author yin
 *
 */
@RestController
public class MongodbController {

	private final AtomicLong counter = new AtomicLong();
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final Logger log = LoggerFactory.getLogger(MongodbController.class);
	@Autowired
	private SysUserRepository sysUserRepository;

	@RequestMapping("/mongodb")
	public String doWithMongodb() {
		SysUser user = new SysUser();
		user.setAccount("123");
		user.setPasswd("qqqqqq");
		sysUserRepository.save(user);
		return "user is not exist.";
	}

}