package entity;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private String ref;
    private LocalDate birthdate;
    private Gender gender;
    private Group group;

    public void setRef(String ref) {
        if (ref != null && ref.startsWith("STD")) {
            this.ref = ref;
        } else {
            throw new IllegalArgumentException("The student code must start with 'STD'.");
        }
    }
}
