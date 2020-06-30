package com.joe.domain.repository;

import com.joe.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WelletRepository extends JpaRepository<Wallet,Long> {
}
