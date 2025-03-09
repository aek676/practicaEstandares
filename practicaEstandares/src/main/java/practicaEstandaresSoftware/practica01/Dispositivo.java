package practicaEstandaresSoftware.practica01;

import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;

import javax.management.RuntimeErrorException;
/**
 * 	Clase Dispositivo
 * 	Representa un dispositivo con un modelo y un conjunto de características
 * 	Además, se almacenan las palabras que se han enviado a través del dispositivo
 *  @version 1.0, 06/07/2021
 */
public class Dispositivo implements Iterable<String> {
	private String modelo;
	private BitSet caracteristicas;
	protected LinkedList<String> registroPalabras; 
		
	/**
	 * 	Si el parámetro modelo es vacío, el modelo del dispositivo será "noModel"; en caso contrario, asignamos como atributo modelo el valor del parámetro eliminando los posibles espacios en blanco que tenga delante y detrás (haz uso del método trim())
	 * 	Asignamos a las diez características (haz uso de la constante Parametros.numCaracteristicas) el valor false
	 * Inicializamos la estructura registroPalabras
	 * @param modelo
	 */
	public Dispositivo(String modelo) {
	    this.modelo = (modelo == null || modelo.trim().isEmpty()) ? "noModel" : modelo.trim();
		this.caracteristicas = new BitSet(Parametros.numCaracteristicas);
		this.registroPalabras = new LinkedList<>();
	}
	
	/**
	 * Si el número de características es distinto de la constante Parametros.numCaracteristicas se ha de lanzar una excepción (throw new RuntimeException(...))
	 * El resto exactamente igual que el constructor anterior salvo la asignación de valores a las características del dispositivo
	 * Recuerda que si el valor es '0', la característica se asigna como false; en caso contrario, true (sea el carácter que sea)
	 * @param modelo
	 * @param caracteristicas
	 */
	public Dispositivo(String modelo, String caracteristicas) {
		if(caracteristicas.length() != Parametros.numCaracteristicas) throw new RuntimeErrorException(null, "El número de características debe ser, exactamente, igual a 10");
	    
		this.modelo = (modelo == null || modelo.trim().isEmpty()) ? "noModel" : modelo.trim();
		
		this.caracteristicas = new BitSet(Parametros.numCaracteristicas);
		
		for(int i=0; i< Parametros.numCaracteristicas; i++) {
			this.caracteristicas.set(i, caracteristicas.charAt(i) != '0');
			
		}
		this.registroPalabras = new LinkedList<>();
	}
	
	public Dispositivo(Dispositivo otro) {
		this.modelo = otro.modelo;
	    this.caracteristicas = (BitSet) otro.caracteristicas.clone();
	    this.registroPalabras = new LinkedList<>(otro.registroPalabras);
	}
	
	public BitSet getInterseccion(Dispositivo otro) {
		BitSet result = (BitSet) this.caracteristicas.clone();
		result.and(otro.caracteristicas);
		return result;
	}
	
	public int getNumPalabras() {
		return this.registroPalabras.size();
	} 
	
	public void vaciarDispositivo() {
		this.registroPalabras.clear();
	}
	
	public void enviarMensaje(String mensaje) {
		String [] mensajeDividido = mensaje.split("[ ,.]+");
		for(String palabra : mensajeDividido) {
		if(!this.registroPalabras.contains(palabra.toLowerCase()))
			this.registroPalabras.add(palabra.toLowerCase());
		}
	}
	
	@Override
	public String toString() {
		return this.modelo +" " +this.caracteristicas.toString();
	}
	
	@Override
	public boolean equals(Object otro) {
		return this.modelo.equals(((Dispositivo) otro).modelo);
	}
	@Override
	public int hashCode() {
		return this.modelo.hashCode();
	}

	@Override
	public Iterator<String> iterator() {
		return this.registroPalabras.iterator();
	}
}