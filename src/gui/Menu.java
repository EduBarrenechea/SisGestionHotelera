package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnReservaYHospedaje;
	private JMenu mnReportes;
	private JMenu mnAyuda;
	private JMenu mnHospedaje;
	private JMenuItem mntmHabitacionM;
	private JMenuItem mntmClienteM;
	private JMenuItem mntmRecepcionistaM;
	private JMenuItem mntmIngresoReserva;
	private JMenuItem mntmListadoReserva;
	private JMenuItem mntmAnulacionReserva;
	private JMenuItem mntmIngresoHospedaje;
	private JMenuItem mntmAnulacionHospedaje;
	private JMenuItem mntmListadoHospedaje;
	private JMenuItem mntmAcerca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Sistema Gesti\u00F3n Hotelera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmHabitacionM = new JMenuItem("Habitacion");
		mntmHabitacionM.addActionListener(this);
		mnMantenimiento.add(mntmHabitacionM);
		
		mntmClienteM = new JMenuItem("Cliente");
		mnMantenimiento.add(mntmClienteM);
		
		mntmRecepcionistaM = new JMenuItem("Recepcionista");
		mnMantenimiento.add(mntmRecepcionistaM);
		
		mnReservaYHospedaje = new JMenu("Reserva");
		menuBar.add(mnReservaYHospedaje);
		
		mntmIngresoReserva = new JMenuItem("Ingreso");
		mnReservaYHospedaje.add(mntmIngresoReserva);
		
		mntmAnulacionReserva = new JMenuItem("Anulacion");
		mnReservaYHospedaje.add(mntmAnulacionReserva);
		
		mntmListadoReserva = new JMenuItem("Listado");
		mnReservaYHospedaje.add(mntmListadoReserva);
		
		mnHospedaje = new JMenu("Hospedaje");
		menuBar.add(mnHospedaje);
		
		mntmIngresoHospedaje = new JMenuItem("Ingreso");
		mnHospedaje.add(mntmIngresoHospedaje);
		
		mntmAnulacionHospedaje = new JMenuItem("Anulacion");
		mnHospedaje.add(mntmAnulacionHospedaje);
		
		mntmListadoHospedaje = new JMenuItem("Listado");
		mnHospedaje.add(mntmListadoHospedaje);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcerca = new JMenuItem("Acerca");
		mnAyuda.add(mntmAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmHabitacionM) {
			do_mntmHabitacionM_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(arg0);
		}
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
			System.exit(0);
	}
	protected void do_mntmHabitacionM_actionPerformed(ActionEvent arg0) {
		MantenimientoHabitacion mHab = new MantenimientoHabitacion();
		mHab.setVisible(true);
	}
}
