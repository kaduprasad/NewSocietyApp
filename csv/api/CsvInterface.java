package com.csv.api;

import com.company.CommandInput;
import com.company.Society;

import java.io.IOException;
import java.util.List;

public interface CsvInterface {

    void addHeader() throws IOException;
    void addRow(Object row);
    void searchByCell();
    void addBottom();
    List readObjectsList();
    void initColumnConfig();
    void generateFile();
    void apppendToFile(List objects);
}
