package com.mfh.rabbitmqproducer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mfh.rabbitmqproducer.model.Employee;

@Service
public class RabbitMQSender {

  @Autowired
  private AmqpTemplate rabbitTemplate;

  @Value("${mfh.rabbitmq.exchange}")
  private String exchange;

  @Value("${mfh.rabbitmq.routingkey}")
  private String routingkey;

  public void send(Employee employee) {
    rabbitTemplate.convertAndSend(exchange, routingkey, employee);
    System.out.println("Msg = " + employee);
  }
}
