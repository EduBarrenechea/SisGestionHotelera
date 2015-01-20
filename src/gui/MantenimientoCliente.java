package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entidad.Cliente;
import controlador.ArregloCliente;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JTable;

public class MantenimientoCliente extends JDialog implements ItemListener, ActionListener, KeyListener {

	ArregloCliente aCli = new ArregloCliente();
	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpcion,lblCodigo,lblApellido,lblNombre,lblTelefono,lblEstado;
	private JComboBox cboOpcion,cboEstado;
	private JTextField txtCodigo,txtApellido,txtNombre,txtTelefono;
	private JButton btnProcesar,btnLimpiar;
	private JLabel label;
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JScrollPane scrollPane_1;
	private JTable tCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoCliente dialog = new MantenimientoCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoCliente() {
		setResizable(false);
		setTitle("Mantenimiento de Clientes");
		setBounds(100, 100, 546, 518);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 508, 516);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		lblOpcion = new JLabel("Opci\u00F3n :");
		lblOpcion.setBounds(10, 11, 85, 14);
		contentPanel.add(lblOpcion);
		
		cboOpcion = new JComboBox();
		cboOpcion.setToolTipText("Seleccione opcion a procesar");
		cboOpcion.setBounds(105, 8, 216, 20);
		cboOpcion.addItem("--Seleccione Opcion -- ");
		cboOpcion.addItem("Ingresar Registro");
		cboOpcion.addItem("Busqueda por Codigo");
		cboOpcion.addItem("Actualizar Registro");
		cboOpcion.addItem("Eliminar Registro");
		cboOpcion.addItem("Listar");	
		cboOpcion.addItemListener(this);
		contentPanel.add(cboOpcion);
		
