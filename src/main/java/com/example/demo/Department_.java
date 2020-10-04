package com.example.demo;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;

public class Department_ {
    public static volatile SingularAttribute<Department, Integer> id;// 用戶ID，自增量
    public static volatile SingularAttribute<Department, String> name;
}
