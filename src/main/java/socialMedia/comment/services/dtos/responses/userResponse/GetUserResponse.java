package socialMedia.comment.services.dtos.responses.userResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMedia.comment.models.Comment;
import socialMedia.comment.models.Post;
import socialMedia.comment.models.Role;
import socialMedia.comment.services.dtos.responses.BaseResponse;
import java.time.LocalDate;
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
    private Post postList;
    private Comment commentList;
    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Set<Role> authorities;
}
