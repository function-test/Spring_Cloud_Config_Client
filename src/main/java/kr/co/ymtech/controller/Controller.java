package kr.co.ymtech.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RestController
public class Controller {

	@Resource
	private Environment env;
	
	@RequestMapping(path = "/properties/{key}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProperties(@PathVariable(name = "key") String key) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.info("key :  {}", key);
		
		String value = env.getProperty(key);
		
		log.info("value :  {}", value);
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("value", value);
		
		return ResponseEntity.ok(map);
	}

}
