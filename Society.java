package com.company;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Society  {
    private String address;
    private String name;
    private int noOfFlats;
    public ArrayList<Member> memberList = new ArrayList<>();

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void addMember(Member memberObj) {
        memberList.add(memberObj);
    }

    public void removeMember(Member memberObj){
        memberList.remove(memberObj);
    }

    public Society(String address, String name, int noOfFlats) {
        this.address = address;
        this.name = name;
        this.noOfFlats = noOfFlats;
    }

    Society(){
        address = null;
        name = null;
        noOfFlats = 0;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNoOfFlats() {
        return noOfFlats;
    }

    @Override
    public String toString() {
        String socStr =  "\nSociety [ " +
                " SocName : " + name +
                ", Address : " + address +
                ", No_of_flats : " + noOfFlats  +
                " ] \nMemberList : " + memberList +
                '}';
        return  socStr;
    }

    public String socInfo(){
        String socInfo = "\n"+name+","+address+","+noOfFlats+",";//(memberList.get(socIndex-1).memberInfo());
        return socInfo;
    }

    public String columnWiseSocInformation(String[] arrayOfSocities){

        String name = arrayOfSocities[0];
        String addr = arrayOfSocities[1];
        String flats = arrayOfSocities[2];
//        String socInformation = "SocName :"+name+" Address :"+addr+" No Of Flats :"+flats+" ";
        String socInformation = " "+name+" "+addr+" "+flats+" ";

        return socInformation;
    }

    public String societyNames(){
        String socNames = "Society : "+name;
        System.out.println(socNames);
        return socNames;
    }

    public String socName(){
        String socName = name+",";
        System.out.println();
        return socName;
    }

    public ArrayList<Member> membersList(){
        return memberList;
    }


    public void memberNames(){
        System.out.println(memberList.toString());
    }
}
