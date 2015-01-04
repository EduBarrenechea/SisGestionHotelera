package controlador;
import entidad.Habitacion;
import java.util.ArrayList;
public class ArregloHabitacion {
	private ArrayList<Habitacion> hab;
	
	public ArregloHabitacion(){
		hab = new ArrayList<Habitacion>();
	}
	
	public int tama�o(){
		return hab.size();
	}
	
	public int generaCodigo(){
		if (tama�o()==0)
			return 101;
		else
			return hab.get(tama�o()-1).getNumHabitacion()+1;
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
	
	public void modificar(Habitacion h){
		for(int i = 0; i < tama�o() ; i ++)
			if(hab.get(i).getNumHabitacion() == h.getNumHabitacion())
				hab.set(i, h);
	}
}
