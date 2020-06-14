package com.csv.api;
import com.company.Member;
import com.company.Society;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractCsvService implements CsvInterface{

    public ColumnConfig columnConfig;
    public CustomFileWriter fileConfig;
    public AbstractCsvService abstractCsvService;

    @Override
    public void addHeader()  {

        if(fileConfig.isFileExists())
            return;
        String header = null;
        for (ColumnConfig.ColumnDetails columnDetails : columnConfig.getColumnDetailsList())
                header = (header == null) ? (columnDetails.colTitle) : (header + ","+columnDetails.colTitle); //condition ? ifTrue : ifFalse
        fileConfig.append(header);
    }

    public void addRow(Object object,Class objectClass) {
        String row = null;
//      Society society = (Society) societyObj;
        String name = object.getClass().getName();

        if (name.equals("com.company.Society")) {
            Society society = (Society) object;
            for (ColumnConfig.ColumnDetails columnDetails : columnConfig.getColumnDetailsList()) {

                try {
                    Method method = Society.class.getMethod("get"+columnDetails.getObjectFieldName());
                    Object value = method.invoke(society);

                    if(value != null)
                        row = (row == null) ? (value+"") : (row+","+value);
                    else
                        row = (row == null) ? ("") : (row+",");

                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                }
            }
            fileConfig.append(row+"\n");
        }
        else if(name.equals("com.company.Member")){
            Member member = (Member) object;

            for (ColumnConfig.ColumnDetails columnDetails : columnConfig.getColumnDetailsList()) {

                try {
                    Method method = Member.class.getMethod("get"+columnDetails.getObjectFieldName());
                    Object value = method.invoke(member);

                    if(value != null)
                        row = row == null?value+"":row+","+value;
                    else
                        row = row == null?"":row+",";

                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                }
            }
                fileConfig.append("\n"+row);
        }
    }
}