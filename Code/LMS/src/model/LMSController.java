/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.DALManager;
import java.util.ArrayList;
import model.dto.Assignments;
import model.dto.ContentDTO;
import model.dto.StudentDTO;
import model.dto.Response;
import model.dto.StatsDTO;
import model.dto.TeacherDTO;
import model.dto.UserState;
import model.validators.CommonValidator;

/**
 *
 * @author Mukhtiar
 */
public class LMSController {
    DALManager objDAL;
    public LMSController(){
    objDAL = LMSFactory.getInstanceOfDALManager();
    }

    public ArrayList<StudentDTO> viewStudents(String searchKey) {
        return objDAL.getStudentsList(searchKey);
    }
public ArrayList<StatsDTO> getStats() {
        return objDAL.getStats();
    }
public ArrayList<StatsDTO> getQuizStats() {
        return objDAL.getQuizStats();
    }

    public Response addStudent(StudentDTO objStudent) {
        Response objResponse = LMSFactory.getResponseInstance();
        CommonValidator.validateStudent(objStudent,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveStudent(objStudent,objResponse);
        }
        return objResponse;
    }

    
   
    public Response addAssignment(Assignments objA) {
        Response objResponse = LMSFactory.getResponseInstance();
        CommonValidator.validateAssignment(objA, objResponse);
       if(objResponse.isSuccessfull()){
            objDAL.saveAssignment(objA,objResponse);
        }
        return objResponse;
    }
    public Response addTeacher(TeacherDTO objTeacher) {
        Response objResponse = LMSFactory.getResponseInstance();
        CommonValidator.validateTeacher(objTeacher,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveTeacher(objTeacher,objResponse);
        }
        return objResponse;
    }

    public Response deleteStudent(String selectedId) {
        Response objResponse = LMSFactory.getResponseInstance();
        objDAL.deleteStudent(selectedId, objResponse);
        return objResponse;
    }
    
    public Response Authenticate(UserState objUser) {
        Response objResponse = LMSFactory.getResponseInstance();
        CommonValidator.validateUser(objUser,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.AuthenticateUser(objUser,objResponse);
        }
        return objResponse;
    }

    public Response ApproveStudent(String selectedId) {
        
        Response objResponse = LMSFactory.getResponseInstance();
  
      
            objDAL.Approve(selectedId,objResponse);
       
        return objResponse;
    }
    
    public Response addContent(ContentDTO obj) {
        Response objResponse = LMSFactory.getResponseInstance();
        CommonValidator.validateContent(obj, objResponse);
       if(objResponse.isSuccessfull()){
            objDAL.saveContent(obj,objResponse);
        }
        return objResponse;
    }
    
    public Response Search(StudentDTO obj) {
     
        
       Response objResponse = LMSFactory.getResponseInstance();
        CommonValidator.validateStudent(obj,objResponse);        
            objDAL.Search(obj,objResponse);        
        return objResponse;
    }
    
}
