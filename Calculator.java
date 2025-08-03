import javax.swing.*;
import java.awt.event.*;
public class Calculator
{
    public static void main(String[] args) 
    {
        // Create frame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Text field to display input/output
        JTextField textField = new JTextField();
        textField.setBounds(30, 40, 230, 30);
        frame.add(textField);
        // Create buttons
        JButton bAdd = new JButton("+");
        JButton bSub = new JButton("-");
        JButton bMul = new JButton("*");
        JButton bDiv = new JButton("/");
        JButton bEq = new JButton("=");
        JButton bClr = new JButton("C");
        bAdd.setBounds(40, 100, 50, 40);
        bSub.setBounds(100, 100, 50, 40);
        bMul.setBounds(160, 100, 50, 40);
        bDiv.setBounds(220, 100, 50, 40);
        bEq.setBounds(100, 160, 50, 40);
        bClr.setBounds(160, 160, 50, 40);
        // Add buttons
        frame.add(bAdd);
        frame.add(bSub);
        frame.add(bMul);
        frame.add(bDiv);
        frame.add(bEq);
        frame.add(bClr);
        // Action listeners
        final double[] num = new double[1];
        final String[] operator = new String[1];
        bAdd.addActionListener(new ActionListener(){
            public void ActionPerformed(ActionEvent e){
            num[0] = Double.parseDouble(textField.getText());
            operator[0] = "+";
            textField.setText("");
            }
        });
        bSub.addActionListener(new ActionListener(){
            public void ActionPerformed(ActionEvent e){
            num[0] = Double.parseDouble(textField.getText());
            operator[0] = "-";
            textField.setText("");
            }
        });
        bMul.addActionListener(new ActionListener(){
            public void ActionPerformed(ActionEvent e){
            num[0] = Double.parseDouble(textField.getText());
            operator[0] = "*";
            textField.setText("");
            }  });
        bDiv.addActionListener(new ActionListener(){
            public void ActionPerformed(ActionEvent e){
            num[0] = Double.parseDouble(textField.getText());
            operator[0] = "/";
            textField.setText("");
            }});
        bEq.addActionListener(new ActionListener(){
            public void ActionPerformed(ActionEvent e){
            double result = 0;
            double secondNum = Double.parseDouble(textField.getText());
            switch (operator[0])
            {
                case "+": result = num[0] + secondNum; break;
                case "-": result = num[0] - secondNum; break;
                case "*": result = num[0] * secondNum; break;
                case "/": 
                    if (secondNum != 0)
                        result = num[0] / secondNum;
                    else
                        textField.setText("Error: Divide by 0");
                    break;
            }
            if (!operator[0].equals("/") || secondNum != 0)
                textField.setText(String.valueOf(result));
        }});
        bClr.addActionListener(e -> textField.setText(""));
        // Show frame
        frame.setVisible(true);
    }

}
