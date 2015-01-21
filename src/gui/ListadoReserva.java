package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import entidad.*;
import controlador.*;

public class ListadoReserva extends JDialog implements ActionListener {
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblListar;
	private JTable tReserva;
	private JButton btnCerrar;
	private JButton btnProcesar;
	private JComboBox cboListado;
	private JScrollPane scrollPane;

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
		setTitle("Listado de Reservas");
		setBounds(100, 100, 841, 454);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 825, 415);
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
			lblListar = new JLabel("Listar :");
			lblListar.setBounds(247, 15, 46, 14);
			contentPanel.add(lblListar);
		
		
			cboListado = new JComboBox();
			cboListado.setBounds(303, 12, 144, 20);
			cboListado.addItem("Todos");
			cboListado.addItem("Iniciada");
			cboListado.addItem("Anulada");
			cboListado.addItem("Atendida");
			contentPanel.add(cboListado);
		
		
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(457, 11, 89, 23);
			contentPanel.add(btnProcesar);
		
		
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(457, 42, 89, 23);
			contentPanel.add(btnCerrar);
		
		
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 72, 805, 332);
			contentPanel.add(scrollPane);
			
			tReserva = new JTable();
			
			
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			btnProcesarActionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			btnCerrarActionPerformed(e);
		}
	}
	protected void btnCerrarActionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void btnProcesarActionPerformed(ActionEvent e) {
		listar();
	}
	void listar(){
		int op = cboListado.getSelectedIndex();
		switch (op) {
		case 0: listarTodo();break;
		case 1 : listarEstado(0);break;
		case 2 : listarEstado(1);break;
		case 3 : listarEstado(2);break;
		}
	}
	void listarTodo(){
		if(aRes.tamaño() > 0){
			String informacion[][] = new String[aRes.tamaño()][8];
			for(int i = 0 ; i < aRes.tamaño(); i++){
				Reserva r = aRes.obtener(i);
				informacion[i][0] = r.getCodReserva()+"";
				informacion[i][1] = aCli.traerNombreCli(r.getCodCliente());
				informacion[i][2] = aRec.traeNombreRec(r.getCodRecepcionista());
				informacion[i][3] = r.getNumeroHabitacion()+"";
				informacion[i][4] = r.getFechaRegistroReserva();
				informacion[i][5] = r.getFechaIngresoReserva();
				informacion[i][6] = r.getFechaSalidaReserva();
				informacion[i][7] = r.getEstado();
			}
			mostrarTabla(informacion);	
		}else{
			mensaje("No hay datos");
			tablaVacia();
		}
		
	}
	
	void listarEstado(int est){
		ArrayList<Reserva> aux = aRes.rEstado(est);
		if(aux.size()>0){
			String informacion[][] = new String[aux.size()][8];
			for(int i = 0 ; i < aux.size(); i++){
				Reserva r = aux.get(i);
				informacion[i][0] = r.getCodReserva()+"";
				informacion[i][1] = aCli.traerNombreCli(r.getCodCliente());
				informacion[i][2] = aRec.traeNombreRec(r.getCodRecepcionista());
				informacion[i][3] = r.getNumeroHabitacion()+"";
				informacion[i][4] = r.getFechaRegistroReserva();
				informacion[i][5] = r.getFechaIngresoReserva();
				informacion[i][6] = r.getFechaSalidaReserva();
				informacion[i][7] = r.getEstado();
			}
			mostrarTabla(informacion);
		}else{
			mensaje("No hay datos");
			tablaVacia();
		}		
	}
	void tablaVacia(){
		String informacion[][] = new String[1][8];
		informacion[0][0] = "--";
		informacion[0][1] = "--";
		informacion[0][2] = "--";
		informacion[0][3] = "--";
		informacion[0][4] = "--";
		informacion[0][5] = "--";
		informacion[0][6] = "--";
		informacion[0][7] = "--";
		mostrarTabla(informacion);
	}
	
	void mostrarTabla(String[][] informacion){
		String titulos[] = {"Código","Cliente","Recepcionista","Numero H","Fecha Registro","Fecha Ingreso","Fecha Salida","Estado"};
		tReserva = new JTable(informacion,titulos);
		tReserva.setEnabled(false);
		tReserva.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(tReserva);
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	
}
