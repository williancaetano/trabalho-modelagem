package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frame;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	// proporções das caixas de texto
	private double wTxt = WIDTH * 0.8;
	private double hTxt = HEIGHT * 0.05;
	private double xTxt = (WIDTH - wTxt)/2 ;
	private JTextField txtLogin;
	private double yTxtLogin = HEIGHT * 0.3;
	private double yTxtSenha = HEIGHT * 0.4;
	private JPasswordField pwdSenha;
	
	private static GnomIoT gnomiot;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin(new GnomIoT());
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
	public TelaLogin(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds((int) xTxt, 165, 70, 15);
		frame.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setText("");
		txtLogin.setBounds((int) xTxt, (int) yTxtLogin, (int) wTxt, (int) hTxt);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds((int) xTxt, 229, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("");
		pwdSenha.setBounds((int) xTxt, (int) yTxtSenha, (int) wTxt, (int) hTxt);
		frame.getContentPane().add(pwdSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Autenticação de usuário
				
				String login = txtLogin.getText();
				String senha = new String(pwdSenha.getPassword());
				
				Usuario usuario = gnomiot.autenticarUsuario(login, senha);
				
				if(usuario != null) {			
					
					TelaInicial telaInicial = new TelaInicial(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					telaInicial.main(null);
					
				} else {
					
					JOptionPane.showMessageDialog(null,"Dados incorretos!");
					
				}
			}
		});
		btnEntrar.setBounds(207, 336, 117, 25);
		frame.getContentPane().add(btnEntrar);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.setBounds(79, 504, 199, 25);
		frame.getContentPane().add(btnCadastrarse);
		
		JButton btnEsqueciASenha = new JButton("Esqueci a senha");
		btnEsqueciASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"tenta lembrar");
			}
		});
		btnEsqueciASenha.setBounds(79, 541, 199, 25);
		frame.getContentPane().add(btnEsqueciASenha);
	}
	
}
