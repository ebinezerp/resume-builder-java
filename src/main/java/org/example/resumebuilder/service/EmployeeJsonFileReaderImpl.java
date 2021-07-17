package org.example.resumebuilder.service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import org.example.resumebuilder.exception.InvalidJsonFormatException;
import org.example.resumebuilder.model.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class EmployeeJsonFileReaderImpl implements EmployeeJsonFileReader {

    @Override
    public Employee readFile(String filename) throws FileNotFoundException, InvalidJsonFormatException {
        try {
            return new Gson().fromJson(new JsonReader(new FileReader(filename)), Employee.class);
        }catch (JsonSyntaxException e){
            throw new InvalidJsonFormatException("Not in the JSON format");
        }catch (JsonIOException e){
            throw new RuntimeException("Exception while reading JSONFile");
        }
    }
}
