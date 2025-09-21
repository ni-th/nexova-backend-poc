package edu.nexovaitsolutions.poc.service.impl;


import edu.nexovaitsolutions.poc.dto.Email;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailConfigurationServiceImpl implements edu.nexovaitsolutions.poc.service.EmailConfigurationService {
    @Override
    public int save(Email email) {
        return 0;
    }

    @Override
    public List<Email> findAll() {
        return List.of();
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int update(Integer id, Email email) {
        return 0;
    }
}
