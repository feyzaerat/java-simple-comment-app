package socialMedia.comment.services.dtos.responses.taskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetTaskListResponse{
    private int id;
    private String title;
    private String content;
    private int userId;

}
