package yte.intern.springweb;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class User {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Max(100) @Min(12)
    private Integer age;

    @Email @NotBlank
    private String email;

    @NotBlank
    private String tckn;

    @PastOrPresent
    private Date birthday;
    @Size(max=250)
    private String address;
    @NotBlank
    private String username;

    @AssertFalse(message = "Username can't be admin.")
    public boolean isAdmin() {
        return username.equals("admin");
    }
}
