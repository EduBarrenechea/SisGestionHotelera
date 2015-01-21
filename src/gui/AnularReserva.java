package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.*;
import controlador.*;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class AnularReserva extends JDialog implements ItemListener, ActionListener {
	
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	private JLabel lblCdigo;
	private JComboBox cboCodigo;
	private JButton btnAnular;
	private JScrollPane scrollPane_1;
	private JTable tReserva;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnularReserva dialog = new AnularReserva();
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
	public AnularReserva() {
		setTitle("Anular Reserva");
		setBounds(100, 100, 408, 339);
		getContentPane().setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo :");
		lblCdigo.setBounds(10, 11, 100, 14);
		getContentPane().add(lblCdigo);
		
		cboCodigo = new JComboBox();
		
		cboCodigo.setBounds(96, 11, 164, 20);
		llenarCombo();
		cboCodigo.addItemListener(this);
		getContentPane().add(cboCodigo);
		
		btnAnular = new JButton("Anular");
		btnAnular.addActionListener(this);
		btnAnular.setBounds(292, 11, 89, 23);
		btnAnular.setEnabled(false);
		getContentPane().add(btnAnular);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 82, 371, 210);
		getContentPane().add(scrollPane_1);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(292, 35, 89, 23);
		getContentPane().add(btnCerrar);
		
		tReserva = new JTable();
		
	}
	
	void llenarTabla(){
		
		if(cboCodigo.getSelectedIndex() > 0){			
			String informacion[][] = tablaData();
			mostrarTabla(informacion);
		}
		else{
			String informacion[][] = tablaVacia();
			mostrarTabla(informacion);
		}		
		
	}
	
	String[][] tablaData(){
		int cod = (int)(cboCodigo.getSelectedItem());
		Reserva r = aRes.buscar(cod);
		String informacion[][] = new String[8][2];
		informacion[0][0]= "Código";
		informacion[0][1]= r.getCodReserva()+"";
		informacion[1][0]= "Cliente";
		informacion[1][1]= aCli.traerNombreCli(r.getCodCliente());
		informacion[2][0]= "Recepcionista";
		informacion[2][1]= aRec.traeNombreRec(r.getCodRecepcionista());
		informacion[3][0]= "Numero H";
		informacion[3][1]= r.getNumeroHabitacion()+"";
		informacion[4][0]= "Fecha Registro";
		informacion[4][1]= r.getFechaRegistroReserva();
		informacion[5][0]= "Fecha Ingreso";
		informacion[5][1]= r.getFechaIngresoReserva();
		informacion[6][0]= "Fecha Salida";
		informacion[6][1]= r.getFechaSalidaReserva();
		informacion[7][0]= "Estado";
		informacion[7][1]= r.getEstado();
		return informacion;
	}
	
	String[][] tablaVacia(){
		String informacion[][] = new String[8][2];
		informacion[0][0]= "Código";
		informacion[0][1]= "--";
		informacion[1][0]= "Cliente";
		informacion[1][1]= "--";
		informacion[2][0]= "Recepcionista";
		informacion[2][1]= "--";
		informacion[3][0]= "Numero H";
		informacion[3][1]= "--";
		informacion[4][0]= "Fecha Registro";
		informacion[4][1]= "--";
		informacion[5][0]= "Fecha Ingreso";
		informacion[5][1]= "--";
		informacion[6][0]= "Fecha Salida";
		informacion[6][1]= "--";
		informacion[7][0]= "Estado";
		informacion[7][1]= "--";
		return informacion;
	}
	
	void mostrarTabla(String[][] informacion){
		String titulos[] ={"Registro","Dato"};
		tReserva = new JTable(informacion,titulos);
		tReserva.setEnabled(false);
		tReserva.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_1.setViewportView(tReserva);
	}
	
	void llenarCombo(){
		cboCodigo.removeAllItems();
		cboCodigo.addItem("-- Seleccione Reserva --");
		ArrayList<Reserva> aux = aRes.rEstado(0);
		for (Reserva r : aux) {
			cboCodigo.addItem(r.getCodReserva());
		}

	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboCodigo) {
			do_cboCodigo_itemStateChanged(arg0);
		}
	}
	protected void do_cboCodigo_itemStateChanged(ItemEvent arg0) {
		if(cboCodigo.getSelectedIndex()==0)
			btnAnular.setEnabled(false);
		else
			btnAnular.setEnabled(true);
		seleccionar();		
	}
	
	void seleccionar(){
		llenarTabla();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnAnular) {
			do_btnAnular_actionPerformed(arg0);
		}
	}
	protected void do_btnAnular_actionPerformed(ActionEvent arg0) {
		if(cboCodigo.getSelectedIndex()> 0){
			int cod = (int)(cboCodigo.getSelectedItem());
			Reserva r = aRes.buscar(cod);
			r.setEstadoReserva(1);
			aRes.grabarArchivo();
			mensaje("Reserva "+cod+" anulada");
			llenarCombo();
			cboCodigo.setSelectedIndex(0);
			llenarTabla();
		}else{
			
		}
		
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
