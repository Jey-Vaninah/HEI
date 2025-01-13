package entity;

import java.time.LocalDate;
import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", ref='" + ref + '\'' +
            ", birthdate=" + birthdate +
            ", gender=" + gender +
            ", group=" + group +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(ref, student.ref) && Objects.equals(birthdate, student.birthdate) && gender == student.gender && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ref, birthdate, gender, group);
    }

    public Student(String id, String name, String ref, LocalDate birthdate, Gender gender, Group group) {
        this.id = id;
        this.name = name;
        this.ref = ref;
        this.birthdate = birthdate;
        this.gender = gender;
        this.group = group;
    }
}
