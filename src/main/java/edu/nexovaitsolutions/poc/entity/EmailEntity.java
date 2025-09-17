package edu.nexovaitsolutions.poc.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmailEntity {
    private Integer id;
    private String api_key;
    private String sender_email;
}
