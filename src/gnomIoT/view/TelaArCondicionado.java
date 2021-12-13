package gnomIoT.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gnomIoT.entities.ArCondicionado;
import gnomIoT.entities.Comodo;
import gnomIoT.entities.Dispositivo;
import gnomIoT.entities.GnomIoT;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class TelaArCondicionado {
	private JFrame frame;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblNomeDispositivo;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaArCondicionado window = new TelaArCondicionado(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaArCondicionado(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, WIDTH,HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNomeDispositivo = new JLabel(gnomiot.getDispositivoAtual().getNome());
		lblNomeDispositivo.setBounds(0, 58, 334, 23);
		lblNomeDispositivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDispositivo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNomeDispositivo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 11, 84, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					gnomiot.setDispositivoAtual(null);
					
					TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					telaDispositivos.main(null);
			}
		});
		contentPane.add(btnVoltar);	
		
		ArCondicionado dispositivo = (ArCondicionado) gnomiot.getDispositivoAtual();
		
		
		
		JSpinner spinnerTemperatura = new JSpinner();
		spinnerTemperatura.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				dispositivo.alterarTemperatura((int) spinnerTemperatura.getValue());
			}
		});
		spinnerTemperatura.setModel(new SpinnerNumberModel(dispositivo.getTemperatura(),(Comparable) dispositivo.getMin(), (Comparable) dispositivo.getMax(), 1));
		
		
		spinnerTemperatura.setBounds(211, 287, 44, 23);
		contentPane.add(spinnerTemperatura);
		
		JLabel lblTemperaturaAtual = new JLabel("Temperatura Atual: ");
		lblTemperaturaAtual.setBounds(96, 291, 105, 14);
		contentPane.add(lblTemperaturaAtual);
		
		invisivel(dispositivo.getEstado(), spinnerTemperatura, lblTemperaturaAtual);
		
		JButton btnLigaDesliga = new JButton(estado(dispositivo.getEstado()));
		btnLigaDesliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispositivo.alterarEstado();
					btnLigaDesliga.setText(estado(dispositivo.getEstado()));
					invisivel(dispositivo.getEstado(), spinnerTemperatura, lblTemperaturaAtual);
					spinnerTemperatura.setValue(dispositivo.getTemperatura());
			}
		});
		btnLigaDesliga.setBounds(136, 256, 89, 23);
		contentPane.add(btnLigaDesliga);
		
	}
	public String estado(boolean a) {
		if (!a) return "Ligar";
		else return "Desligar";
	}
	public void invisivel(boolean a, JComponent ...componentes) {
		for (JComponent item : componentes) {
			item.setVisible(a);
		}
	}

	public Rectangle getlblMeusDispositivoslBounds() {
		return lblNomeDispositivo.getBounds();
	}
	public void setlblMeusDispositivoslBounds(Rectangle bounds) {
		lblNomeDispositivo.setBounds(bounds);
	}
}
