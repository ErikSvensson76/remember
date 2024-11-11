package org.example.remember.service.persistence;

import org.example.remember.model.entity.TodoItemEntity;
import org.example.remember.service.repository.TodoItemEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class TodoItemService {

  private final TodoItemEntityRepository repository;

  public TodoItemService(TodoItemEntityRepository repository) {
    this.repository = repository;
  }

  public TodoItemEntity save(TodoItemEntity item) {
    if(item == null) throw new IllegalArgumentException("item cannot be null");
    return repository.save(item);
  }

}
