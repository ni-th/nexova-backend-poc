package edu.nexovaitsolutions.poc.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SMS {
    private Integer id;
    private String api_key;
    private String sender_phone;
}
