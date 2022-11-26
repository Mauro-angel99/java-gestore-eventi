package org.generation.italy.eventi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDate;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		List<Evento> Eventi = new ArrayList<>();
		ProgrammEventi pe = new ProgrammEventi("Raduni Auto", Eventi);
		
		while(true) {
		
		  System.out.println("Vuoi creare un nuovo evento? (y/n)");
		  String r = sc.next();
		  if (!r.equals("y")) {
			  break;
		  }
		  System.out.println("Nome evento: ");
		  String titolo = sc.next();
		
		  System.out.println("Giorno:");
	      int giorno = sc.nextInt();
	     
	      System.out.println("Mese:");
	      int mese = sc.nextInt();
	     
	      System.out.println("Anno:");
	      int anno = sc.nextInt();
	    
	      System.out.println("Numero massimo di persone che possono parteciparte:");
	      int posti = sc.nextInt();
	      
	      System.out.println("Numero di posti già occupati:");
	      int postiPrenotati = sc.nextInt();
	      
		
		  try {
		  Evento e = new Evento(titolo, giorno, mese, anno, LocalDate.now(), posti, postiPrenotati);
		  
		  pe.addEvento(e);
		
		  
		  
		  e.scadenza();
		   while(true) {
			  System.out.println("Vuoi prenotare? (y/n)");
		 	  String p = sc.next();
		 	  if (!p.equals("y")) {
				  break;
		 	  }else {
				  System.out.println("Quanti posti vuoi prenotare?");
	 			  int np = sc.nextInt();
		 		  for(int x=0;x<np;x++){
		 			 e.prenota();
		 		  }
		 		 System.out.println("I poosti prenotati somo: " + e.getPostiPrenotati());
		 		 int postiLiberi = e.getPostiTotali() - e.getPostiPrenotati();
		 		 System.out.println("I poosti liberi somo: " + postiLiberi);
		 		  break;
		 	  }
		   }
		 	 while(true) {
				   System.out.println("Vuoi disdire? (y/n)");
			 	  String d = sc.next();
			 	  if (!d.equals("y")) {
					  break;
			 	  }else {
					  System.out.println("Quanti posti vuoi disdire?");
		 			  int nd = sc.nextInt();
			 		  for(int x=0;x<nd;x++){
			 			 e.disdici();
			 		  }
			 		 System.out.println("I poosti prenotati somo: " + e.getPostiPrenotati());
			 		 int postiLiberi = e.getPostiTotali() - e.getPostiPrenotati();
			 		 System.out.println("I poosti liberi somo: " + postiLiberi);
			 		  break;
			 	  } 
		   }
		 	 
		  
		  }catch(Exception e) {
			  System.err.println(e.getMessage());
		  }

		
		}
		
		if(pe.numeroEventi() > 0) {
		pe.listEventi();
		System.out.println("------------------");
		System.out.println("Numero eventi: " + pe.numeroEventi());
		System.out.println("------------------");
		System.out.println("Vuoi eliminare tutti gli eventi? (y/n)");
		String e = sc.next();
		if (!e.equals("y")) {
			System.out.println("------------------");
			pe.ordineData();
	 	  }else {
	 		 pe.svuotaLista();
	 		 System.out.println("------------------");
	 		 System.out.println("Numero eventi: " + pe.numeroEventi());
	 	  }
		
		}else {
			System.out.println("Non ci sono eventi in programma!");
		}
	
	}
		
}
