package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ProjectService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("")
    public List<Project> allProjects() {
        List<Project> list = service.findAll();
        return list;
    }
    
    @GetMapping("/open")
    public List<Project> openProjects() {
        List<Project> list = service.findOpen();
        return list;
    }
    
    @GetMapping("/nextToEnd")
    public List<Project> nextToEndProjects() {
        List<Project> list = service.findNextToEnd();
        return list;
    }
   
}
