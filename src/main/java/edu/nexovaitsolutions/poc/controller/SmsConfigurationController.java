package edu.nexovaitsolutions.poc.controller;

import edu.nexovaitsolutions.poc.dto.Email;
import edu.nexovaitsolutions.poc.dto.SMS;
import edu.nexovaitsolutions.poc.service.EmailConfigurationService;
import edu.nexovaitsolutions.poc.service.SmsConfigurationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("config")
@CrossOrigin
@RequiredArgsConstructor
public class SmsConfigurationController {

    final SmsConfigurationService smsConfigurationService;

    @PostMapping("sms/add")
    public ResponseEntity<?> addSms(@Valid @RequestBody SMS sms){
        int save = smsConfigurationService.save(sms);
        if (save > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Internal Server Error"));
    }
    @GetMapping("sms/find-all")
    public List<SMS> findAll(){
        return smsConfigurationService.findAll();
    }

    @DeleteMapping("sms/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if (smsConfigurationService.deleteById(id) > 0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("SMS deleted successfully !");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message", "Internal Server Error"));
    }

    @PutMapping("sms/update/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable Integer id, @Valid @RequestBody SMS sms){
        int update = smsConfigurationService.update(id,sms);
        if (update > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Updated");
        }return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", "Internal Server Error"));
    }
}
