package org.ismailkarakaya.database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection extends DatabaseInformation{
    // Field
    private String url=super.getUrl();
    private String user=super.getUser();
    private String password=super.getPassword();
    private String forNameData=super.getForNameData();

    //for database
    private Connection connection;//import java.sql.Connection;

    //Singleton design Pattern (Class)
    private static DatabaseConnection instance;

    //Singleton design Pattern (Constructor)

    private DatabaseConnection() {
        try{
            Class.forName(this.forNameData);
            System.out.println("Database Class Yüklendi");
            connection= DriverManager.getConnection(url,user,password);
            System.out.println("Database Bağlantısı başarılı");
        }catch (ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //
    public static DatabaseConnection getInstance(){
        try{
            //eğer connection null veya kapalı ise
            //yeni instance oluştur
            if (instance==null || instance.connection.isClosed()){
                instance=new DatabaseConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;

    }



    @Override
    public void databaseInfo() {
        System.out.println("Database Information: "+super.getUrl()+" "+super.getForNameData()+" "+super.getPassword()+" "+super.getUser());


    }
    //Test
    public static void main(String[] args) {
        DatabaseConnection databaseConnection=new DatabaseConnection();
    }
}
