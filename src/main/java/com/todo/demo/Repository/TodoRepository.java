package com.todo.demo.Repository;

import com.todo.demo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task,Long> {
}
