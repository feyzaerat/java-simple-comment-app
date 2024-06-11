package socialMedia.comment.services.dtos.requests.taskRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.services.dtos.requests.UpdateBaseRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest{
    private Integer id;
    private String title;
    private String content;



}
