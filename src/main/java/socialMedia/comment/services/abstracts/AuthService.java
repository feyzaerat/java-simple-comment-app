package socialMedia.comment.services.abstracts;

import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.requests.authRequests.AuthRequest;
import socialMedia.comment.services.dtos.requests.authRequests.SignUpRequest;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;
import socialMedia.comment.services.dtos.requests.userRequest.LoginRequest;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentResponse;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.util.List;
import java.util.Optional;


public interface AuthService {


    Optional<User> getByUsername(String username);

    User signUp(SignUpRequest request) throws Exception;

    String signIn(AuthRequest request);

    String generateToken(AuthRequest request);

    User createUser(AddUserRequest request);
}
