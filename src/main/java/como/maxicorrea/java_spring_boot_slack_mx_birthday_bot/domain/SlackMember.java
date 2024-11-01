package como.maxicorrea.java_spring_boot_slack_mx_birthday_bot.domain;

import java.time.LocalDate;
import java.util.Objects;

public class SlackMember {

    private String name;
    private LocalDate birthday;

    public SlackMember(
            final String name,
            final LocalDate birthDate) {
        this.name = Objects.requireNonNull(name);
        this.birthday = Objects.requireNonNull(birthDate);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isBirthday() {
        LocalDate today = LocalDate.now();
        return birthday.getMonth() == today.getMonth() &&
                birthday.getDayOfMonth() == today.getDayOfMonth();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        SlackMember other = (SlackMember) obj;
        return this.name.equals(other.name) &&
                this.birthday.equals(other.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday());
    }

}
