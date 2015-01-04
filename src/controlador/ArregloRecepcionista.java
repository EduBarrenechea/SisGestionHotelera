package controlador;
import entidad.Recepcionista;
import java.util.ArrayList;

public class ArregloRecepcionista {
	private ArrayList<Recepcionista> rec;
	
	public ArregloRecepcionista(){
		rec = new ArrayList<Recepcionista>();
	}
	
	public int tama�o(){
		return rec.size();
	}
	
	public int generaCodigo(){
		if(tama�o()==0)
			return 101;
		else
			return rec.get(tama�o()-1).getCodRecepcionista()+1;
	}
	
	public void creacion(Recepcionista r){
		rec.add(r);
	} 
	
	public void eliminar(Recepcionista r){
		rec.remove(r);
	}
	
	public Recepcionista obtener(int pos){
		return rec.get(pos);
	}
	
	public Recepcionista buscar(int codRecepcionista){
		for (Recepcionista r : rec) {
			if(codRecepcionista == r.getCodRecepcionista())
				return r;
		}
		return null;
	}
	
	public void modificar(Recepcionista r){
		for (int i = 0; i < tama�o(); i++) {
			if(rec.get(i).getCodRecepcionista() == r.getCodRecepcionista())
				rec.set(i, r);
		}
	}
	
}
