package socialMedia.comment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMedia.comment.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
