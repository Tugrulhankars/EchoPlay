package org.echoplay.echoplay.service;

public interface OtpService {
    void sendResetOtp(String email);
    void resetPassword(String email,String otp,String newPassword);
    void sendOtp(String email);
    void verifyOtp(String email,String otp);

}
