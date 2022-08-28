package com.example.swagger_codgen.employee;

import com.example.swagger_codgen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }

    public List<Employee> getEmployeeDetails() {
        return  employeeRepo.getallEmployes();

    }
    public ResponseEntity<Object> insertEmployeeRecord(Employee modelClass){

        return employeeRepo.insertEmployeeRecord(modelClass);
    }

    public ResponseEntity<Integer> deleteEmployeeRecord(int id)
    {
        return new ResponseEntity(employeeRepo.deleteRecord(id), HttpStatus.OK);
    }
    public ResponseEntity<Employee> updateEmployeeRecord(Employee employee,int id)
    {
        return new  ResponseEntity(employeeRepo.updateRecord(employee,id),HttpStatus.OK);
    }
}
