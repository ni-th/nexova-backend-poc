package edu.nexovaitsolutions.poc.service.impl;


import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.entity.DBEntity;
import edu.nexovaitsolutions.poc.repository.DbConfigurationRepository;
import edu.nexovaitsolutions.poc.service.DbConfigurationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbConfigurationServiceImpl implements DbConfigurationService {
    private final ModelMapper modelMapper;
    private final DbConfigurationRepository dbConfigurationRepository;

    @Override
    public int save(DB db) {
        return dbConfigurationRepository.save(modelMapper.map(db, DBEntity.class));
    }

    @Override
    public List<DB> findAll() {
        List<DB> dbList =new ArrayList<>();
        dbConfigurationRepository.findAll().forEach(dbEntity -> {
            dbList.add(modelMapper.map(dbEntity, DB.class));
        });
        return dbList;
    }

    @Override
    public int deleteById(Integer id) {
        return dbConfigurationRepository.deleteByID(id);
    }

    @Override
    public int update(Integer id, DB db) {
        return dbConfigurationRepository.update(id, modelMapper.map(db, DBEntity.class));
    }
}
