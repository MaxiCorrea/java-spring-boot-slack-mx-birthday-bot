package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SlackProperties {

    @Value("${slack.bot.token}")
    private String botToken;

    @Value("${slack.channel.id}")
    private String channelId;

    public String getBotToken() {
        return botToken;
    }

    public String getChannelId() {
        return channelId;
    }
}
