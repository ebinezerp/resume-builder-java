package org.example.resumebuilder.service;


import org.example.resumebuilder.model.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ResumeBuilder {
    public void build(Employee employee, String outputLocation) throws IOException;
}
