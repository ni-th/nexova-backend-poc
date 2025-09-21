package edu.nexovaitsolutions.poc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private Integer id;
    @NotBlank(message = "API Key cannot be empty")
    private String api_key;
    @NotBlank(message = "Email cannot be empty")
    private String sender_email;
}
