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

public class ConversorTemperatura extends JFrame {
	
//////
//////ATRIBUTOS//////
//////
	private static final long serialVersionUID = 1L;
	JTextField jtTemperaturaBase;
	JTextField jtResultado;
	
//////
//////CONSTRUCTOR//////
//////
	public ConversorTemperatura(String title) {
		super(title);
	}
	public ConversorTemperatura() {
		
	}
	
//////
//////MÉTODOS//////
//////
	
	/**
	 * Inicializa la ventana con sus componentes
	 * */
	public void initialize() {
		
		JLabel jpTemperaturaBase = new JLabel("Ingrese °C");
		jtTemperaturaBase = new JTextField();
		
		JLabel jpResultado = new JLabel("Resultado en °F");
		jtResultado = new JTextField();
		jtResultado.setEditable(false);
		
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertir();
			}
		});
		
		
		JPanel jpForm = new JPanel();
		jpForm.setLayout(new GridLayout(5, 2, 10, 5));
		jpForm.setBackground(new java.awt.Color(175, 178, 203));
		jpForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
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
		jpMainPanel.setBackground(new java.awt.Color(175, 178, 203));
		jpMainPanel.setBorder(BorderFactory.createMatteBorder(30, 24, 24, 24, new java.awt.Color(227, 229, 244)));
		
		jpMainPanel.add(jpForm, BorderLayout.NORTH);
		jpMainPanel.add(btnClear, BorderLayout.SOUTH);
		
		add(jpMainPanel);
		
		
		setSize(500, 400);
		setMinimumSize(new Dimension(450, 400));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Convierte una temperatura de °C a °F y la muestra en el contenedor del resultado
	 */
		void convertir() {
		
		if(SoloNumeros.contieneSoloNumeros(jtTemperaturaBase.getText())) {
			double cantTemperaturaBase = Integer.parseInt(jtTemperaturaBase.getText());
			
			//String objConsulta = (String)((Object) cantMonedaBase).getClass().getSimpleName();
			
			if(cantTemperaturaBase <= 0 ) {
				JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida por favor!");
				return;
			}
			
			//Fórmula (0 °C × 9/5) + 32 = 32 °F
			double cantResultado = (cantTemperaturaBase * 9 / 5) + 32;
			
			jtResultado.setText(String.format("%10.2f", cantResultado));
		}else {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida a convertir por favor!");
			return;
		}
		
		
	}
	
	/**
	 * Limpia el formulario para volver a convertir otro valor
	 */
	void clearInputs() {
		jtTemperaturaBase.setText("");
		jtResultado.setText("");
	}

	
}
