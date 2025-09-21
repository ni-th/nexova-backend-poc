package edu.nexovaitsolutions.poc.repository.impl;

import edu.nexovaitsolutions.poc.entity.SMSEntity;
import edu.nexovaitsolutions.poc.repository.SmsConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SmsConfigurationRepositoryImpl implements SmsConfigurationRepository {
    final JdbcTemplate jdbcTemplate;
    @Override
    public int save(SMSEntity sms) {
        String sql = "INSERT INTO sms_config(api_key,sender_phone) VALUES (?,?)";
        return jdbcTemplate.update(sql, sms.getApi_key(), sms.getSender_phone());
    }

    @Override
    public List<SMSEntity> findAll() {
        String sql = "SELECT * FROM sms_config ORDER BY sender_phone ASC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SMSEntity.class));

    }

    @Override
    public int deleteByID(Integer id) {
        String sql = "DELETE FROM sms_config WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(Integer id, SMSEntity sms) {
        String sql = "UPDATE sms_config SET api_key = ?, sender_phone = ? WHERE id = ?";
        return jdbcTemplate.update(sql,sms.getApi_key(), sms.getSender_phone(), id);
    }
}
