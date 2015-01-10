package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class IngresoHospedaje extends JDialog {
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
		setBounds(100, 100, 452, 509);
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
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cboCliente = new JComboBox();
		cboCliente.setBounds(139, 33, 154, 20);
		getContentPane().add(cboCliente);
		
		cboReserva = new JComboBox();
		cboReserva.setBounds(140, 58, 153, 20);
		getContentPane().add(cboReserva);
		
		cboHabitacion = new JComboBox();
		cboHabitacion.setBounds(140, 83, 86, 20);
		getContentPane().add(cboHabitacion);
		
		cboRecepcionista = new JComboBox();
		cboRecepcionista.setBounds(140, 108, 153, 20);
		getContentPane().add(cboRecepcionista);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setBounds(140, 133, 86, 20);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);

	}
}
