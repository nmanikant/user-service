package com.User.UserService.Service;

import java.util.List;

import com.User.UserService.Model.Bookticket;

public interface BookTicketService {
	public List<Bookticket> findAllBooktickets();
	public Bookticket findBookticketById(Integer bookticketId);
	public Bookticket addBookticket(Bookticket bookticket);
	public Bookticket updateBookticket(Bookticket bookticket);
	public Bookticket deleteBookticket(Integer bookticketId);
	public List<Bookticket> findAllByStatus();
	public Bookticket findpnr(String email);
}
