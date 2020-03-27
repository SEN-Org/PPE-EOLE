package applicationEole;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class GestRegate {
	
	private static Map<Integer, Voilier> lesVoiliers = new HashMap<>();
	
	
	/**
    * Génère le classement par categorie dans la variable classement du participant
    * @param la categorie, la regate
    * @author Zorbrane
    */
	/**
   public void classement(int categorie, Regate regate){
       Set<Integer> e = regate.getLesParticipants().keySet();
       Iterator<Integer> it = e.iterator();
       TreeSet<Participant> classement = new TreeSet<Participant>();
       int i = 0;
       while(it.hasNext()) {
           Integer key = it.next();
           if(regate.getLesParticipants().get(key).getCategorieVoilier() == categorie && regate.getLesParticipants().get(key).getTempsRealise() != 0 ) {
               classement.add(regate.getLesParticipants().get(key));
           }
       }
       while(!classement.isEmpty()) {
           i++;
           classement.pollFirst().setClassement(i);
       }
   }
   **/
   
   
   
   /**
   * Renvoie le temps compenser en seconde à partir du temps réel en seconde.
   * @param un int, le temps en seconde
   * @return Un int
   * @author Zorbrane
   */
  public int tempsCompenses(int temps, Participant participant, Regate regate) {
      int i = temps;
      int r = participant.getRatingVoilier();
      int h = (int)Math.round(5143 / (Math.sqrt(r) + 3.5) * regate.getDistance());
      return i + h;
  }
	
}
