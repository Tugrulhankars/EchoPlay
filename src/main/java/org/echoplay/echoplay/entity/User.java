package org.echoplay.echoplay.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String verifyOtp;
    private Boolean isAccountVerified;
    private Long verifyOtpExpireAt;
    private String resetOtp;
    private Long resetOtpExpireAt;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private Boolean isDeleted;
    @Enumerated(EnumType.STRING)
    private Role roles;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, String verifyOtp, Boolean isAccountVerified, Long verifyOtpExpireAt, String resetOtp, Long resetOtpExpireAt, Timestamp createdAt, Timestamp updatedAt, Boolean isDeleted, Role roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.verifyOtp = verifyOtp;
        this.isAccountVerified = isAccountVerified;
        this.verifyOtpExpireAt = verifyOtpExpireAt;
        this.resetOtp = resetOtp;
        this.resetOtpExpireAt = resetOtpExpireAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getResetOtpExpireAt() {
        return resetOtpExpireAt;
    }

    public void setResetOtpExpireAt(Long resetOtpExpireAt) {
        this.resetOtpExpireAt = resetOtpExpireAt;
    }

    public String getResetOtp() {
        return resetOtp;
    }

    public void setResetOtp(String resetOtp) {
        this.resetOtp = resetOtp;
    }

    public Long getVerifyOtpExpireAt() {
        return verifyOtpExpireAt;
    }

    public void setVerifyOtpExpireAt(Long verifyOtpExpireAt) {
        this.verifyOtpExpireAt = verifyOtpExpireAt;
    }

    public Boolean getAccountVerified() {
        return isAccountVerified;
    }

    public void setAccountVerified(Boolean accountVerified) {
        isAccountVerified = accountVerified;
    }

    public String getVerifyOtp() {
        return verifyOtp;
    }

    public void setVerifyOtp(String verifyOtp) {
        this.verifyOtp = verifyOtp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
