package ar.edu.unq.desapp.grupoo022020.backenddesappapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.UserDonator;

@Service
public class ListWaitingSending {
	
	private Map<Integer, List<UserDonator>> users = new HashMap<Integer, List<UserDonator>>();
	
	public void  addUsers(Integer projectId, UserDonator user) {
		if(!this.users.containsKey(projectId)) {
			this.users.put(projectId, new ArrayList<UserDonator>());
		}
		this.users.get(projectId).add(user);
	}
	
	public List<UserDonator> getUsers(Integer projectId){
		return this.users.get(projectId);
	}
}
