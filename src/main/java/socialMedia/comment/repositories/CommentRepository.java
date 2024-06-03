package socialMedia.comment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMedia.comment.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
