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
import gnomIoT.entities.Residencia;
import gnomIoT.entities.TipoDispositivo;

public class TelaDispositivos {
	private JFrame frame;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblMeusDispositivos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDispositivos window = new TelaDispositivos(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaDispositivos(GnomIoT _gnomiot) {
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
		
		lblMeusDispositivos = new JLabel("      Meus Dispostivos:");
		lblMeusDispositivos.setBounds(0, 58, 334, 23);
		lblMeusDispositivos.setToolTipText("");
		lblMeusDispositivos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeusDispositivos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMeusDispositivos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMeusDispositivos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 11, 84, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					gnomiot.setComodoAtual(null);
					
					TelaComodos telaComodos = new TelaComodos(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					telaComodos.main(null);
			}
		});
		contentPane.add(btnVoltar);
		
		Comodo comodoAtual = gnomiot.getComodoAtual();
		ArrayList<Dispositivo> dispositivos = comodoAtual.getDispositivos();
		
		//ArrayList<JButton> btnsComodos = new ArrayList<JButton>();
		int espacamento = 0;
		
		for(Dispositivo dispositivo : dispositivos) {
			JButton tmp = new JButton(dispositivo.getNome());
			tmp.setBounds((int) xBtn,100 + espacamento,(int) wBtn, (int) hBtn);

			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						gnomiot.setDispositivoAtual(dispositivo);
						// fecha janela atual
						frame.dispose();
						if (dispositivo.getTIPO().equals(TipoDispositivo.ARCONDICIONADO)) {
							TelaArCondicionado telaDispositivo = new TelaArCondicionado(gnomiot);
							// abre a proxima
							telaDispositivo.main(null);
						}
						else {
							TelaDispositivo telaDispositivo = new TelaDispositivo(gnomiot);
							// abre a proxima
							telaDispositivo.main(null);

						}	
				}
			});
			
			//btnsComodos.add(tmp);
			
			frame.getContentPane().add(tmp);
			espacamento += (int) hBtn;
		}
	}

	public Rectangle getlblMeusDispositivoslBounds() {
		return lblMeusDispositivos.getBounds();
	}
	public void setlblMeusDispositivoslBounds(Rectangle bounds) {
		lblMeusDispositivos.setBounds(bounds);
	}
}
