package lamph11.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Document(collection = "post")
public class Post {

    @Id
    private String id;

    @NotBlank
    @Size(min = 5, max = 200)
    private String title;

    @NotBlank
    @Size(min = 50)
    private String content;

    private Long view = 0L;

    private int status = 1;
}
