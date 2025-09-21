package edu.nexovaitsolutions.poc.controller;

import edu.nexovaitsolutions.poc.dto.DB;
import edu.nexovaitsolutions.poc.dto.Email;
import edu.nexovaitsolutions.poc.service.EmailConfigurationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class EmailConfigurationController {

    final EmailConfigurationService emailConfigurationService;

    @PostMapping("email/add")
    public ResponseEntity<?> addEmail(@Valid @RequestBody Email email){
        int save = emailConfigurationService.save(email);
        if (save > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Internal Server Error"));
    }
    @GetMapping("email/find-all")
    public List<Email> findAll(){
        return emailConfigurationService.findAll();
    }

    @DeleteMapping("email/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (emailConfigurationService.deleteById(id) > 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Email deleted successfully !");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Internal Server Error"));
    }

    @PutMapping("email/update/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable Integer id, @Valid @RequestBody Email email){
        int update = emailConfigurationService.update(id,email);
        if (update > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Updated");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Internal Server Error"));
    }
}
