package com.hunre.edu.laptop.dtos.requests;

import com.hunre.edu.laptop.models.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdatetionByAdmin {
    String name;
    String username;
    String email;
    String phoneNumber;
    String role;
    Set<String> roles;
    // MultipartFile avatar;
    boolean enabled;
}
