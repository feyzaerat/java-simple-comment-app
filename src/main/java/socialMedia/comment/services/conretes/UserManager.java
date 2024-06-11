package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.UserRepository;
import socialMedia.comment.services.abstracts.UserService;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.util.List;

@Service
@AllArgsConstructor


public class UserManager implements UserService {
    private final UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private final BCryptPasswordEncoder passwordEncoder;

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

    @Override
    public User createUser(AddUserRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .authorities(request.getAuthorities())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .isEnabled(true)

                .credentialsNonExpired(true)
                .build();
        user.setIsActive(1);
        user.setRank(0);

        return userRepository.save(user);
    }
}
