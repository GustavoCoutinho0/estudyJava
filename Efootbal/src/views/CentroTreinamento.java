package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

public class CentroTreinamento extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] objtos = {
			{"Teste", "Teste", "terceira", "issoAi"},
			{"São Paulo", "Teste", "terceira", "issoAi"},
	};
	private DefaultTableModel tableModel = new DefaultTableModel(
			objtos,
			new String[] {
				"Nome", "Pontos", "Vitoria", "Teste"
			}
			);
	private String nomeExibir = "";
	
	


	public CentroTreinamento(String nomeTime) {
		setResizable(false);
		setTitle(nomeTime);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(nomeExibir.toString());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(251, 358, 233, 17);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 10, 610, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				tableModel);
		
		JButton btnAdd = new JButton("Nova Linha");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableModel.insertRow(
						0, new Object[] { "CSS" }
				);
				
			}
		});
		btnAdd.setBounds(25, 354, 116, 21);
		contentPane.add(btnAdd);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int column = 1;
					int row = table.getSelectedRow();
					nomeExibir = table.getModel().getValueAt(row, column).toString();
					lblNewLabel.setText(nomeExibir);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnMostrar.setBounds(25, 399, 116, 21);
		contentPane.add(btnMostrar);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(247, 409, 282, 11);
		progressBar.setIndeterminate(true);
		contentPane.add(progressBar);
	}
}
