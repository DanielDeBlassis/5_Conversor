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
import javax.swing.WindowConstants;

public class ConversorMoneda extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtMonedaBase;
	JTextField jtResultado;
	
	public void initialize() {
		
		JLabel jpMonedaBase = new JLabel("Ingrese ARS$");
		jtMonedaBase = new JTextField();
		
		JLabel jpResultado = new JLabel("Resultado en USD$");
		jtResultado = new JTextField();
		
		
		
		

		String[] tiposConversion = { "Peso Argentino a Dï¿½lar", "Dï¿½lar a Peso Argentino", "Peso Argentino a Euro", "Euro a Peso Argentino", "Peso Argentino a Libra", "Libra a Peso Argentino", "Peso Argentino a Yen Japonï¿½s", "Yen Japonï¿½s a Peso Argentino", "Peso Argentino a Won Surcoreano", "Won Surcoreano a Peso Argentino"};
		final JComboBox<String> operacion = new JComboBox<String>(tiposConversion);
		
		operacion.setMaximumSize(operacion.getPreferredSize()); // added code
	    operacion.setAlignmentX(Component.TOP_ALIGNMENT);// added code
	    
	    JLabel lbl = new JLabel("Seleccione la operaciï¿½n a realizar");
	    lbl.setAlignmentX(Component.TOP_ALIGNMENT);
	    
	    jpForm.add(lbl);
	    jpForm.add(operacion);
	    
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertir();
			}
		});
		
		
		JPanel jpForm = new JPanel();
		jpForm.setLayout(new GridLayout(5, 2, 10, 5));
		
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
	 * Convierte una cantidad de dinero de peso argentino a dólares
	 * a un valor fijo de 300 pesos por dólar
	 */
	void convertir() {
		
		if(jtMonedaBase.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad a convertir por favor!");
			return;
		}
		
		double cantMonedaBase = Integer.parseInt(jtMonedaBase.getText());
		
		//String objConsulta = (String)((Object) cantMonedaBase).getClass().getSimpleName();
		
		if(cantMonedaBase <= 0 ) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida por favor!");
			return;
		}
		
		
		double cantResultado = cantMonedaBase / 300;
		//String strResultado = String.valueOf(cantResultado);
		
		//jtResultado.setText(strResultado);
		jtResultado.setText(String.format("%10.2f", cantResultado));
	}
	
	/**
	 * Limpia el formulario para volver a convertir otro monto
	 */
	void clearInputs() {
		jtMonedaBase.setText("");
		jtResultado.setText("");
	}

	
}
