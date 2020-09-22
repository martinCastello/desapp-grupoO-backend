package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class AdminUser extends User{

	public AdminUser(String name, String mail, String nickName, String password) {
		super(name, mail, nickName, password);
	}
	
	public void closeProject(Project project) {
		project.close();
	}
	
}