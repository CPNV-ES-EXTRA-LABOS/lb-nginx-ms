package ch.cpnv.tasks.repository;

import ch.cpnv.tasks.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>  {
}
