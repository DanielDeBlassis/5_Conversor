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

public class ConversorPeso extends JFrame {
	JTextField jtPesoBase;
	JTextField jtResultado;
	
	public void initialize() {
		
		JLabel jpTemperaturaBase = new JLabel("Ingrese peso en Kilogramos");
		jtPesoBase = new JTextField();
		
		JLabel jpResultado = new JLabel("Resultado en Libras");
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
		jpForm.add(jtPesoBase);
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

	/**
	 * Convierte una valor peso expresado en Kg a Libras
	 */
	void convertir() {
		
		if(jtPesoBase.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad a convertir por favor!");
			return;
		}
		
		double cantPesoBase = Integer.parseInt(jtPesoBase.getText());
		
		//String objConsulta = (String)((Object) cantMonedaBase).getClass().getSimpleName();
		
		if(cantPesoBase <= 0 ) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida por favor!");
			return;
		}
		
		//Fórmula: para obtener un resultado aproximado, multiplica el valor de masa por 2.205
		double cantResultado = cantPesoBase * 2.205;
		
		jtResultado.setText(String.format("%10.2f", cantResultado));
	}
	
	/**
	 * Limpia el formulario para volver a convertir otro valor
	 */
	void clearInputs() {
		jtPesoBase.setText("");
		jtResultado.setText("");
	}

}
