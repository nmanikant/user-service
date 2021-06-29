package com.User.UserService.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.User.UserService.Model.Bookticket;
import com.User.UserService.Repository.BookticketRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class KafkaConsumer {
	
	
	  private final Logger log = LoggerFactory.getLogger(Bookticket.class);
	  
	  private ObjectMapper mapper = new ObjectMapper();
	  
	  @Autowired private BookticketRepository service;
	  
	  @KafkaListener(topics = "tickettopic", groupId = "group_id") public void
	  consume(String message) throws Exception, JsonProcessingException {
	  Bookticket ticket = this.mapper.readValue(message, Bookticket.class);
	  Bookticket bookticketRes = this.service.save(ticket);
	  log.info("Ticket status is confirmed for {}", bookticketRes); }
	  
	  
	 }
