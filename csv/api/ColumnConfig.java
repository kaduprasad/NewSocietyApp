package com.csv.api;

import java.util.ArrayList;
import java.util.List;

public class ColumnConfig {
    List<ColumnDetails> columnDetailsList = new ArrayList<>();

    public void addColumnDetail(String objectFieldName, String colDataType, String colTitle){

        columnDetailsList.add(new ColumnDetails(objectFieldName,colDataType,colTitle));
    };

    public List<ColumnDetails> getColumnDetailsList() {
        return columnDetailsList;
    }

    public class ColumnDetails{ // inner class
        String objectFieldName;
        String colDataType;
        String colTitle;

        public ColumnDetails(String objectFieldName, String colDataType, String colTitle) {
            this.objectFieldName = objectFieldName;
            this.colDataType = colDataType;
            this.colTitle = colTitle;
        }

        public String getObjectFieldName() {
            return objectFieldName;
        }

        public String getColDataType() {
            return colDataType;
        }

        public String getColTitle() {
            return colTitle;
        }
    }
}
