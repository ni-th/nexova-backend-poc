package edu.nexovaitsolutions.poc.repository;

import edu.nexovaitsolutions.poc.entity.DBEntity;

import java.util.List;

public interface ConfigurationRepository {
    int save(DBEntity db);
    List<DBEntity> findAll();
    int deleteByID(Integer id);
    int update(Integer id, DBEntity map);
}
