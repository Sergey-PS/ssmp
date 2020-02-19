package mn.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String language;
}
