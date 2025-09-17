package edu.nexovaitsolutions.poc.repository.impl;


import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConfigurationRepositoryImpl implements ConfigurationRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public int save(DB db) {
        String sql = "INSERT INTO databases_config(host,username,port,password,database_name) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql,db.getHost(),db.getUsername(),db.getPort(),db.getPassword(),db.getDatabaseName());

    }
}
