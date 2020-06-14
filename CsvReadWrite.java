package com.company;
import java.io.*;       // you can write on java.io.* fo all BufferWriter , writer ,fileWriter
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
// 17 monospaced 1.0 ,  theme default
public class CsvReadWrite {

//    CommandInput commandInput = new CommandInput();
//    public void writeToSocietyCsvFile(CommandInput commandInput) throws Exception{
//
//        BufferedWriter writeInSoc = new BufferedWriter( new FileWriter("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
//        BufferedWriter writeInMember = new BufferedWriter( new FileWriter("C:/Users/prasad/IdeaProjects/Assignment 1/resources/members.csv"));// Writer
//
//        String socInfo = "SocName,Address,NoOfFlats,";
////        String s = commandInput.socList.toString();
////        System.out.println(s);
////        writeInSoc.append(s);
//        writeInSoc.append(socInfo);
//
//        String memberInfo = "SocName, Flat No.,MemberName,";
//        writeInMember.append(memberInfo);
//
////        for (int socIndex = 0; socIndex < socList.size(); socIndex++) {
//          for (int socIndex = 0; socIndex < commandInput.socList.size(); socIndex++) {
//
//            ArrayList<Member> membList = commandInput.socList.get(socIndex).memberList;
//            writeInSoc.append(commandInput.socList.get(socIndex).socInfo());
//
//            for (int memberIndex = 0 ; memberIndex < membList.size() ; memberIndex++) {
////                writeInSoc.append(membList.get(memberIndex).memberInfo());
//                writeInMember.append(membList.get(memberIndex).memberInfo(commandInput.socList.get(socIndex).socName()));
//            }
//            System.out.print("\n");
//        }
//
//        writeInMember.close();
//        writeInSoc.close();
//    }

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
//            String socInfoString =  socObj.columnWiseSocInformation(ArrayOfsocietyInfo);
//            socReadList.add(socInfoString);
//            allSocInfo = readerOfSoc.readLine();   // adding the segregated content into the list
//        }
//        System.out.println();
////        for (int i = 0; i < societyInfo.length; i++ ){
//////            System.out.println(societyInfo[i]+" "+societyInfo[i+1]+" "+societyInfo[i+2]+" ");
////            readList.add(societyInfo[i]+" "+societyInfo[i+1]+" "+societyInfo[i+2]+" ");
////            i = i+2;
////        }
//        System.out.println(socReadList.size());
//        for(int i = 0; i < socReadList.size(); i++){
//            System.out.println(socReadList.get(i));
//        }
////        String memberInfo = " ";
////        String memb = readFromMember.readLine();
////        while (memberInfo !=  null) {
////            memberInfo = memberInfo + " " + memb;
////            memb = readFromMember.readLine();
////        }
////        String members[] = memberInfo.split(",");
////        for (int i = 0; i <= members.length; i++ ){
////            System.out.println(members[i]+" ");
////        }
//
////        for (int socIndex = 0; socIndex < socList.size(); socIndex++) {
////
////            ArrayList<Member> membList = socList.get(socIndex).memberList;
////            readFromSoc.append(socList.get(socIndex).socInfo());
////
////
////            for (int memberIndex = 0 ; memberIndex < membList.size() ; memberIndex++) {
//////                writeInSoc.append(membList.get(memberIndex).memberInfo());
////                readFromMember.append(membList.get(memberIndex).memberInfo());
////            }
////        }
//
////        writeInSoc.append(socList.toString());
//        readerOfMemb.close();
//        readerOfSoc.close();
//    }

    public void writeAllInfoToCsv(CommandInput commandInput) throws Exception{
        WriteToCsv writeToCsv = new WriteToCsv();
        writeToCsv.writeToSocietyCsvFile(commandInput);
        writeToCsv.writeToMemberCsvFile(commandInput);
    }

    public void readAllInfoFromCsv()throws Exception{
        ReadFromCsv readFromCsv = new ReadFromCsv();
        readFromCsv.readfromSocCsvFile();
        readFromCsv.readfromMemberCsvFile();
    }
}
