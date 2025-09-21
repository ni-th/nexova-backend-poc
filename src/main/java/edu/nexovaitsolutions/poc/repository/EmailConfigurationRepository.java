package edu.nexovaitsolutions.poc.repository;

import edu.nexovaitsolutions.poc.entity.EmailEntity;

import java.util.List;

public interface EmailConfigurationRepository {
    int save(EmailEntity email);
    List<EmailEntity> findAll();
    int deleteByID(Integer id);
    int update(Integer id, EmailEntity email);
}
