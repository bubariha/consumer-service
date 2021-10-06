package com.microservice.consumer.service;

import com.microservice.consumer.dao.ErrorLogRepository;
import com.microservice.consumer.entity.ErrorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorLogService {
  @Autowired private ErrorLogRepository errorLogRepository;

  public ErrorLog saveErrorLog(String errorType, String description, String payload) {
    ErrorLog errorLog = new ErrorLog(errorType, description, payload);
    return errorLogRepository.save(errorLog);
  }
}
