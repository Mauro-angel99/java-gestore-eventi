package org.generation.italy.eventi;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> Eventi;
	
	
public ProgrammEventi(String titolo, List<Evento> Eventi) {
		
	this.titolo = titolo;
	this.Eventi = Eventi;
	

}

public void addEvento(Evento e) {
	
	Eventi.add(e);
	

}

public void listEventi() {
	
	for (Evento Evento : Eventi) {
		
		System.out.println(Evento);
	}
}

public int numeroEventi() {
	
	
	int i = 0;
		
    for (Evento Evento : Eventi) {
	
	  i++;
	  
	}
    
    return i;
		
}

public void svuotaLista() {
	
		
    Eventi.clear();
    
    System.out.println("Tutti gli elemeti sono stati eliminati");
    	
}

public void ordineData() {
	
	ArrayList<String> dateArray = new ArrayList<String>();
	
	
	
	for (Evento Evento : Eventi) {
		
		dateArray.add(Evento.dataStr());
		
		Collections.sort(dateArray);
	
	  }
	
	for(int x=0;x<numeroEventi();x++) {
		
		for(Evento Evento : Eventi) {
			
			if(dateArray.get(x).equals(Evento.dataStr())) {
				System.out.println(Evento.data() + " " + Evento.getTitolo());
			}
		}
	
	}

	
	
    	
}


}
