package org.example.resumebuilder.service;

import org.example.resumebuilder.exception.InvalidJsonFormatException;
import org.example.resumebuilder.model.Employee;

import java.io.FileNotFoundException;

public interface EmployeeJsonFileReader {

    public Employee readFile(String filename) throws FileNotFoundException, InvalidJsonFormatException;
}
