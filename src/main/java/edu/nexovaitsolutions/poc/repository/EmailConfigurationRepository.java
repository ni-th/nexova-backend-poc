package edu.nexovaitsolutions.poc.repository;

import edu.nexovaitsolutions.poc.dto.Email;
import edu.nexovaitsolutions.poc.entity.EmailEntity;

import java.util.List;
import java.util.Map;

public interface EmailConfigurationRepository {
    int save(EmailEntity email);
    List<EmailEntity> findAll();
    int deleteByID(Integer id);
    int update(Integer id, EmailEntity email);
}
