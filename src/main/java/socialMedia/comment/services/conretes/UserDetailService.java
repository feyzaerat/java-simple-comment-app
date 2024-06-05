package socialMedia.comment.services.conretes;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import socialMedia.comment.models.User;

import java.util.Optional;

@AllArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user = userService.getByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }
}
