package com.company;

public class Member{

    public  int flatNo;
    public  String name;
    public  String socName;

    public Member(int flatNo, String name, String socName) {
        this.flatNo = flatNo;
        this.name = name;
        this.socName = socName;
    }

    public String getSocName() {
        return socName;
    }

    public String getName() {
        return name;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public Member() {
        flatNo = 0;
        name = "Null";
    }

    public String memberName(){
        String memberName = name+",";
        return memberName;
    }

    @Override
    public String toString() {

        String memberStr = "\nMember { " +
                "FlatNo : " + flatNo +
                ", Name : " + name +" }";
//        System.out.println(memberStr);
        return memberStr;
    }

    public String memberInfo(String socName) {

        String memberStr = "\n"+socName+" "+ flatNo +","+ name +",";
        return memberStr;
    }

    public String columnWiseMemberInformation(String[] arrayOfMembers){


        String socName = arrayOfMembers[0];
        String flatNo = arrayOfMembers[1];
        String name = arrayOfMembers[2];

        String socInformation = " "+socName+" "+flatNo+" "+name+" ";
        return socInformation;
    }


}