package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {

	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoverClient;
	
	@GetMapping("test")
	public String test() {
		
		restTemplate=new RestTemplate();
		System.err.println("inside client");
		ResponseEntity<String> str1 = null;
		List<ServiceInstance> list=discoverClient.getInstances("ZUUL-SERVER");
		//List<ServiceInstance> list=discoverClient.getInstances("EMPLOYEE-CLIENT");
		
		ServiceInstance set=list.get(0);
		String str=set.getUri().toString();
		str=str+"/employee-client/getdata";
		try {
			 str1 = restTemplate.exchange(str, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return str1.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
