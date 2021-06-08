import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class calgui implements ActionListener {
	
	JFrame frame;
	JMenuBar menubar;
	JMenu file;
	JMenuItem clear;
	JMenuItem exit;
	JMenu edit;
	JMenuItem copy;
	JMenuItem paste;
	JMenu his;
	JMenuItem exp;
	JMenuItem imp;
	JTextField textField;
	JTextField secondField;
	JTextField answerField;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMul, btnDiv, btnEq, btnClr, btnDel, btnDot, btnMplus, btnMminus, btnMrec, btnMemcl;
	JComboBox<String>  operations;	
	String input = "" ;
	String input2 = "";
	String answer = "" ;
	String error = "Error";
	String[] ops = {"","+", "-", "*", "/"}; 
	String value = "";
	String copied ="";
	int isFirst = 0;
	double memory = 0;
		
	public calgui() {
		
		// main frame
		frame = new JFrame("Calculator on Steroids");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(370, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		// menubar
		menubar= new JMenuBar();
		file = new JMenu("File"); 
		clear = new JMenuItem("Clear");
		exit = new JMenuItem("Exit");
		edit = new JMenu("Edit");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		his = new JMenu("History"); 
		exp =  new JMenuItem("Export to Text");
		imp = new JMenuItem("Import to Text");
		
		// adding the things to the menubar
		file.add(clear);
		clear.addActionListener(this);
		file.add(exit);
		exit.addActionListener(this);
		menubar.add(file);
		edit.add(copy);
		copy.addActionListener(this);
		edit.add(paste);
		paste.addActionListener(this);
		menubar.add(edit);
		his.add(exp);
		exp.addActionListener(this);
		his.add(imp);
		imp.addActionListener(this);
		menubar.add(his);
		frame.setJMenuBar(menubar);
				
		// operation drop-down menu
		operations= new JComboBox<String>(ops);
		operations.setBounds(145, 30, 55, 30);
		operations.setSelectedIndex(0);
		operations.addActionListener(this);
				
		// text field
		textField = new JTextField();
		textField.setBounds(40, 30, 90, 30);
		
		secondField = new JTextField();
		secondField.setBounds(215, 30, 90, 30);		
				
		answerField = new JTextField();
		answerField.setEditable(false);
		answerField.setBounds(40, 380, 270, 30);	
		
		// button 1
		btn1 = new JButton("1");
		btn1.setBounds(40, 240, 55, 40);
		btn1.addActionListener(this);
		
		// button 2
		btn2 = new JButton("2");
		btn2.setBounds(110, 240, 55, 40);
		btn2.addActionListener(this);
		
		// button 3
		btn3 = new JButton("3");
		btn3.setBounds(180, 240, 55, 40);
		btn3.addActionListener(this);
		
		// button 4
		btn4 = new JButton("4");
		btn4.setBounds(40, 170, 55, 40);
		btn4.addActionListener(this);
		
		// button 5
		btn5 = new JButton("5");
		btn5.setBounds(110, 170, 55, 40);
		btn5.addActionListener(this);
		
		// button 6
		btn6 = new JButton("6");
		btn6.setBounds(180, 170, 55, 40);
		btn6.addActionListener(this);
		
		// button 7
		btn7 = new JButton("7");
		btn7.setBounds(40, 100, 55, 40);
		btn7.addActionListener(this);
		
		// button 8
		btn8 = new JButton("8");
		btn8.setBounds(110, 100, 55, 40);
		btn8.addActionListener(this);
		
		// button 9
		btn9 = new JButton("9");
		btn9.setBounds(180, 100, 55, 40);
		btn9.addActionListener(this);
		
		// button 0
		btn0 = new JButton("0");
		btn0.setBounds(110, 310, 55, 40);
		btn0.addActionListener(this);
		
		// button .
		btnDot = new JButton(".");
		btnDot.setBounds(40, 310, 55, 40);
		btnDot.addActionListener(this);
	
		// button +
		btnAdd = new JButton("+");
		btnAdd.setBounds(250, 310, 55, 40);
		btnAdd.addActionListener(this);
		
		// button -
		btnSub = new JButton("-");
		btnSub.setBounds(250, 240, 55, 40);
		btnSub.addActionListener(this);
				
		// button =
		btnEq = new JButton("=");
		btnEq.setBounds(180, 310, 55, 40);
		btnEq.addActionListener(this);
		
		// button Clear
		btnClr = new JButton("Clr");
		btnClr.setBounds(250, 170, 55, 40);
		btnClr.addActionListener(this);
		
		// button Delete
		btnDel = new JButton("Del");
		btnDel.setBounds(250, 100, 55, 40);
		btnDel.addActionListener(this);
		
		// button Mplus
		btnMplus = new JButton("M+");
		btnMplus.setBounds(40, 75, 55, 20);
		btnMplus.addActionListener(this);
		
		// button Mminus
		btnMminus = new JButton("M-");
		btnMminus.setBounds(110, 75, 55, 20);
		btnMminus.addActionListener(this);
		
		//button Mrec
		btnMrec = new JButton("Mr");
		btnMrec.setBounds(180, 75, 55, 20);
		btnMrec.addActionListener(this);
		
		//button Memcl
		btnMemcl = new JButton("Mc");
		btnMemcl.setBounds(250, 75, 55, 20);
		btnMemcl.addActionListener(this);
		
		textField.addFocusListener((FocusListener) new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {				
				isFirst = 0;
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Do nothing								
			}
		});
		
		secondField.addFocusListener((FocusListener) new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				isFirst = 1;
			}
			@Override
			public void focusLost(FocusEvent e) {
				//Do nothing
			}
		});
		
		frame.add(textField);
		frame.add(secondField);
		frame.add(answerField);
		frame.add(btn0);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(btn5);
		frame.add(btn6);
		frame.add(btn7);
		frame.add(btn8);
		frame.add(btn9);
		frame.add(btn0);
		frame.add(btnDot);
		frame.add(btnAdd);
		frame.add(btnSub);
		frame.add(btnEq);
		frame.add(btnDel);
		frame.add(btnClr);
		frame.add(btnMemcl);
		frame.add(btnMplus);
		frame.add(btnMminus);
		frame.add(btnMrec);
		frame.add(btnMemcl);
		frame.add(operations);
	}
	
	public static void main(String[] args) {
		new calgui();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn0) {
			if (isFirst == 0) { 
				input = textField.getText();
				input = input.concat("0");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("0");
				secondField.setText(input2);	
			}	
		}
		if (e.getSource() == btn1) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("1");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("1");
				secondField.setText(input2);	
			}	
		}
		if (e.getSource() == btn2) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("2");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("2");
				secondField.setText(input2);	
			}	
		}
		if (e.getSource() == btn3) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("3");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("3");
				secondField.setText(input2);	
			}		
		}
		if (e.getSource() == btn4) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("4");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("4");
				secondField.setText(input2);	
			}
		}
		if (e.getSource() == btn5) {
			if (isFirst == 0) { 
				input = textField.getText();
				input = input.concat("5");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("5");
				secondField.setText(input2);	
			}
		}
		if (e.getSource() == btn6) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("6");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("6");
				secondField.setText(input2);	
			}
		}
		if (e.getSource() == btn7) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("7");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("7");
				secondField.setText(input2);	
			}	
		}
		if (e.getSource() == btn8) {
			if (isFirst == 0) { 
				input = textField.getText();
				input = input.concat("8");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("8");
				secondField.setText(input2);	
			}
		}
		if (e.getSource() == btn9) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat("9");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat("9");
				secondField.setText(input2);	
			}
		}
		if (e.getSource() == btnDot) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = input.concat(".");
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = input2.concat(".");
				secondField.setText(input2);	
			}
		}
		if (e.getSource() == btnAdd) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = ("+").concat(input);
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = ("+").concat(input2);
				secondField.setText(input2);	
			}	
		}
		if (e.getSource() == btnSub) {
			if (isFirst == 0) {  
				input = textField.getText();
				input = ("-").concat(input);
				textField.setText(input);		
			}
			else {
				input2 = secondField.getText();
				input2 = ("-").concat(input2);
				secondField.setText(input2);	
			}	
		}
		if (e.getSource() == btnDel) {			
			if (isFirst == 0) {  
				if (input == "") {
                // do nothing
				} else {
					input = textField.getText();
					input = input.substring(0, input.length() - 1);
					textField.setText(input);
				}
			} else {
				if (input2 == "") {
	                // do nothing
					} else {
						input2 = secondField.getText();
						input2 = input2.substring(0, input2.length() - 1);
						secondField.setText(input2);		
				}
			}					
		}
		if (e.getSource( )== btnClr) {			
			input="";
			textField.setText(input);									
            input2 = "";
            secondField.setText(input2);
            answerField.setText("");
		}		
		if (e.getSource() == btnMplus) {
			try {
				memory = memory +  Double.parseDouble(answerField.getText());
			} catch (Exception err) {
				// Do nothing	
			}
		}
		if (e.getSource() == btnMminus) {
			try {
				memory = memory - Double.parseDouble(answerField.getText());
			} catch (Exception err) {
				// Do nothing	
			}
		}
		if (e.getSource() == btnMrec) {
			answerField.setText(Double.toString(memory));
		}
		if (e.getSource() == btnMemcl) {
			memory = 0.0;
		}
		if (e.getSource() == operations) {
			value = operations.getSelectedItem().toString();
		}
		if (e.getSource() == btnEq) {
			input = textField.getText();
			input2= secondField.getText();		
			answer = eval(input, input2, value);
			answerField.setText(answer);
		}
		if (e.getSource() == clear) {
			input="";
			input2="";
			answerField.setText("");
			textField.setText("");
			secondField.setText("");
		}
		if (e.getSource() == exit) {
			frame.dispose();			
		}
		if (e.getSource() == copy) {
			copied=answerField.getText();			
		}
		if (e.getSource() == paste) {
			if (isFirst == 0) {
				input = copied;
				textField.setText(input);
			}
			if (isFirst == 1)
			{				
				input2 = copied; 
				secondField.setText(input2);
			}
		}
		if (e.getSource() == exp) {
			answerField.setText("Unimplemented feature");			
		}
		if (e.getSource() == imp) {
			answerField.setText("Unimplemented feature");			
		}		
	}// Action formed
	
	public static String eval(String x, String y, String operation) {
		double num1, num2;
		num1 = 0.0;
		num2 = 0.0;
		double sagot = 0.0; 
		
		if (x != "") {
			try {
			 num1 = Double.parseDouble(x); 	
			 
			} catch (Exception e) {
				return "Syntax Error";
			}
		}
		if (y != "") {
			try {
				 num2 = Double.parseDouble(y); 	
				 
				} catch (Exception e) {
					return "Syntax Error";
				}
		}
			
		switch (operation) {
			case "+":
				sagot = num1 + num2;
				return Double.toString(sagot);
			case "-":
				sagot = num1 - (num2);
				return Double.toString(sagot);
			case "*":
				sagot = num1 * num2;
				return Double.toString(sagot);
			case "/":
				sagot = num1 / num2;
				return Double.toString(sagot);
			default:
				return ""; 
								
		}
		
	}

}

	
