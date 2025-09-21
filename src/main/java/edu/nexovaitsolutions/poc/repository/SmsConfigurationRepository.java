package edu.nexovaitsolutions.poc.repository;

import edu.nexovaitsolutions.poc.entity.SMSEntity;

import java.util.List;

public interface SmsConfigurationRepository {
    int save(SMSEntity sms);
    List<SMSEntity> findAll();
    int deleteByID(Integer id);
    int update(Integer id, SMSEntity sms);
}
