package org.echoplay.echoplay.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mails")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
