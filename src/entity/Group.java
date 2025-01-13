package entity;

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
    public Group() {}

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

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
