package mark1708.com.model;

public class BookAuthor {
    private Integer id;
    private Integer book_id;
    private Integer author_id;

    public BookAuthor(Integer id, Integer book_id, Integer author_id) {
        this.id = id;
        this.book_id = book_id;
        this.author_id = author_id;
    }

    public BookAuthor(Integer book_id, Integer author_id) {
        this.book_id = book_id;
        this.author_id = author_id;
    }

    public BookAuthor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }
}
