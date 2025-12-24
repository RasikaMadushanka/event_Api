package edu.icet.ecom.Model.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class registration_dto {
    private String id;
    private String name;
    private String email;

    // Connected DTO
   // private EventDto event;

    private String  registeredAt;
}
