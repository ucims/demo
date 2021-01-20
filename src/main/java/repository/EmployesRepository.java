package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Employes;

public interface EmployesRepository extends JpaRepository<Employes, Integer> {

}
