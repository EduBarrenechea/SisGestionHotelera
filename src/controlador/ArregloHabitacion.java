package controlador;
import entidad.Habitacion;
import java.util.ArrayList;
import java.io.*;
public class ArregloHabitacion {
	private ArrayList<Habitacion> hab;
	
	public ArregloHabitacion(){
		hab = new ArrayList<Habitacion>();
		cargarArchivo();
	}
	
	public int tamaño(){
		return hab.size();
	}
	
	public int generaCodigo(){
		if (tamaño()==0)
			return 101;
		else
			return hab.get(tamaño()-1).getNumHabitacion()+1;
	}
	
	public void creacion(Habitacion h){
		hab.add(h);
	}
	
	public void eliminar(Habitacion h){
		hab.remove(h);
	}
	
	public Habitacion obtener(int pos){
		return hab.get(pos);
	}
	
	public Habitacion buscar(int numHabitacion){
		for (Habitacion h : hab) {
			if(numHabitacion == h.getNumHabitacion())
				return h;
		}
		return null;
	}
	
	public void cambioEstado(int numHabitacion, int est){
		Habitacion h = buscar(numHabitacion);
		h.setEstadoHabitacion(est);
		for (int i = 0; i < tamaño() ; i++) {
			if(hab.get(i).getNumHabitacion() == h.getNumHabitacion())
				hab.set(i,h);
		}		
	}
	
	public ArrayList<Habitacion> habitacionesXestado(int estado){
		ArrayList<Habitacion> aH = new ArrayList<Habitacion>();
		for (Habitacion h : hab) {
			if(h.getEstadoHabitacion() == estado){
				aH.add(h);
			}
		}
		return aH;
	}
	
	public void modificar(Habitacion h){
		for(int i = 0; i < tamaño() ; i ++)
			if(hab.get(i).getNumHabitacion() == h.getNumHabitacion())
				hab.set(i, h);
	}
	
	public void cargarArchivo(){
		try {
			FileReader fr = new FileReader("habitacion.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while((linea = br.readLine()) != null){
				String[] sep = linea.split(",");
				Habitacion h = new Habitacion();
				h.setNumHabitacion(Integer.parseInt(sep[0].trim()));
				h.setDesHabitacion(sep[1].trim());
				h.setTipoHabitacion(Integer.parseInt(sep[2].trim()));
				h.setUbicacionHabitacion(Integer.parseInt(sep[3].trim()));
				h.setCostoHabitacion(Double.parseDouble(sep[4].trim()));
				h.setEstadoHabitacion(Integer.parseInt(sep[5].trim()));
				hab.add(h);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void grabarArchivo(){
		try {
			FileWriter fr = new FileWriter("habitacion.txt");
			PrintWriter pw = new PrintWriter(fr);
			for (Habitacion h : hab) {
				pw.println(
						h.getNumHabitacion()+","+
						h.getDesHabitacion()+","+
						h.getTipoHabitacion()+","+
						h.getUbicacionHabitacion()+","+
						h.getCostoHabitacion()+","+
						h.getEstadoHabitacion()
						);
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
