package com.csv.service;

import com.company.Member;
import com.company.Society;
import com.csv.api.AbstractCsvService;
import com.csv.api.ColumnConfig;
import com.csv.api.CustomFileWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MemberCsvService extends AbstractCsvService {

    List<Society> socList;

    public MemberCsvService(List socList) {
        this.socList = socList;

        initColumnConfig();
        fileConfig = new CustomFileWriter("Member","C:\\Users\\prasad\\IdeaProjects\\Assignment 1\\resources\\","csv");
    }


    public void initColumnConfig(){
        columnConfig = new ColumnConfig();

        columnConfig.addColumnDetail("Name","String","Member name");
        columnConfig.addColumnDetail("FlatNo","int","Member FlatNo.");
        columnConfig.addColumnDetail("SocName","String","Member socName");
    }

//    @Override
    public void addMemberRow(Object memberObj) {
        Member member = (Member) memberObj;
        addRow(member);

//        String row = null;
//        Member member = (Member) memberObj;
//
//        for (ColumnConfig.ColumnDetails columnDetails : columnConfig.getColumnDetailsList()) {
//
//            try {
//                Method method = Member.class.getMethod("get"+columnDetails.getObjectFieldName());
//                Object value = method.invoke(member);
//
//                if(value != null)
//                    row = row == null?value+"":row+","+value;
//                else
//                    row = row == null?"":row+",";
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
    public List readObjectsList() {
        return null;
    }

    @Override
    public void generateFile() {
//        addHeader();
        for (Society society : socList)
            for (Member member : society.getMemberList())
                addMemberRow(member);
    }

    @Override
    public void apppendToFile(List objects) {

        for (Object object : objects) {
            Society society = (Society) object;
            for (Member member : (society).getMemberList())
                addMemberRow(member);
        }
    }
}
