package com.LogisticsCompany;

import com.LogisticsCompany.entity.AppUser;
import com.LogisticsCompany.entity.Delivery;
import com.LogisticsCompany.entity.DeliveryLocation;
import com.LogisticsCompany.entity.RoleType;
import com.LogisticsCompany.service.DeliveryService;
import com.LogisticsCompany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LogisticsCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsCompanyApplication.class, args);
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//	}

	@Bean
	CommandLineRunner runner(UserService userService, DeliveryService deliveryService) {
		return args -> {

			userService.saveUser(new AppUser(null,
					"stoqn_kolev@gmail.com",
					"Stoqn Kolev",
					"klimatik1",
					//new Role(null, "USER"),
					"username1"));
			userService.saveUser(new AppUser(null,
					"oko1@abv.bg",
					"Mitio Ochite",
					"parola123",
					RoleType.ADMIN,
					"username2"));
			userService.saveUser(new AppUser(null,
					"elichko_slovakiev19@mail.bg",
					"Elin Slovakiev",
					"parola321",
					//new Role(null, "COURIER"),
					"username3"));
			userService.saveUser(new AppUser(null,
					"sk2@mail.bg",
					"Kole Stoyanov",
					"klimatik22222",
					//new Role(null, "ADMIN"),
					"username4"));

			AppUser tmp = new AppUser(null,
					"asd@gmail.com",
					"Test Subject",
					"123",
					RoleType.USER,
					"user");
			userService.saveUser(tmp);

			Delivery d = new Delivery(null,
					tmp,
					"Gosho",
					DeliveryLocation.DELIVERED,
					"Varna",
					118.5);
			deliveryService.saveDelivery(d);

			userService.addRoleToUser("username1", "USER");
			userService.addRoleToUser("username3", "COURIER");
			userService.addRoleToUser("username4", "ADMIN");
		};
	}

}
