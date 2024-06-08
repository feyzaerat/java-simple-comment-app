package socialMedia.comment.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import socialMedia.comment.models.User;
import socialMedia.comment.services.abstracts.AuthService;
import socialMedia.comment.services.abstracts.UserService;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentResponse;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable int id) {
        return this.userService.getByUserId(id);
    }


}
