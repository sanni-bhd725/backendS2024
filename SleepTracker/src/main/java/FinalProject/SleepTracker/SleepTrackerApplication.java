package FinalProject.SleepTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import FinalProject.SleepTracker.domain.AppUser;
import FinalProject.SleepTracker.domain.AppUserRepository;
import FinalProject.SleepTracker.domain.Sleep;
import FinalProject.SleepTracker.domain.SleepRepository;

@SpringBootApplication
public class SleepTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleepTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDemoData(SleepRepository sRepository,
			AppUserRepository uRepository) {

		return (args) -> {
			System.out.println("Creating demo user data");
			// passwords are "admin" and "user"
			AppUser admin = new AppUser("admin",
					"$2a$10$7n.YdPdbIylPNNKsRd6IUexj79M9mGmA0dEp0vOtpM82sbpCA27Z6",
					"admin@example.com", "ADMIN");
			AppUser user1 = new AppUser("SleepGeek",
					"$2y$10$YNegnizLUY2lXnSCXDDpc.0LNyGVJfQjY8OFiw5c5ihJHFzaLAZgy",
					"user1@example.com", "USER");
			AppUser user2 = new AppUser("BadSleeper",
					"$2y$10$YNegnizLUY2lXnSCXDDpc.0LNyGVJfQjY8OFiw5c5ihJHFzaLAZgy",
					"user2@example.com", "USER");

			uRepository.save(admin);
			uRepository.save(user1);
			uRepository.save(user2);

			System.out.println("Creating demo sleeping data");

			sRepository.save(new Sleep(user2, "01.03.2024", 65,
					4, 2));
			sRepository.save(new Sleep(user1, "15.03.2024", 95,
					8, 5));
			sRepository.save(new Sleep(user1, "16.03.2024", 88,
					7, 4));
			sRepository.save(new Sleep(user2, "08.04.2024", 77,
					5, 3));

			System.out.println("Showing data");
			for (Sleep sleep : sRepository.findAll()) {
				System.out.println("Sleep demo data: " + sleep.toString());
			}

		};
	}
}
