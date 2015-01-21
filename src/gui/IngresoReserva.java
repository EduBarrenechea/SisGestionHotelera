package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.*;
import java.text.*;

import controlador.*;
import entidad.*;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;




public class IngresoReserva extends JDialog implements ActionListener {
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	private JLabel lblCliente , lblRecepcionista ,lblHabitacion, lblFechaDeRegistro, lblFechaDeIngreso ,lblFechaDeSalida ;
	private JComboBox cboCliente, cboRecepcionista,cboHabitacion ;
	private JButton btnGrabar;
	private JButton btnLimpiar;
	private JButton btnCerrar;
	private JDateChooser dFechaRegistro;
	private JDateChooser dFechaIngreso;
	private JDateChooser dFechaSalida;

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
		setBounds(100, 100, 405, 289);
		getContentPane().setLayout(null);
		
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
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 192, 100, 23);
		getContentPane().add(btnGrabar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(132, 192, 92, 23);
		getContentPane().add(btnLimpiar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(241, 192, 91, 23);
		getContentPane().add(btnCerrar);
		
		dFechaRegistro = new JDateChooser();
		dFechaRegistro.setBounds(134, 111, 120, 20);
		getContentPane().add(dFechaRegistro);
		
		dFechaIngreso = new JDateChooser();
		dFechaIngreso.setBounds(134, 136, 120, 20);
		getContentPane().add(dFechaIngreso);
		
		dFechaSalida = new JDateChooser();
		dFechaSalida.setBounds(134, 161, 120, 20);
		getContentPane().add(dFechaSalida);

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
		ArrayList<Habitacion> aHabDispo = aHab.habitacionesXestado(1);
		if (aHabDispo.size()>0)
		for (Habitacion h : aHabDispo) {
			cboHabitacion.addItem(h.getNumHabitacion());
		}else{
			mensaje("No hay Cuartos disponibles para Reservación");
			this.dispose();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
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
		//txtCodigo.setText(""+aRes.generaCodigo());
				
	}
	
	//int getCodigo(){return Integer.parseInt(txtCodigo.getText());}
	int getCodCliente(){return (aCli.obtener(cboCliente.getSelectedIndex())).getCodCliente();}
	int getCodRecepcionista(){return (aRec.obtener(cboRecepcionista.getSelectedIndex())).getCodRecepcionista();}
	int getNumeroHabitacion(){return (int)(cboHabitacion.getSelectedItem());}
	String getFechaRegistro(){return getFecha(dFechaRegistro);}
	String getFechaIngreso(){return getFecha(dFechaIngreso);}
	String getFechaSalida(){return getFecha(dFechaSalida);}
	
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		if(validarVacio()){
			
					try {
						Reserva r= new Reserva(aRes.generaCodigo(), getCodCliente(), getCodRecepcionista(), getNumeroHabitacion(), getFechaRegistro(), getFechaIngreso(), getFechaSalida()	, 0);
						mensaje("Reserva realizada con Código :" + aRes.generaCodigo());
						aRes.creacion(r);
						cambiarHabitacion(getNumeroHabitacion());
						aRes.grabarArchivo();
					} catch (Exception e) {
						mensaje("Ingrese codigo correctamente");
					}
				
			
			
		}else mensaje("Llene todos los campos");
	}
	
	void cambiarHabitacion(int num){
		Habitacion h = aHab.buscar(num);
		h.setEstadoHabitacion(2);
		aHab.grabarArchivo();
		cboHabitacion.removeAllItems();
		llenaComboHabitacion();
	}
	boolean validarVacio(){
		if(getFechaRegistro()!=null && getFechaIngreso()!=null && getFechaSalida()!=null)
			return true;
		return false;
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy");
	public String getFecha(JDateChooser jd){
		if(jd.getDate()!=null){
			return Formato.format(jd.getDate());
		}else{
			return null;
		}
	}
}
