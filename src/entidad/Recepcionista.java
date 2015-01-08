/*Estado Recepcionista
 * 0 = No activo
 * 1 = Activo
 */
package entidad;

public class Recepcionista {
	private int codRecepcionista, estadoRecepcionista;
	private String apellidoRecepcionista,nombreRecepcionista,telefonoRecepcionista;
	
	public Recepcionista(){}
	
	public Recepcionista(int codRecepcionista, String apellidoRecepcionista,
			String nombreRecepcionista, String telefonoRecepcionista,
			int estadoRecepcionista) {
		this.codRecepcionista = codRecepcionista;
		this.apellidoRecepcionista = apellidoRecepcionista;
		this.nombreRecepcionista = nombreRecepcionista;
		this.telefonoRecepcionista = telefonoRecepcionista;
		this.estadoRecepcionista = estadoRecepcionista;
	}
	public int getCodRecepcionista() {
		return codRecepcionista;
	}
	public void setCodRecepcionista(int codRecepcionista) {
		this.codRecepcionista = codRecepcionista;
	}
	public int getEstadoRecepcionista() {
		return estadoRecepcionista;
	}
	public void setEstadoRecepcionista(int estadoRecepcionista) {
		this.estadoRecepcionista = estadoRecepcionista;
	}
	
	public String getEstado(){
		String est;
		if (this.estadoRecepcionista == 0)
			est = "No Activo";
		else 
			est = "Activo";
		return est;
	}
	public String getApellidoRecepcionista() {
		return apellidoRecepcionista;
	}
	public void setApellidoRecepcionista(String apellidoRecepcionista) {
		this.apellidoRecepcionista = apellidoRecepcionista;
	}
	public String getNombreRecepcionista() {
		return nombreRecepcionista;
	}
	public void setNombreRecepcionista(String nombreRecepcionista) {
		this.nombreRecepcionista = nombreRecepcionista;
	}
	public String getTelefonoRecepcionista() {
		return telefonoRecepcionista;
	}
	public void setTelefonoRecepcionista(String telefonoRecepcionista) {
		this.telefonoRecepcionista = telefonoRecepcionista;
	}
	
}
