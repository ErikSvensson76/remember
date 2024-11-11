package org.example.remember.service.repository;

import org.example.remember.model.entity.TodoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemEntityRepository extends JpaRepository<TodoItemEntity, String> {
}
