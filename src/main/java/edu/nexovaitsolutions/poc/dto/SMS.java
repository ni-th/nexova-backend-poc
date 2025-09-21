package edu.nexovaitsolutions.poc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SMS {
    private Integer id;
    @NotBlank(message = "API Key cannot be empty")
    private String api_key;
    @NotBlank(message = "Sender Phone cannot be empty")
    private String sender_phone;
}
