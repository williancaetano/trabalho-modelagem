package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaCadastro {

	private JFrame frame;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	// proporções das caixas de texto
	private double wTxt = WIDTH * 0.8;
	private double hTxt = HEIGHT * 0.05;
	private JTextField txtNome;
	private JPasswordField pwdSenha;
	private JTextField txtEmail;
	private JPasswordField pwdConfirmarsenha;
	
	//proporções labels
	//preguiça
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
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
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(36, 99, 70, 15);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setText("");
		txtNome.setBounds(36, 115, (int) wTxt, (int) hTxt);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(36, 217, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("");
		pwdSenha.setBounds(36, 232, (int) wTxt, (int) hTxt);
		frame.getContentPane().add(pwdSenha);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.setBounds(79, 504, 199, 25);
		frame.getContentPane().add(btnCadastrarse);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(36, 173, 288, 32);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 158, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblConfirmarsenha = new JLabel("Confirmar Senha");
		lblConfirmarsenha.setBounds(36, 275, 199, 15);
		frame.getContentPane().add(lblConfirmarsenha);
		
		pwdConfirmarsenha = new JPasswordField();
		pwdConfirmarsenha.setText("");
		pwdConfirmarsenha.setBounds(36, 290, 288, 32);
		frame.getContentPane().add(pwdConfirmarsenha);
	}
	
	public void centralize() {
		
	}
}
