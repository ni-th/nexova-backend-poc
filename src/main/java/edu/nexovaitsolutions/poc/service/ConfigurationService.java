package edu.nexovaitsolutions.poc.service;

import edu.nexovaitsolutions.poc.dto.DB;

import java.util.List;

public interface ConfigurationService {
    int save(DB db);
    List<DB> findAll();
    int deleteById(Integer id);
}
