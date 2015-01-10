package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.*;
import controlador.*;

public class ListadoReserva extends JDialog {
	
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private final JTextArea txtS = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoReserva dialog = new ListadoReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoReserva() {
		setTitle("Listado de Reservaciones");
		setBounds(100, 100, 765, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.setBounds(648, 349, 91, 23);
			contentPanel.add(btnSalir);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 729, 312);
		contentPanel.add(scrollPane);
		txtS.setEditable(false);
		
		scrollPane.setViewportView(txtS);
		listarReservaciones();
	}
	
	void listarReservaciones(){
		imprimir("Codigo\tCliente\tRecepcionista\tHabitacion\tFechaRegistro\tFechaIngreso\tFechaSalida\tEstado");
		for (int i = 0; i < aRes.tamaño() ; i++) {
			Reserva r = aRes.obtener(i);
			imprimir(
					rellenar(String.valueOf(r.getCodReserva()))+"\t"+
					rellenar(obtenerCliente(r.getCodCliente()))+"\t"+
					rellenar(obtenerRecepcionista(r.getCodRecepcionista()))+"\t"+
					rellenar(String.valueOf(r.getNumeroHabitacion()))+"\t"+
					rellenar(r.getFechaRegistroReserva())+"\t"+
					rellenar(r.getFechaIngresoReserva())+"\t"+
					rellenar(r.getFechaSalidaReserva())+"\t"+
					r.getEstado()
					);
		}
	}
	void imprimir(String cad){
		txtS.append(cad + "\n");
	}
	
	String rellenar(String cad){
		int longitud=cad.length();
		for(int i=longitud; i<10; i++)
			cad+=' ';
		return cad;
	}
	
	String obtenerCliente(int cod){
		return (aCli.buscar(cod)).getApellidoCliente();
	}
	
	String obtenerRecepcionista(int cod){
		return (aRec.buscar(cod)).getApellidoRecepcionista();
	}
	
	
}
