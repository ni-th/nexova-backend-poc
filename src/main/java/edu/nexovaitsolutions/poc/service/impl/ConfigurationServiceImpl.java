package edu.nexovaitsolutions.poc.service.impl;


import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.entity.DBEntity;
import edu.nexovaitsolutions.poc.repository.ConfigurationRepository;
import edu.nexovaitsolutions.poc.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationServiceImpl implements ConfigurationService {
    private final ModelMapper modelMapper;
    private final ConfigurationRepository configurationRepository;

    @Override
    public int save(DB db) {
        return configurationRepository.save(modelMapper.map(db, DBEntity.class));
    }

    @Override
    public List<DB> findAll() {
        List<DB> dbList =new ArrayList<>();
        configurationRepository.findAll().forEach(dbEntity -> {
            dbList.add(modelMapper.map(dbEntity, DB.class));
        });
        return dbList;
    }
}
