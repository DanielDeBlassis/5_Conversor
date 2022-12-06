import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ConversorTemperatura extends JFrame {
	
	JTextField jtTemperaturaBase;
	JTextField jtResultado;
	
	public void initialize() {
		
		JLabel jpTemperaturaBase = new JLabel("Ingrese �C");
		jtTemperaturaBase = new JTextField();
		
		JLabel jpResultado = new JLabel("Resultado en �F");
		jtResultado = new JTextField();
		
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertir();
			}
		});
		
		
		JPanel jpForm = new JPanel();
		jpForm.setLayout(new GridLayout(5, 2, 10, 5));
		
		jpForm.add(jpTemperaturaBase);
		jpForm.add(jtTemperaturaBase);
		jpForm.add(jpResultado);
		jpForm.add(jtResultado);
		
		jpForm.add(btnConvertir);
		
		JButton btnClear = new JButton("Borrar");
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputs();
			}
		});
		
		JPanel jpMainPanel = new JPanel();
		jpMainPanel.setLayout(new BorderLayout(10, 10));
		
		jpMainPanel.add(jpForm, BorderLayout.NORTH);		
		jpMainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 50));
		
		jpMainPanel.add(btnClear, BorderLayout.SOUTH);
		
		add(jpMainPanel);
		
		
		
		
		setSize(500, 400);
		setMinimumSize(new Dimension(450, 400));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
