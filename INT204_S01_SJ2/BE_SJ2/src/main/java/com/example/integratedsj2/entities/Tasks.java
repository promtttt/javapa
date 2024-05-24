package com.example.integratedsj2.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskID", nullable = false)
    private Integer id;
    @Column(name = "taskTitle", nullable = false, length = 100)
    private String title;
    @Column(name = "taskDescription", length = 500)
    private String description;
    @Column(name = "taskAssignees", length = 30)
    private String assignees;
    @Enumerated(EnumType.STRING)
    @Column(name = "taskStatus")
    private Status status;

    @Column(name = "createdOn")
    private ZonedDateTime createdOn;

    @Column(name = "updatedOn")
    private ZonedDateTime updatedOn;
}

