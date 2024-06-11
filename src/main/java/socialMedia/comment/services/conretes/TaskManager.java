package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.Task;
import socialMedia.comment.repositories.TaskRepository;
import socialMedia.comment.services.abstracts.TaskService;
import socialMedia.comment.services.dtos.requests.taskRequest.AddTaskRequest;
import socialMedia.comment.services.dtos.requests.taskRequest.UpdateTaskRequest;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskListResponse;
import socialMedia.comment.services.dtos.responses.taskResponse.GetTaskResponse;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskManager implements TaskService {
    private final TaskRepository taskRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetTaskListResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        List<GetTaskListResponse> response = tasks.stream().map(task -> modelMapperService.forResponse().map(task, GetTaskListResponse.class)).toList();
        return response;
    }

    @Override
    public GetTaskResponse getTaskById(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException());

        GetTaskResponse response = modelMapperService.forResponse().map(task, GetTaskResponse.class);

        return response;
    }

    @Override
    public void addTask(AddTaskRequest request) {
        Task task = this.modelMapperService.forRequest().map(request, Task.class);
        task.setId(null);

       /* task.setIsActive(1);
        task.setRank(0);*/
        taskRepository.save(task);

    }

    @Override
    public void updateTask(UpdateTaskRequest request) {
        taskRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException());
        Task task = this.modelMapperService.forRequest().map(request, Task.class);

        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException());
        this.taskRepository.delete(task);
    }
}
