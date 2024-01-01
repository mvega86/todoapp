package com.sacavix.todoapp.persistence.repository;

import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /*@Query("select t from Task t WHERE t.taskStatus ?1")
    List<Task> findAllByTaskStatusQuery(TaskStatus taskStatus);*/
    public List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
