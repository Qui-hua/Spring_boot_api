package com.example.demo;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;

public class Employee_ {
	
    public static volatile SingularAttribute<Employee, Integer> id;// 用戶ID，自增量
    public static volatile SingularAttribute<Employee, Integer> age;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile SingularAttribute<Employee, String> phone;
    public static volatile SingularAttribute<Employee, String> address;
    public static volatile SingularAttribute<Employee, String> employee_id;
    public static volatile SingularAttribute<Employee, Date> created_at;
    public static volatile SingularAttribute<Employee, Date> updated_at;
    public static volatile SingularAttribute<Employee, Department> department;
    
}
