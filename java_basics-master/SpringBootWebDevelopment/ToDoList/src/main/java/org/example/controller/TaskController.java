package org.example.controller;

import org.example.entity.Task;
import org.example.repository.TaskRepo;
import org.example.util.FormatterDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;

    @PostMapping("/tasks")
    public ResponseEntity createTask(@RequestBody Task task) {
        try {
            taskRepo.save(task);
            return ResponseEntity.status(HttpStatus.CREATED).body("Задача добавлена!");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity completeTask(@PathVariable Integer id, @RequestBody Task taskDetails) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не найдена!");
        }
        Task task = optionalTask.get();
        if (taskDetails.getIsDone() != null) {
            task.setIsDone(taskDetails.getIsDone());
        }
        if (taskDetails.getTitle() != null) {
            task.setTitle(taskDetails.getTitle());
        }
        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }
        task.setCreatedDateTime(FormatterDateTime.fromLocalDateTimeToStr(LocalDateTime.now()));
        return ResponseEntity.ok(taskRepo.save(task));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не найдена!");
        }
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public List<Task> taskList() {
        Iterable<Task> taskIterable = taskRepo.findAll();
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable Integer id) {
        Optional<Task> optionalTask = taskRepo.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не найдена!");
        }
        taskRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Задача успешно удалена!");
    }
}

