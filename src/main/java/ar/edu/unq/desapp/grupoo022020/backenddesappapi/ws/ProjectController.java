package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects.LogExecutionTime;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ProjectService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/projects")
public class ProjectController extends CommonController<Project, ProjectService> {

	@LogExecutionTime
	@GetMapping
	public ResponseEntity<?> allProjects() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/open")
	public ResponseEntity<?> openProjects() {
		return ResponseEntity.ok(service.findOpen());
	}

	@GetMapping("/nextToEnd")
	public ResponseEntity<?> nextToEndProjects() {
		return ResponseEntity.ok(service.findNextToEnd());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Project> getById(@PathVariable String id) {
		var project = service.findByID(Integer.parseInt(id));
		if (project.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(project.get());
	}

	@PostMapping("/createOrUpdateProject")
	public ResponseEntity<Project> createOrUpdateProject(@RequestBody ProjectViewModel project) {

		var alreadyExist = service.existProjectWithLocation(project.idLocation);

		if (alreadyExist && project.id == 0) {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		} else {
			service.save(project);
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		}
	}
}
