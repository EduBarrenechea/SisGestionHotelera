package controlador;
import entidad.Cliente;

import java.io.*;
import java.util.ArrayList;
public class ArregloCliente {
	private ArrayList<Cliente> cli;
	
	public ArregloCliente(){
		cli = new ArrayList<Cliente>();
		cargarArchivo();
	}
	
	public int tamaño(){
		return cli.size();
	}
	
	public int generaCodigo(){
		if(tamaño()==0)
			return 1001;
		else
			return cli.get(tamaño()-1).getCodCliente()+1;
	}
	
	public void creacion(Cliente c){
		cli.add(c);
	}
	
	public void eliminar(Cliente c){
		cli.remove(c);		
	}
	
	public Cliente obtener(int pos){
		return cli.get(pos);
	}
	
	public Cliente buscar(int codCliente){
		for (Cliente c : cli) {
			if(codCliente == c.getCodCliente())
				return c;
		}
		return null;
	}
	
	public void modificar(Cliente c){
		for (int i = 0; i < tamaño(); i++) {
			if(cli.get(i).getCodCliente() == c.getCodCliente())
				cli.set(i, c);
		}
	}
	
	public void cargarArchivo(){
		try {
			FileReader fr = new FileReader("cliente.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] sep = linea.split(",");
				Cliente c = new Cliente();
				c.setCodCliente(Integer.parseInt(sep[0].trim()));
				c.setApellidoCliente(sep[1].trim());
				c.setNombreCliente(sep[2].trim());
				c.setTelefonoCliente(sep[3].trim());
				c.setEstadoCliente(Integer.parseInt(sep[4].trim()));
				cli.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void grabarArchivo(){
		try {
			FileWriter fr = new FileWriter("cliente.txt");
			PrintWriter pw = new PrintWriter(fr);
			for (Cliente c : cli) {
				pw.println(
						c.getCodCliente()+","+
						c.getApellidoCliente()+","+
						c.getNombreCliente()+","+
						c.getTelefonoCliente()+","+
						c.getEstadoCliente());
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
