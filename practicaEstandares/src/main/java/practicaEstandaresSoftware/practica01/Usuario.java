package practicaEstandaresSoftware.practica01;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class Usuario implements Iterable<Dispositivo> {
	private static int numUsuarios = 0;
	private String nombre;
	private int usuarioId;
	private ArrayList<Dispositivo> dispositivos;
	
	public static void inicializarNumUsuarios() {
		numUsuarios = 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	/**
	 * 	Si el parámetro nombre es nulo o está vacío se lanza excepción
	 * Al atributo this.usuarioId se le asigna el número de usuarios creados hasta el momento (identificador autoincremental)
	 * 
	 * @param nombre
	 */
	public Usuario(String nombre) {
		if(nombre == null || nombre.isEmpty()) throw new RuntimeException("El atributo nombre no puede ser ni nulo ni vacío"); 
		this.nombre = nombre.trim();
		this.usuarioId = ++numUsuarios;
		this.dispositivos = new ArrayList<>();
	}
	
	public void vaciarDispositivos() {
		//1 for()
		//...
		for(Dispositivo dispostivo: dispositivos) {
			dispostivo.registroPalabras.clear();
		}
		this.dispositivos.clear();
	}
	
	public void addDispositivos(Dispositivo... dispositivos) {
		for (Dispositivo dispositivo : dispositivos) {
			if(!this.dispositivos.contains(dispositivo)) this.dispositivos.add(new Dispositivo(dispositivo));
		}
	}
	
	public int getNumDispositivos() { 
		return this.dispositivos.size();
	}

	public boolean enviarMensaje(String nombreDispositivo, String mensaje) {
		int pos = this.dispositivos.indexOf(new Dispositivo(nombreDispositivo));
		if (pos == -1) return false;
		dispositivos.get(pos).enviarMensaje(mensaje);
		return true;
	}
	
	public int getNumPalabras(String nombreDispositivo) {
		int pos = this.dispositivos.indexOf(new Dispositivo(nombreDispositivo));
		if (pos == -1) return 0;
		return dispositivos.get(pos).getNumPalabras();
	}
	
	public ArrayList<String> getPalabras() {
		ArrayList<String> result = new ArrayList<>();
		for(Dispositivo dispositivo : dispositivos) {
			for(String palabra : dispositivo.registroPalabras) {
				if(!result.contains(palabra)) result.add(palabra);
			}
		}
		result.sort(null);
		return result;
	}
	
	public BitSet getInterseccion(Usuario otro) {
		BitSet result = new BitSet(Parametros.numCaracteristicas);
		for(Dispositivo dispositivo : this.dispositivos) {
			for(Dispositivo dipositivoOtro : otro.dispositivos) {
				result.or(dispositivo.getInterseccion(dipositivoOtro));
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.usuarioId+".- "+this.nombre+" -> "+this.dispositivos.toString();
	}
	
	@Override
	public boolean equals(Object otro) {
		return this.nombre.equals(((Usuario) otro).nombre );
	}

	@Override
	public Iterator<Dispositivo> iterator() {
		return this.dispositivos.iterator();
	}
}