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
		mntmClienteM.addActionListener(this);
		mnMantenimiento.add(mntmClienteM);
		
		mntmRecepcionistaM = new JMenuItem("Recepcionista");
		mntmRecepcionistaM.addActionListener(this);
		mnMantenimiento.add(mntmRecepcionistaM);
		
		mnReservaYHospedaje = new JMenu("Reserva");
		menuBar.add(mnReservaYHospedaje);
		
		mntmIngresoReserva = new JMenuItem("Ingreso");
		mntmIngresoReserva.addActionListener(this);
		mnReservaYHospedaje.add(mntmIngresoReserva);
		
		mntmAnulacionReserva = new JMenuItem("Anulacion");
		mntmAnulacionReserva.addActionListener(this);
		mnReservaYHospedaje.add(mntmAnulacionReserva);
		
		mntmListadoReserva = new JMenuItem("Listado");
		mntmListadoReserva.addActionListener(this);
		mnReservaYHospedaje.add(mntmListadoReserva);
		
		mnHospedaje = new JMenu("Hospedaje");
		menuBar.add(mnHospedaje);
		
		mntmIngresoHospedaje = new JMenuItem("Ingreso");
		mntmIngresoHospedaje.addActionListener(this);
		mnHospedaje.add(mntmIngresoHospedaje);
		
		mntmAnulacionHospedaje = new JMenuItem("Anulacion");
		mntmAnulacionHospedaje.addActionListener(this);
		mnHospedaje.add(mntmAnulacionHospedaje);
		
		mntmListadoHospedaje = new JMenuItem("Listado");
		mntmListadoHospedaje.addActionListener(this);
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
		if (arg0.getSource() == mntmAnulacionHospedaje) {
			do_mntmAnulacionHospedaje_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmListadoHospedaje) {
			do_mntmListadoHospedaje_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmIngresoHospedaje) {
			do_mntmIngresoHospedaje_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmAnulacionReserva) {
			do_mntmAnulacionReserva_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmListadoReserva) {
			do_mntmListadoReserva_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmIngresoReserva) {
			do_mntmIngresoReserva_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmRecepcionistaM) {
			do_mntmRecepcionistaM_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmClienteM) {
			do_mntmClienteM_actionPerformed(arg0);
		}
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
		mHab.setModal(true);
		mHab.setVisible(true);
	}
	protected void do_mntmClienteM_actionPerformed(ActionEvent arg0) {
		MantenimientoCliente mCli = new MantenimientoCliente();
		mCli.setModal(true);
		mCli.setVisible(true);			
	}
	protected void do_mntmRecepcionistaM_actionPerformed(ActionEvent arg0) {
		MantenimientoRecepcionista mRec = new MantenimientoRecepcionista();
		mRec.setModal(true);
		mRec.setVisible(true);
	}
	protected void do_mntmIngresoReserva_actionPerformed(ActionEvent arg0) {
		IngresoReserva iRes = new IngresoReserva();
		iRes.setModal(true);
		iRes.setVisible(true);
	}
	protected void do_mntmListadoReserva_actionPerformed(ActionEvent arg0) {
		ListadoReserva lRes = new ListadoReserva();
		lRes.setModal(true);
		lRes.setVisible(true);
	}
	protected void do_mntmAnulacionReserva_actionPerformed(ActionEvent arg0) {
		AnularReserva aRes = new AnularReserva();
		aRes.setModal(true);
		aRes.setVisible(true);
	}
	protected void do_mntmIngresoHospedaje_actionPerformed(ActionEvent arg0) {
		IngresoHospedaje iHos = new IngresoHospedaje();
		iHos.setModal(true);
		iHos.setVisible(true);
	}
	protected void do_mntmListadoHospedaje_actionPerformed(ActionEvent arg0) {
		ListadoHospedaje lHos = new ListadoHospedaje();
		lHos.setModal(true);
		lHos.setVisible(true);
	}
	protected void do_mntmAnulacionHospedaje_actionPerformed(ActionEvent arg0) {
		AnularHospedaje aHos = new AnularHospedaje();
		aHos.setModal(true);
		aHos.setVisible(true);
	}
}
