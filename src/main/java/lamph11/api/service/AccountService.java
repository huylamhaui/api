package lamph11.api.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lamph11.api.dto.rest.CreateAccountRequest;
import lamph11.api.dto.rest.CreateAccountResponse;
import lamph11.api.model.Account;
import lamph11.api.repository.AccountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AccountService {
    
    private AccountRepository accountRepository;

    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        Account account = new Account()
            .setUsername(request.getUsername())
            .setPassword(request.getPassword())
            .setRoles(
                Arrays.asList("GUEST")
            );
        account = accountRepository.save(account);

        CreateAccountResponse response = new CreateAccountResponse();
        response.setAccount(account);
        return response;
    }
}
