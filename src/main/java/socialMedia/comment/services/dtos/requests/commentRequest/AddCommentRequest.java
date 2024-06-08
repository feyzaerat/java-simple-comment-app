package socialMedia.comment.services.dtos.requests.commentRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddCommentRequest {
    @NotNull(message = "Comment cannot be Null !!")
    @NotBlank(message = "You have to any entry !!")
    private String content;
    private int userId;

}
