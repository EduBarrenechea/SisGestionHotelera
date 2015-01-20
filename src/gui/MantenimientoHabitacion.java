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

import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.Habitacion;
import controlador.ArregloHabitacion;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JTable;

public class MantenimientoHabitacion extends JDialog implements ItemListener, ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpcion,lblNumero,lblDescripcion,lblTipo,lblUbicacion,lblCosto;
	private JComboBox cboOpcion,cboTipo;
	private JTextField txtNumero,txtDescripcion,txtCosto;
	private JButton btnProcesar,btnLimpiar;
	ArregloHabitacion aHab = new ArregloHabitacion();
	DecimalFormat sdf= new DecimalFormat("#,###.00");
	private JLabel lblParaAyudaColoque;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JComboBox cboUbicacion;
	private JButton btnCerrar;
	private JScrollPane scrollPane_1;
	private JTable tHabitacion;
	private JButton btnBuscar;
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
		setResizable(false);
		setTitle("Mantenimiento de Habitaci\u00F3n");
		setBounds(100, 100, 551, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblOpcion = new JLabel("Opci\u00F3n :");
		lblOpcion.setBounds(10, 11, 85, 14);
		contentPanel.add(lblOpcion);
		
		cboOpcion = new JComboBox();
		cboOpcion.setToolTipText("Seleccione operaci\u00F3n a realizar");
		cboOpcion.setBounds(105, 8, 216, 20);
		cboOpcion.addItem("--Seleccione Opcion--");
		cboOpcion.addItem("Ingresar Registro");
		cboOpcion.addItem("Busqueda por Codigo");
		cboOpcion.addItem("Actualizar Registro");
		cboOpcion.addItem("Eliminar Registro");
		cboOpcion.addItem("Listar");
		cboOpcion.addItemListener(this);
		contentPanel.add(cboOpcion);
		
		lblNumero = new JLabel("N\u00FAmero :");
		lblNumero.setBounds(10, 36, 70, 14);
		contentPanel.add(lblNumero);
		lblNumero.setVisible(false);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setToolTipText("Ingrese Numero de Habitaci\u00F3n");
		txtNumero.setBounds(105, 33, 86, 20);
		contentPanel.add(txtNumero);
		txtNumero.setColumns(10);
		txtNumero.setVisible(false);
		
		lblDescripcion = new JLabel("Descripci\u00F3n :");
		lblDescripcion.setBounds(10, 61, 96, 14);
		contentPanel.add(lblDescripcion);
		lblDescripcion.setVisible(false);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setToolTipText("Ingrese Descripci\u00F3n de la habitaci\u00F3n");
		txtDescripcion.setBounds(105, 58, 216, 20);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		txtDescripcion.setVisible(false);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(10, 86, 46, 14);
		contentPanel.add(lblTipo);
		lblTipo.setVisible(false);
		
		cboTipo = new JComboBox();
		cboTipo.setToolTipText("Seleccione Tipo de Habitaci\u00F3n");
		cboTipo.setBounds(105, 83, 160, 20);
		cboTipo.addItem("--Seleccione Tipo--");
		cboTipo.addItem("Doble");
		cboTipo.addItem("Matrimonial");
		cboTipo.addItem("Simple");
		contentPanel.add(cboTipo);
		cboTipo.setVisible(false);
		
		lblUbicacion = new JLabel("Ubicaci\u00F3n :");
		lblUbicacion.setBounds(10, 111, 70, 14);
		contentPanel.add(lblUbicacion);
		lblUbicacion.setVisible(false);
		
		lblCosto = new JLabel("Costo :");
		lblCosto.setBounds(10, 136, 46, 14);
		contentPanel.add(lblCosto);
		lblCosto.setVisible(false);		
		
		txtCosto = new JTextField();
		txtCosto.addKeyListener(this);
		txtCosto.setToolTipText("Ingrese en decimal");
		txtCosto.setBounds(105, 133, 86, 20);
		contentPanel.add(txtCosto);
		txtCosto.setColumns(10);
		txtCosto.setVisible(false);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setToolTipText("Procesa la operacion seleccionada");
		btnProcesar.setBounds(363, 7, 89, 23);
		btnProcesar.setEnabled(false);
		contentPanel.add(btnProcesar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setToolTipText("Limpia las cajas de texto");
		btnLimpiar.setBounds(363, 32, 89, 23);
		contentPanel.add(btnLimpiar);
		
		lblParaAyudaColoque = new JLabel("Para ayuda coloque el puntero sobre el elemento");
		lblParaAyudaColoque.setForeground(Color.BLUE);
		lblParaAyudaColoque.setBounds(201, 136, 312, 14);
		contentPanel.add(lblParaAyudaColoque);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(10, 161, 46, 14);
		lblEstado.setVisible(false);
		contentPanel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(105, 158, 118, 20);
		cboEstado.addItem("--Seleccione--");
		cboEstado.addItem("Disponible"); 
		cboEstado.addItem("Reservada");
		cboEstado.addItem("Ocupada");
		cboEstado.setVisible(false);
		contentPanel.add(cboEstado);
		
		cboUbicacion = new JComboBox();
		cboUbicacion.setBounds(105, 108, 118, 20);
		cboUbicacion.addItem("-- Seleccione --");
		cboUbicacion.addItem("Edificio A");
		cboUbicacion.addItem("Edificio B");
		cboUbicacion.addItem("Edificio C");
		cboUbicacion.setVisible(false);
		contentPanel.add(cboUbicacion);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(363, 57, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 186, 515, 304);
		contentPanel.add(scrollPane_1);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(200, 32, 76, 23);
		btnBuscar.setVisible(false);
		contentPanel.add(btnBuscar);
		
		tHabitacion = new JTable();
		
		

	}

	

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboOpcion)
			seleccionar();		
	}
	
	void seleccionar(){
		switch (cboOpcion.getSelectedIndex()) {
		case 0:
			btnProcesar.setEnabled(false);
			lblNumero.setVisible(false);
			txtNumero.setVisible(false);
			lblDescripcion.setVisible(false);
			txtDescripcion.setVisible(false);
			lblTipo.setVisible(false);
			cboTipo.setVisible(false);
			lblUbicacion.setVisible(false);
			cboUbicacion.setVisible(false);
			lblCosto.setVisible(false);
			txtCosto.setVisible(false);
			cboEstado.setVisible(false);
			lblEstado.setVisible(false);
			btnBuscar.setVisible(false);
			break;
	
		case 1:
				btnProcesar.setEnabled(true);
				txtDescripcion.requestFocus();
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				txtNumero.setEditable(false);
				lblDescripcion.setVisible(true);
				txtDescripcion.setVisible(true);
				lblTipo.setVisible(true);
				cboTipo.setVisible(true);
				lblUbicacion.setVisible(true);
				cboUbicacion.setVisible(true);
				lblCosto.setVisible(true);
				txtCosto.setVisible(true);
				txtNumero.setText(""+aHab.generaCodigo());
				lblEstado.setVisible(false);
				cboEstado.setVisible(false);
				btnBuscar.setVisible(false);
				break;
		case 2:
				btnProcesar.setEnabled(true);
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				txtNumero.setEditable(true);
				txtNumero.requestFocus();
				lblDescripcion.setVisible(false);
				txtDescripcion.setVisible(false);
				lblTipo.setVisible(false);
				cboTipo.setVisible(false);
				lblUbicacion.setVisible(false);
				cboUbicacion.setVisible(false);
				lblCosto.setVisible(false);
				txtCosto.setVisible(false);
				cboEstado.setVisible(false);
				lblEstado.setVisible(false);
				btnBuscar.setVisible(false);
				if(aHab.tamaño()>0){
					llenarTabla();
					btnProcesar.setEnabled(true);
				}else{
					btnProcesar.setEnabled(false);
				}
				break;
		case 3:
				btnProcesar.setEnabled(true);
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				txtNumero.requestFocus();
				txtNumero.setEditable(true);
				lblDescripcion.setVisible(true);
				txtDescripcion.setVisible(true);
				lblTipo.setVisible(true);
				cboTipo.setVisible(true);
				lblUbicacion.setVisible(true);
				cboUbicacion.setVisible(true);
				lblCosto.setVisible(true);
				txtCosto.setVisible(true);
				cboEstado.setVisible(true);
				lblEstado.setVisible(true);
				btnBuscar.setVisible(true);
				if(aHab.tamaño()>0){
					llenarTabla();
					btnProcesar.setEnabled(true);
				}else{
					btnProcesar.setEnabled(false);
				}
				break;
		case 4:
				btnProcesar.setEnabled(true);
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				txtNumero.setEditable(true);
				txtNumero.requestFocus();
				lblDescripcion.setVisible(false);
				txtDescripcion.setVisible(false);
				lblTipo.setVisible(false);
				cboTipo.setVisible(false);
				lblUbicacion.setVisible(false);
				cboUbicacion.setVisible(false);
				lblCosto.setVisible(false);
				txtCosto.setVisible(false);
				cboEstado.setVisible(false);
				lblEstado.setVisible(false);
				btnBuscar.setVisible(false);
				if(aHab.tamaño()>0){
					llenarTabla();
					btnProcesar.setEnabled(true);
				}else{
					btnProcesar.setEnabled(false);
				}
				break;
			case 5:
				btnProcesar.setEnabled(true);
				lblNumero.setVisible(false);
				txtNumero.setVisible(false);
				lblDescripcion.setVisible(false);
				txtDescripcion.setVisible(false);
				lblTipo.setVisible(false);
				cboTipo.setVisible(false);
				lblUbicacion.setVisible(false);
				cboUbicacion.setVisible(false);
				lblCosto.setVisible(false);
				txtCosto.setVisible(false);
				cboEstado.setVisible(false);
				lblEstado.setVisible(false);
				btnBuscar.setVisible(false);
				break;
		}
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
	void limpiar(){
		txtNumero.setText("");
		txtDescripcion.setText("");
		cboTipo.setSelectedItem(0);
		cboUbicacion.setSelectedIndex(0);
		txtCosto.setText("");
		txtNumero.requestFocus();
	}
	protected void do_btnProcesar_actionPerformed(ActionEvent arg0) {
		procesar();
	}
	
	void procesar() {
		switch(cboOpcion.getSelectedIndex()) {
			case 1 : ingresar(); break;				
			case 2 : buscar(); break;				
			case 3 : actualizar();break;			
			case 4 : eliminar(); break;				
			case 5 : llenarTabla(); break;			
		}
	}
	
	int getNumero(){return Integer.parseInt(txtNumero.getText());}
	String getDescripcion(){return txtDescripcion.getText();}
	int getTipo(){return cboTipo.getSelectedIndex();}
	int getUbicacion(){return cboUbicacion.getSelectedIndex();}
	double getCosto(){return Double.parseDouble(txtCosto.getText());}
	int getEstado(){return cboEstado.getSelectedIndex();}
	
	void ingresar(){
		
		if(validarVacio()){
			try {
					Habitacion h = new Habitacion(aHab.generaCodigo(), getDescripcion(), getTipo(), getUbicacion(), getCosto(), 1);
					aHab.creacion(h);
					llenarTabla();
					limpiar();
					aHab.grabarArchivo();
					txtNumero.setText(""+aHab.generaCodigo());
					txtDescripcion.requestFocus();				
			} catch (Exception e) {
				mensaje("Número de Habitación incorrecto");
				txtNumero.setText(""+aHab.generaCodigo());
				txtDescripcion.requestFocus();
			}

		}else mensaje("Llene todos los campos");
	}
	
	void buscar(){
		if(!txtNumero.getText().isEmpty()){
			try {
				Habitacion h = aHab.buscar(getNumero());
				if(h != null)
					llenarTabla(h);			
				else 
					mensaje("No hay habitación con ese código");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else mensaje("Ingrese código");
	}
	void actualizar(){
		if(validarVacio()){
			Habitacion h = new Habitacion(getNumero(), getDescripcion(), getTipo(), getUbicacion(), getCosto(), getEstado());			
			aHab.modificar(h);
			llenarTabla();
			aHab.grabarArchivo();				
		}else mensaje("Llene todos los campos");
	}
	void eliminar(){
		
		if(!txtNumero.getText().isEmpty()){
			try {
				Habitacion h = aHab.buscar(getNumero());
				if ( h != null){
					aHab.eliminar(h);
					llenarTabla();
					aHab.grabarArchivo();
				}else mensaje("Código no existe");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else
			mensaje("Escriba un código");		
		}
	
	void mostrarTabla(String[][] informacion){
		String titulos[] = {"Número","Descripción","Tipo","Ubicacion","Costo","Estado"};
		tHabitacion = new JTable(informacion, titulos);
		tHabitacion.setEnabled(false);
		tHabitacion.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane_1.setViewportView(tHabitacion);
	}
	
	void llenarTabla(){
		String informacion[][] = new String[aHab.tamaño()][6];
		for(int i = 0 ; i<aHab.tamaño();i++){
			Habitacion h = aHab.obtener(i);
			informacion[i][0] = h.getNumHabitacion()+"";
			informacion[i][1] = h.getDesHabitacion();
			informacion[i][2] = h.getTipo();
			informacion[i][3] = h.getUbicacion();
			informacion[i][4] = sdf.format((h.getCostoHabitacion()))+"";
			informacion[i][5] = h.getEstado();
		}
		mostrarTabla(informacion);
	}
	
	void llenarTabla(Habitacion h){
		String informacion[][] = new String[1][6];
		informacion[0][0] = h.getNumHabitacion()+"";
		informacion[0][1] = h.getDesHabitacion();
		informacion[0][2] = h.getTipo();
		informacion[0][3] = h.getUbicacion();
		informacion[0][4] = sdf.format((h.getCostoHabitacion()))+"";
		informacion[0][5] = h.getEstado();
		mostrarTabla(informacion);
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	
	boolean validarVacio(){
		if(!txtNumero.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && cboTipo.getSelectedIndex()>0 && cboUbicacion.getSelectedIndex()>0 && !txtCosto.getText().isEmpty())
			return true;
		return false;
	}
	
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCosto) {
			do_txtCosto_keyTyped(e);
		}
		if (e.getSource() == txtNumero) {
			do_txtNumero_keyTyped(e);
		}
	}
	protected void do_txtNumero_keyTyped(KeyEvent e) {
		char car = e.getKeyChar();
		if((car<'0' || car>'9'))e.consume();
	}
	protected void do_txtCosto_keyTyped(KeyEvent e) {
		char car = e.getKeyChar();
		if ((car<'0' || car>'9') && car != '.') e.consume();
		if(car == '.' && txtCosto.getText().contains("."))e.consume();
		
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
		if(!txtNumero.getText().isEmpty()){
			Habitacion h = aHab.buscar(getNumero());
			if(h!=null){
				txtDescripcion.setText(h.getDesHabitacion());
				cboTipo.setSelectedIndex(h.getTipoHabitacion());
				cboUbicacion.setSelectedIndex(h.getUbicacionHabitacion());
				txtCosto.setText(String.valueOf(h.getCostoHabitacion()));
				cboEstado.setSelectedIndex(h.getEstadoHabitacion());
			}else mensaje("No hay habitación con ese Número");
		}else mensaje("Numero de Habitacion Vacio");
	}
}
