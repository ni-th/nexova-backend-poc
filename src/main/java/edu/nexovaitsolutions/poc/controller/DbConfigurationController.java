package edu.nexovaitsolutions.poc.controller;

import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.service.DbConfigurationService;
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
public class DbConfigurationController {

    private final DbConfigurationService dbConfigurationService;

    @PostMapping("db/add")
    public ResponseEntity<?> addDB(@Valid @RequestBody DB db){
        int save = dbConfigurationService.save(db);
        if (save > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Internal Server Error"));
    }
    @GetMapping("db/find-all")
    public List<DB> findAll(){
        return dbConfigurationService.findAll();
    }

    @DeleteMapping("db/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (dbConfigurationService.deleteById(id) > 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("DB deleted successfully !");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Internal Server Error"));
    }

    @PutMapping("db/update/{id}")
    public ResponseEntity<?> updateDB(@PathVariable Integer id, @Valid @RequestBody DB db){
        int update = dbConfigurationService.update(id,db);
        if (update > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Updated");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Internal Server Error"));
    }

}
