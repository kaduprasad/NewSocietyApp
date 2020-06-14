package com.csv.service;

import com.company.Society;
import com.csv.api.AbstractCsvService;
import com.csv.api.ColumnConfig;
import com.csv.api.CustomFileWriter;

import java.util.List;

public class SocietyCsvService extends AbstractCsvService {

    List<Society> societyList;
    MemberCsvService memberCsvService;


    public SocietyCsvService(List societyList) {
        this.societyList = societyList;
        memberCsvService = new MemberCsvService(societyList);
        initColumnConfig();
        fileConfig = new CustomFileWriter("Society","C:\\Users\\prasad\\IdeaProjects\\Assignment 1\\resources\\","csv");
    }


    @Override
    public List readObjectsList() {
        fileConfig.readLine();
        String line = fileConfig.readLine();
        while(line != null){
            String societyInfo[] = line.split(",");
            Society society = new Society(societyInfo[1],societyInfo[0],Integer.valueOf(societyInfo[2]));
            societyList.add(society);
            line = fileConfig.readLine();
        }
        return societyList;
    }

    public void initColumnConfig(){
        columnConfig = new ColumnConfig();

        columnConfig.addColumnDetail("Name","String","Society Name");
        columnConfig.addColumnDetail("Address","String","Society Address");
        columnConfig.addColumnDetail("NoOfFlats","int","Society NoOfFlats");
    }

//    @Override
    public void addSocietyRow(Object societyObj) {
        Society society = (Society) societyObj;
        addRow(society);

//        for (ColumnConfig.ColumnDetails columnDetails : columnConfig.getColumnDetailsList()) {
//
//            try {
//                Method method = Society.class.getMethod("get"+columnDetails.getObjectFieldName());
//                Object value = method.invoke(society);
//
//                if(value != null)
//                    row = (row == null) ? (value+"") : (row+","+value);
//                else
//                    row = (row == null) ? ("") : (row+",");
//
//            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//            fileConfig.append(row+"\n");
    }

    @Override
    public void addRow(Object row) {

    }

    @Override
    public void searchByCell() {

    }

    @Override
    public void addBottom() {

    }

    @Override
    public void generateFile() {
        addHeader();
        for (Society society : societyList) {
            addSocietyRow(society);
        }
        memberCsvService.generateFile();
    }

    @Override
    public void apppendToFile(List currentSocList) {
        if(!fileConfig.isFileExists())
            addHeader();
        for (Object society : currentSocList) {
            addSocietyRow(society);
        }
        memberCsvService.apppendToFile(currentSocList);
    }
}
