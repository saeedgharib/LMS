/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.Commmon;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.dto.Response;

/**
 *
 * @author Mukhtiar-HPC
 */
public class CommonHandler {

    public static void handleResponse(Response objResponse,JComponent uiComponent) {
        if(objResponse.hasError()){
            if(uiComponent instanceof JLabel){
                ((JLabel)uiComponent).setText(objResponse.getErrorMessages());
                ((JLabel)uiComponent).setForeground(Color.RED);
            }
        }
        if(objResponse.hasWarning()){
            if(uiComponent instanceof JLabel){
                ((JLabel)uiComponent).setText(objResponse.getErrorMessages());
                ((JLabel)uiComponent).setForeground(Color.YELLOW);
            }
        }
        if(objResponse.hasInfo()){
            if(uiComponent instanceof JLabel){
                ((JLabel)uiComponent).setText(objResponse.getErrorMessages());
                ((JLabel)uiComponent).setForeground(Color.GREEN);
            }
        }
    }
    
}
