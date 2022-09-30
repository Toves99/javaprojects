package Hostel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Struct;
import java.util.jar.JarOutputStream;

public class AdminModel {
    private String firstName;
    private String lastName;
    private String username;
    private String enterPassword;
    private String confirmPassword;

    String password;
    boolean validateAdmin;
    //Database
    static String databaseName = "school";
    static String tableName = "admin";
    //database  command
    String authenticateQuery="select username,password from `"+tableName+"`where username=? and password=?";
    String createAdminQuery="insert  into `"+tableName+"` values(?,?,?,?)";

    //initializing admin

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnterPassword(String enterPassword) {
        this.enterPassword = enterPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPassword(){
        if(this.enterPassword.equals(this.confirmPassword)){
            this.password=this.enterPassword;
        }

    }
    public void setConfirmLoginPassword(String enterPassword){
        this.password=this.enterPassword;
    }
    //validating admin before he/she logs in the system
    Database connectNow=new Database();
    Connection connectDb=connectNow.getConnection(databaseName);
    public void validateAdmin(){
        try{
            if(!(this.username).equals(null) && !(this.password).equals(null)){
                PreparedStatement pst=connectDb.prepareStatement(this.authenticateQuery);
                pst.setString(1,username);
                pst.setString(2,password);
                ResultSet resultSet=pst.executeQuery();
                if(resultSet.next()){
                    this.validateAdmin=true;
                }
            }
            else
            {
                validateAdmin=false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //creating admin account if he/she is new
    public void createAdminAccount(){
        Database connectNow=new Database();
        Connection connectDb=connectNow.getConnection(databaseName);
        try{
            if(!(this.firstName.trim().isEmpty())&&!(this.lastName.trim().isEmpty())&&!(this.username.trim().isEmpty())&&!(this.password.trim().isEmpty())){
                PreparedStatement pst=connectDb.prepareStatement(this.createAdminQuery);
                pst.setString(1,firstName);
                pst.setString(2,lastName);
                pst.setString(3,username);
                pst.setString(4,password);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Account successfully ");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fill All Fields");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEnterPassword() {
        return enterPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public boolean getValidateAdmin(){
        return validateAdmin;
    }
}
