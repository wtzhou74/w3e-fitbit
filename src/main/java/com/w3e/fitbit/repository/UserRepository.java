package com.w3e.fitbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w3e.fitbit.model.account.User;

/**
 * User repository
 * @author ZHOU WENTAO
 * */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
