package socialMedia.comment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass


public  abstract class BaseEntity{


    @CreatedDate
    @Column(name = "created_at",nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    @Column(name = "rank",nullable = false)
    private int rank = 0;


}
