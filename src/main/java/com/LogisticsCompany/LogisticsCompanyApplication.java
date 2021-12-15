package com.LogisticsCompany;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Role;
import com.LogisticsCompany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
public class LogisticsCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsCompanyApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {

			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "COURIER"));
			userService.saveRole(new Role(null, "ADMIN"));

			userService.saveUser(new AppUser(null,
					"stoqn_kolev@gmail.com",
					"Stoqn Kolev",
					"klimatik1",
					"username1"));
			userService.saveUser(new AppUser(null,
					"oko1@abv.bg",
					"Mitio Ochite",
					"parola123",
					"username2"));
			userService.saveUser(new AppUser(null,
					"elichko_slovakiev19@mail.bg",
					"Elin Slovakiev",
					"parola321",
					"username3"));
			userService.saveUser(new AppUser(null,
					"sk2@mail.bg",
					"Kole Stoyanov",
					"klimatik22222",
					"username4"));

			userService.addRoleToUser("username1", "USER");
			userService.addRoleToUser("username2", "USER");
			userService.addRoleToUser("username3", "COURIER");
			userService.addRoleToUser("username4", "ADMIN");
		};
	}

}
