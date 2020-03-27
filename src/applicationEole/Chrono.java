package applicationEole;

public class Chrono {

    private long tempsDepart=0;
    private long tempsFin=0;
    private long pauseDepart=0;
    private long pauseFin=0;
    private long duree=0;

    /**
     * Démarre Le chronomètre
     * @author Zorbrane
     */
    public void start() {
        tempsDepart=System.currentTimeMillis();
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
    }
    
    /**
     * Mettre en pause le chronomètre
     * @author Zorbrane
     */
    public void pause() {
        if(tempsDepart==0) {return;}
        pauseDepart=System.currentTimeMillis();
    }

    /**
     * Reprendre après une pause
     * @author Zorbrane
     */
    public void resume() {
        if(tempsDepart==0) {return;}
        if(pauseDepart==0) {return;}
        pauseFin=System.currentTimeMillis();
        tempsDepart=tempsDepart+pauseFin-pauseDepart;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
    }
    
    /**
     * Arrête le chronomètre
     * @author Zorbrane
     */
    public void stop() {
        if(tempsDepart==0) {return;}
        tempsFin=System.currentTimeMillis();
        duree=(tempsFin-tempsDepart) - (pauseFin-pauseDepart);
        tempsDepart=0;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
    }        
    
    /**
     * Renvoie la durée en secondes
     * @return Un long
     * @author Zorbrane
     */
    public long getDureeSec() {
        return duree/1000;
    }
        
    /**
     * Renvoie la durée en millisecondes
     * @return Un long
     * @author Zorbrane
     */
    public long getDureeMs() {
        return duree;
    }        

    /**
     * Renvoie la durée au format HH:MM:SS
     * @return Un String
     * @author Zorbrane
     */
    public String getDureeTxt() {
        return timeToHMS(getDureeSec());
    }

    /**
     * Renvoie une durée au format HH:MM:SS à partir d'une durée en secondes
     * @param Un temps en seconde de type long
     * @return Un String
     */
    public  String timeToHMS(long tempsS) {

        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r="";

        if(h<=0 && m<=0 && s<=0) {r="00:00:00";}
        
        if(h>0) {
        	if(h<10) {
        		r+="0"+h+":";
        	}else {
        		r+= h+":";
        	}
        
        }else {
        	r+= "00:";
        }
        
        if(m>0) {
        	if(m<10) {
        		r+="0"+m+":";
        	}else {
        		r+= m+":";
        	}
        	
        }else {
        	r+= "00:";
        }
        
        if(s>0) {
        	if(s<10) {
        		r+= "0"+s;
        	}else {
        		r+= s;
        	}
        	
        }
        

        return r;
    }  
    
    public  String timeToHMS(int tempsS) {

        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r="";

        if(h<=0 && m<=0 && s<=0) {r="00:00:00";}
        
        if(h>0) {
        	if(h<10) {
        		r+="0"+h+":";
        	}else {
        		r+= h+":";
        	}
        
        }else {
        	r+= "00:";
        }
        
        if(m>0) {
        	if(m<10) {
        		r+="0"+m+":";
        	}else {
        		r+= m+":";
        	}
        	
        }else {
        	r+= "00:";
        }
        
        if(s>0) {
        	if(s<10) {
        		r+= "0"+s;
        	}else {
        		r+= s;
        	}
        	
        }
        

        return r;
    }  

}
