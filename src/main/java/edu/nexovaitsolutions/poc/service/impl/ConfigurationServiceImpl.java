package edu.nexovaitsolutions.poc.service.impl;


import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.repository.ConfigurationRepository;
import edu.nexovaitsolutions.poc.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigurationServiceImpl implements ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    @Override
    public int save(DB db) {
        return configurationRepository.save(db);
    }
}
