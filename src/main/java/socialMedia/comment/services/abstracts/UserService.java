package socialMedia.comment.services.abstracts;

import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    GetUserResponse getByUserId(int id);

    User createUser(AddUserRequest request);
}
