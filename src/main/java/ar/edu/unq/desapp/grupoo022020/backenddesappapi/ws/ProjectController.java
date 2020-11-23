package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.utils.DateUtils;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel.ProjectViewModel;

@RestController
@EnableAutoConfiguration
@RequestMapping("/home/projects")
public class ProjectController extends CommonController<Project, ProjectService>{
	
	@Autowired
	private LocationService locationService;

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
	public ResponseEntity<?> getById(@PathVariable String id) {
		Optional<Project> project = this.service.findByID(Integer.parseInt(id));
		if (project.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(project.get());
	}

	@PostMapping("/createOrUpdateProject")
	public ResponseEntity<Project> createOrUpdateProject(@RequestBody ProjectViewModel project) throws Exception {

		boolean alreadyExist = this.service.existProjectWithLocation(project.getLocationId());

		if (alreadyExist && project.getProjectId() == 0) {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		} else {
			Location location = this.locationService.findByID(project.getLocationId());
			Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(project.getEndDate());
			Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(project.getStartDate());
			Project proj = new Project(project.getName(), endDate, startDate, location);
			proj.setFactor(project.getFactor());
			service.save(proj);
			return new ResponseEntity<Project>(proj, HttpStatus.OK);
		}
	}
   
}
