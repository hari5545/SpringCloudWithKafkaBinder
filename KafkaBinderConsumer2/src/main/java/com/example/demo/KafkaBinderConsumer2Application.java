package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.OrderDetails;

@SpringBootApplication
@EnableBinding(Processor.class)
@RestController
public class KafkaBinderConsumer2Application {
	OrderDetails orderDetails;
	@StreamListener(Processor.INPUT)
	public void consumeOrderDetails(OrderDetails orderDetails) {
		this.orderDetails=orderDetails;
		System.out.println(orderDetails);
	}
	@GetMapping(path = "/getOrder",produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaBinderConsumer2Application.class, args);
	}

}
