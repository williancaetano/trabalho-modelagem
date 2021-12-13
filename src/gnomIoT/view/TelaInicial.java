package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gnomIoT.entities.GnomIoT;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial {

	private JFrame frame;
	private int WIDTH = 360;
	private int HEIGHT = 640;
	private static GnomIoT gnomiot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial(gnomiot);
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
	public TelaInicial(GnomIoT _gnomiot) {
		initialize();
		gnomiot = _gnomiot;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer?");
		lblOQueDeseja.setBounds(98, 194, 164, 15);
		frame.getContentPane().add(lblOQueDeseja);
		
		JButton btnEntrarEmResidencia = new JButton("Entrar em residência");
		btnEntrarEmResidencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaResidencias telaResidencias = new TelaResidencias(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				telaResidencias.main(null);
			}
		});
		btnEntrarEmResidencia.setBounds(53, 281, 231, 25);
		frame.getContentPane().add(btnEntrarEmResidencia);
		
		JButton btnCriarResidencia = new JButton("Criar residência");
		btnCriarResidencia.setBounds(53, 318, 231, 25);
		frame.getContentPane().add(btnCriarResidencia);
		
		JButton btnConfiguracoes = new JButton("Configurações");
		btnConfiguracoes.setBounds(53, 355, 231, 25);
		frame.getContentPane().add(btnConfiguracoes);
		
		JLabel lblBemVindo = new JLabel("Bem vindo!");
		lblBemVindo.setBounds(134, 103, 128, 15);
		frame.getContentPane().add(lblBemVindo);
	}

}
