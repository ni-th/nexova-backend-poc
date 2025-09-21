package edu.nexovaitsolutions.poc.repository.impl;

import edu.nexovaitsolutions.poc.entity.EmailEntity;
import edu.nexovaitsolutions.poc.repository.EmailConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmailConfigurationRepositoryImpl implements EmailConfigurationRepository {
    final JdbcTemplate jdbcTemplate;
    @Override
    public int save(EmailEntity email) {
        String sql = "INSERT INTO email_config(api_key,sender_email) VALUES (?,?)";
        return jdbcTemplate.update(sql, email.getApi_key(), email.getSender_email());
    }

    @Override
    public List<EmailEntity> findAll() {
        String sql = "SELECT * FROM email_config ORDER BY sender_email ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EmailEntity.class));

    }

    @Override
    public int deleteByID(Integer id) {
        String sql = "DELETE FROM email_config WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(Integer id, EmailEntity email) {
        String sql = "UPDATE email_config SET api_key = ?, sender_email = ? WHERE id = ?";
        return jdbcTemplate.update(sql,email.getApi_key(), email.getSender_email(),id);
    }
}
