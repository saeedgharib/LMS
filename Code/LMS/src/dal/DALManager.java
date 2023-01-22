/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.LMSFactory;
import model.dto.Assignments;
import model.dto.ContentDTO;
import model.dto.StudentDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.TeacherDTO;
import model.dto.UserState;
import model.dto.StatsDTO;
/**
 *
 * @author Mukhtiar
 */
public class DALManager {
    IConnection objConnection;
    DBReader objReader;
    RecordsMapper objMapper;
    RecordsAdder objAdder;
    RecordsModifier objModifier;
    Verifyer objVerify;
    
    public DALManager(RecordsMapper mapper){
    objConnection = new SQLConnection("//","ReadIT", "sa","root");
    objReader = new DBReader();
    objAdder = LMSFactory.getInstanceOfAdder();
    this.objMapper=mapper;
    objModifier = LMSFactory.getInstanceOfModifier();
    objVerify = LMSFactory.getInstanceOfVerifyer();
    }
    public ArrayList<StudentDTO> getStudentsList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewStudentsQuery = "Select * from Student";
        if(searchKey == null || searchKey.length() > 0)
        {
            viewStudentsQuery += " where FirstName LIKE '%"+searchKey+"%' OR LastName LIKE '%"+searchKey+"%' OR Title LIKE '%"+searchKey+"%';";
        }
        ResultSet rs = objReader.getRecords(viewStudentsQuery, dbConnection);
        return objMapper.getStudents(rs);        
    }  

    public void saveStudent(StudentDTO objEmp, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveStudent(objEmp,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
public void saveTeacher(TeacherDTO objTeacher, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveTeacher(objTeacher,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
     public Response deleteStudent(String selectedId, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objModifier.deleteStudent(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to delete employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }

     public Response Approve(String selectedId, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objModifier.ApproveStudent(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to delete employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }

     public void saveAssignment(Assignments objA, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveAssignment(objA,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to generate Assignment", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }
    public void AuthenticateUser(UserState objUser, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objVerify.Verify(objUser, objResponse, dbConnection);
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Login Failed", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n"+e.getStackTrace(), MessageType.Exception));
        }
        
        
    }
    public void saveContent(ContentDTO obj, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveContent(obj,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to generate Assignment", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    public ArrayList<StatsDTO> getStats() {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewStatsQuery = "SELECT  COUNT(Student_ID) As ID FROM Student UNION SELECT  COUNT(Teacher_ID)  FROM Teacher;";
    
        ResultSet rs = objReader.getStats(viewStatsQuery, dbConnection);
        return objMapper.getStats(rs);        
    }  
   
    
    public ArrayList<StatsDTO> getQuizStats() {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewStatsQuery = "SELECT  COUNT(Quiz_ID) from Quiz ;";
    
        ResultSet rs = objReader.getQuizStats(viewStatsQuery, dbConnection);
        return objMapper.getQuizStats(rs);        
    } 
    public StudentDTO Search(StudentDTO obj, Response objResponse) {          
      Connection  dbConnection = objConnection.getConnection();
        String viewStudentsQuery = "Select * from Student";
        if(obj.FirstName!=null)
        {
            viewStudentsQuery += " where Fname LIKE '%"+obj.FirstName+"%' OR Lname LIKE '%"+obj.FirstName+"%';";
        }
        ResultSet rs = objReader.getRecords(viewStudentsQuery, dbConnection);
        return objMapper.viewStudents(rs);  
    } 
}
