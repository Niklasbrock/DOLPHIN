package IO;

import dataHolder.Competition;
import dataHolder.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOWriter {

    public void writeFile(Member newMember){
        try{
            int num = 0;
            String fileName = "Member" + num + ".txt";
            File file = new File("Data/"+fileName);
            while (file.exists()) {
                fileName = "Member"+(num++)+".txt";
                file = new File("Data/"+fileName);
            }
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(newMember.getName());
            printWriter.println(newMember.getPhoneNumber());
            printWriter.println(newMember.getEmail());
            printWriter.println(newMember.getAge());
            printWriter.println(newMember.getStartDate());
            printWriter.println(newMember.getActive());
            printWriter.println(newMember.getDeficit());
            printWriter.println(newMember.getCompetitive());
            printWriter.println(newMember.getBalance());

            fileWriter.close();
        }catch (IOException e){
            System.out.println("Error "+e);
        }
    }
    public void writeFile(Competition newCompetition){
        try{
            int num = 0;
            String fileName = "Member" + num + ".txt";
            File file = new File("Data/"+fileName);
            while (file.exists()) {
                fileName = "Member"+(num++)+".txt";
                file = new File("Data/"+fileName);
            }
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            fileWriter.close();
        }catch (IOException e){
            System.out.println("Error "+e);
        }
    }
}
