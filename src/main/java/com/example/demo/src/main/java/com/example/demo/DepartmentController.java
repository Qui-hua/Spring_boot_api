package com.example.demo;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	@Autowired
    DepartmentService service;
 
    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        List<Department> list = service.getAll();
        return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Department>  getDepartmentById(@PathVariable("id") Integer id) 
   // public ResponseEntity<Department>  getDepartmentById(@PathVariable("id") Integer id) 
    {
        Department entity = service.getDepartmentById(id);
        /////如果是要回傳是json字串，可用這種方式
       // Gson gson = new Gson();
       // String json1 = gson.toJson(entity);
       // return new ResponseEntity<String>(json1,HttpStatus.OK);
        return new ResponseEntity<Department>(entity, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Department> createDepartment(Department department)
    {
        Department createDepartment = service.addDepartment(department);
        return new ResponseEntity<Department>(createDepartment, HttpStatus.OK);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<Department> UpdateDepartment(Department department, @PathVariable("id") Integer id)
    {
        Department updateDepartment = service.updateDepartment(department, id);
        return new ResponseEntity<Department>(updateDepartment, HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartmentById(@PathVariable("id") Integer id) {
        
        State returnState= service.deleteDepartmentById(id);
    	if(returnState.getState().equals("fail"))
    	{
    	    HttpHeaders headers = new HttpHeaders();
    	    headers.add("state", "fail");
    	    headers.add("message", returnState.getMessage());
    		return new ResponseEntity(headers, HttpStatus.OK);
    	}
    	else
    	{
    	    HttpHeaders headers = new HttpHeaders();
    	    headers.add("state", "sucess");
    	    headers.add("message", returnState.getMessage());
    		return new ResponseEntity(headers, HttpStatus.OK);
    	}
    }
    
    @GetMapping("/find/{name}")
    public ResponseEntity<List<Department>> findByName(@PathVariable("name") String name) {
        List<Department> list = service.getDepartmentByName(name);
        return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
    }
}




