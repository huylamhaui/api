package lamph11.api.dto.rest;

import lamph11.api.model.Account;
import lombok.Data;

@Data
public class CreateAccountResponse {
    
    private Account account;
}
