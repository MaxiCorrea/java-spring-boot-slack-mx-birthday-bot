package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.domain.SlackImage;
import como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.service.SlackBotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final SlackBotService service;

    public MessageController(SlackBotService service) {
        this.service = service;
    }

    @PostMapping("/")
    public String postMessage(@RequestBody String message) {
        return service.sendMessage(message);
    }

    @PostMapping("/image")
    public String postImage(@RequestBody SlackImage image) {
        return service.sendImage(
                image.getImageUrl(),
                image.getDescription(),
                image.getAltText());
    }

}
