package com.User.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.User.UserService.Model.Bookticket;
import com.User.UserService.Repository.BookticketRepository;
import com.User.UserService.exception.UserServiceNotFoundException;


@Service
public class BookTicketServiceImpl implements BookTicketService{
	@Autowired
	private BookticketRepository repository;
	
	@Override
	public List<Bookticket> findAllBooktickets() {
		 return this.repository.findAll();
	}

	@Override
	public Bookticket findBookticketById(Integer bookticketId) {
		Optional<Bookticket> record = this.repository.findById(bookticketId);
		return record.map(bookticket -> bookticket).orElseThrow(()->new UserServiceNotFoundException("Bookticket with Id " + bookticketId + " not found!"));
	}

	@Override
	public Bookticket addBookticket(Bookticket bookticket) {
		return this.repository.save(bookticket);
	}

	@Override
	public Bookticket updateBookticket(Bookticket bookticket) {
		return this.repository.save(bookticket);
	}

	@Override
	public Bookticket deleteBookticket(Integer bookticketId) {
		Bookticket bookticket = this.findBookticketById(bookticketId);
		this.repository.deleteById(bookticketId);
		return bookticket;
	}
	@Override
	public List<Bookticket> findAllByStatus(){
		List<Bookticket> booktickets = this.repository.findStatus();
		return booktickets;
	}

	@Override
	public Bookticket findpnr(String email) {
		// TODO Auto-generated method stub
		Optional<Bookticket> record = this.repository.findpnr(email);
		return record.map(bookticket -> bookticket).orElseThrow(()->new UserServiceNotFoundException("Bookticket with email " + email + " not found!"));
	}

}

