package socialMedia.comment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMedia.comment.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
