package org.orpheus.insurancepolicymanager.security.con_ser_rep;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.security.filter.JwtUtil;
import org.orpheus.insurancepolicymanager.security.model.User;
import org.orpheus.insurancepolicymanager.security.model.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String userRegister(String username, String password){

        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(UserRole.USER);

        try {
            userRepository.save(user);
            return "Welcome " + username;
        } catch (Exception e) {
            throw new RuntimeException("Failed to register user");
        }
    }

    public String userLogin(String username, String password){

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("Username not found");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
