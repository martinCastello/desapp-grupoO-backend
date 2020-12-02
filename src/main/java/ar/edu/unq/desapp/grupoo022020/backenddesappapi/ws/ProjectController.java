package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.aspects.LogExecutionTime;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.jwt.JwtService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Location;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.Project;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.EmailService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ListWaitingSending;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.LocationService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.ProjectService;
import ar.edu.unq.desapp.grupoo022020.backenddesappapi.viewmodel.ProjectViewModel;

@RestController
@RequestMapping(path = "/home/projects", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProjectController extends CommonController<Project, ProjectService>{
	
	@Autowired
	private LocationService locationService;
	@Autowired
	private JwtService jwtService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ListWaitingSending listWaitingSendingService;
	
    @LogExecutionTime
    @GetMapping
    public ResponseEntity<?> allProjects(/*@RequestHeader("Authorization") String header*/) {
//    	String token = header.split(" ")[1];
//    	try {
//    		if(jwtService.hasTokenExpired(token)) {
//        		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        	}else {
//        		return ResponseEntity.ok(service.findAll());
//        	}
//    	}catch(Exception e) {
//    		return ResponseEntity.ok(service.findAll());
//    	}
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

		try {
			Location location = this.locationService.findByID(project.getLocationId());
			Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(project.getEndDate());
			Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(project.getStartDate());
			Project proj;
			if (alreadyExist) {
				proj  = this.service.findByID(project.getProjectId()).get();
			} else {
				proj = new Project(project.getName(), endDate, startDate, location);
			}
			proj.setFactor(project.getFactor());
			service.save(proj);
			return new ResponseEntity<Project>(proj, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("close/{id}")
	public ResponseEntity<?> closeById(@PathVariable String id) {
		Optional<Project> project = this.service.findByID(Integer.parseInt(id));
		if (project.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Project projectToClose = project.get();
		projectToClose.close();
		
		String subject = "Cierre de Proyecto";
		String text = projectToClose.getName() + " cerrado.";
		for(UserDonator user : listWaitingSendingService.getUsers(projectToClose.getId())){
			emailService.sendSimpleMessage(user.getMail(), subject, text);
		}
		
		service.save(projectToClose);
		return new ResponseEntity<Project>(projectToClose, HttpStatus.OK);
	}
   
}
