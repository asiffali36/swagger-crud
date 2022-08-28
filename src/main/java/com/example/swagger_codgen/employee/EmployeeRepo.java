package com.example.swagger_codgen.employee;

import com.example.swagger_codgen.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepo {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    EmployeeRepo(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

    RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setFirstName(rs.getString("firstname"));
            employee.setLastName(rs.getString("lastname"));
            return employee;
        }
    };


    public List<Employee> getallEmployes()
    {
        String query ="SELECT * FROM employee_data";
        return jdbcTemplate.query(query,employeeRowMapper);
    }
    public ResponseEntity<Object> insertEmployeeRecord(Employee modelClass) {
        String query = "insert into employee_data(firstname,lastname) values(?,?)";

       int update= this.jdbcTemplate.update(query,modelClass.getFirstName(), modelClass.getLastName());

       return new ResponseEntity(modelClass,HttpStatus.OK);
    }

    public int deleteRecord(int id) {
        String query = "Delete from employee_data where id=? ";
        return this.jdbcTemplate.update(query, id);
    }

    public ResponseEntity<Object> updateRecord(Employee modelClass,int id) {
        String query = "UPDATE employee_data\n" +
                "SET firstname = ?, lastname= ?" +
                "WHERE id = ?";
         this.jdbcTemplate.update(query, modelClass.getFirstName(), modelClass.getLastName(),id);
         return new ResponseEntity(modelClass,HttpStatus.OK);
    }
}
