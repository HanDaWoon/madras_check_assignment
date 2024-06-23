package madras_check.admin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MUser {
    @JsonIgnore
    private Integer id;
    private String email;
    @JsonIgnore
    private String password;
    private String role;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
