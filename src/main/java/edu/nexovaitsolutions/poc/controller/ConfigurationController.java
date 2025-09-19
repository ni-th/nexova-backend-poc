package edu.nexovaitsolutions.poc.controller;

import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.service.ConfigurationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("config")
@CrossOrigin
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @PostMapping("db/add")
    public ResponseEntity<String> addDB(@Valid @RequestBody DB db){
        int save = configurationService.save(db);
        if (save>0){
            return ResponseEntity.ok("Saved");
        }else{
            return ResponseEntity.ok("Not Saved");
        }
    }
    @GetMapping("db/find-all")
    public List<DB> findAll(){
        return configurationService.findAll();
    }

    @DeleteMapping("db/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        if (configurationService.deleteById(id) > 0){
            return ResponseEntity.ok("DB deleted successfully !");
        }return ResponseEntity.ok("DB not deleted");
    }
}
