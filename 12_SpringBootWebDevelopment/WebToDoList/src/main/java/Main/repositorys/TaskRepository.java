package Main.repositorys;

import Main.models.Task;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task,Long> {
}
