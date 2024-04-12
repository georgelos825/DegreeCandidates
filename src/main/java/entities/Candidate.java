package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private Date applicationDate;
    private String remarks;
    private boolean accepted;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private Degree degree;

}