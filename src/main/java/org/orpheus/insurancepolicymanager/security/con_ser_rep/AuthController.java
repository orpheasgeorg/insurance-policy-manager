package org.orpheus.insurancepolicymanager.security.con_ser_rep;

import lombok.RequiredArgsConstructor;
import org.orpheus.insurancepolicymanager.security.DTO.AuthRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    final AuthService authService;


    @PostMapping("/register")
    public String register(@RequestBody AuthRequest user) {
        return authService.userRegister(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest user) {
        return authService.userLogin(user.getUsername(), user.getPassword());
    }
}
