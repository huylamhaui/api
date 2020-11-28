package lamph11.api.router;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lamph11.api.dto.rest.CreateCategoryTypeRequest;
import lamph11.api.dto.rest.UpdateCategoryTypeRequest;
import lamph11.api.model.FilterCategoryType;
import lamph11.api.service.CategoryTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@Slf4j
public class CategoryTypeResource {

    private final CategoryTypeService categoryTypeService;

    @GetMapping
    public ResponseEntity<?> query(@ModelAttribute FilterCategoryType filter) {
        try {
            return ResponseEntity.ok(categoryTypeService.getList(filter));
        } catch (Throwable t) {
            return ResponseEntity.badRequest().body(t);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CreateCategoryTypeRequest request) {
        try {
            return ResponseEntity.ok(categoryTypeService.createCategory(request));
        } catch (Throwable t) {
            log.error(this.getClass().getName(), t);
            return ResponseEntity.badRequest().body(t);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateCategoryTypeRequest request) {
        try {
            return ResponseEntity.ok(categoryTypeService.updateCategory(request));
        } catch (Throwable t) {
            return ResponseEntity.badRequest().body(t);
        }
    }

}
