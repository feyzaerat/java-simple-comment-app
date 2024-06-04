package socialMedia.comment.services.dtos.responses;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass

public abstract class BaseResponse {
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int isActive;
    private int rank;

}
