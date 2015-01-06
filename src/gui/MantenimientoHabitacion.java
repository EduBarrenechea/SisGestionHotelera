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

public class MantenimientoHabitacion extends JDialog implements ItemListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblOpcion,lblNumero,lblDescripcion,lblTipo,lblUbicacion,lblCosto;
	private JComboBox cboOpcion,cboTipo;
	private JTextField txtNumero,txtDescripcion,txtUbicacion,txtCosto;
	private JButton btnProcesar,btnLimpiar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	ArregloHabitacion aHab = new ArregloHabitacion();
	DecimalFormat sdf= new DecimalFormat("#,###.00");
	private JLabel lblParaAyudaColoque;
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
		
		txtUbicacion = new JTextField();
		txtUbicacion.setToolTipText("Ingrese en n\u00FAmeros");
		txtUbicacion.setBounds(105, 108, 86, 20);
		contentPanel.add(txtUbicacion);
		txtUbicacion.setColumns(10);
		txtUbicacion.setVisible(false);
		
		lblCosto = new JLabel("Costo :");
		lblCosto.setBounds(10, 136, 46, 14);
		contentPanel.add(lblCosto);
		lblCosto.setVisible(false);		
		
		txtCosto = new JTextField();
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 477, 290);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblParaAyudaColoque = new JLabel("Para ayuda coloque el puntero sobre el elemento");
		lblParaAyudaColoque.setForeground(Color.BLUE);
		lblParaAyudaColoque.setBounds(201, 136, 312, 14);
		contentPanel.add(lblParaAyudaColoque);
		

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
			txtUbicacion.setVisible(false);
			lblCosto.setVisible(false);
			txtCosto.setVisible(false);				
			break;
	
		case 1:
				btnProcesar.setEnabled(true);
				txtDescripcion.requestFocus();
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				lblDescripcion.setVisible(true);
				txtDescripcion.setVisible(true);
				lblTipo.setVisible(true);
				cboTipo.setVisible(true);
				lblUbicacion.setVisible(true);
				txtUbicacion.setVisible(true);
				lblCosto.setVisible(true);
				txtCosto.setVisible(true);
				txtNumero.setText(""+aHab.generaCodigo());
				break;
		case 2:
				btnProcesar.setEnabled(true);
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				txtNumero.requestFocus();
				lblDescripcion.setVisible(false);
				txtDescripcion.setVisible(false);
				lblTipo.setVisible(false);
				cboTipo.setVisible(false);
				lblUbicacion.setVisible(false);
				txtUbicacion.setVisible(false);
				lblCosto.setVisible(false);
				txtCosto.setVisible(false);
				if(aHab.tamaño()>0){
					listar();
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
				lblDescripcion.setVisible(true);
				txtDescripcion.setVisible(true);
				lblTipo.setVisible(true);
				cboTipo.setVisible(true);
				lblUbicacion.setVisible(true);
				txtUbicacion.setVisible(true);
				lblCosto.setVisible(true);
				txtCosto.setVisible(true);
				if(aHab.tamaño()>0){
					btnProcesar.setEnabled(true);
				}else{
					btnProcesar.setEnabled(false);
				}
				break;
		case 4:
				btnProcesar.setEnabled(true);
				lblNumero.setVisible(true);
				txtNumero.setVisible(true);
				txtNumero.requestFocus();
				lblDescripcion.setVisible(false);
				txtDescripcion.setVisible(false);
				lblTipo.setVisible(false);
				cboTipo.setVisible(false);
				lblUbicacion.setVisible(false);
				txtUbicacion.setVisible(false);
				lblCosto.setVisible(false);
				txtCosto.setVisible(false);
				if(aHab.tamaño()>0){
					listar();
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
				txtUbicacion.setVisible(false);
				lblCosto.setVisible(false);
				txtCosto.setVisible(false);				
				break;
		}
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
	void limpiar(){
		txtNumero.setText("");
		txtDescripcion.setText("");
		cboTipo.setSelectedItem(0);
		txtUbicacion.setText("");
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
			case 5 : listar(); break;			
		}
	}
	
	int getNumero(){return Integer.parseInt(txtNumero.getText());}
	String getDescripcion(){return txtDescripcion.getText();}
	int getTipo(){return cboTipo.getSelectedIndex();}
	int getUbicacion(){return Integer.parseInt(txtUbicacion.getText());}
	double getCosto(){return Double.parseDouble(txtCosto.getText());}
	
	void ingresar(){
		int num;
		if(validarVacio()){
			try {
				num = getNumero();
				Habitacion h = aHab.buscar(num);
				if(h==null){
					h = validarDatos();
					if(h!=null){
					aHab.creacion(h);
					listar();
					limpiar();
					txtNumero.setText(""+aHab.generaCodigo());
					txtDescripcion.requestFocus();
					}else mensaje("Ingrese correctamente los datos");
				}
				else 
					mensaje("Código ya existe, intente con otro");
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
					listar(h);			
				else 
					mensaje("No hay habitación con ese código");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else mensaje("Ingrese código");
	}
	void actualizar(){
		if(validarVacio()){
			Habitacion h = aHab.buscar(getNumero());
			if(h!=null){
				h= validarDatos();
				if(h!=null){
				aHab.modificar(h);
				listar();
				}else mensaje("Llene correctamente los campos");
			}
		}else mensaje("Llene todos los campos");
	}
	void eliminar(){
		
		if(!txtNumero.getText().isEmpty()){
			try {
				Habitacion h = aHab.buscar(getNumero());
				if ( h != null){
					aHab.eliminar(h);
					listar();
				}else mensaje("Código no existe");
			} catch (Exception e) {
				mensaje("Llena correctamente el código");
			}
		}else
			mensaje("Escriba un código");		
		}
	
	void listar(){
		txtS.setText("");
		imprimir("Número\tDescripcion\tTipo\tUbicación\tCosto");
		for (int i = 0; i < aHab.tamaño(); i++) {
			Habitacion h = aHab.obtener(i);
			imprimir(rellenar(String.valueOf(h.getNumHabitacion()))+"\t"+
					 rellenar(h.getDesHabitacion())+"\t"+
					 rellenar(h.getTipo())+"\t"+
					 rellenar(String.valueOf(h.getUbicacionHabitacion()))+"\t"+
					 sdf.format((h.getCostoHabitacion())));
		}
	}
	
	void listar(Habitacion h){
		txtS.setText("");

		imprimir("Número\t:  "+String.valueOf(h.getNumHabitacion()));
		imprimir("Descripción\t:  "+(h.getDesHabitacion()));
		imprimir("Tipo\t:  "+(h.getTipo()));
		imprimir("Ubicación\t:  "+(String.valueOf(h.getUbicacionHabitacion())));
		imprimir("Costo\t:  "+sdf.format((h.getCostoHabitacion())));
		
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
	
	boolean validarVacio(){
		if(!txtNumero.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && cboTipo.getSelectedIndex()>0 && !txtUbicacion.getText().isEmpty() && !txtCosto.getText().isEmpty())
			return true;
		return false;
	}
	
	Habitacion validarDatos(){
		Habitacion h = null;
		try {
			h= new Habitacion(getNumero(), getDescripcion(), getTipo(), getUbicacion(), getCosto());			
		} catch (Exception e) {
			
		}
		return h;
	}
}
