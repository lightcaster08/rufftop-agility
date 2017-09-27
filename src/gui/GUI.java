package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.RooftopAgility;
import data.Data;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox vbox;
	private JLabel label;
	public boolean running;
	public enum agilityCourses {
		SELECT,
		DRAYNOR,
		ALKHARID,
		VARROCK,
		CANIFIS,
		FALADOR,
		SEERS,
		POLLNIVNEACH,
		RELLEKKA,
		ARDOUGNE;
		
		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}
	
	public GUI() {
		setTitle("Rufftop Agility");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 150);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox comboBox = new JComboBox(agilityCourses.values()); 
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString() != null) {
					RooftopAgility.data = new Data(comboBox.getSelectedItem().toString(), vbox.isSelected());
				}
			}
		});
		
		JButton btnStartScript = new JButton("Start Script");
		btnStartScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				running = false;
				dispose();
			}
		});
		
		btnStartScript.setBounds(10, 80, 150, 25);
		contentPane.add(btnStartScript);
		
		label = new JLabel("Select a course:");
		label.setBounds(10, 0, 150, 20);
		contentPane.add(label);
		
		comboBox.setBounds(10, 20, 100, 20);
		contentPane.add(comboBox);
		
		vbox = new JCheckBox();
		vbox.setText("Debug");
		vbox.setBounds(10, 50, 100, 20);
		vbox.setSelected(true);
		contentPane.add(vbox);

		running = true;
		setVisible(true);
	}
}