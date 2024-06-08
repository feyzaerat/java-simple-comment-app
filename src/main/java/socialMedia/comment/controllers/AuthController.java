package socialMedia.comment.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import socialMedia.comment.models.User;
import socialMedia.comment.services.abstracts.AuthService;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;
import socialMedia.comment.services.dtos.requests.userRequest.LoginRequest;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api")

public class AuthController {
    private final AuthService authService;


    @PostMapping("/login")
    public void login(@RequestBody @Valid LoginRequest loginRequest){
       this.authService.login(loginRequest);
    }
    @PostMapping("/register")
    public void register(@RequestBody @Valid AddUserRequest addUserRequest){
        this.authService.register(addUserRequest);
    }
}
