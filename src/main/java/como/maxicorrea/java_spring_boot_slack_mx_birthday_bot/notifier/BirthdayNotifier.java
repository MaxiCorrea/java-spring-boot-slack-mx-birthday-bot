package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.service.SlackBotService;

@Component
public class BirthdayNotifier {

    @Autowired
    private SlackBotService slackBotService;

    @Autowired
    private SlackBotService birthdayService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void notifyBirthdays() {
        birthdayService.getBirthdays().forEach((e) -> {
            if (e.isBirthday()) {
                slackBotService.sendMessage("¡Feliz cumpleaños, " + e.getName() + "! 🎉🎂");
            }
        });
    }

}
