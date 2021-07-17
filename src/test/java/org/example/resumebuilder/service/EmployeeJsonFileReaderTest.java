package org.example.resumebuilder.service;

import org.example.resumebuilder.exception.InvalidJsonFormatException;
import org.example.resumebuilder.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeJsonFileReaderTest {

    private EmployeeJsonFileReader employeeJsonFileReader;

    @BeforeEach
    void setUp() {
        employeeJsonFileReader = new EmployeeJsonFileReaderImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testReadFile() throws FileNotFoundException, InvalidJsonFormatException {
        Employee employee = employeeJsonFileReader.readFile("employee_jdu.json");
        assertNotNull(employee);
        assertEquals("Suzuki", employee.getFirstName());
        assertEquals(employee
                .getSkillMatrix()
                .size(), 7);
    }

    @Test
    void testReadFileWithNonExistingFile() {
        assertThrows(FileNotFoundException.class, () -> employeeJsonFileReader.readFile("abcd.json"));
    }

    @Test
    void testReadFileWithInvalidJsonData() {
        assertThrows(InvalidJsonFormatException.class, () -> employeeJsonFileReader.readFile("employee_jdu_invalid.json"));
    }
}