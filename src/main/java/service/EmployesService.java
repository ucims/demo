package service;

import java.util.List;

import controller.request.CreateEmployesRequest;
import controller.request.UpdateEmployesRequest;
import model.Employes;

public interface EmployesService {
	
	void create(CreateEmployesRequest request);
	
	void update(Integer id, UpdateEmployesRequest request);
	
	List<Employes> findAll();
	
	Employes findById(Integer id);
	
	void delete(Integer id);
}
