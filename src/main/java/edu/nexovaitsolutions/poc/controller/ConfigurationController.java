package edu.nexovaitsolutions.poc.controller;

import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.service.ConfigurationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("config")
@CrossOrigin
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @PostMapping("db/add")
    public ResponseEntity<?> addDB(@Valid @RequestBody DB db){
        int save = configurationService.save(db);
        if (save > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Internal Server Error"));
    }
    @GetMapping("db/find-all")
    public List<DB> findAll(){
        return configurationService.findAll();
    }

    @DeleteMapping("db/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (configurationService.deleteById(id) > 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("DB deleted successfully !");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Internal Server Error"));
    }
}
