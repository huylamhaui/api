package lamph11.api.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lamph11.api.model.Account;
import lamph11.api.repository.AccountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optional = accountRepository.findByUsername(username);
        if(!optional.isPresent()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return optional.get();
    }
    
}
