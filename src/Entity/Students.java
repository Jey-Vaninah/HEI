package Entity;

import java.time.LocalDate;

public class Students {
    private String std;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private Gender gender;
    private String group;
    private Level level;
    private String address;
    private String email;

    public void setStd(String std) {
        if (std != null && std.startsWith("STD")) {
            this.std = std;
        } else {
            throw new IllegalArgumentException("The student code must start with 'STD'.");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.startsWith("hei")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("The email must start with 'hei'.");
        }
    }
}
