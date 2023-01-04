/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.DALManager;
import dal.RecordsAdder;
import dal.RecordsMapper;
import dal.RecordsModifier;
import dal.Verifyer;
import model.dto.Message;
import static model.dto.MessageType.Error;
import model.dto.Response;

/**
 *
 * @author Mukhtiar
 */
public class LMSFactory {

    static DALManager getInstanceOfDALManager() {
        return new DALManager(new RecordsMapper());
    }

    public static LMSController getInstanceOfLMSController() {
        return new LMSController();
    }

    static Response getResponseInstance() {
        return new Response();
    }

    public static RecordsAdder getInstanceOfAdder() {
        return new RecordsAdder();
    }

    public static RecordsModifier getInstanceOfModifier() {
        return new RecordsModifier();
    }
    public static Message getInstanceOfMessage() {
        return new Message("asd",Error);
    }

    public static Verifyer getInstanceOfVerifyer() {
       return new Verifyer();
    }
    
}
