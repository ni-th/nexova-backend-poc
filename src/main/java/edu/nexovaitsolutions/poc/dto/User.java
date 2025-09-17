package edu.nexovaitsolutions.poc.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    private Integer id;
    private String email;
    private String password;
}
