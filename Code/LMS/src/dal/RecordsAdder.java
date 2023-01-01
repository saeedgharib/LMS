/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import UI.Commmon.Login;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Assignments;
import model.dto.StudentDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.TeacherDTO;

/**
 *
 * @author Mukhtiar-HPC
 */
public class RecordsAdder {

    void saveStudent(StudentDTO objStudent, Response objResponse, Connection dbConnection) {
        
        try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO Student (Fname,Lname,Username,Email,Password) VALUES (?,?,?,?,?);");
            p.setString(1, objStudent.FirstName);
            p.setString(2, objStudent.LastName);
            p.setString(3, objStudent.Username);
            p.setString(4, objStudent.Email);
            p.setString(5, objStudent.Password);
            int rowsInserted = p.executeUpdate();
          
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Student added successfully.", MessageType.Information));
                
             
                
                
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to add Student, Please contact support that there an issue while saving new employee.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    void saveTeacher(TeacherDTO objTeacher, Response objResponse, Connection dbConnection) {
       try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO Teacher (Fname,Lname,Username,Email,Password) VALUES (?,?,?,?,?);");
            p.setString(1, objTeacher.FirstName);
            p.setString(2, objTeacher.LastName);
            p.setString(3, objTeacher.Username);
            p.setString(4, objTeacher.Email);
            p.setString(5, objTeacher.Password);
            int rowsInserted = p.executeUpdate();
          
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Teacher Registered successfully.", MessageType.Information));
                
             
                
                
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to Register Teacher, Please contact support that there an issue while saving new employee.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    void saveAssignment(Assignments objA, Response objResponse, Connection dbConnection) {
        
        try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO Assignment(Assignment_ID,url,Course_ID) VALUES (?,?,?);");
            p.setInt(1, 10);
            p.setString(2,objA.URL);
            p.setInt(3, 10);
            int rowsInserted = p.executeUpdate();
          
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("task added successfully.", MessageType.Information));
                
             
                
                
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to add Task.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
}
