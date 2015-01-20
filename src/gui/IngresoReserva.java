package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.*;
import java.text.*;

import controlador.*;
import entidad.*;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;


public class IngresoReserva extends JDialog implements ActionListener {
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	private JLabel lblCodigo, lblCliente , lblRecepcionista ,lblHabitacion, lblFechaDeRegistro, lblFechaDeIngreso ,lblFechaDeSalida ;
	private JTextField txtCodigo;
	private JComboBox cboCliente, cboRecepcionista,cboHabitacion ;
	private JTextField txtFechaRegistro;
	private JTextField txtFechaIngreso;
	private JTextField txtFechaSalida;
	private JButton btnGrabar;
	private JButton btnLimpiar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoReserva dialog = new IngresoReserva();
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
	public IngresoReserva() {
		setTitle("Ingreso de Reserva");
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo :");
		lblCodigo.setBounds(10, 11, 100, 14);
		getContentPane().add(lblCodigo);
		
		lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(10, 36, 100, 14);
		getContentPane().add(lblCliente);
		
		lblRecepcionista = new JLabel("Recepcionista :");
		lblRecepcionista.setBounds(10, 61, 100, 14);
		getContentPane().add(lblRecepcionista);
		
		lblHabitacion = new JLabel("Habitaci\u00F3n :");
		lblHabitacion.setBounds(10, 86, 100, 14);
		getContentPane().add(lblHabitacion);
		
		lblFechaDeRegistro = new JLabel("Fecha de Registro :");
		lblFechaDeRegistro.setBounds(10, 111, 110, 14);
		getContentPane().add(lblFechaDeRegistro);
		
		lblFechaDeIngreso = new JLabel("Fecha de Ingreso:");
		lblFechaDeIngreso.setBounds(10, 136, 110, 14);
		getContentPane().add(lblFechaDeIngreso);
		
		lblFechaDeSalida = new JLabel("Fecha de Salida :");
		lblFechaDeSalida.setBounds(10, 161, 110, 14);
		getContentPane().add(lblFechaDeSalida);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(134, 11, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setText(""+aRes.generaCodigo());
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		
		cboCliente = new JComboBox();
		cboCliente.setBounds(134, 36, 230, 20);
		llenarComboCliente();
		getContentPane().add(cboCliente);
		
		cboRecepcionista = new JComboBox();
		cboRecepcionista.setBounds(134, 61, 230, 20);
		llenarComboRecepcionista();
		getContentPane().add(cboRecepcionista);
		
		cboHabitacion = new JComboBox();
		cboHabitacion.setBounds(134, 86, 110, 20);
		llenaComboHabitacion();
		getContentPane().add(cboHabitacion);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setBounds(134, 111, 110, 20);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);
		
		txtFechaIngreso = new JTextField();
		txtFechaIngreso.setBounds(134, 136, 110, 20);
		getContentPane().add(txtFechaIngreso);
		txtFechaIngreso.setColumns(10);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setBounds(134, 161, 110, 20);
		getContentPane().add(txtFechaSalida);
		txtFechaSalida.setColumns(10);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(42, 201, 100, 23);
		getContentPane().add(btnGrabar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(164, 201, 92, 23);
		getContentPane().add(btnLimpiar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(273, 201, 91, 23);
		getContentPane().add(btnCancelar);

	}
	
	void llenarComboCliente(){
		for (int i = 0; i < aCli.tamaño(); i++) {
			Cliente c = aCli.obtener(i);
			cboCliente.addItem(c.getApellidoCliente()+" , " + c.getNombreCliente());
		}
	}
	
	void llenarComboRecepcionista(){
		for (int i = 0; i < aRec.tamaño(); i++) {
			Recepcionista r = aRec.obtener(i);
			cboRecepcionista.addItem(r.getApellidoRecepcionista()+" , " + r.getNombreRecepcionista());
		}
	}
	
	void llenaComboHabitacion(){
		for (int i = 0; i < aHab.tamaño(); i++) {
			Habitacion h = aHab.obtener(i);
			cboHabitacion.addItem(h.getNumHabitacion());
			}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(arg0);
		}
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent arg0) {
		limpiar();
	}
	
	void limpiar(){
		txtCodigo.setText(""+aRes.generaCodigo());
		txtFechaRegistro.setText("");
		txtFechaIngreso.setText("");
		txtFechaSalida.setText("");
	}
	
	int getCodigo(){return Integer.parseInt(txtCodigo.getText());}
	int getCodCliente(){return (aCli.obtener(cboCliente.getSelectedIndex())).getCodCliente();}
	int getCodRecepcionista(){return (aRec.obtener(cboRecepcionista.getSelectedIndex())).getCodRecepcionista();}
	int getNumeroHabitacion(){return (aHab.obtener(cboHabitacion.getSelectedIndex())).getNumHabitacion();}
	String getFechaRegistro(){return txtFechaRegistro.getText();}
	String getFechaIngreso(){return txtFechaIngreso.getText();}
	String getFechaSalida(){return txtFechaSalida.getText();}
	
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		if(validarVacio()){
			if(validaFecha()){
				if(validaDiaReal(getFechaRegistro()) && validaMesReal(getFechaRegistro()) && validaDiaReal(getFechaIngreso()) && validaMesReal(getFechaIngreso()) && validaDiaReal(getFechaSalida()) && validaMesReal(getFechaSalida())){
					try {
						Reserva r= new Reserva(getCodCliente(), getCodCliente(), getCodRecepcionista(), getNumeroHabitacion(), getFechaRegistro(), getFechaIngreso(), getFechaSalida()	, 0);
						aRes.creacion(r);
						mensaje("Reserva realizada");
						aRes.grabarArchivo();
					} catch (Exception e) {
						mensaje("Ingrese codigo correctamente");
					}
				}else mensaje("Ingrese fechas Reales");
			}else mensaje("Ingrese Fecha con Formato DD/MM/YYYY");
			
		}else mensaje("Llene todos los campos");
	}
	
	boolean validarVacio(){
		if(!txtCodigo.getText().isEmpty() && !txtFechaRegistro.getText().isEmpty() && !txtFechaIngreso.getText().isEmpty() && !txtFechaSalida.getText().isEmpty())
			return true;
		return false;
	}
	
	boolean validaFecha(){
			try {
				Date fechaRegistro = f.parse(txtFechaRegistro.getText());
				Date fechaIngreso = f.parse(txtFechaIngreso.getText());
				Date fechaSalida = f.parse(txtFechaSalida.getText());
				return true;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return false;
	}
	
	boolean validaDiaReal(String fecha){
		int dia= Integer.parseInt(fecha.substring(0, 2));
			if( 0 < dia && dia <=31)
				return true;
		return false;
	} 
	
	boolean validaMesReal(String fecha){
		int mes = Integer.parseInt(fecha.substring(3, 5));
		if( 0 < mes && mes <=12)
			return true;
		return false;
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent arg0) {

	}
}
