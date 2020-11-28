package lamph11.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import lamph11.api.model.CategoryType;

@Repository
public interface CategoryTypeRepository extends MongoRepository<CategoryType, String>{
    
}
    
