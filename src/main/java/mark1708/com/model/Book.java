package mark1708.com.model;

import java.util.Date;

public class Book {

    private Integer id;
    private Date pubDate;
    private Integer isBestseller;
    private String slug;
    private String title;
    private Author author;
    private String image;
    private String description;
    private Integer price;
    private Integer discount;

    public Book(Integer id, Date pubDate, Integer isBestseller, String slug, String title, Author author, String image, String description, Integer price, Integer discount) {
        this.id = id;
        this.pubDate = pubDate;
        this.isBestseller = isBestseller;
        this.slug = slug;
        this.title = title;
        this.author = author;
        this.image = image;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public Book(Date pubDate, Integer isBestseller, String slug, String title, Author author, String image, String description, Integer price, Integer discount) {
        this.pubDate = pubDate;
        this.isBestseller = isBestseller;
        this.slug = slug;
        this.title = title;
        this.author = author;
        this.image = image;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public Book() {
    }

    public Integer getNewPrice() {
        return price * (100 - discount) / 100;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
