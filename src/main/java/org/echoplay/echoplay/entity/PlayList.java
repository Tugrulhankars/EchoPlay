package org.echoplay.echoplay.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "playlists")
public class PlayList extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "playlist_media",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<MediaFile> mediaFiles;

    public PlayList() {
    }

    public PlayList(Long id, List<MediaFile> mediaFiles, User owner, String name) {
        this.id = id;
        this.mediaFiles = mediaFiles;
        this.owner = owner;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MediaFile> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
