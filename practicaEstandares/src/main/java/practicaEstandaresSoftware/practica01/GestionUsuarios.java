package practicaEstandaresSoftware.practica01;

import java.util.ArrayList;

public class GestionUsuarios {
	private ArrayList<Usuario> usuarios;
	 
	public GestionUsuarios() {
		this.usuarios = new ArrayList<>();
	}
	
	public void addDispositivos(Usuario usuario, Dispositivo... dispositivos) {
		int pos = this.usuarios.indexOf(usuario);
		if(pos == -1) {
			this.usuarios.add(usuario);
			pos = usuarios.size()-1;
		}		
		this.usuarios.get(pos).addDispositivos(dispositivos);
	}
	
	public String getGradosSimilitud(Usuario usuario) {
		String result = usuario.getNombre()+ " -> ";
		for(Usuario usuarioIterar : usuarios) {
			if(usuarioIterar.equals(usuario)) continue;
			result += usuarioIterar.getNombre()+" ";
			result += "<"+usuarioIterar.getInterseccion(usuario).cardinality()+"> ";
		}
		return result;
	}

	public boolean enviarMensaje(String nombreUsuario, String nombreDispositivo, String mensaje) {
		int pos = usuarios.indexOf(new Usuario(nombreUsuario));
		if(pos == -1) return false;
		return usuarios.get(pos).enviarMensaje(nombreDispositivo, mensaje);
	}
	
	public ArrayList<String> getPalabrasUsuario(String nombreUsuario) {
		ArrayList<String> result = new ArrayList<>();
		int pos = usuarios.indexOf(new Usuario(nombreUsuario));
		if(pos == -1) return null;
		for(Dispositivo dispositivo : usuarios.get(pos)) {
			for(String palabra : dispositivo.registroPalabras) {
				if(!result.contains(palabra)) result.add(palabra);
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.usuarios.toString();
	}
}