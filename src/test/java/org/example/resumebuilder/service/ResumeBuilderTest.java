package org.example.resumebuilder.service;

import org.example.resumebuilder.exception.InvalidJsonFormatException;
import org.example.resumebuilder.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ResumeBuilderTest {

    private ResumeBuilder resumeBuilder;
    private EmployeeJsonFileReader employeeJsonFileReader;

    @BeforeEach
    public void setUp(){
        resumeBuilder = new ResumeBuilderImpl();
        employeeJsonFileReader = new EmployeeJsonFileReaderImpl();
    }

    @Test
    void testBuild() throws IOException, InvalidJsonFormatException {
        Employee employee = employeeJsonFileReader.readFile("./employee_jdu.json");
        resumeBuilder.build(employee, "./");
        File file = new File("./"+employee.getFirstName()+employee.getLastName()+"_"+employee.getEmpId()+".pdf");
        assertTrue(file.exists());
    }
}