package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import entidad.*;
import controlador.*;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class IngresoHospedaje extends JDialog implements ItemListener, ActionListener {
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	ArregloHospedaje aHos = new ArregloHospedaje();
	ArrayList<Reserva> rc;

	
	
	
	private JLabel lblCodigo;
	private JLabel lblReserva;
	private JLabel lblCliente;
	private JLabel lblHabitacion;
	private JLabel lblRecepcionista;
	private JLabel lblFechaRegistro;
	private JTextField txtCodigo;
	private JComboBox cboCliente;
	private JComboBox cboReserva;
	private JComboBox cboHabitacion;
	private JComboBox cboRecepcionista;
	private JTextField txtFechaRegistro;
	private JTextField txtHabitacion;
	private JTextField txtRecepcionista;
	private JCheckBox chkReserva;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoHospedaje dialog = new IngresoHospedaje();
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
	public IngresoHospedaje() {
				
		setTitle("Ingreso de Hospedaje");
		setBounds(100, 100, 553, 229);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(10, 11, 120, 14);
		getContentPane().add(lblCodigo);
		
		lblReserva = new JLabel("Reserva :");
		lblReserva.setBounds(10, 61, 120, 14);
		getContentPane().add(lblReserva);
		
		lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(10, 36, 120, 14);
		getContentPane().add(lblCliente);
		
		lblHabitacion = new JLabel("Habitacion :");
		lblHabitacion.setBounds(10, 86, 120, 14);
		getContentPane().add(lblHabitacion);
		
		lblRecepcionista = new JLabel("Recepcionista :");
		lblRecepcionista.setBounds(10, 111, 120, 14);
		getContentPane().add(lblRecepcionista);
		
		lblFechaRegistro = new JLabel("Fecha Registro :");
		lblFechaRegistro.setBounds(10, 136, 120, 14);
		getContentPane().add(lblFechaRegistro);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(140, 8, 86, 20);
		txtCodigo.setText(""+aHos.generaCodigo());
		txtCodigo.setEditable(false);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cboCliente = new JComboBox();
		cboCliente.setBounds(139, 33, 201, 20);
		llenarComboCliente();
		cboCliente.addItemListener(this);
		getContentPane().add(cboCliente);
		
		cboReserva = new JComboBox();
		cboReserva.addItemListener(this);
		cboReserva.setBounds(140, 58, 200, 20);
		getContentPane().add(cboReserva);
		
		cboHabitacion = new JComboBox();
		cboHabitacion.setBounds(140, 83, 86, 20);
		getContentPane().add(cboHabitacion);
		
		cboRecepcionista = new JComboBox();
		cboRecepcionista.setBounds(140, 108, 153, 20);
		getContentPane().add(cboRecepcionista);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setText("10/01/2015");
		txtFechaRegistro.setBounds(140, 133, 86, 20);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);
		
		txtHabitacion = new JTextField();
		txtHabitacion.setEditable(false);
		txtHabitacion.setBounds(140, 83, 86, 20);
		getContentPane().add(txtHabitacion);
		txtHabitacion.setColumns(10);
		
		txtRecepcionista = new JTextField();
		txtRecepcionista.setEditable(false);
		txtRecepcionista.setBounds(140, 108, 153, 20);
		getContentPane().add(txtRecepcionista);
		txtRecepcionista.setColumns(10);
		
		chkReserva = new JCheckBox("Sin Reserva");
		chkReserva.addItemListener(this);
		chkReserva.setBounds(356, 57, 126, 23);
		getContentPane().add(chkReserva);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(356, 132, 89, 23);
		getContentPane().add(btnGrabar);

	}
	
	void llenarComboCliente(){
		for (int i = 0; i < aCli.tamaño(); i++) {
			Cliente c = aCli.obtener(i);
			cboCliente.addItem(c.getApellidoCliente()+" , " + c.getNombreCliente());
		}
	}
	
	void llenarComboReserva(int codCli){
		cboReserva.removeAllItems();
		int indice=0;
		rc = aRes.reservaxCLiente(codCli);
		if(rc.size()>0){
			chkReserva.setSelected(false);
			chkReserva.setVisible(true);			
			cliConR();		
		}else{
			 chkReserva.setVisible(false);
			 cliSinR();
			
		}	 
	}
	void cliConR(){
		for (Reserva r : rc) {
			cboReserva.addItem(r.getCodReserva());
			cboReserva.setEnabled(true);
			cboHabitacion.setVisible(false);
			cboRecepcionista.setVisible(false);
			txtHabitacion.setVisible(true);
			txtRecepcionista.setVisible(true);
		}
	}
	
	void cliSinR(){
		cboReserva.addItem("-- Sin Reserva --");
		cboReserva.setEnabled(false);
		cboHabitacion.setVisible(true);
		txtHabitacion.setVisible(false);
		cboRecepcionista.setVisible(true);
		txtRecepcionista.setVisible(false);
		llenarSinR();
	}
	
	void llenarConR(){
			cboHabitacion.removeAllItems();
			cboRecepcionista.removeAllItems();
			if(rc.size()>0){
				try {
					Reserva r = rc.get(cboReserva.getSelectedIndex());
					txtHabitacion.setText(String.valueOf(r.getNumeroHabitacion()));
					txtRecepcionista.setText((aRec.buscar(r.getCodRecepcionista())).getApellidoRecepcionista()+" , "+(aRec.buscar(r.getCodRecepcionista())).getNombreRecepcionista());
				} catch (Exception e) {
					// TODO: handle exception
				}				
			}		
	}
	void llenarSinR(){
		for (int i = 0; i < aRec.tamaño(); i++) {
			Recepcionista r = aRec.obtener(i);
			cboRecepcionista.addItem(r.getApellidoRecepcionista()+" , " + r.getNombreRecepcionista());
		}
		for (int i = 0; i < aHab.tamaño(); i++) {
			Habitacion h = aHab.obtener(i);
			cboHabitacion.addItem(h.getNumHabitacion());
			}
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == chkReserva) {
			do_chkReserva_itemStateChanged(arg0);
		}
		if (arg0.getSource() == cboReserva) {
			do_cboReserva_itemStateChanged(arg0);
		}
		if (arg0.getSource() == cboCliente) {
			do_cboCliente_itemStateChanged(arg0);
		}
	}
	protected void do_cboCliente_itemStateChanged(ItemEvent arg0) {
		int codCli = (aCli.obtener(cboCliente.getSelectedIndex())).getCodCliente();
		llenarComboReserva(codCli);
		chkReserva.setSelected(false);
	}
	protected void do_cboReserva_itemStateChanged(ItemEvent arg0) {
		llenarConR();
		
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	protected void do_chkReserva_itemStateChanged(ItemEvent arg0) {
		sinReserva();
	}
	
	void sinReserva(){
		cboHabitacion.removeAllItems();
		cboRecepcionista.removeAllItems();
		if(chkReserva.isSelected())cliSinR();
		else cliConR();
	}
	
	Hospedaje grabarSinR(){
		Hospedaje h = new Hospedaje();
		try {
				h.setCodHospedaje(Integer.parseInt(txtCodigo.getText()));
					h.setCodReserva(-1);
					h.setCodCliente((aCli.obtener(cboCliente.getSelectedIndex())).getCodCliente());
					h.setCodHabitacion((int)(cboHabitacion.getSelectedItem()));
					h.setCodRecepcionista((aRec.obtener(cboRecepcionista.getSelectedIndex())).getCodRecepcionista());
					h.setTipoHospedaje(1);
					h.setFechaRegistroHospedaje(txtFechaRegistro.getText());
					h.setEstadoHospedaje(1);
		} catch (Exception e) {
			mensaje("Error SinR");
		}
		return h;
	}
	
	Hospedaje grabarConR(){
		Hospedaje h = new Hospedaje();
		if(!chkReserva.isSelected()){
			Reserva r = rc.get(cboReserva.getSelectedIndex());

		try {
			h.setCodHospedaje(Integer.parseInt(txtCodigo.getText()));
			h.setCodReserva(r.getCodReserva());
			h.setCodCliente(r.getCodCliente());
			h.setCodHabitacion(r.getNumeroHabitacion());
			h.setCodRecepcionista(r.getCodRecepcionista());
			h.setTipoHospedaje(0);
			h.setFechaRegistroHospedaje(txtFechaRegistro.getText());
			h.setEstadoHospedaje(1);
			//aRes.modificar(r.getCodReserva(), 2);					
		} catch (Exception e) {
			mensaje("Error ConR");
		}
		}
		else{
			h = grabarSinR();
		}
			return h;
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(arg0);
		}
	}
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		grabar();
	}
	
	void grabar(){
		Hospedaje h;
		if(rc.size()>0)
			 h = grabarConR();
		else 
			 h = grabarSinR();
		if(h != null){
		aHos.creacion(h);
		txtCodigo.setText(""+aHos.generaCodigo());
		aHos.grabarArchivo();
		mensaje("Hospedaje Grabado");
		}
	}

}
