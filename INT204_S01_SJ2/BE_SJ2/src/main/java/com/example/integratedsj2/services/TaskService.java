package com.example.integratedsj2.services;


import com.example.integratedsj2.entities.Tasks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.integratedsj2.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Tasks findByID(Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Task id " + id +  " does not exist !!!"));
    }

    public List<Tasks> findAllTask() {
        return repository.findAll();
    }

}
