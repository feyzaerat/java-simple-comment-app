package socialMedia.comment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMedia.comment.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
