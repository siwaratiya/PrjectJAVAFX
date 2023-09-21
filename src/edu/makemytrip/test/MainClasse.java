    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.test;

import edu.makemytrip.entities.Chambre;
import edu.makemytrip.entities.Hotel;
import edu.makemytrip.entities.Type;
import edu.makemytrip.entities.Vue;
import edu.makemytrip.services.ChambreCrud;
import edu.makemytrip.services.HotelCrud;


/**
 *
 * @author siwar
 */
public class MainClasse {
     public static void main(String[] args) {
         //MyConnection mc=new MyConnection();
    Hotel h = new Hotel(4,"lff","gg","ggg","hhh",4,"ggg",3);
   HotelCrud hot = new HotelCrud(); 
   ChambreCrud ch = new ChambreCrud();
      //Type type=Type.Singel;
      //Vue vue=Vue.Normale;
   Chambre chh= new Chambre(13,Type.Double,Vue.Normale,9.8,5);
 //hot.ajouterHotel();
  ch.ajouterChambre(chh);
  //hot.ajouterHotel2(h);
  // hot.supprimerHotel(4);
  //hot.modifierHotel(h);
  //ch.modifierChambre(chh);
 //hot.supprimerChambre(13,h);
 //System.out.println(hot.listerHoteles());
//System.out.println(ch.listerChambres());
//hot.listerchm(3);
}
}