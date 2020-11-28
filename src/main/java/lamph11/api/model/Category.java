package lamph11.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Category {
    
    private String code;
    private String name;
    private String description;
}
