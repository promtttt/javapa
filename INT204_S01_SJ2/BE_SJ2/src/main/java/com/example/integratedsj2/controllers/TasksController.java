package com.example.integratedsj2.controllers;


import com.example.integratedsj2.dtos.SimpleTaskDTO;
import com.example.integratedsj2.entities.Tasks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.integratedsj2.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TasksController {
    @Autowired
    TaskService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<Object> findAllTask(){
        List<Tasks> tasks = service.findAllTask();
        List<SimpleTaskDTO> taskDTOList = tasks.stream().map(task -> modelMapper.map(task, SimpleTaskDTO.class)).toList();
        return ResponseEntity.ok(taskDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findTaskByID(@PathVariable Integer id){
        Tasks task = service.findByID(id);
        return ResponseEntity.ok(task);
    }

}
