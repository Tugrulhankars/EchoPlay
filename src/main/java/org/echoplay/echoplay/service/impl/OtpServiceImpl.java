package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.entity.User;
import org.echoplay.echoplay.repository.UserRepository;
import org.echoplay.echoplay.service.OtpService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class OtpServiceImpl implements OtpService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public OtpServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void sendResetOtp(String email) {
        User existingUser=userRepository.findByEmail(email);
        String otp=String.valueOf(ThreadLocalRandom.current().nextInt(100000,1000000));
        long expiryTime=System.currentTimeMillis()+(15*60*1000);
        existingUser.setResetOtp(otp);
        existingUser.setResetOtpExpireAt(expiryTime);

        userRepository.save(existingUser);

    }

    @Override
    public void resetPassword(String email, String otp, String newPassword) {
          User existingUser=userRepository.findByEmail(email);
          if (existingUser.getResetOtp()==null || !existingUser.getResetOtp().equals(otp)){
              throw new RuntimeException("Invalid OTP");
          }
          if (existingUser.getResetOtpExpireAt()<System.currentTimeMillis()){
              throw new RuntimeException("OTP Expired");
          }

          existingUser.setPassword(passwordEncoder.encode(newPassword));
          existingUser.setResetOtp(null);
          existingUser.setResetOtpExpireAt(0L);
          userRepository.save(existingUser);
    }

    @Override
    public void sendOtp(String email) {
        User existingUser=userRepository.findByEmail(email);

        if (existingUser.getAccountVerified() !=null && existingUser.getAccountVerified()){
            return;
        }

        String otp = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));
        long expiryTime = System.currentTimeMillis() + (24 * 60 * 60 * 1000);

        existingUser.setVerifyOtp(otp);
        existingUser.setResetOtpExpireAt(expiryTime);
        userRepository.save(existingUser);
    }

    @Override
    public void verifyOtp(String email, String otp) {
        User existingUser=userRepository.findByEmail(email);
        if (existingUser.getVerifyOtp()==null || !existingUser.getVerifyOtp().equals(otp)){
            throw new RuntimeException("Invalid OTP");
        }
        if (existingUser.getResetOtpExpireAt()<System.currentTimeMillis()){
            throw new RuntimeException("OTP Expired");
        }
        existingUser.setAccountVerified(true);
        existingUser.setVerifyOtp(null);
        existingUser.setResetOtpExpireAt(0L);
        userRepository.save(existingUser);
    }
}
