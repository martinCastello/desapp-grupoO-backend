package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects.LogExecutionTime;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects.LogExecutionTimeAspectAnnotation;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ProjectService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/projects")
public class ProjectController {
	
	static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectAnnotation.class);

    @Autowired
    private ProjectService service;

    @LogExecutionTime
    @GetMapping
    public ResponseEntity<?> allProjects() {
        return ResponseEntity.ok(service.findAll());
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
