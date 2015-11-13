package com.example.controller;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.DemoApplication;
import com.example.entity.SysUser;
import com.example.respositroy.SysUserRespositroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * REST
 * 
 * @author yin
 *
 */
@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	@Autowired
	private SysUserRespositroy sysUserRespositroy;
	@Autowired
	StringRedisTemplate template;

	/**
	 * 请求REST入口
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/send_rest")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return "123" + quote.getType();
	}

	/**
	 * JDBC入口
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/jdbc")
	public String jdbc(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT id, name FROM sys_user");
		for (Map<String, Object> m : list) {
			System.out.println(m.get("id"));
		}
		return "123";
	}

	@RequestMapping("/jpa")
	public String getByEmail(String email) {
		SysUser user = new SysUser();
		user.setName("大隆");
		user.setAccount("xlyinweilong");
		user.setPasswd("123456");
		sysUserRespositroy.save(user);
		return "user " + email + " is not exist.";
	}

	@RequestMapping("/login")
	public String login(String name) {
//		template.setStringSerializer(new SysUser());
		template.convertAndSend("chat", "Hello from Redis!");
		return "1";
	}

}