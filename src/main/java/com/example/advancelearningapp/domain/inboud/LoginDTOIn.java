package com.example.advancelearningapp.domain.inboud;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Setter
@Getter
public class LoginDTOIn {
    @NotNull
    @NotEmpty
    @Email
    String email;
    @NotNull
    @NotEmpty
    //@ValidPassword
    //@Size(min = 8, message = "You should enter atleast 8 characters")

    //@Pattern(regexp = "^[a-z655A-Z0-9]{8}", message = "Password should contain alphabets and special characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{5,20}$")
    public String password;

}
