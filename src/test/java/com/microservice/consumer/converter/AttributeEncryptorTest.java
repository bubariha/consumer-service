package com.microservice.consumer.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AttributeEncryptorTest {

  @Test
  public void testEncrypt() throws Exception {
    AttributeEncryptor attributeEncryptor = new AttributeEncryptor();
    String encryptedCustomerNumber = attributeEncryptor.convertToDatabaseColumn("1234567890");
    assertEquals("VOgoDLRwk9oJBPByoF3u+w==", encryptedCustomerNumber);
  }

  @Test
  public void testDecrypt() throws Exception {
    AttributeEncryptor attributeEncryptor = new AttributeEncryptor();
    String encryptedCustomerNumber =
        attributeEncryptor.convertToEntityAttribute("VOgoDLRwk9oJBPByoF3u+w==");
    assertEquals("1234567890", encryptedCustomerNumber);
  }
}
