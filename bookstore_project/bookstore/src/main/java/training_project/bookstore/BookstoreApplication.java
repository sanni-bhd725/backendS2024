package training_project.bookstore;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import training_project.bookstore.domain.*;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	/*
	 * ~~ h2 ajonaikaisen tietokannan demodata ~~
	 * 
	 * @Bean
	 * public CommandLineRunner createDemoData(BookRepository bRepository,
	 * CategoryRepository cRepository,
	 * AppUserRepository urepository) {
	 * return (args) -> {
	 * System.out.println("Creating demo data");
	 * 
	 * cRepository.save(new Category("Contemporary fiction"));
	 * cRepository.save(new Category("Historical fiction"));
	 * cRepository.save(new Category("Historical non-fiction"));
	 * 
	 * bRepository.save(new Book("Kjell Westö",
	 * "978-951-1-38706-0",
	 * "Molly & Henry",
	 * 2023,
	 * 29.95, cRepository.findByName("Historical fiction").get(0)));
	 * 
	 * bRepository.save(new Book("Mirja Mäntylä",
	 * "978-952-371-049-8",
	 * "Tampereen kartanot",
	 * 2022,
	 * 47.00,
	 * cRepository.findByName("Historical non-fiction").get(0)));
	 * 
	 * bRepository.save(new Book("Johannes Alaranta",
	 * "978-952-396-106-7",
	 * "Armoton pohjanmeri",
	 * 2023,
	 * 25.00,
	 * cRepository.findByName("Contemporary fiction").get(0)));
	 * 
	 * bRepository.save(new Book("Henri Nyholm",
	 * "978-952-379-293-7",
	 * "Vajonnut kaupunki",
	 * 2024,
	 * 26.95,
	 * cRepository.findByName("Contemporary fiction").get(0)));
	 * 
	 * AppUser user1 = new AppUser("user",
	 * "$2a$10$AWcRJ2FU4HKu2JQJ2tsLOOLfgqsIT7HTuFQ5x.Co9NS4lnpZXfgoW",
	 * "user1@example.com", "USER");
	 * AppUser user2 = new AppUser("admin",
	 * "$2a$10$7n.YdPdbIylPNNKsRd6IUexj79M9mGmA0dEp0vOtpM82sbpCA27Z6",
	 * "user2@example.com", "ADMIN");
	 * 
	 * urepository.save(user1);
	 * urepository.save(user2);
	 * 
	 * System.out.println("Showing data");
	 * for (Book book : bRepository.findAll()) {
	 * System.out.println("Book details: " + book.toString());
	 * }
	 * };
	 * }
	 */
}
