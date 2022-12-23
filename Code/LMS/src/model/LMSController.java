/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.DALManager;
import java.util.ArrayList;
import model.dto.StudentDTO;
import model.dto.Response;
import model.validators.CommonValidator;

/**
 *
 * @author Mukhtiar
 */
public class LMSController {
    DALManager objDAL;
    public LMSController(){
    objDAL = SMSFactory.getInstanceOfDALManager();
    }

    public ArrayList<StudentDTO> viewStudents(String searchKey) {
        return objDAL.getStudentsList(searchKey);
    }

    public Response addStudent(StudentDTO objStudent) {
        Response objResponse = SMSFactory.getResponseInstance();
        CommonValidator.validateStudent(objStudent,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveStudent(objStudent,objResponse);
        }
        return objResponse;
    }

    public Response deleteStudent(String selectedId) {
        Response objResponse = SMSFactory.getResponseInstance();
        objDAL.deleteStudent(selectedId, objResponse);
        return objResponse;
    }
}
