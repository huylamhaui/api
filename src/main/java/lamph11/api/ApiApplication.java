package lamph11.api;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lamph11.api.model.Category;
import lamph11.api.model.CategoryType;
import lamph11.api.repository.CategoryTypeRepository;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Autowired
	private CategoryTypeRepository categoryTypeRepository;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> {
			System.out.println("Da vao day");
			Category show = new Category()
				.setCode("SHOW")
				.setName("Display")
				.setDescription("");

			Category hidden = new Category()
				.setCode("HIDDEN")
				.setName("Hidden")
				.setDescription("");
			
			CategoryType categoryType = new CategoryType()
				.setCode("DISPLAY_STATUS")
				.setName("Trạng thái hiển thị")
				.setDescription("")
				.setStatus(1)
				.setCategories(
					Arrays.asList(show, hidden)
				);
			categoryType = categoryTypeRepository.save(categoryType);
			System.out.println(categoryType);
		};
	}

}
