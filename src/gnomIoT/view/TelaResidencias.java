package gnomIoT.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class TelaResidencias {

	private JFrame frame;
	private static GnomIoT gnomiot;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaResidencias window = new TelaResidencias(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaResidencias(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/*
	 * 
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem vindo, " + gnomiot.getUsuarioLogado().getNome() + "!");
		lblBemVindo.setBounds(91, 42, 181, 15);
		frame.getContentPane().add(lblBemVindo);
		

		//ArrayList<JButton> btnsResidencias = new ArrayList<JButton>();
		int espacamento = 0;
		for(Residencia residencia : gnomiot.listaDeResidencias()) {
			
			JButton tmp = new JButton(residencia.getNome());
			tmp.setBounds((int) xBtn,100 + espacamento,(int) wBtn, (int) hBtn);
			
			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						gnomiot.setResidenciaAtual(residencia);
						
						TelaComodos telaComodo = new TelaComodos(gnomiot);
						
						// fecha janela atual
						frame.dispose();
						
						// abre a proxima
						telaComodo.main(null);
				}
			});
			frame.getContentPane().add(tmp);
			espacamento += (int) hBtn;
			//btnsResidencias.add(tmp);
			
		}
	}
}
