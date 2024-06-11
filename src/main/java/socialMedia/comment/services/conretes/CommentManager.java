package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.exceptions.NotFoundException;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.Comment;
import socialMedia.comment.models.Task;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.CommentRepository;
import socialMedia.comment.repositories.TaskRepository;
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
    private final TaskRepository taskRepository;
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
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment Not Found"));
        GetCommentResponse response = modelMapperService.forResponse().map(comment, GetCommentResponse.class);

        return response;
    }

    @Override
    public List<GetCommentListResponse> getAllCommentsByTaskId(int taskId){
        Task task = this.taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("Task Not Found"));
        List<Comment> comments = task.getCommentList();

        List<GetCommentListResponse> responses = comments.stream().map(comment -> this.modelMapperService.forResponse().map(comment, GetCommentListResponse.class)).toList();
        return responses;
    }

    @Override
    public void addComment(AddCommentRequest request) {
        Comment comment = this.modelMapperService.forRequest().map(request, Comment.class);
        comment.setId(null);

        comment.setIsActive(1);
        comment.setRank(0);

        Task task = this.taskRepository.findById(request.getTaskId()).orElseThrow(() -> new NotFoundException("Task Not Found"));
        User user = this.userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new NotFoundException("User Not Found"));

        comment.setTask(task);
        comment.setUser(user);

        commentRepository.save(comment);

    }

    @Override
    public void updateComment(UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(request.getId()).orElseThrow(() -> new NotFoundException("Comment Not Found"));
        this.modelMapperService.forRequest().map(request, comment);


        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment Not Found"));
        this.commentRepository.delete(comment);
    }


}
