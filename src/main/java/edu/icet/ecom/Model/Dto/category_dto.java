package edu.icet.ecom.Model.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class category_dto {
    private String id;
    private String name;
    private String slug;

    // One Category -> Many Events
    private List<event_dto> events;
}
