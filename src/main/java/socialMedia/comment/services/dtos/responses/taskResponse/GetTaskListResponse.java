package socialMedia.comment.services.dtos.responses.taskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.responses.BaseResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetTaskListResponse extends BaseResponse {
    private int id;
    private String title;
    private String content;
    private int userId;

}
