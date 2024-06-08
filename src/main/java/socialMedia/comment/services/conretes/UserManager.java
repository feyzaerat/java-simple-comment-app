package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.UserRepository;
import socialMedia.comment.services.abstracts.UserService;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.util.List;

@Service
@AllArgsConstructor


public class UserManager implements UserService {
    private final UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public GetUserResponse getByUserId(int id) {
        User response = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        GetUserResponse user = modelMapperService.forResponse().map(response, GetUserResponse.class);

        return user;
    }
}
