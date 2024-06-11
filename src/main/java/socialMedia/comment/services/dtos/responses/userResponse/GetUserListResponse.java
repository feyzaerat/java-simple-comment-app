package socialMedia.comment.services.dtos.responses.userResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.Comment;
import socialMedia.comment.models.Task;
import socialMedia.comment.services.dtos.responses.BaseResponse;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetUserListResponse extends BaseResponse {
    private int id;
    private String username;
    private String email;

    private LocalDate birthDate;
    private String imgURL;

}
