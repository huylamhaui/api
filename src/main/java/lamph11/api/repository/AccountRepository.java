package lamph11.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import lamph11.api.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
    
    Optional<Account> findByUsername(String username);
}
