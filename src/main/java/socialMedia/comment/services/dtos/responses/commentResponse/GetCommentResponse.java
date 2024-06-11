package socialMedia.comment.services.dtos.responses.commentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.responses.BaseResponse;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskResponse;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetCommentResponse {
    private Integer id;
    private String content;
    private GetUserResponse user;
    private GetTaskResponse task;
    private LocalDateTime createdAt;
    private int isActive;

}
