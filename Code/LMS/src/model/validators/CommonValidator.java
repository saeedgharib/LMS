
package model.validators;

import javax.swing.JFrame;
import model.LMSFactory;
import model.dto.StudentDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import UI.Commmon.Login;
import model.dto.Assignments;
import model.dto.TeacherDTO;
import model.dto.User;

/**
 *
 * @author Mukhtiar-HPC
 */
public class CommonValidator {
   
    
    public static void validateStudent(StudentDTO objStudent, Response objResponse) {
        if(objStudent.FirstName == null || objStudent.FirstName.length() < 3){
            //objResponse.messagesList.add(new Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
                
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
            
            
        }
        if(objStudent.LastName == null ){
        
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="\"Last Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
       if(objStudent.Password == null || objStudent.Password.length()<8){
            
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="\"Password should be 8 characters long.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
       if(objStudent.Username == null ){
           
            
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="\"Please provide valid valid Username .\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
        
    }
    
    public static void validateTeacher(TeacherDTO objTeacher, Response objResponse) {
        if(objTeacher.FirstName == null || objTeacher.FirstName.length() < 3){
            //objResponse.messagesList.add(new Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
                
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }}
            
//        }
//        if(objTeacher.LastName == null ){
//          
//            
//            Message msg =SMSFactory.getInstanceOfMessage();
//            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
//            msg.Type=MessageType.Error;
//            objResponse.messagesList.add(msg);
//        }
//       if(objTeacher.Password == null || objTeacher.Password.length()<8 ||!objTeacher.Password.startsWith("ABCDEFGHIJKLMNOPQRSTUVWXYZ")){
//         
//            
//            Message msg =SMSFactory.getInstanceOfMessage();
//            msg.Message="\"Password should be 8 characters long.First letter should be capital\"";
//            msg.Type=MessageType.Error;
//            objResponse.messagesList.add(msg);
//        }
//       if(objTeacher.Username == null ){
//           
//            
//            Message msg =SMSFactory.getInstanceOfMessage();
//            msg.Message="\"FIrst Name is not valid, Provide valid first name with at least 3 characters.\"";
//            msg.Type=MessageType.Error;
//            objResponse.messagesList.add(msg);
//        }
//        
//    }
//
        
    public static void validateUser(User objUser, Response objResponse) {
        if(objUser.username==null || objUser.password==null){
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="Username or Password cannot be null";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
    }
    
     public static void validateAssignment(Assignments objA, Response objResponse) {
        if(objA.URL==null){
            Message msg =LMSFactory.getInstanceOfMessage();
            msg.Message="File Not Found";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
    }
}
