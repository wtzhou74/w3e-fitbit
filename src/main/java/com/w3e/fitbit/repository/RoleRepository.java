package com.w3e.fitbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w3e.fitbit.model.account.Role;

/**
 * role repository
 * @author ZHOU WENTAO
 * */
public interface RoleRepository extends JpaRepository<Role, Long>{

}
