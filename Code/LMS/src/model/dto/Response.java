/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import static java.awt.Color.yellow;
import java.util.ArrayList;

/**
 *
 * @author Mukhtiar-HPC
 */
public class Response {
    public ArrayList<Message> messagesList;
    public Response(){ 
        messagesList = new ArrayList<>();
    }

    public boolean hasError() {
        for(Message m : messagesList)
        {
            if(m.Type == MessageType.Error || m.Type == MessageType.Exception)
                return true;
        }
        return false;
}
   public boolean hasWarning() {
        for(Message m : messagesList)
        {
            if(m.Type == MessageType.Warning)
                return true;
        }
        return false;
}
   public boolean hasInfo() {
        for(Message m : messagesList)
        {
            if(m.Type == MessageType.Information)
                return true;
        }
        return false;
}
   

    public String getErrorMessages() {
        StringBuilder sb = new StringBuilder();    
        for(Message m : messagesList)
        {
           if(sb.length() > 0) 
               sb.append(",\n");
                sb.append(m.Message);
                
        }
        return sb.toString();
    }

    public boolean isSuccessfull() {
        return !hasError();
    }
}
