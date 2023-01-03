/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import UI.AdminInterface.StudentMod;
import UI.Commmon.Login;
import UI.LMSA;
import UI.StudentInterface.StudentDashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.User;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.LMSFactory;
/**
 *
 * @author Mansoor
 */
public class Verifyer {

    void Verify(User objUser, Response objResponse, Connection dbConnection) {
        
               try{
                   try (dbConnection) {
                       PreparedStatement p;
                       if(null != objUser.type)switch (objUser.type) {
                           case "Teacher":{
                               p = dbConnection.prepareStatement("Select * from Teacher where Username=? and Password=?;" );
                               p.setString(1,objUser.username);
                               p.setString(2, objUser.password);
                               ResultSet rs =p.executeQuery();
                               if(rs.next()){
                                   LMSA ob =new LMSA();
                                   ob.setVisible(true);  
                               }
                               else{
                                   Message msg =LMSFactory.getInstanceOfMessage();
                                   msg.Message="Login Failed! \n Username or Password is incorrect";
                                   msg.Type=MessageType.Error;
                                   objResponse.messagesList.add(msg);
                               }           break;
                               }
                           case "Admin":{
                               p = dbConnection.prepareStatement("Select * from Admin where Username=? and Password=?;" );
                               p.setString(1,objUser.username);
                               p.setString(2, objUser.password);
                               ResultSet rs =p.executeQuery();
                               if(rs.next()){
                                   StudentMod std =new StudentMod();
                                   std.setVisible(true);  
                               }
                               else{
                                   Message msg =LMSFactory.getInstanceOfMessage();
                                   msg.Message="Login Failed! \n Username or Password is incorrect";
                                   msg.Type=MessageType.Error;
                                   objResponse.messagesList.add(msg);
                               }           break;
                               }
                           case "Student":{
                               p = dbConnection.prepareStatement("Select * from Student where Username=? and Password=?;" );
                               p.setString(1,objUser.username);
                               p.setString(2, objUser.password);
                               ResultSet rs =p.executeQuery();
                               if(rs.next()){
                                   StudentDashboard ob2 =new StudentDashboard();
                                   ob2.setVisible(true);
                               }
                               else{
                                   Message msg =LMSFactory.getInstanceOfMessage();
                                   msg.Message="Login Failed! \n Username or Password is incorrect";
                                   msg.Type=MessageType.Error;
                                   objResponse.messagesList.add(msg);
                               }           break;
                               }
                           default:
                               break;
                       }
                       
                       
                   }
                   dbConnection.close();
        }catch(SQLException e){
//            objResponse.messagesList.add(new Message("Login Failed:User", MessageType.Error));
//            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
            
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="Login Failed! \n Username or Password is incorrect";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
    }
    
}
