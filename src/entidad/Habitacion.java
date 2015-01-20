package entidad;

public class Habitacion {
	private int numHabitacion,tipoHabitacion,ubicacionHabitacion,estadoHabitacion;
	private String desHabitacion;
	private double costoHabitacion;
	public Habitacion(){}
	public Habitacion(int numHabitacion, String desHabitacion,
			int tipoHabitacion, int ubicacionHabitacion, double costoHabitacion,int estadoHabitacion) {
		this.numHabitacion = numHabitacion;
		this.desHabitacion = desHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.ubicacionHabitacion = ubicacionHabitacion;
		this.costoHabitacion = costoHabitacion;
		this.estadoHabitacion= estadoHabitacion;
	}
	public int getNumHabitacion() {
		return numHabitacion;
	}
	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
	public int getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(int tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	public String getTipo(){
		String tipo="";
		switch (this.tipoHabitacion) {
		case 1:tipo="Doble";break;
		case 2:tipo="Matrimonial";break;
		case 3:tipo="Simple";break;
		}
		return tipo;
	}
	public int getUbicacionHabitacion() {
		return ubicacionHabitacion;
	}
	public String getUbicacion(){
		String tipo="";
		switch (this.ubicacionHabitacion) {
		case 1:tipo="Edificio A";break;
		case 2:tipo="Edificio B";break;
		case 3:tipo="Edificio C";break;
		}
		return tipo;
	}
	public void setUbicacionHabitacion(int ubicacionHabitacion) {
		this.ubicacionHabitacion = ubicacionHabitacion;
	}
	public String getDesHabitacion() {
		return desHabitacion;
	}
	public void setDesHabitacion(String desHabitacion) {
		this.desHabitacion = desHabitacion;
	}
	public double getCostoHabitacion() {
		return costoHabitacion;
	}
	public void setCostoHabitacion(double costoHabitacion) {
		this.costoHabitacion = costoHabitacion;
	}
	public int getEstadoHabitacion(){
		return estadoHabitacion;
	}
	
	public String getEstado(){
		String tipo="";
		switch (this.ubicacionHabitacion) {
		case 1:tipo="Disponible";break;
		case 2:tipo="Reservada";break;
		case 3:tipo="Ocupada";break;
		}
		return tipo;
	}
	public void setEstadoHabitacion(int estadoHabitacion){
		this.estadoHabitacion = estadoHabitacion;
	}
	
	
}
