package dataHolder;

import IO.IOReader;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberList {

    private ArrayList<Member> MemberList;

    public ArrayList<Member> getMemberList() {
        return MemberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        MemberList = memberList;
    }

    public ArrayList<Member> createMemberList(){
        IOReader ioReader = new IOReader();
        ioReader.loadFiles();

        for(int i = 0; i < ioReader.getFileList().size(); i++){
            try{
                Scanner in = new Scanner(ioReader.getFileList().get(i));
                String name = in.nextLine();
                String phoneNumber = in.nextLine();
                String email = in.nextLine();
                ChronoLocalDateTime age = LocalDateTime.parse(in.nextLine());
                ChronoLocalDateTime startDate = LocalDateTime.parse(in.nextLine());
                Boolean active = Boolean.parseBoolean(in.nextLine());
                Boolean deficit = Boolean.parseBoolean(in.nextLine());
                Boolean competitive = in.nextBoolean();
                int balance = Integer.parseInt(in.nextLine());

                MemberList.add(new Member(name, phoneNumber, email, age, startDate, active, deficit, competitive, balance));

            }catch(FileNotFoundException e){
                System.out.println("Error: "+e);
            }
        }
        return MemberList;
    }
}
