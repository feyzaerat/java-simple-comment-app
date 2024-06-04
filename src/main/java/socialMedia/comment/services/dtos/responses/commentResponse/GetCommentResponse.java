package socialMedia.comment.services.dtos.responses.commentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.responses.BaseResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetCommentResponse extends BaseResponse {
    private int id;
    private String content;
    private User user;

}
