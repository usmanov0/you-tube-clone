package com.example.tube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    @Size(min = 2, max = 20, message = "Edit first name.")
    private String firstName;

    @Size(min = 2, max = 20, message = "Edit last name.")
    private String lastName;

    @Size(min = 2, max = 14, message = "Edit password.")
    private String password;
}
