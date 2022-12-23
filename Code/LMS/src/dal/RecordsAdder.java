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
import model.dto.StudentDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

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

}
