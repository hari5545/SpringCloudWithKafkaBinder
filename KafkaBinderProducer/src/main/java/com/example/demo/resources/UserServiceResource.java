package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserDetailsServic;



@RestController
public class UserServiceResource {

	@Autowired
	private MessageChannel output;

	@Autowired
	UserDetailsServic userDetailsServic;

	@GetMapping(value = "/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> getDetails(@PathVariable Long id) {

		UserDetails userdetails=userDetailsServic.findById(id);
		//the payload object will send in kafka culster
		output.send(MessageBuilder.withPayload(userdetails).build());
		return new  ResponseEntity<UserDetails>(userdetails,HttpStatus.OK);
	}
}