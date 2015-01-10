package controlador;
import java.util.ArrayList;
import java.io.*;

import entidad.Cliente;
import entidad.Hospedaje;
import entidad.Recepcionista;
import entidad.Reserva;

public class ArregloReserva {
	private ArrayList<Reserva> res;
	
	public ArregloReserva(){
		res = new ArrayList<Reserva>();
		cargarArchivo();
	}
	
	public int tamaño(){
		return res.size();				
	}
	
	public int generaCodigo(){
		if(tamaño()==0)
			return 1001;
		else 
			return res.get(tamaño()-1).getCodReserva()+1; 
	}
	
	public void creacion(Reserva r){
		res.add(r);
	}
	
	public Reserva obtener(int pos){
		return res.get(pos);
	}
	
	/*public void modificar(Reserva r){
		for (int i = 0; i < tamaño(); i++) {
			if(res.get(i).getCodReserva() == r.getCodReserva())
				res.set(i, r);				
		}
	}*/
	
	public void modificar(int pos,int est){
		Reserva r = obtener(pos);
		r.setEstadoReserva(est);
	}
	
	public Reserva buscar(int codReserva){
		for (Reserva r : res) {
			if(codReserva == r.getCodReserva())
				return r;
		}
		return null;
	}
	
	public ArrayList<Reserva> reservaxCLiente(int codCli){
		ArrayList<Reserva> aRes =  new ArrayList<Reserva>();
		for (Reserva r : res) {
			if(r.getCodCliente() == codCli)
				aRes.add(r);
		}
		return aRes;
	}
	
    public void cargarArchivo(){
    	try {
			FileReader fr = new FileReader("reservacion.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null ) {
				String[] sep = linea.split(",");
				Reserva r = new Reserva();
				r.setCodReserva(Integer.parseInt(sep[0].trim()));
				r.setCodCliente(Integer.parseInt(sep[1].trim()));
				r.setCodRecepcionista(Integer.parseInt(sep[2].trim()));
				r.setNumeroHabitacion(Integer.parseInt(sep[3].trim()));
				r.setFechaRegistroReserva(sep[4].trim());
				r.setFechaIngresoReserva(sep[5].trim());
				r.setFechaSalidaReserva(sep[6].trim());
				r.setEstadoReserva(Integer.parseInt(sep[7].trim()));
				res.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void grabarArchivo(){
    	try {
			FileWriter fr = new FileWriter("reservacion.txt");
			PrintWriter pw = new PrintWriter(fr);
			for (Reserva r : res) {
				pw.println(
						r.getCodReserva()+","+
						r.getCodCliente()+","+
						r.getCodRecepcionista()+","+
						r.getNumeroHabitacion()+","+
						r.getFechaRegistroReserva()+","+
						r.getFechaIngresoReserva()+","+
						r.getFechaSalidaReserva()+","+
						r.getEstadoReserva()
						);
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
