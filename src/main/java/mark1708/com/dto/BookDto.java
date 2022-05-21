package mark1708.com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mark1708.com.model.Author;

import java.util.Date;

@Data
@NoArgsConstructor
public class BookDto {
    private Integer id;
    private Date pubDate;
    private Integer isBestseller;
    private String slug;
    private String title;
    private String image;
    private String description;
    private Integer price;
    private Integer discount;
    private Author author;

    public Integer getNewPrice() {
        return price * (100 - discount) / 100;
    }
}