		lblCodigo = new JLabel("C\u00F3digo :");
		lblCodigo.setBounds(10, 36, 85, 14);
		contentPanel.add(lblCodigo);
		
		
		lblApellido = new JLabel("Apellido :");
		lblApellido.setBounds(10, 61, 85, 14);
		contentPanel.add(lblApellido);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 86, 85, 14);
		contentPanel.add(lblNombre);
		
		lblTelefono = new JLabel("Tel\u00E9fono :");
		lblTelefono.setBounds(10, 111, 85, 14);
		contentPanel.add(lblTelefono);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(10, 136, 85, 14);
		contentPanel.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setToolTipText("Ingrese codigo en numeros");
		txtCodigo.setBounds(105, 33, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setToolTipText("Ingrese Apellido");
		txtApellido.setBounds(105, 58, 150, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Ingrese Nombre");
		txtNombre.setBounds(105, 83, 150, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setToolTipText("Ingrese Telefono");
		txtTelefono.setBounds(105, 108, 150, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.setToolTipText("Procesar Opcion");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(371, 11, 89, 23);
		contentPanel.add(btnProcesar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setToolTipText("Limpiar Texto");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(371, 36, 89, 23);
		contentPanel.add(btnLimpiar);
		
		cboEstado = new JComboBox();
		cboEstado.setToolTipText("Cambia estado del Cliente");
		cboEstado.setBounds(105, 133, 86, 20);
		cboEstado.addItem("No Activo");
		cboEstado.addItem("Activo");
		contentPanel.add(cboEstado);
		
		label = new JLabel("Para ayuda coloque el puntero sobre el elemento");
		label.setForeground(Color.BLUE);
		label.setBounds(201, 136, 312, 14);
		contentPanel.add(label);
		
		lblCodigo.setVisible(false);
		txtCodigo.setVisible(false);
		lblApellido.setVisible(false);
		txtApellido.setVisible(false);
		lblNombre.setVisible(false);
		txtNombre.setVisible(false);
		lblTelefono.setVisible(false);
		txtTelefono.setVisible(false);
		lblEstado.setVisible(false);
		cboEstado.setVisible(false);
		btnProcesar.setEnabled(false);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setToolTipText("Cerrar Ventana");
		btnCerrar.setBounds(371, 61, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Llenar Datos del Cliente");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(201, 32, 85, 23);
		btnBuscar.setVisible(false);
		contentPanel.add(btnBuscar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 161, 450, 317);
		contentPanel.add(scrollPane_1);
		
		tCliente = new JTable();
		
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboOpcion) {
			do_cboOpcion_itemStateChanged(arg0);
		}
	}
	protected void do_cboOpcion_itemStateChanged(ItemEvent arg0) {
		seleccionar();
	}
	
	void seleccionar(){
		switch (cboOpcion.getSelectedIndex()) {
		case 0:
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			lblApellido.setVisible(false);
			txtApellido.setVisible(false);
			lblNombre.setVisible(false);
			txtNombre.setVisible(false);
			lblTelefono.setVisible(false);
			txtTelefono.setVisible(false);
			lblEstado.setVisible(false);
			cboEstado.setVisible(false);
			btnProcesar.setEnabled(false);
			btnBuscar.setVisible(false);
			break;
		case 1:
			btnProcesar.setEnabled(true);
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			txtCodigo.setEditable(false);
			lblApellido.setVisible(true);
			txtApellido.setVisible(true);
			lblNombre.setVisible(true);
			txtNombre.setVisible(true);
			lblTelefono.setVisible(true);
			txtTelefono.setVisible(true);
			lblEstado.setVisible(false);
			cboEstado.setVisible(false);
			//txtCodigo.setText(""+aCli.generaCodigo());
			txtApellido.requestFocus();
			btnBuscar.setVisible(false);
			break;
		case 2:
			btnProcesar.setEnabled(true);
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			txtCodigo.setEditable(true);
			lblApellido.setVisible(false);
			txtApellido.setVisible(false);
			lblNombre.setVisible(false);
			txtNombre.setVisible(false);
			lblTelefono.setVisible(false);
			txtTelefono.setVisible(false);
			lblEstado.setVisible(false);
			cboEstado.setVisible(false);
			btnBuscar.setVisible(false);
			if(aCli.tamaño()>0){
				llenarTabla();
				btnProcesar.setEnabled(true);
			}else{
				btnProcesar.setEnabled(false);
			}
			break;
		case 3: 
			btnProcesar.setEnabled(true);
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			txtCodigo.setEditable(true);
			lblApellido.setVisible(true);
			txtApellido.setVisible(true);
			lblNombre.setVisible(true);
			txtNombre.setVisible(true);
			lblTelefono.setVisible(true);
			txtTelefono.setVisible(true);
			lblEstado.setVisible(true);
			cboEstado.setVisible(true);	
			cboEstado.setSelectedIndex(1);
			btnBuscar.setVisible(true);
			if(aCli.tamaño()>0){
				btnProcesar.setEnabled(true);
			}else{
				btnProcesar.setEnabled(false);
			}
			break;
		case 4:
			btnProcesar.setEnabled(true);
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			txtCodigo.setEditable(true);
			lblApellido.setVisible(false);
			txtApellido.setVisible(false);
			lblNombre.setVisible(false);
			txtNombre.setVisible(false);
			lblTelefono.setVisible(false);
			txtTelefono.setVisible(false);
			lblEstado.setVisible(false);
			cboEstado.setVisible(false);
			btnBuscar.setVisible(false);
			if(aCli.tamaño()>0){
				llenarTabla();
				btnProcesar.setEnabled(true);
			}else{
				btnProcesar.setEnabled(false);
			}
			break;
		case 5:
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			lblApellido.setVisible(false);
			txtApellido.setVisible(false);
			lblNombre.setVisible(false);
			txtNombre.setVisible(false);
			lblTelefono.setVisible(false);
			txtTelefono.setVisible(false);
			lblEstado.setVisible(false);
			cboEstado.setVisible(false);
			btnProcesar.setEnabled(true);
			btnBuscar.setVisible(false);
			break;
		
		}		
	}
	
	void limpiar(){
		txtCodigo.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		cboEstado.setSelectedIndex(0);
		txtCodigo.requestFocus();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			do_btnProcesar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(arg0);
		}
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent arg0) {
		limpiar();
	}
	int getCodigo(){return Integer.parseInt(txtCodigo.getText());}
	String getApellido(){return txtApellido.getText();}
	String getNombre(){return txtNombre.getText();}
	String getTelefono(){return txtTelefono.getText();}
	
	
	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		switch (cboOpcion.getSelectedIndex()) {
		case 1:ingresar();break;
		case 2:buscar();break;
		case 3:actualizar();break;
		case 4:eliminar();break;
		case 5:llenarTabla();break;

		default:
			break;
		}
	}
	void ingresar(){
		if(validarVacio()){
			try {
					Cliente c = new Cliente(aCli.generaCodigo(), getApellido(), getNombre(), getTelefono(), 1);
					aCli.creacion(c);
					llenarTabla();
					limpiar();
					aCli.grabarArchivo();
					//txtCodigo.setText(""+aCli.generaCodigo());
					txtApellido.requestFocus();				
				
			} catch (Exception e) {
				mensaje("Código incorrecto");
				//txtCodigo.setText(""+aCli.generaCodigo());
				txtApellido.requestFocus();
			}
		}
		else mensaje("Llene todos los Campos");
		
	}
	void mostrarTabla(String[][] informacion){
		String titulos[]={"Codigo","Apellido","Nombre","Telefono","Estado"};
		tCliente = new JTable(informacion, titulos);
		tCliente.setEnabled(false);
		tCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_1.setViewportView(tCliente);
	}
	
	void llenarTabla(){		
		String informacion[][] = new String[aCli.tamaño()][5];
		for (int i = 0; i < aCli.tamaño(); i++) {
			Cliente c = aCli.obtener(i);
			informacion[i][0] = c.getCodCliente()+"";
			informacion[i][1] = c.getApellidoCliente();
			informacion[i][2] = c.getNombreCliente();
			informacion[i][3] = c.getTelefonoCliente();
			informacion[i][4] = c.getEstado();			
		}
		mostrarTabla(informacion);
	}
	
	void llenarTabla(Cliente c){
		String informacion[][]= new String[1][5];
		informacion[0][0] = c.getCodCliente()+"";
		informacion[0][1] = c.getApellidoCliente();
		informacion[0][2] = c.getNombreCliente();
		informacion[0][3] = c.getTelefonoCliente();
		informacion[0][4] = c.getEstado();	
		mostrarTabla(informacion);
	}
	
	void buscar(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Cliente c = aCli.buscar(getCodigo());
				if(c != null)
					llenarTabla(c);			
				else 
					mensaje("No hay Cliente con ese código");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else mensaje("Ingrese código");
	}
	
	void actualizar(){
		if(validarVacio()){
			try {
				Cliente c = aCli.buscar(getCodigo());
				if(c!=null){
					Cliente cli = new Cliente(getCodigo(), getApellido(), getNombre(), getTelefono(), cboEstado.getSelectedIndex());
					aCli.modificar(cli);
					llenarTabla();
					aCli.grabarArchivo();
				} else mensaje("No existe codigo");
			} catch (Exception e) {
				mensaje("Llene correctamento el codigo");
			}
		} else mensaje("Llene todos los campos");
	}
	
	void eliminar(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Cliente c = aCli.buscar(getCodigo());
				if ( c != null){
					aCli.eliminar(c);
					aCli.grabarArchivo();
					llenarTabla();
				}else mensaje("Código no existe");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else
			mensaje("Escriba un código");
	}
	boolean validarVacio(){
		if(cboOpcion.getSelectedIndex()== 1){
		if(!txtApellido.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty())
			return true;
		}else {
			if(!txtCodigo.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty())
			return true;
		}
		return false;
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		buscarData();
	}
	
	void buscarData(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Cliente c = aCli.buscar(getCodigo());
				if(c!=null){
					txtApellido.setText(c.getApellidoCliente());
					txtNombre.setText(c.getNombreCliente());
					txtTelefono.setText(c.getTelefonoCliente());
					cboEstado.setSelectedIndex(c.getEstadoCliente());
				} else mensaje("No existe codigo");
			} catch (Exception e) {
				mensaje("Llene correctamento el codigo");
			}
		} else mensaje("Ingrese código");
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCodigo) {
			do_txtCodigo_keyTyped(arg0);
		}
	}
	protected void do_txtCodigo_keyTyped(KeyEvent arg0) {
		char car = arg0.getKeyChar();
		if((car<'0' || car>'9'))arg0.consume();
	}
}