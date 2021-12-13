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

import gnomIoT.entities.Comodo;
import gnomIoT.entities.Dispositivo;
import gnomIoT.entities.GnomIoT;
import javax.swing.JToggleButton;

public class TelaDispositivo {
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
					TelaDispositivo window = new TelaDispositivo(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaDispositivo(GnomIoT _gnomiot) {
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
		
		Dispositivo dispositivo = gnomiot.getDispositivoAtual();
		
		JButton btnLigaDesliga = new JButton(estado2String(dispositivo.getEstado()));
		btnLigaDesliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispositivo.alterarEstado();
					btnLigaDesliga.setText(estado2String(dispositivo.getEstado()));
			}
		});
		btnLigaDesliga.setBounds(138, 238, 89, 23);
		contentPane.add(btnLigaDesliga);
		
	}
	public String estado2String(boolean a) {
		if (!a) return "Ligar";
		else return "Desligar";
	}

	public Rectangle getlblMeusDispositivoslBounds() {
		return lblNomeDispositivo.getBounds();
	}
	public void setlblMeusDispositivoslBounds(Rectangle bounds) {
		lblNomeDispositivo.setBounds(bounds);
	}
}
