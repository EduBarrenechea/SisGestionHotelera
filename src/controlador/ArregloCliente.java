package controlador;
import entidad.Cliente;
import java.util.ArrayList;
public class ArregloCliente {
	private ArrayList<Cliente> cli;
	
	public ArregloCliente(){
		cli = new ArrayList<Cliente>();
	}
	
	public int tama�o(){
		return cli.size();
	}
	
	public int generaCodigo(){
		if(tama�o()==0)
			return 1001;
		else
			return cli.get(tama�o()-1).getCodCliente()+1;
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
		for (int i = 0; i < tama�o(); i++) {
			if(cli.get(i).getCodCliente() == c.getCodCliente())
				cli.set(i, c);
		}
	}
}
