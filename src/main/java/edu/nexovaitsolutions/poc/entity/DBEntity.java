package edu.nexovaitsolutions.poc.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DBEntity {
    private Integer id;
    private String host;
    private String username;
    private int port;
    private String password;
    private String databaseName;
}
