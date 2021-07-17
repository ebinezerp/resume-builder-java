package org.example.resumebuilder.service;

import com.itextpdf.text.DocumentException;
import org.example.resumebuilder.model.Employee;

import java.io.FileNotFoundException;

public interface ResumeBuilder {
    public void build(Employee employee, String outputLocation) throws FileNotFoundException, DocumentException;
}
