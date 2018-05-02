/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postekpro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Fadly
 */
public class ListRekening {
    
    Rekening rek;
    
    public List<Rekening> getAllRekening()
    {
        List<Rekening> listRek = new ArrayList<>(getAllId());
        listRek.addAll(getAllPIN());
        listRek.addAll((Collection<? extends Rekening>) rek.getIsi());
        return listRek;
    }
    
    public List<Rekening> getAllId()
    {
        List<Rekening> listId = new ArrayList<>(rek.getId());
        return listId;
    }
   
    public List<Rekening> getAllPIN()
    {
        List<Rekening> listPin = new ArrayList<>(rek.getPin());
        return listPin;
    }
}
