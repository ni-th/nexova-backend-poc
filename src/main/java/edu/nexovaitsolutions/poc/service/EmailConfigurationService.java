package edu.nexovaitsolutions.poc.service;

import edu.nexovaitsolutions.poc.dto.Email;
import jakarta.validation.Valid;

import java.util.List;

public interface EmailConfigurationService {
    int save(@Valid Email email);
    List<Email> findAll();
    int deleteById(Integer id);
    int update(Integer id, @Valid Email email);
}
