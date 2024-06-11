package socialMedia.comment.services.dtos.responses.taskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.responses.BaseResponse;
import socialMedia.comment.services.dtos.responses.userResponse.GetUserResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetTaskResponse extends BaseResponse {
    private int id;
    private String title;
    private String content;
    private GetUserResponse user;


}
