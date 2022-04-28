import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equalButton, delButton, clearButton;
	JPanel panel;
	
	Font myFont = new Font("Deathknell ",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		frame =new JFrame("Calculator");
		//this allows us to close out of the program and then a size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame dot set size
		frame.setSize(420, 550);
		// frame set layout
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalButton = new JButton("=");
		delButton = new JButton("Delete");
		clearButton = new JButton("C");
		// Action listener
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clearButton;
	    //  For loop function buttons that's going to loop eight times 
		for(int i =0;i<8;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			
		}
		 //  For loop number buttons that's going to loop ten times
		for(int i =0;i<10;i++) {
			 numberButtons[i]= new JButton(String.valueOf(i));
			 numberButtons[i].addActionListener(this);
			 numberButtons[i].setFont(myFont);
			 numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50, 430, 145, 50);
		clearButton.setBounds(205, 430, 145, 50);
		// insert all of the elements into the panel
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout( 4,4,10,10));
		panel.setBackground(Color.black);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton); 
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equalButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clearButton);
		frame.add(textfield);
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		
        Calculator calc = new Calculator();
        


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource()== numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1= Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1= Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1= Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1= Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()==equalButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result = num1+num2;
				break;
			case'-':
				result = num1-num2;
				break;
			case'*':
				result = num1*num2;
				break;
			case'/':
				result = num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		//clearing
		if(e.getSource()==clearButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}  
		
	}

	public double add(double a, double b) {
		  return a + b;
		 }
		 
		 public double sub(double a, double b) {
		  return a - b;
		 }
		 
		 public double mul(double a, double b) {
		  return a * b;
		 }
		 
		 public double div(double a, double b) { 
		  if(b == 0) {
		   throw new ArithmeticException();
		  }
		  return a / b;
		 }

}
