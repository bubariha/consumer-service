package com.microservice.consumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class ErrorLog implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "ERROR_TYPE")
  private String errorType;

  @Column(name = "ERROR_DESCRIPTION")
  private String errorDescription;

  @Column(name = "PAYLOAD")
  private String payload;

  public ErrorLog() {
  }

  public ErrorLog(String errorType, String errorDescription, String payload) {
    this.errorType = errorType;
    this.errorDescription = errorDescription;
    this.payload = payload;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }
}
