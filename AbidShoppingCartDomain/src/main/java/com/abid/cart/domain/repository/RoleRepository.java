package com.abid.cart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abid.cart.domain.model.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}