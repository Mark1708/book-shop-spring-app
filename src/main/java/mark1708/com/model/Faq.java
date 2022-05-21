package mark1708.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="faq")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sort_index", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer sortIndex;
    private String question;
    @Column(columnDefinition = "TEXT")
    @Type(type = "org.hibernate.type.TextType")
    private String answer;

}
