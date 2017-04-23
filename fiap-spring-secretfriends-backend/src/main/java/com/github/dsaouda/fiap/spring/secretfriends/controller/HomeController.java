package com.github.dsaouda.fiap.spring.secretfriends.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.dsaouda.fiap.spring.secretfriends.Amigo;
import com.github.dsaouda.fiap.spring.secretfriends.Response;

@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value="home.xml", method=RequestMethod.GET, produces="application/xml")
	public Response homeXml() {
		Amigo a = new Amigo();
		a.setNome("Diego");
		a.setA("A");
		a.setB("B");
		
		
		return new Response(a);
	}
	
	@RequestMapping(value="home.json", method=RequestMethod.GET, produces="application/json")
	public Response homeJson() {
		Amigo a = new Amigo();
		a.setNome("Diego");
		a.setA("A");
		a.setB("B");
		
		return new Response(a);
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<String>> home() {
		List<String> a = new ArrayList<>();
		a.add("string 1");
		a.add("string 2");
		a.add("string 3");
		
		return new ResponseEntity<List<String>>(a, HttpStatus.OK);
	}
}