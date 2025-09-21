package edu.nexovaitsolutions.poc.service;

import edu.nexovaitsolutions.poc.dto.Email;

import java.util.List;

public interface EmailConfigurationService {
    int save(Email email);
    List<Email> findAll();
    int deleteById(Integer id);
    int update(Integer id, Email email);
}
