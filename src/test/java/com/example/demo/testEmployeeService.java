package com.example.demo;


import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;	



@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class testEmployeeService {

    private MockMvc mockMvc;
    
    @Autowired
	private EmployeeService employeeService;

	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc = MockMvcBuilders.standaloneSetup(employeeService).build();
	}
	
	 
	 @Test
	 ////依照員工姓名查詢
	public void findTest() throws ParseException {
    	Employee employee = new Employee();
    	String Address ="地址";
    	int age =30;
    	int department_id =1;
    	String employee_id="R-1";
    	String gender="F";
    	String name="陳楚來";
    	String phone="09123456789";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date created_atDate =df.parse("2020-09-27 20:03:39 000");
        Date updated_atDate =df.parse("2020-09-27 20:03:41 000");
        
        employee.setName(name);
 		int page = 0;
 		int size = 10;
 		String sortColumn="id";
 	    String  sortType = "ASC";
 	    
    	Page<Employee> returnsEmployee = employeeService.getEmployeeByEmployeee( employee, page,  size,  sortColumn,  sortType);
    	
	    assertEquals( (Object) Address, returnsEmployee.getContent().get(0).getAddress());//調用測試方法
	    assertEquals( (Object) age, returnsEmployee.getContent().get(0).getAge());//調用測試方法
	    assertEquals( (Object) department_id, returnsEmployee.getContent().get(0).getDepartment_id());//調用測試方法
	    assertEquals( (Object) employee_id, returnsEmployee.getContent().get(0).getEmployee_id());//調用測試方法
	    assertEquals( (Object) gender, returnsEmployee.getContent().get(0).getGender());//調用測試方法
	    assertEquals( (Object) name, returnsEmployee.getContent().get(0).getName());//調用測試方法
	    assertEquals( (Object) phone, returnsEmployee.getContent().get(0).getPhone());//調用測試方法
	    assertEquals( (Object) created_atDate, returnsEmployee.getContent().get(0).getCreated_at());//調用測試方法
	    assertEquals( (Object) updated_atDate, returnsEmployee.getContent().get(0).getUpdated_at());//調用測試方法
	}

	 ////依照員工年齡查詢
	 @Test
	public void findTest1() throws ParseException {
    	Employee employee = new Employee();
    	String Address ="地址";
    	int age =45;
    	int department_id =2;
    	String employee_id="R-17";
    	String gender="M";
    	String name="王大明16";
    	String phone="09345678901";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date created_atDate =df.parse("2020-09-27 20:03:39 000");
        Date updated_atDate =df.parse("2020-09-27 20:03:41 000");
        


        employee.setAge(age);
 		int page = 1;
 		int size = 3;
 		String sortColumn="id";
 	    String  sortType = "DESC";
 	    
    	Page<Employee> returnsEmployee = employeeService.getEmployeeByEmployeee( employee, page,  size,  sortColumn,  sortType);
    	
	    assertEquals( (Object) Address, returnsEmployee.getContent().get(0).getAddress());//調用測試方法
	    assertEquals( (Object) age, returnsEmployee.getContent().get(0).getAge());//調用測試方法
	    assertEquals( (Object) department_id, returnsEmployee.getContent().get(0).getDepartment_id());//調用測試方法
	    assertEquals( (Object) employee_id, returnsEmployee.getContent().get(0).getEmployee_id());//調用測試方法
	    assertEquals( (Object) gender, returnsEmployee.getContent().get(0).getGender());//調用測試方法
	    assertEquals( (Object) name, returnsEmployee.getContent().get(0).getName());//調用測試方法
	    assertEquals( (Object) phone, returnsEmployee.getContent().get(0).getPhone());//調用測試方法
	}

	
	 ////依照員工編號查詢
	 @Test
	public void findTest2() throws ParseException {
    	Employee employee = new Employee();
    	String Address ="地址";
    	int age =45;
    	int department_id =2;
    	String employee_id="R-2";
    	String gender="M";
    	String name="王大明01";
    	String phone="09345678901";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date created_atDate =df.parse("2020-09-27 20:03:39 000");
        Date updated_atDate =df.parse("2020-09-27 20:03:41 000");
        


        employee.setEmployee_id(employee_id);
 		int page = 0;
 		int size = 3;
 		String sortColumn="id";
 	    String  sortType = "DESC";
 	    
    	Page<Employee> returnsEmployee = employeeService.getEmployeeByEmployeee( employee, page,  size,  sortColumn,  sortType);
    	
	    assertEquals( (Object) Address, returnsEmployee.getContent().get(0).getAddress());//調用測試方法
	    assertEquals( (Object) age, returnsEmployee.getContent().get(0).getAge());//調用測試方法
	    assertEquals( (Object) department_id, returnsEmployee.getContent().get(0).getDepartment_id());//調用測試方法
	    assertEquals( (Object) employee_id, returnsEmployee.getContent().get(0).getEmployee_id());//調用測試方法
	    assertEquals( (Object) gender, returnsEmployee.getContent().get(0).getGender());//調用測試方法
	    assertEquals( (Object) name, returnsEmployee.getContent().get(0).getName());//調用測試方法
	    assertEquals( (Object) phone, returnsEmployee.getContent().get(0).getPhone());//調用測試方法
	}

	 ////依照員工部門查詢
	 @Test
	public void findTest3() throws ParseException {
    	Employee employee = new Employee();
    	String Address ="地址";
    	int age =45;
    	int department_id =2;
    	String employee_id="R-12";
    	String gender="M";
    	String name="王大明11";
    	String phone="09345678901";
    	String department_Name="產品二部";
    	

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date created_atDate =df.parse("2020-09-27 20:03:39 000");
        Date updated_atDate =df.parse("2020-09-27 20:03:41 000");
        
        Department department = new Department();
        department.setName(department_Name);

        employee.setDepartment(department);
 		int page = 2;
 		int size = 4;
 		String sortColumn="id";
 	    String  sortType = "DESC";
 	    
    	Page<Employee> returnsEmployee = employeeService.getEmployeeByEmployeee( employee, page,  size,  sortColumn,  sortType);
    	
	    assertEquals( (Object) Address, returnsEmployee.getContent().get(0).getAddress());//調用測試方法
	    assertEquals( (Object) age, returnsEmployee.getContent().get(0).getAge());//調用測試方法
	    assertEquals( (Object) department_id, returnsEmployee.getContent().get(0).getDepartment_id());//調用測試方法
	    assertEquals( (Object) employee_id, returnsEmployee.getContent().get(0).getEmployee_id());//調用測試方法
	    assertEquals( (Object) gender, returnsEmployee.getContent().get(0).getGender());//調用測試方法
	    assertEquals( (Object) name, returnsEmployee.getContent().get(0).getName());//調用測試方法
	    assertEquals( (Object) phone, returnsEmployee.getContent().get(0).getPhone());//調用測試方法
	    assertEquals( (Object) department_Name, returnsEmployee.getContent().get(0).getDepartment().getName());//調用測試方法
	}
 
	@Test
	public void addTest() {
    	Employee employee = new Employee();
    	String Address ="Address_add";
    	int age =30;
    	int department_id =1;
    	String employee_id="R-3_add";
    	String gender="F";
    	String name="測試_add";
    	String phone="0912345678";
    	
    	employee.setAddress(Address);
    	employee.setAge(age);
    	employee.setDepartment_id(department_id);
    	employee.setEmployee_id(employee_id);
    	employee.setGender(gender);
    	employee.setName(name);
    	employee.setPhone(phone);

    	Employee returnsEmployee = employeeService.addEmployee(employee);

	    assertEquals( (Object) Address, returnsEmployee.getAddress());//調用測試方法
	    assertEquals( (Object) age, returnsEmployee.getAge());//調用測試方法
	    assertEquals( (Object) department_id, returnsEmployee.getDepartment_id());//調用測試方法
	    assertEquals( (Object) employee_id, returnsEmployee.getEmployee_id());//調用測試方法
	    assertEquals( (Object) gender, returnsEmployee.getGender());//調用測試方法
	    assertEquals( (Object) name, returnsEmployee.getName());//調用測試方法
	    assertEquals( (Object) phone, returnsEmployee.getPhone());//調用測試方法
	}

	@Test
	public void updateTest() {
    	Employee employee = new Employee();
    	String Address ="Address_update";
    	int age =31;
    	int department_id =2;
    	String employee_id="R-3_update";
    	String gender="F";
    	String name="測試_update";
    	String phone="0912345699";
    	int employee_table_id =10;
    	employee.setAddress(Address);
    	employee.setAge(age);
    	employee.setDepartment_id(department_id);
    	employee.setEmployee_id(employee_id);
    	employee.setGender(gender);
    	employee.setName(name);
    	employee.setPhone(phone);

    	Employee returnsEmployee = employeeService.updateEmployee(employee,employee_table_id);

    	
	    assertEquals( (Object) Address, returnsEmployee.getAddress());//調用測試方法
	    assertEquals( (Object) age, returnsEmployee.getAge());//調用測試方法
	    assertEquals( (Object) department_id, returnsEmployee.getDepartment_id());//調用測試方法
	    assertEquals( (Object) employee_id, returnsEmployee.getEmployee_id());//調用測試方法
	    assertEquals( (Object) gender, returnsEmployee.getGender());//調用測試方法
	    assertEquals( (Object) name, returnsEmployee.getName());//調用測試方法
	    assertEquals( (Object) phone, returnsEmployee.getPhone());//調用測試方法
	}
		
	 
	@Test
	public void deleteTest() {
   	Employee employee = new Employee();
   	String Address ="Address_delete";
   	int age =30;
   	int department_id =1;
   	String employee_id="R-3_delete";
   	String gender="F";
   	String name="測試_delete";
   	String phone="0912345678";
   	
   	employee.setAddress(Address);
   	employee.setAge(age);
   	employee.setDepartment_id(department_id);
   	employee.setEmployee_id(employee_id);
   	employee.setGender(gender);
   	employee.setName(name);
   	employee.setPhone(phone);

   	Employee returnsEmployee = employeeService.addEmployee(employee);
   	State returnsState =  employeeService.deleteEmployeeById(returnsEmployee.getId()); 

   	assertEquals( (Object) "ok", returnsState.getMessage());//調用測試方法
   	assertEquals( (Object) "sucess", returnsState.getState());//調用測試方法
    
	}


}
