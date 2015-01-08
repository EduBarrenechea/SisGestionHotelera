package controlador;
import entidad.Recepcionista;
import java.util.ArrayList;
import java.io.*;

public class ArregloRecepcionista {
	private ArrayList<Recepcionista> rec;
	
	public ArregloRecepcionista(){
		rec = new ArrayList<Recepcionista>();
		cargarArchivo();
	}
	
	public int tamaño(){
		return rec.size();
	}
	
	public int generaCodigo(){
		if(tamaño()==0)
			return 1001;
		else
			return rec.get(tamaño()-1).getCodRecepcionista()+1;
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
		for (int i = 0; i < tamaño(); i++) {
			if(rec.get(i).getCodRecepcionista() == r.getCodRecepcionista())
				rec.set(i, r);
		}
	}
	
	public void cargarArchivo(){
		try {
			FileReader fr = new FileReader("recepcionista.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] sep = linea.split(",");
				Recepcionista r = new Recepcionista();
				r.setCodRecepcionista(Integer.parseInt(sep[0].trim()));
				r.setApellidoRecepcionista(sep[1].trim());
				r.setNombreRecepcionista(sep[2].trim());
				r.setTelefonoRecepcionista(sep[3].trim());
				r.setEstadoRecepcionista(Integer.parseInt(sep[4].trim()));
				rec.add(r);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void grabarArchivo(){
		try {
			FileWriter fr = new FileWriter("recepcionista.txt");
			PrintWriter pw = new PrintWriter(fr);
			for (Recepcionista r : rec) {
				pw.println(
							r.getCodRecepcionista()+","+
							r.getApellidoRecepcionista()+","+
							r.getNombreRecepcionista()+","+
							r.getTelefonoRecepcionista()+","+
							r.getEstadoRecepcionista());
				}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
