package socialMedia.comment.services.dtos.requests.userRequest;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.hibernate.annotations.processing.Pattern;
import socialMedia.comment.models.Role;
import socialMedia.comment.services.dtos.requests.AddBaseRequest;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AddUserRequest extends AddBaseRequest {
    @NotNull(message = " Username Can Not Be Empty !")
    @Size

    private String username;
    private String email;
    private String password;
    private Set<Role> authorities;
}
