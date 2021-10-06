package com.microservice.consumer.service;

import com.microservice.consumer.dao.AuditLogRepository;
import com.microservice.consumer.entity.AuditLog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
  @SpringBootTest
public class AuditLogServiceTest {
  @Autowired private AuditLogRepository auditLogRepository;

  @Test
  @Rollback
  public void saveAuditLog() throws Exception {
    AuditLog auditLog = new AuditLog();
    auditLog.setCustomerNumber("1234567890");
    auditLog.setPayload(
        "{\"email\":\"string\",\"address\":{\"street\":\"string\",\"postalCode\":\"string\",\"addressLine1\":\"string\",\"addressLine2\":\"string\"},\"country\":\"string\",\"lastName\":\"Haribabu Pacharla\",\"birthDate\":\"09/01/1993\",\"firstName\":\"Haribabu Pacharla\",\"countryCode\":\"string\",\"mobileNumber\":\"1234567890\",\"customerNumber\":\"123\",\"customerStatus\":\"R\"}");
    AuditLog savedAuditLog = auditLogRepository.save(auditLog);
    auditLogRepository.getById(savedAuditLog.getId());
    System.out.println("savedAuditLog.getCustomerNumber() = " + savedAuditLog.getCustomerNumber());
    assertEquals(savedAuditLog.getCustomerNumber(), auditLog.getCustomerNumber());
  }
}
