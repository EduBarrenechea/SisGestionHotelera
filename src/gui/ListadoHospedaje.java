package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.*;
import controlador.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ListadoHospedaje extends JDialog implements ActionListener {
	
	ArregloReserva aRes = new ArregloReserva();
	ArregloCliente aCli = new ArregloCliente();
	ArregloRecepcionista aRec = new ArregloRecepcionista();
	ArregloHabitacion aHab = new ArregloHabitacion();
	ArregloHospedaje aHos = new ArregloHospedaje();
	DateFormat f = DateFormat.getDateInstance(DateFormat.MEDIUM);

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private final JTextArea txtS = new JTextArea();
	private JButton btnCerrar;
	private JButton btnListar;
	private JComboBox cboListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoHospedaje dialog = new ListadoHospedaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoHospedaje() {
		setTitle("Listado de Hospedajes");
		setBounds(100, 100, 765, 499);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(457, 45, 91, 23);
			contentPanel.add(btnCerrar);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 353, 729, 62);
		contentPanel.add(scrollPane);
		txtS.setEditable(false);
		
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(457, 11, 89, 23);
		contentPanel.add(btnListar);
		
		cboListar = new JComboBox();
		cboListar.setBounds(267, 12, 180, 20);
		contentPanel.add(cboListar);
		listarHospedajes();
	}
	
	void listarHospedajes(){
		imprimir("Codigo\tReserva\tCliente\tHabitacion\tRecepcionista\tTipo\tFechaRegistro\tEstado");
		for (int i = 0; i < aHos.tama�o() ; i++) {
			Hospedaje h = aHos.obtener(i);
			String codRe="--";
			if(h.getCodReserva() != -1)
				codRe=String.valueOf(h.getCodReserva());
			imprimir(
					rellenar(String.valueOf(h.getCodHospedaje()))+"\t"+
					rellenar(codRe)+"\t"+
					rellenar(obtenerCliente(h.getCodCliente()))+"\t"+
					rellenar(String.valueOf(h.getCodHabitacion()))+"\t"+
					rellenar(obtenerRecepcionista(h.getCodRecepcionista()))+"\t"+
					rellenar(h.getTipo())+"\t"+
					rellenar(h.getFechaRegistroHospedaje())+"\t"+
					rellenar(h.getEstado())
					);
		}
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
	
	String obtenerCliente(int cod){
		return (aCli.buscar(cod)).getApellidoCliente();
	}
	
	String obtenerRecepcionista(int cod){
		return (aRec.buscar(cod)).getApellidoRecepcionista();
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
