package edu.nexovaitsolutions.poc.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private Integer id;
    private String api_key;
    private String sender_email;
}
