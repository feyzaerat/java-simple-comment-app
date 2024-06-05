package socialMedia.comment.services.conretes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.UserRepository;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public User createUser(AddUserRequest request){
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .authorities(request.getAuthorities())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .isEnabled(true)
                .credentialsNonExpired(true)
            .build();

        return userRepository.save(user);
    }
}
