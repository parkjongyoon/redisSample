package com.ndarkness;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	RedisTemplate redisTemplate;
	
	@GetMapping("hellow")
	public String getHellow() {
		
		HashMap<String, String> park = new HashMap<>();
		park.put("name","park jong yoon");
		park.put("age", "23");
		
		HashMap<String, String> kim = new HashMap<>();
		kim.put("name","kim min jong");
		kim.put("age", "43");
		
		HashOperations<String, String, String> hOperation = redisTemplate.opsForHash();
		hOperation.putAll("emp:park", park);
		hOperation.putAll("emp:kim", kim);
        
		System.out.println(hOperation.entries("emp:park").get("age"));
		return "hello world";
	}
}
