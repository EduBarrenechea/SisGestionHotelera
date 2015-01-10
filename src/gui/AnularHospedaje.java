package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.*;
import controlador.*;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnularHospedaje extends JDialog implements ItemListener, ActionListener {
	
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	ArregloHospedaje aHos = new ArregloHospedaje();
	private JLabel lblCdigo;
	private JComboBox cboCodigo;
	private JButton btnAnular;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnularHospedaje dialog = new AnularHospedaje();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AnularHospedaje() {
		setTitle("Anular Hospedaje");
		setBounds(100, 100, 408, 378);
		getContentPane().setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo :");
		lblCdigo.setBounds(10, 11, 100, 14);
		getContentPane().add(lblCdigo);
		
		cboCodigo = new JComboBox();
		
		cboCodigo.setBounds(120, 11, 140, 20);
		llenarCombo();
		cboCodigo.addItemListener(this);
		getContentPane().add(cboCodigo);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setBounds(292, 11, 83, 20);
		getContentPane().add(btnAnular);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 365, 267);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);	
		listarHospedaje(0);
	}
	
	void listarHospedaje(int pos){
		Hospedaje h = aHos.obtener(pos);
		txtS.setText("");
		String codRe="--";
		if(h.getCodReserva() != -1)
			codRe=String.valueOf(h.getCodReserva());		
		imprimir("Codigo:\t "+ h.getCodHospedaje());
		imprimir("Reserva:\t"+codRe);
		imprimir("Cliente:\t"+obtenerCliente(h.getCodCliente()));
		imprimir("Habitacion:\t"+h.getCodHabitacion());
		imprimir("Recepcionista:\t"+obtenerRecepcionista(h.getCodRecepcionista()));
		imprimir("Tipo:\t"+h.getTipo());
		imprimir("FechaRegistro:\t"+h.getFechaRegistroHospedaje());
		imprimir("Estado:\t"+h.getEstado());
		
	}
	
	void imprimir(String cad){
		txtS.append(cad + "\n");
	}
	

	String obtenerCliente(int cod){
		return (aCli.buscar(cod)).getApellidoCliente()+" "+(aCli.buscar(cod)).getNombreCliente();
	}
	
	String obtenerRecepcionista(int cod){
		return (aRec.buscar(cod)).getApellidoRecepcionista()+" "+(aRec.buscar(cod)).getNombreRecepcionista();
	}
	
	void llenarCombo(){
		for (int i = 0; i < aHos.tamaño(); i++) {
			Hospedaje h = aHos.obtener(i);
			cboCodigo.addItem(h.getCodHospedaje());			
		}
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboCodigo) {
			do_cboCodigo_itemStateChanged(arg0);
		}
	}
	protected void do_cboCodigo_itemStateChanged(ItemEvent arg0) {
		seleccionar();
		
	}
	
	void seleccionar(){
		listarHospedaje(cboCodigo.getSelectedIndex());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAnular) {
			do_btnAnular_actionPerformed(arg0);
		}
	}
	protected void do_btnAnular_actionPerformed(ActionEvent arg0) {
		aHos.modificar(cboCodigo.getSelectedIndex());
		aHos.grabarArchivo();
		seleccionar();
	}
}
