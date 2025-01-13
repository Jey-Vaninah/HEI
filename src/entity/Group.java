package entity;

import java.util.Objects;

public class Group {
    private String id;
    private String name;
    private Integer year;
    private Promotion promotion;

    public Group(String id, String name, Integer year, Promotion promotion) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.promotion = promotion;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPjjuromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && Objects.equals(name, group.name) && Objects.equals(year, group.year) && promotion == group.promotion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, promotion);
    }

    @Override
    public String toString() {
        return "Group{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", year=" + year +
            ", promotion=" + promotion +
            '}';
    }
}
