package lamph11.api.service;

import static lamph11.api.service.CategoryTypeCriteria.codeLike;
import static lamph11.api.service.CategoryTypeCriteria.nameLike;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lamph11.api.dto.rest.CreateCategoryTypeRequest;
import lamph11.api.dto.rest.UpdateCategoryTypeRequest;
import lamph11.api.model.CategoryType;
import lamph11.api.model.FilterCategoryType;
import lamph11.api.repository.CategoryTypeRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CategoryTypeService {

    private final CategoryTypeRepository categoryTypeRepository;
    private final MongoTemplate mongoTemplate;

    public CategoryType createCategory(CreateCategoryTypeRequest request) {
        CategoryType categoryType = new CategoryType().setCode(request.getCode()).setName(request.getName())
                .setDescription(request.getDescription()).setCategories(request.getCategories());
        categoryType = categoryTypeRepository.save(categoryType);
        return categoryType;
    }

    public CategoryType updateCategory(UpdateCategoryTypeRequest request) {
        Optional<CategoryType> optional = categoryTypeRepository.findById(request.getId());
        if (!optional.isPresent())
            throw new RuntimeException("category type not found");

        CategoryType categoryType = optional.get().setCode(request.getCode()).setName(request.getName())
                .setStatus(request.getStatus()).setCategories(request.getCategories());
        categoryType = categoryTypeRepository.save(categoryType);
        return categoryType;
    }

    public List<CategoryType> getList(FilterCategoryType filter) {
        Criteria criteria = codeLike(filter.getCode())
            .andOperator(nameLike(filter.getName()));
        Query query = new Query(criteria);
        query.with(PageRequest.of(0, 10));
        return mongoTemplate.find(query, CategoryType.class);
        
    }
}
