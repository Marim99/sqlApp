/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlapp;

import dataSource.MyDataSourceFactory;
import dataSource.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.sql.DataSource;

/**
 *
 * @author Alex-Store
 */
public class SqlApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        testData();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private static void testData()
    {
            DataSource ds=null;
            ds=MyDataSourceFactory.getMySqlDataSource();
            Connection con =null;
            Statement stmt=null;
            ResultSet rs=null;
        try {
            con=ds.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from person");
            while(rs.next())
            {
                System.out.println("id :  "+ rs.getInt("id")+"  "+ "first name:  "+rs.getString("fName"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
                try {
                    //System.out.println(rs);
                    if(rs !=null)rs.close();
                    if(stmt !=null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException ex) {
                  ex.printStackTrace();
                }
        }
    }
    
}
