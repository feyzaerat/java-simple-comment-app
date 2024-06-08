package socialMedia.comment.services.dtos.responses.commentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;
import socialMedia.comment.services.dtos.responses.BaseResponse;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetCommentListResponse {
    private Integer id;
    private String content;
    private int userId;
    private LocalDateTime createdAt;
    private int isActive;

}
