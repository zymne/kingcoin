package ibs.kingcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Integer price;

    @ManyToOne
    private Country country;

    /*Coin, Banknote, Coin Set, Banknote Set, Mixed Set*/
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "item")
    private List<Image> images;

    private Date issueYear;

    private Boolean published = true;

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
        return country.getName();
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCategory() {
        return category.getName();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public int getIssueYear() {

        if(issueYear == null)
            return -1;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueYear);
        return calendar.get(Calendar.YEAR);
    }

    public void setIssueYear(Date issueYear) {
        this.issueYear = issueYear;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
