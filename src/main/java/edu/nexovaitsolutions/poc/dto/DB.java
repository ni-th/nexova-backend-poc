package edu.nexovaitsolutions.poc.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DB {
    private Integer id;
    @NotBlank(message = "Host cannot be empty")
    @URL(message = "Host name is invalid.")
    private String host;
    @NotBlank(message = "UserName cannot be empty")
    @Pattern(regexp = "^[a-zA-Z][A-Za-z0-9_]*$", message = "Username name is invalid. Name should be start with a letter and must contain a letter, number or _")
    private String username;
    @Min(value = 1024, message = "Port must be >=1024")
    @Max(value = 65535, message = "Port must be <=65535")

    private Integer port;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!()-?><'\"/|;:`~]).{8,20}$",
            message = "Password must contain at least one digit, one lowercase, one uppercase, and one special character (@#$%^&+=!()-?><'\"/|;:`~)"
    )

    private String password;
    @NotBlank(message = "DatabaseName cannot be empty")
    @Pattern(regexp = "^[a-zA-Z][A-Za-z0-9_]*$", message = "Database name is invalid. Name should be start with a letter and must contain a letter, number or _")

    private String databaseName;
}
