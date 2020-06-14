package com.company;
import java.io.*;       // you can write on java.io.* fo all BufferWriter , writer ,fileWriter
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
   1.read society
   2.read member
 */
public class CommandInput {
    private Scanner scan = new Scanner(System.in);
    public List<Society> socList;

    public CommandInput(List<Society> socList) {
        this.socList = socList;
    }

    private Society readSociety() {
        System.out.println("Enter soc name :");
        return new Society(null, scan.next(), 0);
    }

    private Member readMember(Society society) {
        System.out.println("Enter member name :");
        return new Member(0,scan.next(),society.getName());
    }

    private void removeMemberFromSociety(String name, Society societyObj) {

        Member memberToSearch = null;
        for (Member member : societyObj.memberList) {
            if (name.equals(member.memberName())) {
                memberToSearch = member;
                break;
            }
        }
        if (memberToSearch != null) {
            societyObj.removeMember(memberToSearch);
            System.out.println("Removed all information of " + name);
        } else {
            System.out.println("No Memember found with name " + name);
        }
    }

    private void memberOperations(Society societyObj) {
        int choiceOfMember = 0;
        while (choiceOfMember != 4) {
            printInstructionsOfMember();
            System.out.println("Enter your Choice :");
            choiceOfMember = scan.nextInt();

            switch (choiceOfMember) {

                case 1:// show member list
                    societyObj.memberNames();
                    break;

                case 2:// add member to societyObj
                    Member memberObj = readMember(societyObj);
                    societyObj.addMember(memberObj);
                    break;

                case 3://
                    societyObj.memberNames();
                    System.out.println("Enter the Name of member to be Removed :");
                    String name = scan.next();
                    removeMemberFromSociety(name, societyObj);
                    break;
                case 4:
                    break;

            }
        }
    }

    private static void printInstructionsOfMember() {
        System.out.println();
        System.out.println(" 1. Print MembersList ");
        System.out.println(" 2. Add Member");
        System.out.println(" 3. Remove Member");
        System.out.println(" 4. Exit.");
    }

    private static void printInstructionsOfSoc() {
        System.out.println();
        System.out.println(" 1. Add New Society ");
        System.out.println(" 2. Show Society List");
        System.out.println(" 3. Select current Soc for Member Options");
        System.out.println(" 4. Exit.");
    }

//    private static void searchForMember(String memberName) {
//
//        System.out.println();
//
//        for(int i = 0;i < socList.size(); i++){
//            if(socList.)
//        }
//    }

    public List<Society> getInput() {

        Scanner scan = new Scanner(System.in);
        Society societyObj = null;
        List<Society> currentSocList = new ArrayList<>();

        int societyChoice;

        do {
            printInstructionsOfSoc();
            societyChoice = scan.nextInt();

            if (societyChoice == 1) {  // add society
                societyObj = readSociety();
                socList.add(societyObj);
                currentSocList.add(societyObj);
                System.out.println(societyObj.getName() + " Society added");

            } else if (societyChoice == 2) { // Soclist For operations
                System.out.println("List of Societies :");
                int index = 1;
                for (Society i : socList) {
                    System.out.print(index + ".");
                    i.societyNames(); // imp concept
                    index++;
                }

                System.out.println(" Select Society for further operations :");
                int soc = scan.nextInt() - 1;
                if (soc > socList.size() - 1) {
                    System.out.println("Invalid society number select. Please try again.");
                    continue;
                }
                Society member = socList.get(soc);
                memberOperations(member);
//                String soc = scan.next();   // select society by name
//                System.out.println(soc);
//                for (Society name : socList) {
//                    if (soc.equals(name.socName())) {
//                        commandInput.memberOperations(name);
//                    }
//                }
            } else if (societyChoice == 3) {
                memberOperations(societyObj);

            } else if (societyChoice == 4) {
                break;
            }

            else if (societyChoice == 5){
                System.out.println("Enter the name you want to Search");
            }

        } while (4 != societyChoice);
        System.out.println(socList);
        return currentSocList;
    }

    public List<Society> getSocList() {
        return socList;
    }


//    public void writeToSocietyCsvFile() throws Exception{
//
//        BufferedWriter writeInSoc = new BufferedWriter( new FileWriter("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
//        BufferedWriter writeInMember = new BufferedWriter( new FileWriter("C:/Users/prasad/IdeaProjects/Assignment 1/resources/members.csv"));// Writer
//
//        String socInfo = "SocName,Address,NoOfFlats,";
//        writeInSoc.append(socInfo);
//
//        String memberInfo = "SocName, Flat No.,MemberName,";
//        writeInMember.append(memberInfo);
//
////        for (int socIndex = 0; socIndex < socList.size(); socIndex++) {
//        for (int socIndex = 0; socIndex < socList.size(); socIndex++) {
//
//            ArrayList<Member> membList = socList.get(socIndex).memberList;
//            writeInSoc.append(socList.get(socIndex).socInfo());
//
//            for (int memberIndex = 0 ; memberIndex < membList.size() ; memberIndex++) {
////                writeInSoc.append(membList.get(memberIndex).memberInfo());
//                writeInMember.append(membList.get(memberIndex).memberInfo(socList.get(socIndex).socName()));
//            }
//            System.out.print("\n");
//        }
//
////        writeInSoc.append(socList.toString());
//        writeInMember.close();
//        writeInSoc.close();
//    }
//
//    public void readfromSocCsvFile() throws Exception{
//
//        BufferedReader readFromSoc = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/society.csv")); // FileWriter
//
//        BufferedReader readFromMember = new BufferedReader(new FileReader("C:/Users/prasad/IdeaProjects/Assignment 1/resources/members.csv")); // Writer
//
//        List<String> readList = new ArrayList();
//
//        String socInfo = readFromSoc.readLine();
//
//        while (socInfo != null) {
//            String societyInfo[] = socInfo.split(",");
//
//            Society soc = new Society();
//            String socList =  soc.columnWiseSocInformation(societyInfo);
//            readList.add(socList);
//            socInfo = readFromSoc.readLine();
//        }
//        System.out.println();
////        for (int i = 0; i < societyInfo.length; i++ ){
//////            System.out.println(societyInfo[i]+" "+societyInfo[i+1]+" "+societyInfo[i+2]+" ");
////            readList.add(societyInfo[i]+" "+societyInfo[i+1]+" "+societyInfo[i+2]+" ");
////            i = i+2;
////        }
//        System.out.println(readList.size());
//        for(int i = 0; i < readList.size(); i++){
//            System.out.println(readList.get(i));
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
//        readFromMember.close();
//        readFromSoc.close();
//    }

}

/*
        i) Do you want to add soc?
        ii) do you want to add members in this soc?
*/