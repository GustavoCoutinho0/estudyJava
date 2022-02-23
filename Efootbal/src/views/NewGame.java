package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import program.centroTreinamentoController;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewGame extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGame frame = new NewGame();
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
	public NewGame() {
		setTitle("Efootbal (Beta)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 636, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNomeTime = new JTextField();
		textNomeTime.setToolTipText("Nome do Time");
		textNomeTime.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeTime.setBounds(77, 35, 483, 27);
		contentPane.add(textNomeTime);
		textNomeTime.setColumns(10);
		
		JLabel lblLogoTime = new JLabel("");
		lblLogoTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoTime.setIcon(new ImageIcon(NewGame.class.getResource("/imagens/baixados.png")));
		lblLogoTime.setBounds(184, 72, 265, 204);
		contentPane.add(lblLogoTime);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewGame.this.setVisible(false);
				centroTreinamentoController centro = new centroTreinamentoController();
				centro.abrirCentroTreinamento(textNomeTime.getText(), lblLogoTime.getIcon());				
			};
		});
		btnConfirmar.setBounds(262, 317, 113, 21);
		contentPane.add(btnConfirmar);
	}
}
