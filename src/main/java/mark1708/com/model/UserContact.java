package mark1708.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="user_contact")
public class UserContact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private LoginType type;

    private Integer approved;
    private String code;

    @Column(name = "code_trials")
    private Integer codeTrials;

    @Column(name = "code_time")
    private Date codeTime;
    private String contact;

}
