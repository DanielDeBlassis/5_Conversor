import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversorMoneda extends JFrame {
	
//////
//////ATRIBUTOS//////
//////
	private static final long serialVersionUID = 1L;
	
	JTextField jtMonedaBase;
	JTextField jtResultado;
	
//////
//////CONSTRUCTORES//////
//////
	public ConversorMoneda(String title) {
		super(title);
	}
	public ConversorMoneda() {
	}
	
//////
//////MÉTODOS//////
//////
	
	/**
	 * Inicializa la ventana con sus componentes
	 * */
	public void initialize() {
		
		JLabel jpMonedaBase = new JLabel("Ingrese valor a convertir");
		jtMonedaBase = new JTextField();
		
		JLabel jpResultado = new JLabel("Resultado de la conversión");
		jtResultado = new JTextField();
		jtResultado.setEditable(false);
		
		
		JPanel jpForm = new JPanel();
		jpForm.setLayout(new GridLayout(5, 2, 10, 10));
		jpForm.setBackground(new java.awt.Color(175, 178, 203));
		//jpForm.setBorder(BorderFactory.createTitledBorder("Seleccione tipo de conversión"));
		jpForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		

		String[] tiposConversion = { "Peso Argentino a Dólar", "Dólar a Peso Argentino", "Peso Argentino a Euro", "Euro a Peso Argentino", "Peso Argentino a Libra", "Libra a Peso Argentino", "Peso Argentino a Yen Japonés", "Yen Japonés a Peso Argentino", "Peso Argentino a Won Surcoreano", "Won Surcoreano a Peso Argentino"};
		final JComboBox<String> operacion = new JComboBox<String>(tiposConversion);
		
		operacion.setMaximumSize(operacion.getPreferredSize()); // added code
	    operacion.setAlignmentX(Component.TOP_ALIGNMENT);// added code
	    
	    JLabel lbl = new JLabel("Seleccione la operación a realizar");
	    lbl.setAlignmentX(Component.TOP_ALIGNMENT);
	    
	    jpForm.add(lbl);
	    jpForm.add(operacion);
	    
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String operation = (String) operacion.getSelectedItem();
				convertir(operation);
			}
		});
		
		
		jpForm.add(jpMonedaBase);
		jpForm.add(jtMonedaBase);
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
	 * Convierte una cantidad de dinero según la opción seleccionada
	 * @param op parámetro de tipo String que corresponde a la opción elegida
	 */
	void convertir(String op) {
		
		if(SoloNumeros.contieneSoloNumeros(jtMonedaBase.getText())) {
			double cantMonedaBase = Integer.parseInt(jtMonedaBase.getText());
			
			if(cantMonedaBase <= 0 ) {
				JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida por favor!");
				return;
			}
			
			double cantResultado;
			
			switch(op) {
			case "Peso Argentino a Dólar":
				cantResultado = cantMonedaBase / 300;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Dólar a Peso Argentino":
				cantResultado = cantMonedaBase * 300;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Peso Argentino a Euro":
				cantResultado = cantMonedaBase / 200;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Euro a Peso Argentino":
				cantResultado = cantMonedaBase * 200;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Peso Argentino a Libra":
				cantResultado = cantMonedaBase / 210;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Libra a Peso Argentino":
				cantResultado = cantMonedaBase * 210;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Peso Argentino a Yen Japonés":
				cantResultado = cantMonedaBase / 1.5;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Yen Japonés a Peso Argentino":
				cantResultado = cantMonedaBase * 1.5;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Peso Argentino a Won Surcoreano":
				cantResultado = cantMonedaBase / 0.2;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
			case "Won Surcoreano a Peso Argentino":
				cantResultado = cantMonedaBase * 0.2;
				jtResultado.setText(String.format("%10.2f", cantResultado));
				break;
				default:
					System.out.println("Error! Vuelve a intentarlo.");
					break;
			}
			
		}else {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida a convertir por favor!");
			return;
		}
		
	}
	
	/**
	 * Limpia el formulario para volver a convertir otro monto
	 */
	void clearInputs() {
		jtMonedaBase.setText("");
		jtResultado.setText("");
	}

	
}
