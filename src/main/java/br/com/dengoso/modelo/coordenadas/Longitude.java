package br.com.dengoso.modelo.coordenadas;

import javax.persistence.Embeddable;

@Embeddable
public class Longitude {

	private double longitude;

	Longitude(double valor) {
		this.longitude = valor;
	}
	
	public double getValor() {
		return longitude;
	}
}
