package edu.tecjerez.topicos.vista;

import javax.swing.*;

import edu.tecjerez.topicos.figuras.d2.*;
import edu.tecjerez.topicos.figuras.d2.*;
import edu.tecjerez.topicos.figuras.d3.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ras implements ActionListener {
	VentanaInicio v;
	public Ras(VentanaInicio b) {
		v=b;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(v.comboFiguras.getSelectedItem() == null) return;
		
		v.txtNum1.setVisible(true);
		v.txtNum2.setVisible(true);
		
		v.cajaNum1.setVisible(true);
		v.cajaNum2.setVisible(true);
		
		v.cajaNum1.setText("");
		v.cajaNum2.setText("");
		
		switch(v.comboFiguras.getSelectedItem().toString()) {
		
		case "Circulo":
			v.txtNum1.setText("Radio del círculo: ");
			v.txtNum2.setVisible(false);
			v.cajaNum2.setVisible(false);
			break;

		case "Elipse":
			v.txtNum1.setText("diametro menor del elipse: ");
			v.txtNum2.setText("diametro mayor del elipse: ");
			break;
			
		case "Rombo":
			v.txtNum1.setText("distancia menor del rombo: ");
			v.txtNum2.setText("distancia mayor del rombo: ");
			
			break;
		
		case "Cono":
			v.txtNum1.setText("Altura del cono: ");
			v.txtNum2.setText("Radio del cono: ");
			
			break;
			
		case "Piramide":
			v.txtNum1.setText("longitud de los lados de la piramide: ");
			v.txtNum2.setText("Altura de la piramide: ");
			break;
		}
	}
	
}
class rasResolver implements ActionListener {
	VentanaInicio v;
	public rasResolver(VentanaInicio b) {
		v=b;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
		double num1 = 0;
		double num2 = 0;
		double num3 = 0;
		try {
			if(v.cajaNum1.isVisible()) num1 = Double.parseDouble(v.cajaNum1.getText());
			if(v.cajaNum2.isVisible()) num2 = Double.parseDouble(v.cajaNum2.getText());
			
		
			v.txtRes1.setVisible(true);
			v.cajaRes1.setVisible(true);
			
			v.txtRes2.setVisible(true);		
			v.cajaRes2.setVisible(true);
		}catch (NumberFormatException e1) {
			e1.printStackTrace();
			return;
		}
		Conico L = new Conico();
		
		switch(v.comboFiguras.getSelectedItem().toString()) {
		
		case "Circulo":
			v.cir = L.new Circulo(num1); //por que
			v.txtRes1.setText("perimetro del Circulo: ");
			v.cajaRes1.setText(""+v.cir.obtenerPerimetro());
			
			v.txtRes2.setText("Area del Circulo: ");
			v.cajaRes2.setText(""+v.cir.obtenerArea());
			break;

		case "Elipse":
			v.eli = L.new Elipse(num1, num2);
			v.txtRes1.setText("perimetro de la Elipse: ");
			v.cajaRes1.setText(""+v.eli.obtenerPerimetro());
			
			v.txtRes2.setText("Area de la Elipse: ");
			v.cajaRes2.setText(""+v.eli.obtenerArea());
			break;
			
		case "Rombo":
			v.rom = new Poligono.Rombo(num1, num2);
			v.txtRes1.setText("perimetro del Rombo: ");
			v.cajaRes1.setText(""+v.rom.obtenerPerimetro());
			
			v.txtRes2.setText("Area del Rombo: ");
			v.cajaRes2.setText(""+v.rom.obtenerArea());
			break;
		
		case "Cono":
			v.con = new Voluminoso.Cono(num1, num2);
			
			v.txtRes1.setText("Volumen del Cono: ");
			v.cajaRes1.setText(""+v.con.obtenerVolumen());
			
			v.txtRes2.setVisible(false);		
			v.cajaRes2.setVisible(false);
			break;
			
		case "Piramide":
			v.pir = new Voluminoso.Piramide(num1, num2);
			v.txtRes1.setText("Volumen de la Piramide: ");
			v.cajaRes1.setText(""+v.pir.obtenerVolumen());
			
			v.txtRes2.setVisible(false);		
			v.cajaRes2.setVisible(false);
			break;
		}
	}
	
}

public class VentanaInicio extends JFrame implements ActionListener{
	
	protected Conico.Circulo cir;
	protected Conico.Elipse eli;
	protected Poligono.Rombo rom;
	
	protected Voluminoso.Cono con;
	protected Voluminoso.Piramide pir;
	
	private JRadioButton d2 = new JRadioButton("2D");
	private JRadioButton d3 = new JRadioButton("3D");
	
	private ButtonGroup btns = new ButtonGroup();
	JComboBox<String> comboFiguras = new JComboBox<String>();
	JLabel txtNum1 = new JLabel();
	JTextField cajaNum1 = new JTextField(5);
	
	JLabel txtNum2 = new JLabel();
	JTextField cajaNum2 = new JTextField(5);
	
	
	Ras rasEvento = new Ras(this);
	
	JLabel txtRes1 = new JLabel();
	JTextField cajaRes1 = new JTextField(5);
	
	JLabel txtRes2 = new JLabel();
	JTextField cajaRes2 = new JTextField(5);
	JButton btnCalcular = new JButton("Calcular");
	public VentanaInicio() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculador");
		setSize(470, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(new JLabel("Seleccione la dimenison de la figura"));
		btns.add(d2);
		btns.add(d3);
		d2.addActionListener(this);
		d3.addActionListener(this);
		add(d2);
		add(d3);
		
		comboFiguras.addActionListener(rasEvento);
		add(comboFiguras);
		
		add(txtNum1);
		add(cajaNum1);
		
		add(txtNum2);
		add(cajaNum2);
		
		txtNum1.setVisible(false);
		cajaNum1.setVisible(false);

		txtNum2.setVisible(false);
		cajaNum2.setVisible(false);
		
		
		txtRes1.setVisible(false);
		cajaRes1.setVisible(false);
		
		txtRes2.setVisible(false);		
		cajaRes2.setVisible(false);
		
		add(txtRes1);
		add2(cajaRes1, 200, 10);
		add(txtRes2);
		add2(cajaRes2, 200, 10);
		
		btnCalcular.setVisible(false);
		btnCalcular.addActionListener(new rasResolver(this));
		add(btnCalcular);
	}
	void add2(JComponent c, int w, int h){
		c.setBounds(0, 0, w, h);
		add(c);
	}
	
	public static void main(String[] args) {
		new VentanaInicio();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//cambio de dimension
		comboFiguras.removeAllItems();
		if(( (JRadioButton)e.getSource() ).equals(d2)) {
			comboFiguras.addItem("Circulo");
			comboFiguras.addItem("Elipse");
			comboFiguras.addItem("Rombo");
			//System.out.println("L");
			
		}else {
			comboFiguras.addItem("Cono");
			comboFiguras.addItem("Piramide");
			//System.out.println("C");
		}
		btnCalcular.setVisible(true);
	}
}

