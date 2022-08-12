package com.mfh.rabbitmqproducer.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
//@Entity
//@Table(name = "Employee")
@ToString(of = "name")
@EqualsAndHashCode(callSuper = false)
public class Employee implements Serializable{

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "rid")
  private int rid;
//
//  @Column(name = "name", nullable = false)
  private String name;
}
