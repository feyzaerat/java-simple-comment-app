package socialMedia.comment.services.dtos.requests.taskRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.services.dtos.requests.AddBaseRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest extends AddBaseRequest {
    private String title;
    private String content;
    private String username;

}
