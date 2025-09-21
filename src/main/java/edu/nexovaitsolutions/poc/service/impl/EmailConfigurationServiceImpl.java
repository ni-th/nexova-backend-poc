package edu.nexovaitsolutions.poc.service.impl;

import edu.nexovaitsolutions.poc.dto.Email;
import edu.nexovaitsolutions.poc.entity.EmailEntity;
import edu.nexovaitsolutions.poc.repository.EmailConfigurationRepository;
import edu.nexovaitsolutions.poc.service.EmailConfigurationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailConfigurationServiceImpl implements EmailConfigurationService {
    private final ModelMapper modelMapper;
    final EmailConfigurationRepository emailConfigurationRepository;

    @Override
    public int save(Email email) {
        return emailConfigurationRepository.save(modelMapper.map(email, EmailEntity.class));
    }

    @Override
    public List<Email> findAll() {
        List<Email> emailList =new ArrayList<>();
        emailConfigurationRepository.findAll().forEach(emailEntity -> {
            emailList.add(modelMapper.map(emailEntity, Email.class));
        });
        return emailList;
    }

    @Override
    public int deleteById(Integer id) {
        return emailConfigurationRepository.deleteByID(id);
    }

    @Override
    public int update(Integer id, Email email) {
        return emailConfigurationRepository.update(id, modelMapper.map(email, EmailEntity.class));
    }
}
