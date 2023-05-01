package cbd.vazquez.tfgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TfgsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TfgsApplication.class, args);
	}


	@GetMapping
	public String apiRoot() {
		return "Proyecto de CBD de Francisco Javier Vázquez Monge";
	}
}
