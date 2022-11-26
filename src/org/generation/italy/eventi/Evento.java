package org.generation.italy.eventi;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;

public class Evento {
	
	private String titolo;
	private int giorno;
	private int mese;
	private int anno;
	private LocalDate dataOggi;
	private int postiTotali;
	private int postiPrenotati;
	
	public Evento(String titolo, int giorno, int mese, int anno, LocalDate dataOggi, int postiTotali, int postiPrenotati) throws Exception {
		
		setTitolo(titolo);
		setGiorno(giorno);
		setMese(mese);
		setAnno(anno);
		setDataOggi(dataOggi);
		
		this.postiTotali = postiTotali;
		this.postiPrenotati = postiPrenotati;
	}
	

	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public int getMese() {
		return mese;
	}

	public void setMese(int mese) {
		this.mese = mese;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public LocalDate getDataOggi() {
		return dataOggi;
	}
	
	public void setDataOggi(LocalDate dataOggi) {
		this.dataOggi = dataOggi;
	}
	
	public int getPostiTotali() {
		return postiTotali;
	}
	
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public LocalDate data() {
		LocalDate inputDate = LocalDate.of(anno,mese,giorno);
		return inputDate;
	}
	
	public String dataStr() {
		return data().toString();
	}
	
	public boolean scadenza() throws Exception {
       if(dataOggi.isAfter(data())){
			
			 throw new Exception("Impossibile prenotare! Data di prenotazione scaduta");
       }else {
    	   return true;       }
	}
	
	public int prenota() throws Exception {
		
		if(postiPrenotati >= postiTotali) {
			throw new Exception("Posti esauriti!");
		}else {
			return postiPrenotati = postiPrenotati + 1;
		}
		
	}
	
	public int disdici() throws Exception {
		if(postiPrenotati < 0){
			
			throw new Exception("Non si può disdire più posti di quelli prenotati!");
			
		}else {
			return postiPrenotati = postiPrenotati - 1;
		}
		
	}
	
	@Override
    public String toString() {
		
		return  "\nL'evento: " + titolo
		        + "\nIl giorno: " + data();
	}


	
	
	
	

}
