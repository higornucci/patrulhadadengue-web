package br.com.dengoso.modelo.coordenadas;

import javax.persistence.Embeddable;

@Embeddable
class Longitude {

	private double longitude;
	
	Longitude() {
	}

	Longitude(double valor) {
		this.longitude = valor;
	}
	
	public double getValor() {
		return longitude;
	}
}
