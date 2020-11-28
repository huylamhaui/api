package lamph11.api.dto.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lamph11.api.model.Category;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateCategoryTypeRequest {
    
    @NotBlank
    @Size(min = 3, max = 30)
    private String code;

    @NotBlank
    @Size(min = 6, max = 60)
    private String name;

    @Size(max = 200)
    private String description;

    private  List<Category> categories = new ArrayList<>();
}
