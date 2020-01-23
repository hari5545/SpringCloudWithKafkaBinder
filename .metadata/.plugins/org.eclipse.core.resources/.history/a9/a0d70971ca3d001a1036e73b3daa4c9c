package com.example.resources;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.http.MediaType;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ItemDetails;
import com.example.model.OrderDetails;
import com.example.model.UserDetails;
import com.example.service.OrderItemsService;

@RestController
@RequestMapping("/rest")
public class OrderResources {

	UserDetails userDetails;
	@Autowired
	OrderItemsService orderItemsService;

	@Autowired
	MessageChannel output;

	@StreamListener(Processor.INPUT)
	public void consumeUserDetails(UserDetails userDetails) {
		this.userDetails=userDetails;
	}

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@SendTo(Processor.OUTPUT)
	public OrderDetails saveOrderItemsBy(@RequestBody ItemDetails itemDetails) {

		ItemDetails item = new ItemDetails();
		UserDetails user = new UserDetails();
		OrderDetails orderdetail = new OrderDetails();

		item.setItemName(itemDetails.getItemName());
		item.setQty(itemDetails.getQty());
		List<ItemDetails> l = new LinkedList<>();
		l.add(item);

		user.setId(userDetails.getId());
		user.setFirstName(userDetails.getFirstName());
		user.setMiddleName(userDetails.getMiddleName());
		user.setLastName(userDetails.getLastName());
		user.setAddress(userDetails.getAddress());


		Date date = new Date();
		date.setDate(date.getDate() + 5);
		//user.setId(userDetails.getId());
		orderdetail.setExpecteddate(date);
		orderdetail.setOrderdate(new Date());
		orderdetail.setOrderedby(userDetails.getFirstName()+""+userDetails.getMiddleName()+""+userDetails.getLastName());
		orderdetail.setItemdetails(l);
		orderdetail.setUserDetailsEntity(user);
		orderItemsService.save(orderdetail);
		//output.send(MessageBuilder.withPayload(orderdetail).build());
		return orderdetail;
	}
}
