package com.cg.fms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public boolean existsByUserId(int userId);

	public User findByUserId(int userId);

	public boolean existsByEmailAndPassword(String email, String password);

	public User findByEmailAndPassword(String email, String password);
}
