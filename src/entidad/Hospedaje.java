/*  Tipo :
 * 0 = Con reserva
 * 1 = Sin reserva
 *  Estado
 * 0 = Anulada
 * 1 = Atendida
 */
package entidad;

public class Hospedaje {
	private int codHospedaje,codReserva,codCliente,numHabitacion,codRecepcionista,tipoHospedaje,estadoHospedaje;
	private String fechaRegistroHospedaje;
	public Hospedaje(){}
	public Hospedaje(int codHospedaje, int codReserva, int codCliente,
			int codHabitacion, int codRecepcionista, int tipoHospedaje,
			String fechaRegistroHospedaje, int estadoHospedaje) {
		this.codHospedaje = codHospedaje;
		this.codReserva = codReserva;
		this.codCliente = codCliente;
		this.numHabitacion = codHabitacion;
		this.codRecepcionista = codRecepcionista;
		this.tipoHospedaje = tipoHospedaje;
		this.fechaRegistroHospedaje = fechaRegistroHospedaje;
		this.estadoHospedaje = estadoHospedaje;
	}
	public int getCodHospedaje() {
		return codHospedaje;
	}
	public void setCodHospedaje(int codHospedaje) {
		this.codHospedaje = codHospedaje;
	}
	public int getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodHabitacion() {
		return numHabitacion;
	}
	public void setCodHabitacion(int codHabitacion) {
		this.numHabitacion = codHabitacion;
	}
	public int getCodRecepcionista() {
		return codRecepcionista;
	}
	public void setCodRecepcionista(int codRecepcionista) {
		this.codRecepcionista = codRecepcionista;
	}
	public int getTipoHospedaje() {
		return tipoHospedaje;
	}
	public void setTipoHospedaje(int tipoHospedaje) {
		this.tipoHospedaje = tipoHospedaje;
	}
	public int getEstadoHospedaje() {
		return estadoHospedaje;
	}
	public void setEstadoHospedaje(int estadoHospedaje) {
		this.estadoHospedaje = estadoHospedaje;
	}
	public String getFechaRegistroHospedaje() {
		return fechaRegistroHospedaje;
	}
	public void setFechaRegistroHospedaje(String fechaRegistroHospedaje) {
		this.fechaRegistroHospedaje = fechaRegistroHospedaje;
	}
	
}
