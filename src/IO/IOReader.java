package IO;

import dataHolder.Member;
import dataHolder.MemberList;

import java.io.File;
import java.util.ArrayList;

public class IOReader {

    private ArrayList<File> FileList;

    public ArrayList<File> getFileList() {
        return FileList;
    }

    public void setFileList(ArrayList<File> fileList) {
        FileList = fileList;
    }

    //Loads in all files from /data folder and adds them to ArrayList<File> FileList
    public void loadFiles(){
        int num = 0;
        String fileName = "Member" + num + ".txt";
        File file = new File("Data/"+fileName);
        while (file.exists()) {
            FileList.add(file);
            fileName = "Member"+(num++)+".txt";
            file = new File("Data/"+fileName);
        }
    }


}
