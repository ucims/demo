package service.impl;

import java.util.List;

import controller.request.UpdateEmployesRequest;
import org.springframework.beans.factory.annotation.Autowired;

import controller.request.CreateEmployesRequest;
import model.Employes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.EmployesRepository;
import service.EmployesService;

@Service
public class EmployesServiceImpl implements EmployesService{
	
	@Autowired
	private EmployesRepository employesRepository;

	@Override
	public void create(CreateEmployesRequest request) {
		// TODO Auto-generated method stub
		Employes employes =  new Employes();
		employes.setName(request.getNama());
		employes.setAddress(request.getAddress());
		employesRepository.save(employes);
	}

	@Override
	public void update(Integer id, UpdateEmployesRequest request) {
		Employes employes = findById(id);
		employes.setAddress(request.getAddress());
		employesRepository.save(employes);
	}

	@Override
	public List<Employes> findAll() {
		// TODO Auto-generated method stub
		return employesRepository.findAll();
	}

	@Override
	public Employes findById(Integer id) {
		// TODO Auto-generated method stub
		return employesRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		findById(id);
		employesRepository.deleteById(id);
	}

}
