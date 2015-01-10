package controlador;
import entidad.Hospedaje;
import java.util.ArrayList;
import java.io.*;

public class ArregloHospedaje {
	private ArrayList<Hospedaje> hos; 
	
	public ArregloHospedaje(){
		hos = new ArrayList<Hospedaje>();
		cargarArchivo();
	}
	
	public int tamaño(){ return hos.size();}
	
	public int generaCodigo(){
		if(tamaño() == 0)
			return 1001;
		else
			return hos.get(tamaño()-1).getCodHospedaje()+1;
	}
	
	public void creacion(Hospedaje h){ hos.add(h);}
	
	public Hospedaje obtener(int pos){ return hos.get(pos);}
	
	public void modificar(int pos){
		Hospedaje h = obtener(pos);
		h.setEstadoHospedaje(0);
	}
	
	public void cargarArchivo(){
		try {
			FileReader fr = new FileReader("hospedaje.txt");
				BufferedReader br = new BufferedReader(fr);
				String linea = null;
				while ((linea = br.readLine()) !=null ) {
					String[] sep = linea.split(",");
					 Hospedaje h = new Hospedaje();
					 h.setCodHospedaje(Integer.parseInt(sep[0].trim()));
					 h.setCodReserva(Integer.parseInt(sep[1].trim()));
					 h.setCodCliente(Integer.parseInt(sep[2].trim()));
					 h.setCodHabitacion(Integer.parseInt(sep[3].trim()));
					 h.setCodRecepcionista(Integer.parseInt(sep[4].trim()));
					 h.setTipoHospedaje(Integer.parseInt(sep[5].trim()));
					 h.setFechaRegistroHospedaje(sep[6].trim());
					 h.setEstadoHospedaje(Integer.parseInt(sep[7].trim()));
					 hos.add(h);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void grabarArchivo(){
		try {
			FileWriter fr = new FileWriter("hospedaje.txt");
			PrintWriter pw = new PrintWriter(fr);
			for (Hospedaje h : hos) {
				pw.println(
						h.getCodHospedaje()+","+
						h.getCodReserva()+","+
						h.getCodCliente()+","+
						h.getCodHabitacion()+","+
						h.getCodRecepcionista()+","+
						h.getTipoHospedaje()+","+
						h.getFechaRegistroHospedaje()+","+
						h.getEstadoHospedaje()
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
