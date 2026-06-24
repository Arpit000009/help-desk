package com.substring.helpdesk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="help_desk_tickets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String summary;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(unique = true)
    private String username;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    void preSave(){
        if(this.createdOn==null){
            this.createdOn = LocalDateTime.now();
        }
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate(){
        this.updatedOn = LocalDateTime.now();
    }
}
