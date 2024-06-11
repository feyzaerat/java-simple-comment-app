package socialMedia.comment.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import socialMedia.comment.services.abstracts.CommentService;
import socialMedia.comment.services.dtos.requests.commentRequest.AddCommentRequest;
import socialMedia.comment.services.dtos.requests.commentRequest.UpdateCommentRequest;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentListResponse;
import socialMedia.comment.services.dtos.responses.commentResponse.GetCommentResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/comments")
public class CommentsController {
    private final CommentService commentService;

    @GetMapping()
    public List<GetCommentListResponse> getAllComments() {
        return this.commentService.getAllComments();
    }

    @GetMapping("/getAllCommentsByTaskId/{taskId}")
    public List <GetCommentListResponse> getAllCommentsByTaskId(@PathVariable int taskId ){
        return this.commentService.getAllCommentsByTaskId(taskId);

    }

    @GetMapping("/{id}")
    public GetCommentResponse getById(@PathVariable int id) {
        return this.commentService.getByCommentId(id);
    }

    @PostMapping("/add-comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewComment(@RequestBody AddCommentRequest addCommentRequest) {
        this.commentService.addComment(addCommentRequest);
    }

    @PutMapping
    public void updateComment(@RequestBody UpdateCommentRequest updateCommentRequest) {
        this.commentService.updateComment(updateCommentRequest);

    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        this.commentService.deleteComment(id);
    }
}
