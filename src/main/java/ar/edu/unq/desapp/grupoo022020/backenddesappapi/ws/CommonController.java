package ar.edu.unq.desapp.grupoo022020.backenddesappapi.ws;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.service.CommonService;

@CrossOrigin(origins = "*")
public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody E entity, BindingResult result){
		if(result.hasErrors())
			return this.valid(result);
		E entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}
	
	protected ResponseEntity<?> valid(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}
