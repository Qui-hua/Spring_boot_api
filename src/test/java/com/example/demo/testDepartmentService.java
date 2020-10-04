package com.example.demo;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;	




@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class testDepartmentService {

    private MockMvc mockMvc;

    @Autowired
	private DepartmentService departmentService;

	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
	    this.mockMvc = MockMvcBuilders.standaloneSetup(departmentService).build();
	}
	
	 
	@Test
	public void addTest() {
		Department department = new Department();
    	String name="測試部門";
    	
    	department.setName(name);

    	Department returnsDepartment = departmentService.addDepartment(department);

	    assertEquals( (Object) name, returnsDepartment.getName());//調用測試方法
	}

	@Test
	public void updateTest() {

		Department department = new Department();
    	String name="測試部門_update";
    	int departmentID = 1;
    	department.setName(name);

    	Department returnsDepartment = departmentService.updateDepartment(department, departmentID);

	    assertEquals( (Object) name, returnsDepartment.getName());//調用測試方法
	}
		
	 
	@Test
	public void deleteTest() {

		Department department = new Department();
    	String name="測試部門_update";
    	int departmentID = 1;
    	department.setName(name);
    	Department returnsDepartment = departmentService.updateDepartment(department, departmentID);
    	State returnsState =  departmentService.deleteDepartmentById(returnsDepartment.getId()); 	
	   	assertEquals( (Object) "ok", returnsState.getMessage());//調用測試方法
	   	assertEquals( (Object) "sucess", returnsState.getState());//調用測試方法
    
	}


}
