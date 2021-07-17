package org.example.resumebuilder.service;

import com.itextpdf.text.DocumentException;
import org.example.resumebuilder.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ResumeBuilderTest {

    private ResumeBuilder resumeBuilder;

    @BeforeEach
    public void setUp(){
        resumeBuilder = new ResumeBuilderImpl();
    }

    @Test
    void testBuild() throws DocumentException, FileNotFoundException {
        Employee employee = new Employee();
        employee.setEmpId("12345");
        employee.setFirstName("sudhakar");
        employee.setLastName("perumala");
        resumeBuilder.build(employee, "./");
        File file = new File("./"+employee.getFirstName()+employee.getLastName()+"_"+employee.getEmpId()+".pdf");
        //assertTrue(file.exists());
    }
}