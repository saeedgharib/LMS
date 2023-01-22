/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import UI.AdminInterface.StudentMod;
import UI.AdminInterface.ViewStdnt;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.dto.StatsDTO;
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
    
    ArrayList<StatsDTO> getStats(ResultSet rs) {
     ArrayList<StatsDTO> statslist = new ArrayList<>();
        
        try{
        while (rs.next())
            {   
              StatsDTO obj =new StatsDTO();
              obj.TotalTeachers=rs.getInt(1);
//              obj.TotalTeachers=rs.getInt(2);
              statslist.add(obj);
              
            }
        }catch (Exception e){
        }
        return statslist;
    }
    
    StudentDTO viewStudents(ResultSet rs) {
        StudentDTO objStudent=new StudentDTO();   
      try{
        while (rs.next())
            {                                      
                objStudent.FirstName= rs.getString(2);
//                objStudent.LastName=rs.getString(3);  
//                objStudent.Username=rs.getString(4); 
//                objStudent.Email=rs.getString(6); 
//                objStudent.PhoneNumber=rs.getString(8);                                                
            }            
         ViewStdnt ob = new ViewStdnt(objStudent);
                ob.setVisible(true);
        }catch (Exception e){
            System.out.println("mapper Error");
        }
        return objStudent;
    }

    ArrayList<StatsDTO> getQuizStats(ResultSet rs) {
        ArrayList<StatsDTO> statslist = new ArrayList<>();
        
        try{
        while (rs.next())
            {   
              StatsDTO obj =new StatsDTO();
              obj.TotalQuiz=rs.getInt(1);                
              statslist.add(obj);
              
            }
        }catch (Exception e){
        }
        return statslist;
    }
}
