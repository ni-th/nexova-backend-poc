package edu.nexovaitsolutions.poc.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserEntity {
    private Integer id;
    private String email;
    private String password;
}
