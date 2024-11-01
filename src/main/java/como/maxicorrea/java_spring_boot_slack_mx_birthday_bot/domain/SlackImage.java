package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.domain;

public class SlackImage {

    private String imageUrl;
    private String description;
    private String altText;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setDescription(String descriptionI) {
        this.description = descriptionI;
    }

    public String getDescription() {
        return description;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getAltText() {
        return altText;
    }
}
