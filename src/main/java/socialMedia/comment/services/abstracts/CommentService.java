package socialMedia.comment.services.abstracts;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import socialMedia.comment.services.dtos.requests.commentRequest.AddCommentRequest;
import socialMedia.comment.services.dtos.requests.commentRequest.UpdateCommentRequest;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentListResponse;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentResponse;

import java.util.List;


public interface CommentService {
    List<GetCommentListResponse> getAllComments();
    GetCommentResponse getByCommentId(int id);

    List<GetCommentListResponse> getAllCommentsByTaskId(int taskId);

    void addComment(AddCommentRequest request);
    void updateComment(UpdateCommentRequest request);
    void deleteComment(int id);
}
