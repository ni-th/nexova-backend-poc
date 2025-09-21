package edu.nexovaitsolutions.poc.service.impl;

import edu.nexovaitsolutions.poc.dto.SMS;
import edu.nexovaitsolutions.poc.entity.SMSEntity;
import edu.nexovaitsolutions.poc.repository.SmsConfigurationRepository;
import edu.nexovaitsolutions.poc.service.SmsConfigurationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsConfigurationServiceImpl implements SmsConfigurationService {
    private final ModelMapper modelMapper;
    final SmsConfigurationRepository smsConfigurationRepository;

    @Override
    public int save(SMS sms) {
        return smsConfigurationRepository.save(modelMapper.map(sms, SMSEntity.class));
    }

    @Override
    public List<SMS> findAll() {
        List<SMS> smsList =new ArrayList<>();
        smsConfigurationRepository.findAll().forEach(smsEntity -> {
            smsList.add(modelMapper.map(smsEntity, SMS.class));
        });
        return smsList;
    }

    @Override
    public int deleteById(Integer id) {
        return smsConfigurationRepository.deleteByID(id);
    }

    @Override
    public int update(Integer id, SMS sms) {
        return smsConfigurationRepository.update(id, modelMapper.map(sms, SMSEntity.class));
    }
}
