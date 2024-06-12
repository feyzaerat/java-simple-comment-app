package socialMedia.comment.services.abstracts;

import socialMedia.comment.models.Task;
import socialMedia.comment.services.dtos.requests.taskRequest.AddTaskRequest;
import socialMedia.comment.services.dtos.requests.taskRequest.UpdateTaskRequest;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskListResponse;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskResponse;

import java.util.List;

public interface TaskService {
    List<GetTaskListResponse> getAllTasks();

    GetTaskResponse getTaskById(int id);
    void addTask(AddTaskRequest request);
    void updateTask(UpdateTaskRequest request);
    void deleteTask(int id);

}
