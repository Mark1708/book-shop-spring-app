package mark1708.com.model;

public class BookGenre {
    private Integer id;
    private Integer book_id;
    private Integer genre_id;

    public BookGenre(Integer id, Integer book_id, Integer genre_id) {
        this.id = id;
        this.book_id = book_id;
        this.genre_id = genre_id;
    }

    public BookGenre(Integer book_id, Integer genre_id) {
        this.book_id = book_id;
        this.genre_id = genre_id;
    }

    public BookGenre() {
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

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }
}
