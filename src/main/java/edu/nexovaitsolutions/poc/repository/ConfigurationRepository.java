package edu.nexovaitsolutions.poc.repository;

import edu.nexovaitsolutions.poc.entity.DBEntity;

import java.util.List;

public interface ConfigurationRepository {
    public int save(DBEntity db);
    List<DBEntity> findAll();
}
