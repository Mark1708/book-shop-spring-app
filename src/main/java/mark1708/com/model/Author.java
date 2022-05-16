package mark1708.com.model;

import java.util.List;

public class Author {
    private Integer id;
    private String photo;
    private String slug;
    private String name;
    private String description;
    private List<Book> bookList;

    public Author(Integer id, String photo, String slug, String name, String description, List<Book> bookList) {
        this.id = id;
        this.photo = photo;
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.bookList = bookList;
    }

    public Author(String photo, String slug, String name, String description, List<Book> bookList) {
        this.photo = photo;
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.bookList = bookList;
    }

    public Author() {
    }

    public String getFirstLetter() {
        return name.substring(0, 1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
