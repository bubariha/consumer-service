package com.microservice.consumer.listener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microservice.consumer.service.AuditLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaListener {
  private static final Logger logger = LoggerFactory.getLogger(KafkaListener.class);

  @Autowired
  private AuditLogService auditLogService;


  @org.springframework.kafka.annotation.KafkaListener(topics = "${kafka.topic_name}", groupId = "${kafka.group_id}")
  public void listener(String message) {
    logger.info("Received message = {}", message);
    auditLogService.saveAuditLog(message);

  }
}
