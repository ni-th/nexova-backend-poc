package edu.nexovaitsolutions.poc.controller;


import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.service.ConfigurationService;
import edu.nexovaitsolutions.poc.service.impl.ConfigurationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("config")
public class ConfigurationController {

    private final ConfigurationServiceImpl configurationService;

    @GetMapping("hello")
    public String getAlert(){
        return "Hello";
    }

    @PostMapping("db/add")
    public ResponseEntity<?> addDB(@RequestBody DB db){
        int save = configurationService.save(db);
        if (save>0){
            return ResponseEntity.ok("Saved");
        }else{
            return ResponseEntity.ok("Not Saved");
        }

    }
}
