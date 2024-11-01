package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.SectionBlock;
import com.slack.api.model.block.composition.BlockCompositions;

import como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.domain.SlackMember;
import como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.properties.SlackProperties;

@Service
public class SlackBotService {

    private final Slack slack = Slack.getInstance();
    private final SlackProperties properties;

    public SlackBotService(SlackProperties properties) {
        this.properties = properties;
    }

    public String sendMessage(
            final String text) {
        try {
            String botToken = properties.getBotToken();
            String channelId = properties.getChannelId();
            ChatPostMessageResponse response = slack.methods(botToken).chatPostMessage(req -> req
                    .channel(channelId)
                    .text(text));
            return response.isOk() ? "Success" : "Error: " + response.getError();
        } catch (IOException | SlackApiException e) {
            return "Error " + e.getMessage();
        }
    }

    public String sendImage(
            final String imageUrl,
            final String text,
            final String altText) {
        try {
            String botToken = properties.getBotToken();
            String channelId = properties.getChannelId();
            ChatPostMessageResponse response = slack.methods(botToken).chatPostMessage(req -> req
                    .channel(channelId)
                    .text(text)
                    .blocks(Blocks.asBlocks(
                            SectionBlock.builder()
                                    .text(BlockCompositions.plainText(text))
                                    .build(),
                            Blocks.image(i -> i
                                    .imageUrl(imageUrl)
                                    .altText("")))));
            return response.isOk() ? "Success" : "Error: " + response.getError();
        } catch (IOException | SlackApiException e) {
            return "Error " + e.getMessage();
        }
    }

    public List<SlackMember> getBirthdays() {
        return List.of(new SlackMember("Maximiliano Correa", LocalDate.of(1991, 5, 29)));
    }

}
