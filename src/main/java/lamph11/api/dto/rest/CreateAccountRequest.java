package lamph11.api.dto.rest;

import lombok.Data;

@Data
public class CreateAccountRequest {
    
    private String username;

    private String password;
}
