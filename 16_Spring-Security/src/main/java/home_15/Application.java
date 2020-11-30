package home_15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass1 = "qwerty";
		String pass2 = "admin";

		System.out.println(passwordEncoder.encode(pass1));
		System.out.println(passwordEncoder.encode(pass2));*/
	}

}
