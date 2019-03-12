package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;

public class NumeroModel {
	
	private final int NMAX = 100;
	private final int TMAX = 8;

	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public NumeroModel() {
		inGioco = false;
	} 
	
	
	//avvia nuova partita
	public void newGame() {
		// Gestisce l'inizio di una nuova partita

		// Logica del gioco
		inGioco=true;
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
	}
	
	public int tentativo(int t) {
		// controllo se la partita e' in corso
		if(!inGioco) {
			throw new IllegalStateException("La partita e' terminata");
		}
		
		//controllo se l input e' nel range corretto
		if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Devi inserire un numero tra %d e %d", 1, NMAX));
		}
		
		//gestisco tentativo
		this.tentativiFatti++;
		if(this.tentativiFatti==this.TMAX) {
			this.inGioco = false;
		}
			
		
		if(t == this.segreto) {
			this.inGioco=false;
			return 0;
		}
		
		if(t > this.segreto) {
			return 1;
		}
		
		return -1;
	}
	
	public boolean tentativoValido(int t) {
		if(t<1 || t>NMAX)
			return false;
		else
			return true;
	}


	public boolean isInGioco() {
		return inGioco;
	}


	public int getSegreto() {
		return segreto;
	}


	public int getTentativiFatti() {
		return tentativiFatti;
	}


	public int getTMAX() {
		return TMAX;
	}
	
	
	

}
