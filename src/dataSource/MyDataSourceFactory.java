
package dataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

/**
 *
 * @author Mariam khaled
 */
public class MyDataSourceFactory {
    public static DataSource getMySqlDataSource()
    {
             Properties prop=new Properties();
            FileInputStream fis=null;
            MysqlDataSource mysqlDS=null;
        try {
            fis=new FileInputStream("db.properties");
            prop.load(fis);
            mysqlDS=new MysqlDataSource();
            mysqlDS.setURL(prop.getProperty("DB_URL"));
            mysqlDS.setUser(prop.getProperty("USER"));
            mysqlDS.setPassword(prop.getProperty("PASSWORD"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return mysqlDS;
    }
    
    public static Person getPerson(String sql)
    {
            DataSource ds=null;
            ds=MyDataSourceFactory.getMySqlDataSource();
            Connection con =null;
            Statement stmt=null;
            Person person=new Person();
            ResultSet rs=null;
        try {
            con=ds.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()) {                
            person.setId(rs.getInt("id"));
            person.setfName(rs.getString("fName"));
            person.setlName(rs.getString("lName"));
            person.setmName(rs.getString("middleName"));
            person.setEmail(rs.getString("email"));
            person.setPhone(rs.getInt("phone"));
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
                try {
                    if(rs !=null)rs.close();
                    if(stmt !=null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException ex) {
                  ex.printStackTrace();
                }
        }
             return  person;
    }
    public static void newPerson(Person person)
    {          
            DataSource ds=null;
            ds=MyDataSourceFactory.getMySqlDataSource();
            Connection con =null;
            Statement stmt=null;
        try {
            con=ds.getConnection();
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
            String sql="insert into person(fName,middleName,lName,email,phone) values('" + person.getfName() + "','" + person.getmName() + "','" + person.getlName() + "','" + person.getEmail() + "','" + person.getPhone() + "')";
           int m=stmt.executeUpdate(sql);
           if(m==1)
            {
                System.err.println("success");
            }else{
                System.err.println("Not success ");
                
            }
            con.close();
           
        } catch (SQLException ex) {
                      

            ex.printStackTrace();
           
        }finally{
                try {
                    if(stmt !=null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException ex) {
                  ex.printStackTrace();
                }
        }
        
    }
    
    public static void updatePerson(Person person)
    {
        DataSource ds=null;
        ds=MyDataSourceFactory.getMySqlDataSource();
            
        try {
            Connection con =ds.getConnection();
            System.out.println(person);
            String sql="update person set fName=?,middleName=?,lName=?,email=?,phone=? where id=?";
            PreparedStatement  stmt=con.prepareStatement(sql);
            stmt.setString(1, person.getfName());
            stmt.setString(3, person.getlName());
            stmt.setString(2, person.getmName());
            stmt.setString(4, person.getEmail());
            stmt.setInt(5, person.getPhone());
            stmt.setInt(6, person.getId());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }
    public static boolean removePerson(int id) {
        boolean hasDeleted = false;
        try {
            DataSource ds = getMySqlDataSource();
            Connection con = null;
            con = ds.getConnection();
            String sql = "delete from person where id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            hasDeleted = true;
            con.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return hasDeleted;

    }
    
}
