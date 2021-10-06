package com.microservice.consumer.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microservice.consumer.dao.AuditLogRepository;
import com.microservice.consumer.entity.AuditLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuditLogService {
  private static final Logger logger = LoggerFactory.getLogger(AuditLogService.class);
  private Gson gson = new GsonBuilder().create();
  @Autowired private AuditLogRepository auditLogRepository;
  @Autowired private ErrorLogService errorLogService;

  public void saveAuditLog(String payload) {
    logger.info("Saving Audit Logs {}", payload);
    try {
      Map<String, Object> map = gson.fromJson(payload, Map.class);
      AuditLog auditLog = new AuditLog();
      auditLog.setCustomerNumber((String) map.get("customerNumber"));
      auditLog.setPayload(payload);
      auditLogRepository.save(auditLog);
    } catch (Exception e) {
      logger.info("Exception while saving Audit Logs", e);
      errorLogService.saveErrorLog(e.getClass().getSimpleName(), e.getMessage(), e.toString());
    }
  }
}
