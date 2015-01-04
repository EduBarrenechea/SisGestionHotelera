/* 
 * 0 = Iniciada
 * 1 = Anulada
 * 2 = Atendida 
 */
package entidad;

public class Reserva {
	private int codReserva,codCliente,codCajero,codRecepcionista,numeroHabitacion,estadoReserva;
	private String fechaRegistroReserva, fechaIngresoReserva,fechaSalidaReserva;
	public Reserva(int codReserva, int codCliente, int codCajero,
			int codRecepcionista, int numeroHabitacion,
			String fechaRegistroReserva, String fechaIngresoReserva,
			String fechaSalidaReserva, int estadoReserva) {
		this.codReserva = codReserva;
		this.codCliente = codCliente;
		this.codCajero = codCajero;
		this.codRecepcionista = codRecepcionista;
		this.numeroHabitacion = numeroHabitacion;
		this.fechaRegistroReserva = fechaRegistroReserva;
		this.fechaIngresoReserva = fechaIngresoReserva;
		this.fechaSalidaReserva = fechaSalidaReserva;
		this.estadoReserva = estadoReserva;
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
	public int getCodCajero() {
		return codCajero;
	}
	public void setCodCajero(int codCajero) {
		this.codCajero = codCajero;
	}
	public int getCodRecepcionista() {
		return codRecepcionista;
	}
	public void setCodRecepcionista(int codRecepcionista) {
		this.codRecepcionista = codRecepcionista;
	}
	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	public int getEstadoReserva() {
		return estadoReserva;
	}
	public void setEstadoReserva(int estadoReserva) {
		this.estadoReserva = estadoReserva;
	}
	public String getFechaRegistroReserva() {
		return fechaRegistroReserva;
	}
	public void setFechaRegistroReserva(String fechaRegistroReserva) {
		this.fechaRegistroReserva = fechaRegistroReserva;
	}
	public String getFechaIngresoReserva() {
		return fechaIngresoReserva;
	}
	public void setFechaIngresoReserva(String fechaIngresoReserva) {
		this.fechaIngresoReserva = fechaIngresoReserva;
	}
	public String getFechaSalidaReserva() {
		return fechaSalidaReserva;
	}
	public void setFechaSalidaReserva(String fechaSalidaReserva) {
		this.fechaSalidaReserva = fechaSalidaReserva;
	}
	
}
