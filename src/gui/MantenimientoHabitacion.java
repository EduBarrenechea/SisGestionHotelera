package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MantenimientoHabitacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpcin;
	private JComboBox cboOpcion;
	private JLabel lblNmero;
	private JTextField txtNumero;
	private JLabel lblDescripcin;
	private JTextField txtDescripcion;
	private JLabel lblTipo;
	private JTextField txtTipo;
	private JLabel lblUbicacin;
	private JTextField txtUbicacion;
	private JLabel lblCosto;
	private JTextField txtCosto;
	private JButton btnProcesar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoHabitacion dialog = new MantenimientoHabitacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoHabitacion() {
		setTitle("Mantenimiento de Habitaci\u00F3n");
		setBounds(100, 100, 513, 499);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblOpcin = new JLabel("Opci\u00F3n :");
		lblOpcin.setBounds(10, 11, 85, 14);
		contentPanel.add(lblOpcin);
		
		cboOpcion = new JComboBox();
		cboOpcion.setToolTipText("Seleccione operaci\u00F3n a realizar");
		cboOpcion.setBounds(105, 8, 216, 20);
		cboOpcion.addItem("Ingresar Registro");
		cboOpcion.addItem("Busqueda por Codigo");
		cboOpcion.addItem("Actualizar Registro");
		cboOpcion.addItem("Eliminar Registro");
		cboOpcion.addItem("Listar");
		contentPanel.add(cboOpcion);
		
		lblNmero = new JLabel("N\u00FAmero :");
		lblNmero.setBounds(10, 36, 70, 14);
		contentPanel.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(105, 33, 86, 20);
		contentPanel.add(txtNumero);
		txtNumero.setColumns(10);
		
		lblDescripcin = new JLabel("Descripci\u00F3n :");
		lblDescripcin.setBounds(10, 61, 96, 14);
		contentPanel.add(lblDescripcin);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(105, 58, 216, 20);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 86, 46, 14);
		contentPanel.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(105, 83, 86, 20);
		contentPanel.add(txtTipo);
		txtTipo.setColumns(10);
		
		lblUbicacin = new JLabel("Ubicaci\u00F3n :");
		lblUbicacin.setBounds(10, 111, 70, 14);
		contentPanel.add(lblUbicacin);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setBounds(105, 108, 86, 20);
		contentPanel.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		
		lblCosto = new JLabel("Costo :");
		lblCosto.setBounds(10, 136, 46, 14);
		contentPanel.add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(105, 133, 86, 20);
		contentPanel.add(txtCosto);
		txtCosto.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setToolTipText("Procesa la operacion seleccionada");
		btnProcesar.setBounds(363, 7, 89, 23);
		contentPanel.add(btnProcesar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setToolTipText("Limpia las cajas de texto");
		btnLimpiar.setBounds(363, 32, 89, 23);
		contentPanel.add(btnLimpiar);
	}
}
