package com.microservice.consumer.dao;

import com.microservice.consumer.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Integer> {}
