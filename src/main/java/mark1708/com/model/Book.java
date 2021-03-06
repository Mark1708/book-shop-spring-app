package mark1708.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date pubDate;
    private Integer isBestseller;
    private String slug;
    private String title;
    private String image;
    @Column(columnDefinition = "TEXT")
    @Type(type = "org.hibernate.type.TextType")
    private String description;
    private Integer price;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer discount;
}
