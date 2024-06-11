package socialMedia.comment.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import socialMedia.comment.services.abstracts.AuthService;
import socialMedia.comment.services.dtos.requests.authRequests.AuthRequest;
import socialMedia.comment.services.dtos.requests.authRequests.SignUpRequest;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;
import socialMedia.comment.services.dtos.requests.userRequest.LoginRequest;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api")

public class AuthController {
    private final AuthService authService;


    @PostMapping("/login")
    public String login(@RequestBody @Valid AuthRequest authRequest) throws Exception {
          return authService.signIn(authRequest);

    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid SignUpRequest signUpRequest) throws Exception {
        this.authService.signUp(signUpRequest);
    }
}
