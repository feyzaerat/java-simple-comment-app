package socialMedia.comment.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import socialMedia.comment.services.abstracts.TaskService;
import socialMedia.comment.services.dtos.requests.taskRequest.AddTaskRequest;
import socialMedia.comment.services.dtos.requests.taskRequest.UpdateTaskRequest;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskListResponse;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("api/tasks")
public class TasksController {
    private final TaskService taskService;

    @GetMapping()
    public List<GetTaskListResponse> getAllTasks(){
        return this.taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public GetTaskResponse getById(@PathVariable int id){
        return this.taskService.getTaskById(id);
    }

    @PostMapping("/add-task")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewTask(@RequestBody AddTaskRequest addTaskRequest){
        this.taskService.addTask(addTaskRequest);
    }

    @PutMapping
    public void updateTask(@RequestBody @Valid UpdateTaskRequest updateTaskRequest){
        this.taskService.updateTask(updateTaskRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id){
        this.taskService.deleteTask(id);
    }
}
