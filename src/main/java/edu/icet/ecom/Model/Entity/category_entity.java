package edu.icet.ecom.Model.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class category_entity {
    private String id;
    private String name;
    private String slug;

}
