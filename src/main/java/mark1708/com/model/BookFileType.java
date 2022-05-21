package mark1708.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="book_file_type")
public class BookFileType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(columnDefinition = "TEXT")
    @Type(type = "org.hibernate.type.TextType")
    private String description;

}
