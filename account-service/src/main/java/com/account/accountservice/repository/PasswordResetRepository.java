package com.account.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.UserPasswordReset;

@Repository
public interface PasswordResetRepository extends JpaRepository<UserPasswordReset, Long>{

}
