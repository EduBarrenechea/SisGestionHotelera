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

import entidad.Recepcionista;
import controlador.ArregloRecepcionista;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JTable;;

public class MantenimientoRecepcionista extends JDialog implements ItemListener, ActionListener, KeyListener {

	ArregloRecepcionista aRec = new ArregloRecepcionista();
	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpcion,lblCodigo,lblApellido,lblNombre,lblTelefono,lblEstado;
	private JComboBox cboOpcion,cboEstado;
	private JTextField txtCodigo,txtApellido,txtNombre,txtTelefono;
	private JButton btnProcesar,btnLimpiar;
	private JLabel label;
	private JButton btnBuscar;
	private JButton btnCerrar;
	private JScrollPane scrollPane_1;
	private JTable tRecepcionista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoRecepcionista dialog = new MantenimientoRecepcionista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoRecepcionista() {
		setResizable(false);
		setTitle("Mantenimiento de Recepcionista");
		setBounds(100, 100, 524, 439);
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(201, 32, 89, 23);
		btnBuscar.setVisible(false);
		contentPanel.add(btnBuscar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(371, 61, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 161, 488, 240);
		contentPanel.add(scrollPane_1);
		
		tRecepcionista = new JTable();
		
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
			//txtCodigo.setText(""+aRec.generaCodigo());
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
			if(aRec.tamaño()>0){
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
			if(aRec.tamaño()>0){
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
			if(aRec.tamaño()>0){
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
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(arg0);
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
				Recepcionista r = new Recepcionista(aRec.generaCodigo(), getApellido(), getNombre(), getTelefono(), 1);
					aRec.creacion(r);
					llenarTabla();
					limpiar();
					aRec.grabarArchivo();
					txtCodigo.setText(""+aRec.generaCodigo());
					txtApellido.requestFocus();
								
			} catch (Exception e) {
				mensaje("Código incorrecto");
				txtCodigo.setText(""+aRec.generaCodigo());
				txtApellido.requestFocus();
			}
		}
		else mensaje("Llene todos los Campos");
		
	}
	
	void mostrarTabla(String informacion[][]){
		String titulos[]={"Código","Apellido","Nombre","Telefono","Estado"};
		tRecepcionista = new JTable(informacion, titulos);
		tRecepcionista.setEnabled(false);
		tRecepcionista.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_1.setViewportView(tRecepcionista);
	}
	
	void llenarTabla(){		
		String informacion[][] = new String[aRec.tamaño()][5];
		for(int i = 0 ; i<aRec.tamaño(); i++){
			Recepcionista r = aRec.obtener(i);
			informacion[i][0] = r.getCodRecepcionista()+"";
			informacion[i][1] = r.getApellidoRecepcionista();
			informacion[i][2] = r.getNombreRecepcionista();
			informacion[i][3] = r.getTelefonoRecepcionista();
			informacion[i][4] = r.getEstado();
		}
		mostrarTabla(informacion);
	}
	
	void llenarTabla(Recepcionista r){
		String informacion[][] = new String[1][5];
		informacion[0][0] = r.getCodRecepcionista()+"";
		informacion[0][1] = r.getApellidoRecepcionista();
		informacion[0][2] = r.getNombreRecepcionista();
		informacion[0][3] = r.getTelefonoRecepcionista();
		informacion[0][4] = r.getEstado();
		mostrarTabla(informacion);
	}
	
	void buscar(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Recepcionista r = aRec.buscar(getCodigo());
				if(r != null)
					llenarTabla(r);			
				else 
					mensaje("No hay Recepcionista con ese código");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else mensaje("Ingrese código");
	}
	
	void actualizar(){
		if(validarVacio()){
			try {
				Recepcionista r = aRec.buscar(getCodigo());
				if(r!=null){
					Recepcionista rec = new Recepcionista(getCodigo(), getApellido(), getNombre(), getTelefono(), cboEstado.getSelectedIndex());
					aRec.modificar(rec);
					llenarTabla();
					aRec.grabarArchivo();
				} else mensaje("No existe codigo");
			} catch (Exception e) {
				mensaje("Llene correctamento el codigo");
			}	
		} else mensaje("Llene todos los campos");
	}
	
	void eliminar(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Recepcionista r = aRec.buscar(getCodigo());
				if ( r != null){
					aRec.eliminar(r);
					llenarTabla();
					aRec.grabarArchivo();
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
		}else{
			if(!txtCodigo.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty())
				return true;
		}		
		return false;
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		buscarData();
	}
	void buscarData(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Recepcionista r = aRec.buscar(getCodigo());
				if(r != null){
					txtApellido.setText(r.getApellidoRecepcionista());
					txtNombre.setText(r.getNombreRecepcionista());
					txtTelefono.setText(r.getTelefonoRecepcionista());
					cboEstado.setSelectedIndex(r.getEstadoRecepcionista());
				}else 
					mensaje("No hay Recepcionista con ese código");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else mensaje("Ingrese código");
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodigo) {
			do_txtCodigo_keyTyped(e);
		}
	}
	protected void do_txtCodigo_keyTyped(KeyEvent e) {
		char car = e.getKeyChar();
		if((car<'0' || car>'9'))e.consume();
	}
}