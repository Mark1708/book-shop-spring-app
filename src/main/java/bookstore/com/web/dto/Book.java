package bookstore.com.web.dto;

import javax.validation.constraints.*;

public class Book {
    private Integer id;
    @NotEmpty(message = "Author name must be not empty")
    @Size(min = 1, max = 250, message = "Value must be between 1 and 250")
    private String author;
    @NotEmpty(message = "Title name must be not empty")
    @Size(min = 1, max = 250, message = "Value must be between 1 and 250")
    private String title;
    @NotNull(message = "Size field must be not empty")
    @Digits(integer = 4, fraction = 0, message = "Size value must be digit and less than 4 signs")
    @Min(value = 1)
    private Integer size;

    public Book(Integer id, String author, String title, Integer size) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.size = size;
    }

    public Book(String author, String title, Integer size) {
        this.author = author;
        this.title = title;
        this.size = size;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
