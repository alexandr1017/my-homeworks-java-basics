package org.example.entity;


import org.example.util.FormatterDateTime;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="todo_list")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "is_done", columnDefinition = "TINYINT(1)")
    private Boolean isDone = false;
    private String description;
    private String createdDateTime = FormatterDateTime.fromLocalDateTimeToStr(LocalDateTime.now());

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
