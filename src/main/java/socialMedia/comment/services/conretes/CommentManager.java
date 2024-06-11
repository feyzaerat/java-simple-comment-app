package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.Comment;
import socialMedia.comment.repositories.CommentRepository;
import socialMedia.comment.repositories.UserRepository;
import socialMedia.comment.services.abstracts.CommentService;
import socialMedia.comment.services.dtos.requests.commentRequest.AddCommentRequest;
import socialMedia.comment.services.dtos.requests.commentRequest.UpdateCommentRequest;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentListResponse;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentManager implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetCommentListResponse> getAllComments() {
        List<Comment> comments = commentRepository.findAll();

        List<GetCommentListResponse> response = comments.stream().map(comment -> modelMapperService.forResponse().map(comment, GetCommentListResponse.class)).toList();
        return response;
    }

    @Override
    public GetCommentResponse getByCommentId(int id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        GetCommentResponse response = modelMapperService.forResponse().map(comment, GetCommentResponse.class);

        return response;
    }

    @Override
    public void addComment(AddCommentRequest request) {
        Comment comment = this.modelMapperService.forRequest().map(request, Comment.class);
        comment.setId(null);

        comment.setIsActive(1);
        comment.setRank(0);
        commentRepository.save(comment);

    }

    @Override
    public void updateComment(UpdateCommentRequest request) {
        commentRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException());
        Comment comment = this.modelMapperService.forRequest().map(request, Comment.class);

        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        this.commentRepository.delete(comment);
    }
}
