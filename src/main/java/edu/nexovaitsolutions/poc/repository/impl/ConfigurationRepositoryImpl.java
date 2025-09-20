package edu.nexovaitsolutions.poc.repository.impl;

import edu.nexovaitsolutions.poc.entity.DBEntity;
import edu.nexovaitsolutions.poc.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConfigurationRepositoryImpl implements ConfigurationRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public int save(DBEntity db) {
        String sql = "INSERT INTO databases_config(host,username,port,password,database_name) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql,db.getHost(),db.getUsername(),db.getPort(),db.getPassword(),db.getDatabaseName());
    }

    @Override
    public List<DBEntity> findAll() {
        String sql = "SELECT * FROM databases_config ORDER BY database_name ASC";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(DBEntity.class));
    }

    @Override
    public int deleteByID(Integer id) {
        String sql = "DELETE FROM databases_config WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(Integer id, DBEntity db) {
        String sql = "UPDATE databases_config SET host = ?, username = ?, port = ?, password = ?, database_name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, db.getHost(),db.getUsername(),db.getPort(),db.getPassword(),db.getDatabaseName(), id);
    }
}
