package org.ismailkarakaya.utils;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.security.Permission;
import java.util.Date;
import java.util.UUID;

//LOMBOK
@Data
@Log4j2
public class FilePathData {

    //Variable
    private String id;
    private String pathFileName;
    private String url;
    private String path;
    private File file;
    private Date systemCreatedDate;

    //Parametresiz constructor


    public FilePathData() {
        id= UUID.randomUUID().toString();
        systemCreatedDate=new Date(System.currentTimeMillis());
        url="D:\\projeler\\file";
        pathFileName="\\MyRemainingRight.txt";
        path=url.concat(pathFileName);
        file=new File(path);

        try{
            if (file.createNewFile()){
                System.out.println(path + "Böyle bir dosya yoktur ve oluşturuldu.");
                System.out.println("Permission: Okunabilinir mi ?" + file.canRead() + " yazılabilinir mi? " + file.canWrite() + " Çalıştırılabilinir mi " + file.canExecute());
                System.out.println("ID: " + this.id + " URL: " + this.url + " Hash Code: " + file.hashCode());

            }else{
                String fileName = path + "Böyle bir dosya var tekrardan oluşturulmadı.";
                System.out.println(fileName);
            }
            //default 4 hak
            fileRemainingNumber();
            System.out.println("kalan hak: "+fileReaderRemainingNumber());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //parametreli constructor
    public FilePathData(String id, File file) {
        this.id = id;
        this.file = file;
    }

    //FileWriter
    private void fileRemainingNumber(){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(this.path,false))){
            bufferedWriter.write("4");
            bufferedWriter.flush();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //FileReader
    private Integer fileReaderRemainingNumber(){
        String rows;
        Integer numberOfRights=null;
        String readRows;
        StringBuilder stringBuilder=new StringBuilder();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(this.path))){
            while ((rows = bufferedReader.readLine()) != null) {
                stringBuilder.append(rows);
            }
            readRows=stringBuilder.toString();
            numberOfRights=Integer.valueOf(readRows);
        }catch(Exception e){
            e.printStackTrace();
        }
        return numberOfRights;
    }

    public static void main(String[] args) {
        FilePathData filePathData=new FilePathData();
        System.out.println(filePathData);
    }
}
