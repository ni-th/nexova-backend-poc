package edu.nexovaitsolutions.poc.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DB {
    private Integer id;
    private String host;
    private String username;
    private Integer port;
    private String password;
    private String databaseName;
}
