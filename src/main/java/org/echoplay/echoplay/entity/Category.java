package org.echoplay.echoplay.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "categories")
@Entity
public class Category extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MediaFile> mediaFiles;
    
    // Constructor
    public Category() {}
    
    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name, List<MediaFile> mediaFiles) {
        this.id = id;
        this.name = name;
        this.mediaFiles = mediaFiles;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    

    
    public List<MediaFile> getMediaFiles() {
        return mediaFiles;
    }
    
    public void setMediaFiles(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }
}
