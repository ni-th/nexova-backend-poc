package edu.nexovaitsolutions.poc.service;

import edu.nexovaitsolutions.poc.dto.SMS;

import java.util.List;

public interface SmsConfigurationService {
    int save(SMS sms);
    List<SMS> findAll();
    int deleteById(Integer id);
    int update(Integer id, SMS sms);
}
