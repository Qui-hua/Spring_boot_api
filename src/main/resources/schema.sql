DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  employee_id VARCHAR(250) NOT NULL,
  department_id INT NOT NULL,
  gender VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  created_at TIMESTAMP NULL DEFAULT NULL,
  updated_at TIMESTAMP NULL DEFAULT NULL,
  FOREIGN KEY (department_id) REFERENCES department(id)
);



DROP TABLE IF EXISTS department;
 
CREATE TABLE department (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);