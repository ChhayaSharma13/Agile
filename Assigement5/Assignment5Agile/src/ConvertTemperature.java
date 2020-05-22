import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import JUnit.ConvertTemperatureTest;
import validate.ConvertTemperatureImpl;

public class ConvertTemperature {

	private JFrame frame;
	private JTextField celsiusTxt;
	private JTextField fahrenheitTxt;
	private ConvertTemperatureImpl impl = new ConvertTemperatureImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertTemperature window = new ConvertTemperature();
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
	public ConvertTemperature() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperature Converter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(102, 25, 243, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(72, 85, 86, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		celsiusTxt = new JTextField();
		
//		KeyListener for Celsius to only accept number values
		celsiusTxt.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_MINUS) || (c == KeyEvent.VK_PERIOD))) {
		      
		        e.consume();
		      }
		    }
		  });
		celsiusTxt.setBounds(156, 84, 207, 19);
		frame.getContentPane().add(celsiusTxt);
		celsiusTxt.setColumns(10);
		
		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFahrenheit.setBounds(72, 136, 86, 13);
		frame.getContentPane().add(lblFahrenheit);
		
		fahrenheitTxt = new JTextField();
		
//		KeyListener for Fahrenheit to only accept number values
		fahrenheitTxt.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE)  || (c == KeyEvent.VK_MINUS) || (c == KeyEvent.VK_PERIOD))){
		      
		        e.consume();
		      }
		    }
		  });
		fahrenheitTxt.setColumns(10);
		fahrenheitTxt.setBounds(156, 135, 207, 19);
		frame.getContentPane().add(fahrenheitTxt);
		
		JButton convertFahrenheitBtn = new JButton("Convert into Fahrenheit");
		convertFahrenheitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				// If textbox is empty 
				if(impl.checkEmptyInput(celsiusTxt.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "No value is entered");
					flag= false;
				}
				
				// if Value is out of valid range
				else if(impl.validateCelsius(celsiusTxt.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "Value should be in the range of -273.15 and 100");
					flag=false;
				}
				
				if(flag){
					double celsius = Double.parseDouble(celsiusTxt.getText());
					double fahrenheit = (celsius * 9 / 5) + 32;
					fahrenheitTxt.setText(""+fahrenheit);
				}
			}
		});

		convertFahrenheitBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		convertFahrenheitBtn.setBounds(102, 179, 226, 21);
		frame.getContentPane().add(convertFahrenheitBtn);
		
		JButton convertCelsiusBtn = new JButton("Convert into Celsius");
		convertCelsiusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				//Empty Textbox
			
				if(impl.checkEmptyInput(fahrenheitTxt.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "No value is entered");
					flag= false;
					
				}
				
				// Value out of range
				else if(impl.validateFahrenheit(fahrenheitTxt.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "Value should be in the range of -459.67 and 212");
					flag=false;
				}
				
				//Convert  to Fahrenheit
				if(flag) {
					double fahrenheit = Double.parseDouble(fahrenheitTxt.getText());	
					double celsius = (fahrenheit - 32) * 5 / 9;
					celsiusTxt.setText(""+celsius);
				}
			}
		});
		convertCelsiusBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		convertCelsiusBtn.setBounds(102, 218, 226, 21);
		frame.getContentPane().add(convertCelsiusBtn);
	}
}
