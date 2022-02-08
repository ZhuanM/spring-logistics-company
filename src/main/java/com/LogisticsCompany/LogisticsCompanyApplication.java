package com.LogisticsCompany;

import com.LogisticsCompany.entity.*;
import com.LogisticsCompany.repo.CompanyRepo;
import com.LogisticsCompany.repo.DeliveryRepo;
import com.LogisticsCompany.repo.OfficeRepo;
import com.LogisticsCompany.repo.UserRepo;
import com.LogisticsCompany.service.CompanyService;
import com.LogisticsCompany.service.DeliveryService;
import com.LogisticsCompany.service.OfficeService;
import com.LogisticsCompany.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.List;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LogisticsCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsCompanyApplication.class, args);
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	CommandLineRunner runner(UserService userService, DeliveryService deliveryService, CompanyService companyService,
							 DeliveryRepo deliveryRepo, OfficeService officeService) {
		return args -> {

			userService.saveUser(new AppUser(null,
					"stoqn_stoqnov@gmail.com",
					"Stoqn Stoqn",
					"klimatik1",
					//new Role(null, "USER"),
					"username1"));
			userService.saveUser(new AppUser(null,
					"aaa@abv.bg",
					"Asdf Fdsa",
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
			userService.saveUser(new AppUser(null,
					"ivan@mail.bg",
					"Ivan Ivanov",
					"password5",
					RoleType.USER,
					"username5"));
			userService.saveUser(new AppUser(null,
					"cooguy69@mail.bg",
					"Teodor Teodorov",
					"password6",
					RoleType.USER,
					"username6"));
			userService.saveUser(new AppUser(null,
					"totallyacourier@mail.bg",
					"Kurier Kurierov",
					"courier1",
					RoleType.USER,
					"courier1"));
			userService.saveUser(new AppUser(null,
					"totallyacourier2@mail.bg",
					"Kurierov Kurier",
					"courier2",
					RoleType.USER,
					"courier2"));

			AppUser tmp = new AppUser(null,
					"asd@gmail.com",
					"Test Subject",
					"123",
					RoleType.ADMIN,
					"admin");
			userService.saveUser(tmp);

			Company company = new Company(null, "Ekont", "EKNT");
			companyService.saveCompany(company);

			Office o = new Office(null, "Main Office", "ul. Montevideo 15", company);
			Office o2 = new Office(null, "Office2", "ul. Dobrichine 20, Sofia", company);
			Office o3 = new Office(null, "Office3", "Montevideo 15", company);
			officeService.saveOffice(o);
			officeService.saveOffice(o2);
			officeService.saveOffice(o3);
			company.addOffice(o);
			company.addOffice(o2);
			company.addOffice(o3);

			Delivery d = new Delivery(null,
					company,
					tmp,
					"username1",
					"Gosho",
					DeliveryLocation.DELIVERED,
					"Varna",
					LocalDate.now(),
					LocalDate.now(),
					118.5,
					815.80);
			deliveryService.saveDelivery(d);
			tmp.addDelivery(d);

			Delivery d2 = new Delivery(null,
					company,
					tmp,
					"username6",
					"Vladimir",
					DeliveryLocation.IN_OFFICE,
					"Berlin",
					LocalDate.now(),
					LocalDate.now(),
					312,
					1239.99);
			deliveryService.saveDelivery(d2);
			tmp.addDelivery(d2);

			Delivery d3 = new Delivery(null,
					company,
					tmp,
					"username6",
					"Ivan",
					DeliveryLocation.IN_COURIER,
					"Sofia",
					LocalDate.now(),
					LocalDate.now(),
					65,
					109.68);
			deliveryService.saveDelivery(d3);
			tmp.addDelivery(d3);


			userService.addRoleToUser("username1", "USER");
			userService.addRoleToUser("username3", "COURIER");
			userService.addRoleToUser("username4", "ADMIN");
		};
	}

}
