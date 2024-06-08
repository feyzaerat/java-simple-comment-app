package socialMedia.comment.services.dtos.requests.commentRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCommentRequest {
    @Positive(message = "Id mus be a positive number")
    @NotNull(message = "Comment ID cannot be Null !!")
    private Integer id;

    @NotNull(message = "Comment cannot be Null !!")
    @NotBlank(message = "You have to any entry !!")
    private String content;
}
