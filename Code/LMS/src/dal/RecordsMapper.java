/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.StudentDTO;

/**
 *
 * @author Mukhtiar
 */
public class RecordsMapper {

    ArrayList<StudentDTO> getStudents(ResultSet rs) {
        ArrayList<StudentDTO> studentlist = new ArrayList<>();
        try{
        while (rs.next())
            {
                StudentDTO objStudent=new StudentDTO();                
//                objStudent.Id=rs.getString(1);
                objStudent.Id= rs.getString(1);
                objStudent.FirstName =rs.getString(2);
                objStudent.LastName =rs.getString(3);
                studentlist.add(objStudent);
            }
        }catch (Exception e){
        }
        return studentlist;
    }
    
}
