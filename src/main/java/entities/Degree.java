package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@Table(name = "degrees")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

}

