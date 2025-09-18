package edu.nexovaitsolutions.poc.service;

import edu.nexovaitsolutions.poc.dto.DB;

import java.util.List;

public interface ConfigurationService {
    public int save(DB db);
    List<DB> findAll();
}
