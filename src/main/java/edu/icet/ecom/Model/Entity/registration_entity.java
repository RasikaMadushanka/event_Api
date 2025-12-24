package edu.icet.ecom.Model.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class registration_entity {
    private String id;
    private String name;
    private String email;

    // Connected DTO
    //private EventDto event;

    private String registeredAt;
}
