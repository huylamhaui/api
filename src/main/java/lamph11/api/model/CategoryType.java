package lamph11.api.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Document(collection = "category_type")
public class CategoryType {

    @Id
    private String id;

    @Indexed(unique = true, name = "code is unique")
    @Field("code")
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