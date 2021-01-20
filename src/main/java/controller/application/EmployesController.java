package controller.application;

import controller.request.CreateEmployesRequest;
import controller.request.UpdateEmployesRequest;
import model.Employes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.EmployesService;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployesController {

    @Autowired
    private EmployesService employesService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }

    @PostMapping(value = "/employes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateEmployesRequest request){
        employesService.create(request);
    }

    @PutMapping(value = "/employes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody UpdateEmployesRequest request){
        employesService.update(id, request);
    }

    @GetMapping(value = "/employes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employes> findAll(){
        return employesService.findAll();
    }

    @GetMapping(value = "/employes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Employes findById(@PathVariable Integer id){
        return employesService.findById(id);
    }

    @DeleteMapping(value = "/employes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
         employesService.delete(id);
    }

}
