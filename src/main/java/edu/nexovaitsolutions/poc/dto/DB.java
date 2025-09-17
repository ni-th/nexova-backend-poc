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

    public Integer getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }
}
