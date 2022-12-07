import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal {
	
	public static String eleccion;
	
	public static void main(String[] args) {
	    JFrame frame = new JFrame("Selecciona Conversor");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 300);
	    frame.setLocation(500, 100);

	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

	    frame.add(panel);

	    JLabel lbl = new JLabel("Selecciona conversión a realizar y presiona el botón");
	    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    //lbl.setVisible(true); // Not needed

	    panel.add(lbl);

	    String[] choices = { "Conversor de Monedas", "Conversor de Temperatura", "Conversor de Peso"};

	    final JComboBox<String> cb = new JComboBox<String>(choices);

	    cb.setMaximumSize(cb.getPreferredSize()); // added code
	    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
	    //cb.setVisible(true); // Not needed
	    panel.add(cb);

	    JButton btn = new JButton("Continuar");
	    btn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
	    panel.add(btn);

	    frame.setVisible(true); // added code
	    
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion = (String) cb.getSelectedItem();
				//elegir(eleccion);
				if(eleccion == "Conversor de Monedas") {
					ConversorMoneda conversorMoneda = new ConversorMoneda("Conversor de Monedas");
					conversorMoneda.initialize();
					
				}else if(eleccion == "Conversor de Temperatura"){
					ConversorTemperatura conversorTemperatura = new ConversorTemperatura("Conversor de Temperatura");
					conversorTemperatura.initialize();
				}else if(eleccion == "Conversor de Peso"){
					ConversorPeso conversorPeso = new ConversorPeso("Conversor de Peso");
					conversorPeso.initialize();
				}
			}
		});
		

	}
	
	

}




