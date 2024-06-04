package socialMedia.comment.services.dtos.responses.postResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.responses.BaseResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetPostResponse extends BaseResponse {
    private int id;
    private String title;
    private String content;
    private User user;

}
