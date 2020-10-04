package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service


public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;

//  @Autowired
  @PersistenceContext//@[email protected]
  EntityManager em;
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }
     
    public Employee getEmployeeById(Integer id)  
    {
        Optional<Employee> employee = repository.findById(id);
         
        return employee.get();
    }
     
    public List<Employee> getEmployeeByName(String name)  
    {
    	return repository.findByName(name);
    }
    

    public Page<Employee> getEmployeeByEmployeee(Employee employee,int page, int size, String sortColumn, String sortType)  
    {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        
         //檢查查詢條件
        Predicate p1 = null;
        if (employee.getEmployee_id()!=null && !employee.getEmployee_id().equals("")) {
            System.out.println("正在操作eid！！！");
            Predicate p2 = cb.equal(root.get(Employee_.employee_id), employee.getEmployee_id());
            if (p1 != null) {
                p1=cb.and(p1, p2);
            } else {
                p1 = p2;
            }
        }
        if (employee.getName()!=null && !employee.getName().equals("")) {
            System.out.println("正在操作name！！！");
            Predicate p2 = cb.equal(root.get(Employee_.name), employee.getName());
            if (p1 != null) {
                p1=cb.and(p1, p2);
            } else {
                p1 = p2;
            }
        }

        if (employee.getAge()!=null ) {
            System.out.println("正在操作age！！！");
            Predicate p2 = cb.equal(root.get(Employee_.age ), employee.getAge());
            if (p1 != null) {
                p1=cb.and(p1, p2);
            } else {
                p1 = p2;
            }
        }

        if (employee.getDepartment()!=null &&employee.getDepartment().getName()!=null && !employee.getDepartment().getName().equals("")) {
            System.out.println("正在操作department.name！！！");
            
            Join join = root.join(Employee_.department);
            Predicate p2 = cb.equal(join.get(Department_.name), employee.getDepartment().getName());
            if (p1 != null) {
                p1=cb.and(p1, p2);
            } else {
                p1 = p2;
            }
        }
        

    	if(sortColumn=="") {
    		query.orderBy(cb.asc(root.get("id"))); 
    	}else {
    		switch(sortType){
            case "DESC" :
            	//降序
            	query.orderBy(cb.desc(root.get(sortColumn))); 
    			break; 
            case "ASC" :
    			//升序
            	query.orderBy(cb.asc(root.get(sortColumn))); 
    			break; 
    		}
    	}
        
        //5
        query.select( root );
        query.where(p1);
        //6
        //計數查詢結果條數 
        TypedQuery<Employee> createCountQuery = em.createQuery(query); 
        

      //SQL查詢物件 
        TypedQuery<Employee> createQuery = em.createQuery(query); 
        Pageable pageable = (Pageable) PageRequest.of(page, size,Sort.by("id").descending());

        
        // 實際查詢返回分頁物件 
        int startIndex = size * page; 
        createQuery.setFirstResult(startIndex); 
        createQuery.setMaxResults(size); 

        Page<Employee> pageRst = 
        		new PageImpl<Employee>(createQuery.getResultList(),  pageable, createCountQuery.getResultList().size()); 
        return pageRst;
    }
    
    public Employee addEmployee(Employee entity)  
    {	
    	entity.setCreated_at(new Date());
    	entity.setUpdated_at(new Date());
    	entity = repository.save(entity);
        
        return entity;
    } 
    
    public Employee updateEmployee(Employee entity, Integer id)  
    {
    	try
    	{
            Optional<Employee> employee = repository.findById(id);
            Employee newEntity = employee.get();
            newEntity.setName(entity.getName());
            newEntity.setEmployee_id(entity.getEmployee_id());
            newEntity.setDepartment_id(entity.getDepartment_id());
            newEntity.setGender(entity.getGender());
            newEntity.setPhone(entity.getPhone());
            newEntity.setAddress(entity.getAddress());
            newEntity.setAge(entity.getAge());
            Date current = new Date();
            newEntity.setUpdated_at(current);
            newEntity = repository.save(newEntity);
             
            return newEntity;
    	}
    	catch(Exception e)
    	{
            return null;
    	}

    } 
     
    public State deleteEmployeeById(Integer id)  
    {
    	try
    	{
            Optional<Employee> employee = repository.findById(id);
            repository.deleteById(id);
            State state = new State();
            state.setState("sucess");
            state.setMessage("ok");
            return state;
    	}
    	catch (Exception ex)
    	{
            State state = new State();
            state.setState("fail");
            state.setMessage(ex.toString());
            return state;
    	}
    } 
}