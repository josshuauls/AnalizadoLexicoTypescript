package dlince;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.SystemColor;

public class GUIAnalizador {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAnalizador window = new GUIAnalizador();
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
	public GUIAnalizador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 715, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		JTextArea textArea2 = new JTextArea();
		textArea2.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea2.setForeground(new Color(0, 0, 139));
		textArea2.setEnabled(false);
		textArea2.setBackground(new Color(105, 105, 105));
		
		JButton btnNewButton1 = new JButton("EJECUTAR");
		btnNewButton1.setForeground(new Color(50, 205, 50));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expresion = textArea.getText();
				AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(expresion));
				try {
					lexico.yylex();
				} catch (IOException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}
				textArea2.setText(lexico.textoImpreso);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("ANALIZADOR LEXICO - TYPECRIPT");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnNewButton2 = new JButton("LIMPIAR");
		btnNewButton2.setForeground(new Color(255, 0, 0));
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea2.setText("");
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("By: jfloresch@ulasalle.edu.pe");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
							.addGap(66))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
							.addGap(38)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton1)
							.addGap(37)
							.addComponent(btnNewButton2)))
					.addGap(39))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(472, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton1)
								.addComponent(btnNewButton2))
							.addGap(23)
							.addComponent(textArea2, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
