package lamph11.api.dto.rest;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lamph11.api.model.Category;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateCategoryTypeRequest {
    

    @NotBlank
    private String id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String code;

    @NotBlank
    @Size(min = 3, max = 60)
    private String name;

    @Size(max = 200)
    private String description;

    private int status = 1;
    
    private List<Category> categories;
}
