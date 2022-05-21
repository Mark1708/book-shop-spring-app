package mark1708.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String photo;
    private String slug;
    private String name;
    @Column(columnDefinition = "TEXT")
    @Type(type = "org.hibernate.type.TextType")
    private String description;


    public String getFirstLetter() {
        return name.substring(0, 1);
    }
}
