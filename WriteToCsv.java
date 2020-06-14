package com.company;

import com.csv.service.MemberCsvService;
import com.csv.service.SocietyCsvService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteToCsv extends CsvReadWrite {

    public void writeToSocietyCsvFile(CommandInput commandInput) throws Exception{
        SocietyCsvService societyCsvService = new SocietyCsvService(commandInput.socList);
        societyCsvService.readObjectsList();
        societyCsvService.generateFile();


//        BufferedWriter writeInSoc = new BufferedWriter( new FileWriter("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
//        String socCsvHeaderInfo = "SocName,Address,NoOfFlats,";
//        writeInSoc.append(socCsvHeaderInfo);

//
//        for (int socIndex = 0; socIndex < commandInput.socList.size(); socIndex++) {
///
//            writeInSoc.append(commandInput.socList.get(socIndex).socInfo());
////            for (int memberIndex = 0 ; memberIndex < membList.size() ; memberIndex++) {
//////                writeInSoc.append(membList.get(memberIndex).memberInfo());
////                writeInMember.append(membList.get(memberIndex).memberInfo(commandInput.socList.get(socIndex).socName()));
////            }
////            System.out.print("\n");
//        }
//        writeInSoc.close();
    }

    public void writeToMemberCsvFile(CommandInput commandInput) throws Exception{

        BufferedWriter writeInMember = new BufferedWriter( new FileWriter("C:/Users/prasad/IdeaProjects/Assignment 1/resources/members.csv"));// Writer
        String memberCsvHeaderInfo = "SocName, Flat No.,MemberName,";
        writeInMember.append(memberCsvHeaderInfo);

        for (int socIndex = 0; socIndex < commandInput.socList.size(); socIndex++) {

            ArrayList<Member> membList = commandInput.socList.get(socIndex).memberList;
            for (int memberIndex = 0 ; memberIndex < membList.size() ; memberIndex++) {
//                writeInSoc.append(membList.get(memberIndex).memberInfo());
                writeInMember.append(membList.get(memberIndex).memberInfo(commandInput.socList.get(socIndex).socName()));
            }
            System.out.print("\n");
        }
        writeInMember.close();
    }






}
