package com.mfh.rabbitmqproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mfh.rabbitmqproducer.model.Employee;
import com.mfh.rabbitmqproducer.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitMQWebController {

	@Autowired
  public RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setRid(Integer.parseInt(empId));
	emp.setName(empName);
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ Successfully";
	}

}
