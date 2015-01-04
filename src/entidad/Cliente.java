/*Estado Cliente
 * 0 = No activo
 * 1 = Activo
 */
package entidad;

public class Cliente {
	private int codCliente, estadoCliente;
	private String apellidoCliente,nombreCliente,telefonoCliente;
	public Cliente(int codCliente, String apellidoCliente,
			String nombreCliente, String telefonoCliente, int estadoCliente) {
		this.codCliente = codCliente;
		this.apellidoCliente = apellidoCliente;
		this.nombreCliente = nombreCliente;
		this.telefonoCliente = telefonoCliente;
		this.estadoCliente = estadoCliente;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(int estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	
}
