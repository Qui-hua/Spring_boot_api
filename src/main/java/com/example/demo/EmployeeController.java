package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
    EmployeeService service;
 
	///取得全部資料
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {        
        List<Employee> list = service.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

	///取得Employee ID資料
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) 
    {
        Employee entity = service.getEmployeeById(id);
        return new ResponseEntity<Employee>(entity, HttpStatus.OK);
    }
    ////新增
    @PostMapping
    public ResponseEntity<Employee> createEmployee(Employee employee)
    {
    	String check = checkEmployee( employee);
    	if(!check.equals(""))
    	{
    	    HttpHeaders headers = new HttpHeaders();
    	    headers.add("state", check);
            return new ResponseEntity<Employee>(null,headers, HttpStatus.OK);
    	}
        Employee createEmployee = service.addEmployee(employee);
        return new ResponseEntity<Employee>(createEmployee, HttpStatus.OK);
    }
    ///修改
    @PostMapping("/{id}")
    public ResponseEntity<Employee> UpdateEmployee(HttpServletResponse response,Employee employee, @PathVariable("id") Integer id) throws IOException
    {
    	String check = checkEmployee( employee);
    	if(!check.equals(""))
    	{
    	    HttpHeaders headers = new HttpHeaders();
    	    headers.add("state", check);
            return new ResponseEntity<Employee>(null,headers, HttpStatus.OK);
    	}

        Employee updateEmployee = service.updateEmployee(employee, id);
        return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
    }
 ///刪除
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable("id") Integer id) {
    	State returnState= service.deleteEmployeeById(id);
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


	///取得 name 資料
    @GetMapping("/find/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable("name") String name) {
        List<Employee> list = service.getEmployeeByName(name);
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }
    

    //依照搜尋條件取得資料
    @GetMapping("/find")
    public ResponseEntity<Page<Employee>> findByEmployeee(@RequestParam(required = false) Integer page, Integer size, String sortColumn, String sortType,Employee employee)
    {

	   if(page == null) 
	   {
		   page = 0;
	   }
	   else 
	   {
	   		page -= 1;
	   }
	   if(size == null) {
			size = 10;
	   }
	   if(sortColumn == null) {
			sortColumn="id";
	   }
	   if(sortType == null) {
		   sortType = "ASC";
	   }
	   Page<Employee> list = service.getEmployeeByEmployeee(employee, page, size, sortColumn, sortType);
	   return new ResponseEntity<Page<Employee>>(list, HttpStatus.OK);
    }
   

   
   	////檢測物件元素是否是空或null
   public String checkEmployee( Employee employee) {    
	   	
	   	if(employee.getName() == null || employee.getName().equals(""))
	   	{
	   		return "Please input employee's name!";
	   	}
	   	if(employee.getAge() == null )
	   	{
	   		return "Please input employee's age!";
	   	}
	   	if(employee.getAddress() == null || employee.getAddress().equals(""))
	   	{
	   		return "Please input employee's address!";
	   	}
	   	if(employee.getDepartment_id() == null || employee.getDepartment_id().equals(""))
	   	{
	   		return "Please input employee's department_id!";
	   	}
	   	if(employee.getEmployee_id() == null || employee.getEmployee_id().equals(""))
	   	{
	   		return "Please input employee's id!";
	   	}
	   	if(employee.getGender() == null || employee.getGender().equals(""))
	   	{
	   		return "Please input employee's gender!";
	   	}
	   	if(!employee.getGender().equals("F") && employee.getGender().equals("f")
	   	 && employee.getGender().equals("M") && employee.getGender().equals("m"))
	   	{
	   		return "Please input F or M for employee's gender!";
	   	}
	
	   	if(employee.getPhone() == null || employee.getPhone().equals(""))
	   	{
	   		return "Please input employee's phone!";
	   	}
	   	return "";
   }
}

