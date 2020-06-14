package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;

public class ReadFromCsv {

    Scanner scan = new Scanner(System.in);
    public void readfromSocCsvFile() throws Exception{

        BufferedReader readerOfSoc = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
        List<String> socReadList = new ArrayList();

        String allSocInfo = readerOfSoc.readLine(); // all the society info is stored into this string

        while (allSocInfo != null) { // loading the input string into array , divided by (,)
            String ArrayOfsocietyInfo[] = allSocInfo.split(",");

            Society socObj = new Society();

            String socInfoInString =  socObj.columnWiseSocInformation(ArrayOfsocietyInfo);
            socReadList.add(socInfoInString);
            allSocInfo = readerOfSoc.readLine();// adding the segregated content into the list
        }
//        System.out.println(socReadList.size());
        for(int i = 0; i < socReadList.size(); i++){
            System.out.println(socReadList.get(i));
        }
        System.out.println();

        readerOfSoc.close();
    }


    public void readfromMemberCsvFile() throws Exception{

        BufferedReader readerOfMemb = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/members.csv")); // Writer
        List<String> membReadList = new ArrayList();

        String allMembInfo = readerOfMemb.readLine();
        while (allMembInfo !=  null) {
            String arrayOfMemberInfo[] = allMembInfo.split(",");

            Member member = new Member();
            String membInfoInString = member.columnWiseMemberInformation(arrayOfMemberInfo);
            membReadList.add(membInfoInString);
//            System.out.println(arrayOfMemberInfo[0]+" "+arrayOfMemberInfo[1]+" "+arrayOfMemberInfo[2]);

            allMembInfo = readerOfMemb.readLine();
        }
        System.out.println();
//        System.out.println(membReadList.size());
        for (int i = 0; i < membReadList.size(); i++ ){
            System.out.println(membReadList.get(i));
        }

        readerOfMemb.close();
    }

//    public void readfromSocCsvFile() throws Exception{
//
//        BufferedReader readerOfSoc = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
//        BufferedReader readerOfMemb = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/members.csv")); // Writer
//
//        List<String> socReadList = new ArrayList();
//
//        String allSocInfo = readerOfSoc.readLine(); // all the society info is stored into this string
//
//        while (allSocInfo != null) { // loading the input string into array , divided by (,)
//            String ArrayOfsocietyInfo[] = allSocInfo.split(",");
//
//            Society socObj = new Society();
//
//            String socInfoInString =  socObj.columnWiseSocInformation(ArrayOfsocietyInfo);
//            socReadList.add(socInfoInString);
//            allSocInfo = readerOfSoc.readLine();// adding the segregated content into the list
//        }
////        System.out.println(socReadList.size());
//        for(int i = 0; i < socReadList.size(); i++){
//            System.out.println(socReadList.get(i));
//        }
//        System.out.println();
//
//
//        List<String> membReadList = new ArrayList();
//
//        String allMembInfo = readerOfMemb.readLine();
//        while (allMembInfo !=  null) {
//            String arrayOfMemberInfo[] = allMembInfo.split(",");
//
//            Member member = new Member();
//            String membInfoInString = member.columnWiseMemberInformation(arrayOfMemberInfo);
//            membReadList.add(membInfoInString);
////            System.out.println(arrayOfMemberInfo[0]+" "+arrayOfMemberInfo[1]+" "+arrayOfMemberInfo[2]);
//
//            allMembInfo = readerOfMemb.readLine();
//        }
//        System.out.println();
////        System.out.println(membReadList.size());
//        for (int i = 0; i < membReadList.size(); i++ ){
//            System.out.println(membReadList.get(i));
//        }
//
////        for (int socIndex = 0; socIndex < socReadList.size(); socIndex++) {
////
////            ArrayList<Member> membList = socReadList.get(socIndex).memberList;
//////            readFromSoc.append(socReadList.get(socIndex).socInfo());
////
////
////            for (int memberIndex = 0 ; memberIndex < membList.size() ; memberIndex++) {
//////                writeInSoc.append(membList.get(memberIndex).memberInfo());
////                readerOfMemb.append(membList.get(memberIndex).memberInfo());
////            }
////        }
//
////        writeInSoc.append(socList.toString());
//        readerOfMemb.close();
//        readerOfSoc.close();
//    }



//    public void deleteFromSocCSvFile() throws  Exception{
//        System.out.println("Enter the Soc to be deleted : ");
//        String SocNameToBeDeleted = scan.next();
//
//        BufferedReader readerOfSoc = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
//        List<String> socReadList = new ArrayList();
//
//        String allSocInfo = readerOfSoc.readLine(); // all the society info is stored into this string
//        System.out.println(allSocInfo);
//        while (allSocInfo != null) { // loading the input string into array , divided by (,)
//            String ArrayOfsocietyInfo[] = allSocInfo.split(",");
//
//            Society socObj = new Society();
//
//            String socInfoInString =  socObj.columnWiseSocInformation(ArrayOfsocietyInfo);
//            socReadList.add(socInfoInString);
//            allSocInfo = readerOfSoc.readLine();// adding the segregated content into the list
//        }
//
////        System.out.println(socReadList.toString());
//
//
//
//    }

}
