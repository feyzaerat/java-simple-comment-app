package socialMedia.comment.services.dtos.responses.userResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.Comment;
import socialMedia.comment.models.Task;
import socialMedia.comment.models.Role;
import socialMedia.comment.services.dtos.responses.BaseResponse;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentListResponse;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskListResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetUserResponse extends BaseResponse {
    private int id;
    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String imgURL;
    private GetTaskListResponse taskList;
    private GetCommentListResponse commentList;


}
