package com.LogisticsCompany;

import com.LogisticsCompany.entity.AppUser;
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
			AppUser user1 = new AppUser(null,
					"stoqn_kolev@gmail.com",
					"Stoqn Kolev",
					"klimatik1",
					0,
					"username1");
			AppUser user2 = new AppUser(null,
					"oko1@abv.bg",
					"Mitio Ochite",
					"parola123",
					0,
					"username2");
			AppUser user3 = new AppUser(null,
					"elichko_slovakiev19@mail.bg",
					"Elin Slovakiev",
					"parola321",
					1,
					"username3");
			AppUser user4 = new AppUser(null,
					"sk2@mail.bg",
					"Kole Stoyanov",
					"klimatik2",
					2,
					"username4");
			userService.saveUser(user1);
			userService.saveUser(user2);
			userService.saveUser(user3);
			userService.saveUser(user4);
		};
	}

}
