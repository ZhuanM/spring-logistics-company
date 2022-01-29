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

import java.time.LocalDate;
import java.util.List;
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
	CommandLineRunner runner(UserService userService, DeliveryService deliveryService, CompanyService companyService,
							 DeliveryRepo deliveryRepo, OfficeService officeService) {
		return args -> {

			userService.saveUser(new AppUser(null,
					"stoqn_kolev@gmail.com",
					"Stoqn Kolev",
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

			AppUser tmp = new AppUser(null,
					"asd@gmail.com",
					"Test Subject",
					"123",
					RoleType.ADMIN,
					"user");
			userService.saveUser(tmp);

			Company company = new Company(null, "Ekont");
			companyService.saveCompany(company);

			Office o = new Office(null, "Office1", "Montevideo 15", company);
			officeService.saveOffice(o);
			company.addOffice(o);

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
					67.99);
			deliveryService.saveDelivery(d);
			tmp.addDelivery(d);

			Delivery d2 = new Delivery(null,
					company,
					tmp,
					"username2",
					"Ivan",
					DeliveryLocation.IN_OFFICE,
					"Berlin",
					LocalDate.now(),
					LocalDate.now(),
					65,
					1239.99);
			deliveryService.saveDelivery(d2);
			tmp.addDelivery(d2);



			//System.out.println(deliveryService.getDeliveries());
//			System.out.println("------------------------"+deliveryRepo.findByName("d_user_2"));
//			System.out.println("------------------------"+company.getOfficeList());

			userService.addRoleToUser("username1", "USER");
			userService.addRoleToUser("username3", "COURIER");
			userService.addRoleToUser("username4", "ADMIN");
		};
	}

}
