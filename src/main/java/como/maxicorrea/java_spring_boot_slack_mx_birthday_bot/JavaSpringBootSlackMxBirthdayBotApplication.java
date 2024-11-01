package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaSpringBootSlackMxBirthdayBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBootSlackMxBirthdayBotApplication.class, args);
	}

}
