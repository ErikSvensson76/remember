package org.example.remember.service.persistence;

import org.example.remember.model.entity.TodoItemEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
@DirtiesContext
class TodoItemServiceTest {

  @Autowired private TestEntityManager entityManager;
  @Autowired private TodoItemService underTest;

  @Test
  void saveNewTodoItemEntity(){
    TodoItemEntity item = new TodoItemEntity(
        "Title",
        "Description",
        2,
        LocalDateTime.now()
    );

    TodoItemEntity persisted = underTest.save(item);

    assertNotNull(persisted);
    assertNotNull(persisted.getId());
    assertEquals(item.getTitle(), persisted.getTitle());
    assertEquals(item.getDescription(), persisted.getDescription());
    assertEquals(item.getPriority(), persisted.getPriority());
    assertNotNull(item.getCreatedAt());
    assertNull(item.getUpdatedAt());
  }

  @Test
  void saveUpdatedTodoItemEntity(){
    TodoItemEntity entity = entityManager.persist(
        new TodoItemEntity(
            "Clean toilets",
            "Some description",
            4,
            LocalDateTime.now()
        )
    );


    assertNotNull(entity);
    assertNotNull(entity.getCreatedAt());
    assertNotNull(entity.getUpdatedAt());

    TodoItemEntity persisted = new TodoItemEntity();
    persisted.setId(entity.getId());
    persisted.setTitle("Clean oven");
    persisted.setDescription("Some description");
    persisted.setPriority(2);
    persisted.setDeadLine(LocalDateTime.now().plusHours(3));
    persisted.setCreatedAt(entity.getCreatedAt());
    persisted.setUpdatedAt(entity.getUpdatedAt());
    persisted.setDone(true);


    TodoItemEntity update = underTest.save(persisted);
    entityManager.flush();

    assertNotNull(update);
    assertEquals(persisted.getId(), update.getId());
    assertEquals(persisted.getTitle(), update.getTitle());
    assertEquals(persisted.getDescription(), update.getDescription());
    assertEquals(persisted.getDeadLine(), update.getDeadLine());
    assertEquals(persisted.getPriority(), update.getPriority());
    assertEquals(persisted.getCreatedAt(), update.getCreatedAt());
    assertNotNull(update.getUpdatedAt());
    assertTrue(update.isDone(), "done should be true");
  }


}