package org.echoplay.echoplay.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity
public class User extends Auditable implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String verifyOtp;  //kulalnıcı kayıt olduktan sonra hesabı doğrulamak için gönderilen one time password
    private Boolean isAccountVerified;//Kullanıcının hesabını doğrulayıp doğrulamadığını tutar.
    private Long verifyOtpExpireAt;//verifyOtp kodunun son geçerlilik süresini zaman damgası (timestamp) olarak tutar.
    private String resetOtp;//Kullanıcı “şifremi unuttum” dediğinde gönderilen şifre sıfırlama OTP'si.
    private Long resetOtpExpireAt;//resetOtp’nin geçerlilik süresini (timestamp) tutar.




    @Enumerated(EnumType.STRING)
    private Role roles;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, String verifyOtp, Boolean isAccountVerified, Long verifyOtpExpireAt, String resetOtp, Long resetOtpExpireAt,  Boolean isDeleted, Role roles) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
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
