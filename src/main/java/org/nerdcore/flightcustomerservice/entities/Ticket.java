package org.nerdcore.flightcustomerservice.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;

    @OneToMany(orphanRemoval = true)
    @JoinTable(name="Ticket_Attachment",
               joinColumns = {@JoinColumn(name="ticketId")},
                inverseJoinColumns = {@JoinColumn(name="attachmentId")})
    private List<Attachment> attachments = new ArrayList<>();
}
