package mark1708.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sort_index", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer sortIndex;

    private String slug;
    private String title;
    @Column(columnDefinition = "TEXT")
    @Type(type = "org.hibernate.type.TextType")
    private String text;
}
