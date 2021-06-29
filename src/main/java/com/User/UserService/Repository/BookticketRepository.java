package com.User.UserService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.User.UserService.Model.Bookticket;

@Repository
public interface BookticketRepository extends JpaRepository<Bookticket, Integer>{
	@Query(value="SELECT a FROM Bookticket a WHERE a.status = false")
    List<Bookticket> findStatus();
	@Query(value="SELECT a FROM Bookticket a WHERE a.email = :email")
    Optional<Bookticket> findpnr(@Param("email") String email);
}
