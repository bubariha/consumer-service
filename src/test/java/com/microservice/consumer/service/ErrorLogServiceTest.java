package com.microservice.consumer.service;

import com.microservice.consumer.dao.ErrorLogRepository;
import com.microservice.consumer.entity.ErrorLog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ErrorLogServiceTest {
  @Autowired private ErrorLogRepository errorLogRepository;

  @Test
  @Rollback
  public void saveAuditLog() throws Exception {
    ErrorLog errorLog = new ErrorLog();
    errorLog.setErrorType(NullPointerException.class.getSimpleName());
    errorLog.setErrorDescription("NullPointerException");
    errorLog.setPayload(
        "java.lang.NullPointerException\n" + "    at Maze.getNumRandOccupants(Maze.java:118)");
    ErrorLog savedErrorLog = errorLogRepository.save(errorLog);
    errorLogRepository.getById(savedErrorLog.getId());
    System.out.println("savedErrorLog.getCustomerNumber() = " + savedErrorLog.getErrorType());
    assertEquals(savedErrorLog.getErrorType(), errorLog.getErrorType());
  }
}
