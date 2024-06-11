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
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "rank")
    private int rank = 0;
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }


}
