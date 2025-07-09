package org.echoplay.echoplay.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mails")
public class Mail extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String content;
    private String toEmail;

    public Mail(Long id, String toEmail, String content, String subject) {
        this.id = id;
        this.toEmail = toEmail;
        this.content = content;
        this.subject = subject;
    }

    public Mail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return toEmail;
    }

    public void setTo(String to) {
        this.toEmail = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
