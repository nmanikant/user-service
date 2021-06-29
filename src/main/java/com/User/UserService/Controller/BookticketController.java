package com.User.UserService.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.UserService.Model.Bookticket;
import com.User.UserService.Repository.BookticketRepository;
import com.User.UserService.Service.BookTicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class BookticketController {
	@Autowired
	private BookTicketService service;

	@Autowired
	private Environment env;

	@GetMapping("/booktickets")
	public ResponseEntity<List<Bookticket>> findAll() {
		List<Bookticket> booktickets = this.service.findAllBooktickets();
		ResponseEntity<List<Bookticket>> response = new ResponseEntity<List<Bookticket>>(booktickets, HttpStatus.OK);
		return response;
	}

	@GetMapping("/bookticketstatus")
	public ResponseEntity<List<Bookticket>> findAllByStatus() {
		List<Bookticket> booktickets = this.service.findAllByStatus();
		ResponseEntity<List<Bookticket>> response = new ResponseEntity<List<Bookticket>>(booktickets, HttpStatus.OK);
		return response;
	}

	@GetMapping("/booktickets/{bookticketId}")
	public ResponseEntity<Bookticket> findById(@PathVariable Integer bookticketId) {

		Bookticket bookticket = this.service.findBookticketById(bookticketId);
		ResponseEntity<Bookticket> response = new ResponseEntity<Bookticket>(bookticket, HttpStatus.OK);
		return response;
	}

	@PostMapping("/booktickets")
	public ResponseEntity<Bookticket> add(@RequestBody Bookticket bookticket) {
		Bookticket bookticketRes = this.service.addBookticket(bookticket);
		ResponseEntity<Bookticket> response = new ResponseEntity<Bookticket>(bookticketRes, HttpStatus.OK);
		return response;
	}

	@PutMapping("/booktickets")
	public ResponseEntity<Bookticket> update(@RequestBody Bookticket bookticket) {
		Bookticket bookticketRes = this.service.updateBookticket(bookticket);
		ResponseEntity<Bookticket> response = new ResponseEntity<Bookticket>(bookticketRes, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/booktickets/{bookticketId}")
	public ResponseEntity<Bookticket> delete(@PathVariable Integer bookticketId) {
		this.service.deleteBookticket(bookticketId);
		ResponseEntity<Bookticket> response = new ResponseEntity<Bookticket>(HttpStatus.OK);
		return response;
	}

	@GetMapping("/searchpnr/{email}")
	public ResponseEntity<Bookticket> findpnr(@PathVariable String email) {
		Bookticket booktickets = this.service.findpnr(email);
		ResponseEntity<Bookticket> response = new ResponseEntity<Bookticket>(booktickets, HttpStatus.OK);
		return response;
	}
}

