package mn.domain;

import liquibase.pro.packaged.I;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String country;
}
