package ar.edu.unq.desapp.grupoo022020.backenddesappapi.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class ControllerRulesTest {

	@Test
    public void testSomeArchitectureRule() {
        JavaClasses importedClasses = new ClassFileImporter()
        		.importPackages("ar.edu.unq.desapp.grupoo022020.backenddesappapi");
    
        ArchRule rule = classes().that().areAnnotatedWith(RestController.class)
        		.or().haveNameMatching(".*Controller")
        		.should().resideInAPackage("..ws..");
    
        rule.check(importedClasses);
    }

}
