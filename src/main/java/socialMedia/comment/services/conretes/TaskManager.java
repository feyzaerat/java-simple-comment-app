package socialMedia.comment.services.conretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import socialMedia.comment.core.exceptions.NotFoundException;
import socialMedia.comment.core.utilities.mappers.ModelMapperService;
import socialMedia.comment.models.Task;
import socialMedia.comment.models.User;
import socialMedia.comment.repositories.TaskRepository;
import socialMedia.comment.repositories.UserRepository;
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
    private UserRepository userRepository;
    @Override
    public List<GetTaskListResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        List<GetTaskListResponse> response = tasks.stream().map(task -> modelMapperService.forResponse().map(task, GetTaskListResponse.class)).toList();
        return response;
    }

    @Override
    public GetTaskResponse getTaskById(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task Not Found"));

        GetTaskResponse response = modelMapperService.forResponse().map(task, GetTaskResponse.class);

        return response;
    }

    @Override
    public void addTask(AddTaskRequest request) {
        Task task = this.modelMapperService.forRequest().map(request, Task.class);
        User user = this.userRepository.findByUsername(request.getUserName()).orElseThrow(() -> new NotFoundException("User Not Found"));

        task.setId(null);
        task.setUser(user);

       /* task.setIsActive(1);
        task.setRank(0);*/
        taskRepository.save(task);

    }

    @Override
    public void updateTask(UpdateTaskRequest request) {
        Task task = taskRepository.findById(request.getId()).orElseThrow(() -> new NotFoundException("Task Not Found"));
        this.modelMapperService.forRequest().map(request, task);

        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task Not Found"));
        this.taskRepository.delete(task);
    }
}
