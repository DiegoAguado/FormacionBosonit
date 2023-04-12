package com.formacionBosonit.block6pathvariableheaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@RestController
public class Block6PathVariableHeadersApplication {
	@PostMapping(value = "/json")
	public Map greeting(@RequestBody Map mapa){
		return mapa;
	}

	@GetMapping(value = "/user/{id}")
	public int user(@PathVariable int id){
		return id;
	}

	@PutMapping(value = "/post")
	public HashMap post(@RequestParam int var1, @RequestParam int var2){
		HashMap<String, Integer> map = new HashMap<>();
		map.put("var1", var1);
		map.put("var2", var2);
		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(Block6PathVariableHeadersApplication.class, args);
	}

}
