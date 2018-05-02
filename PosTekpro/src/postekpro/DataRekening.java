/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postekpro;

import java.util.ArrayList;
import java.util.List;

public class DataRekening {
    
    
      public List<Rekening> getAllId()
    {
        List<Rekening> listId = new ArrayList<>();
        listId.addAll(listId);
        return listId;
    }
   
    public List<Rekening> getAllPIN()
    {
        List<Rekening> listId = new ArrayList<>();
        listId.addAll(listId);
        return listId;
    }
    
     public List<Rekening> getAllRekening(){
        List<Rekening> listRek = new ArrayList<>(getAllPIN());
        listRek.addAll(getAllId());
        return listRek;
    }
}
