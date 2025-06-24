package org.echoplay.echoplay.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "listening_history")
public class ListeningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User listener;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id")
    private MediaFile mediaFile;

    private LocalDateTime listenedAt;

    public ListeningHistory() {
    }

    public ListeningHistory(Long id, MediaFile mediaFile, User listener, LocalDateTime listenedAt) {
        this.id = id;
        this.mediaFile = mediaFile;
        this.listener = listener;
        this.listenedAt = listenedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getListenedAt() {
        return listenedAt;
    }

    public void setListenedAt(LocalDateTime listenedAt) {
        this.listenedAt = listenedAt;
    }

    public MediaFile getMediaFile() {
        return mediaFile;
    }

    public void setMediaFile(MediaFile mediaFile) {
        this.mediaFile = mediaFile;
    }

    public User getListener() {
        return listener;
    }

    public void setListener(User listener) {
        this.listener = listener;
    }
}
