package ibs.kingcoin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Integer price;

    private String country;

    /*Coin, Banknote, Coin Set, Banknote Set, Mixed Set*/
    private String category;

    private Date issueYear;

    private Boolean published;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public int getIssueYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueYear);
        return calendar.get(Calendar.YEAR);
    }

    public void setIssueYear(Date issueYear) {
        this.issueYear = issueYear;
    }
}
