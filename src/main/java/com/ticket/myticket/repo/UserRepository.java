package com.ticket.myticket.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.myticket.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String userName);
}
