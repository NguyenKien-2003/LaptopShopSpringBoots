package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.models.User;

public interface EmailService {
    public void sendVerificationEmail(User user);
    public void sendForgotPasswordEmail(User user);
}
