package com.substring.helpdesk.DTO;

import com.substring.helpdesk.entity.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketRequest {

    private String summary;
    private String description;
    private String email;
    private String category;
    private Priority priority;

}
