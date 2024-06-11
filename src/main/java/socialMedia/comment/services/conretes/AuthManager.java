package socialMedia.comment.services.conretes;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.Comment;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.UserRepository;
import socialMedia.comment.services.abstracts.AuthService;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;
import socialMedia.comment.services.dtos.requests.userRequest.LoginRequest;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentResponse;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.util.List;
import java.util.Optional;
@Service

public class AuthManager implements AuthService {

    private final UserRepository userRepository;
    private ModelMapperService modelMapperService;


    private final BCryptPasswordEncoder passwordEncoder;

    public AuthManager(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User register(AddUserRequest request){
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
    @Override
    public String login(LoginRequest loginRequest){
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());

        if(user.isEmpty()){
            throw new EntityNotFoundException("User Not Found !!!");
        }
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return loginRequest.getUsername();
    }
}
