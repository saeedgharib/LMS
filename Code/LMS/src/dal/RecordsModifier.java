/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import java.sql.ResultSet;
import model.dto.StudentDTO;

/**
 *
 * @author Mukhtiar-HPC
 */
public class RecordsModifier {

    void deleteStudent(String selectedId, Response objResponse, Connection dbConnection) {
        try{
            
            PreparedStatement p;// (FirstName,LastName,Title) VALUES (?,?,?);");
            p = dbConnection.prepareStatement("delete from Student where Fname=?;");
            p.setString(1, selectedId);
            int rowsInserted = p.executeUpdate();
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Student deleted successfully.", MessageType.Information));
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    
    void ApproveStudent(String selectedId, Response objResponse, Connection dbConnection) {
       try{
            PreparedStatement p;// (FirstName,LastName,Title) VALUES (?,?,?);");
            p = dbConnection.prepareStatement("select from Student where StudentID=?");
            p.setString(1, selectedId);
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                StudentDTO obj =new StudentDTO();
                obj.FirstName=rs.getString(1);
                obj.LastName=rs.getString(2);
                obj.Username=rs.getString(3);
                obj.Password=rs.getString(4);
                obj.Email=rs.getString(5);
                
            }
            
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
    
}
