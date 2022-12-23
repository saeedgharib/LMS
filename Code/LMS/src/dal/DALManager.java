/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SMSFactory;
import model.dto.StudentDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;

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

    public DALManager(RecordsMapper mapper){
    objConnection = new SQLConnection("//","LMS", "sa","root");
    objReader = new DBReader();
    objAdder = SMSFactory.getInstanceOfAdder();
    this.objMapper=mapper;
    objModifier = SMSFactory.getInstanceOfModifier();
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
    
}
