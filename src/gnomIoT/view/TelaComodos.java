package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Component;

public class TelaComodos {

	private JFrame frame;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblMeusComodos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComodos window = new TelaComodos(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaComodos(GnomIoT _gnomiot) {
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
		
		lblMeusComodos = new JLabel("      Meus Cômodos:");
		lblMeusComodos.setBounds(0, 58, 334, 23);
		lblMeusComodos.setToolTipText("");
		lblMeusComodos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeusComodos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMeusComodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMeusComodos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 11, 84, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					gnomiot.setResidenciaAtual(null);
					
					TelaResidencias telaResidencias = new TelaResidencias(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					telaResidencias.main(null);
			}
		});
		contentPane.add(btnVoltar);
		
		Residencia residenciaAtual = gnomiot.getResidenciaAtual();
		ArrayList<Comodo> comodos = residenciaAtual.pegarPerfil(gnomiot.getUsuarioLogado()).getComodos();
		
		//ArrayList<JButton> btnsComodos = new ArrayList<JButton>();
		int espacamento = 0;
		
		for(Comodo comodo : comodos) {
			JButton tmp = new JButton(comodo.getNome());
			
			tmp.setBounds((int) xBtn,100 + espacamento,(int) wBtn, (int) hBtn);
			
			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						gnomiot.setComodoAtual(comodo);
						
						TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
						
						// fecha janela atual
						frame.dispose();
						
						// abre a proxima
						telaDispositivos.main(null);
				}
			});
			//btnsComodos.add(tmp);
			frame.getContentPane().add(tmp);
			espacamento += (int) hBtn;
		}
	}

	public Rectangle getLblMeusComodoslBounds() {
		return lblMeusComodos.getBounds();
	}
	public void setLblMeusComodoslBounds(Rectangle bounds) {
		lblMeusComodos.setBounds(bounds);
	}
}
