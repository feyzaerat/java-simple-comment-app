package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.exceptions.InvalidPasswordException;
import socialMedia.comment.core.exceptions.NotFoundException;
import socialMedia.comment.models.Role;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.UserRepository;
import socialMedia.comment.services.abstracts.AuthService;
import socialMedia.comment.services.dtos.requests.authRequests.AuthRequest;
import socialMedia.comment.services.dtos.requests.authRequests.SignUpRequest;
import socialMedia.comment.services.dtos.requests.userRequest.AddUserRequest;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j

public class AuthManager implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Optional<User> getByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public User signUp(SignUpRequest request) throws Exception {

        User newUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .accountNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .authorities(Set.of(Role.ROLE_USER))

                .build();

        return this.userRepository.save(newUser);
    }
    @Override
    public String signIn(AuthRequest request) {
        Optional<User> user = this.userRepository.findByUsername(request.username());
        if (user.isEmpty()) {
            throw new NotFoundException("User Not Found !");
        }
        if (!passwordEncoder.matches(request.password(), user.get().getPassword())) {
            throw new InvalidPasswordException("Invalid Password");
        }

        return generateToken(request);
    }
    @Override
    public String generateToken(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.username());
        }

        log.info("Invalid username: " + request.username());
        throw new UsernameNotFoundException("Invalid username: " + request.username());
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



