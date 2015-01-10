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

public class MantenimientoCliente extends JDialog implements ItemListener, ActionListener {

	ArregloCliente aCli = new ArregloCliente();
	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpcion,lblCodigo,lblApellido,lblNombre,lblTelefono,lblEstado;
	private JComboBox cboOpcion,cboEstado;
	private JTextField txtCodigo,txtApellido,txtNombre,txtTelefono;
	private JButton btnProcesar,btnLimpiar;
	private JLabel label;
	private JScrollPane scrollPane;
	private JTextArea txtS;

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
		setTitle("Mantenimiento de Clientes");
		setBounds(100, 100, 524, 555);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 488, 320);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
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
			break;
		case 1:
			btnProcesar.setEnabled(true);
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			txtCodigo.setEditable(false);
			lblApellido.setVisible(true);
			txtApellido.setVisible(true);
			lblNombre.setVisible(true);
			txtNombre.setVisible(true);
			lblTelefono.setVisible(true);
			txtTelefono.setVisible(true);
			lblEstado.setVisible(false);
			cboEstado.setVisible(false);
			txtCodigo.setText(""+aCli.generaCodigo());
			txtApellido.requestFocus();
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
			if(aCli.tamaño()>0){
				listar();
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
			if(aCli.tamaño()>0){
				listar();
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
		case 5:listar();break;

		default:
			break;
		}
	}
	void ingresar(){
		int cod;
		if(validarVacio()){
			try {
				cod = getCodigo();
				Cliente c = aCli.buscar(cod);
				if(c==null){
					c = new Cliente(getCodigo(), getApellido(), getNombre(), getTelefono(), 1);
					aCli.creacion(c);
					listar();
					limpiar();
					aCli.grabarArchivo();
					txtCodigo.setText(""+aCli.generaCodigo());
					txtApellido.requestFocus();
				}else mensaje("Codigo ya existe intento con otro");
				
			} catch (Exception e) {
				mensaje("Código incorrecto");
				txtCodigo.setText(""+aCli.generaCodigo());
				txtApellido.requestFocus();
			}
		}
		else mensaje("Llene todos los Campos");
		
	}
	
	void listar(){
		txtS.setText("");
		imprimir("Codigo\tApellido\tNombre\tTelefono\tEstado");
		for (int i = 0; i < aCli.tamaño(); i++) {
			Cliente c = aCli.obtener(i);			
			imprimir(rellenar(String.valueOf(c.getCodCliente()))+"\t"+
					 rellenar(c.getApellidoCliente())+"\t"+
					 rellenar(c.getNombreCliente())+"\t"+
					 rellenar(c.getTelefonoCliente())+"\t"+
					 c.getEstado()
					);
			
		}
	}
	
	void listar(Cliente c){
		txtS.setText("");
		imprimir("Código\t:  "+String.valueOf(c.getCodCliente()));
		imprimir("Apellido\t:  "+c.getApellidoCliente());
		imprimir("Nombre\t  :"+c.getNombreCliente());
		imprimir("Telefono\t  :"+c.getTelefonoCliente());
		imprimir("Estado\t  :"+c.getEstado());
	}
	
	void buscar(){
		if(!txtCodigo.getText().isEmpty()){
			try {
				Cliente c = aCli.buscar(getCodigo());
				if(c != null)
					listar(c);			
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
					listar();
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
					listar();
				}else mensaje("Código no existe");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else
			mensaje("Escriba un código");
	}
	boolean validarVacio(){
		if(!txtCodigo.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty())
			return true;
		return false;
	}
	
	void imprimir(String cad){
		txtS.append(cad + "\n");
	}
	
	String rellenar(String cad){
		int longitud=cad.length();
		for(int i=longitud; i<10; i++)
			cad+=' ';
		return cad;
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
}