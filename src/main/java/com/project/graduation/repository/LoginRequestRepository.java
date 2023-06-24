package com.project.graduation.repository;

import com.project.graduation.domain.user.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRequestRepository extends JpaRepository<LoginRequest, Long> {
}