/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validators;

import javax.swing.JFrame;
import model.SMSFactory;
import model.dto.StudentDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import UI.Commmon.Login;

/**
 *
 * @author Mukhtiar-HPC
 */
public class CommonValidator {
   
    
    public static void validateStudent(StudentDTO objStudent, Response objResponse) {
        if(objStudent.FirstName == null || objStudent.FirstName.length() < 3){
            //objResponse.messagesList.add(new Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
                
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
            
            
        }
        if(objStudent.LastName == null ){
        
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"Last Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
       if(objStudent.Password == null || objStudent.Password.length()<8){
            
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"Password should be 8 characters long.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
       if(objStudent.Username == null ){
           
            
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"Please provide valid valid Username .\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
        
    }
    
    public static void validateTeacher(StudentDTO objStudent, Response objResponse) {
        if(objStudent.FirstName == null || objStudent.FirstName.length() < 3){
            //objResponse.messagesList.add(new Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
                
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
            
            
        }
        if(objStudent.LastName == null ){
          
            
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
       if(objStudent.Password == null || objStudent.Password.length()<8 ||!objStudent.Password.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")){
         
            
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"Password should be 8 characters long.First letter should be capital\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
       if(objStudent.Username == null ){
           
            
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
        
    }
    
}
