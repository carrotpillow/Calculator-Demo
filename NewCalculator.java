
// Zi Kay Yon | Dhara Shah | M/W 5:30 PM

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class NewCalculator extends JFrame implements ActionListener{

    // - - - Initializes frame and container - - -
    private static JFrame frame;
    private static Container container;

    // - - - Initializes textfield values - - -
    private static JTextField inputValues;

    // - - - Initializes JButton values - - -
    private static JButton zero, one, two, three, four, five, six, seven, eight, nine;
    private static JButton plus, minus, multiply, divide, equals;
    private static JButton dot, delete, clear;
    private static JButton factorial;

    String neutralInput = "", firstInput = "", secondInput = "";

    public static void main(String[] args) {

        // - - - Pulls Calculator method - - -
        new NewCalculator();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setSize(400, 400);

        // - - - Adds container to frame and sets size/resizability - - -
        frame.add(container);
        frame.setSize(400,500);
        frame.setResizable(false);
        frame.setVisible(true);

        inputValues.setBounds(30,40,280,30);
        seven.setBounds(40,100,50,40);
        eight.setBounds(110,100,50,40);
        nine.setBounds(180,100,50,40);
        divide.setBounds(250,100,50,40);

        four.setBounds(40,170,50,40);
        five.setBounds(110,170,50,40);
        six.setBounds(180,170,50,40);
        multiply.setBounds(250,170,50,40);

        one.setBounds(40,240,50,40);
        two.setBounds(110,240,50,40);
        three.setBounds(180,240,50,40);
        minus.setBounds(250,240,50,40);

        zero.setBounds(110,310,50,40);
        equals.setBounds(180,310,50,40);
        plus.setBounds(250,310,50,40);

        dot.setBounds(40,310,50,40);
        delete.setBounds(60,380,70,40); // Not used, but here for future upgrades
        clear.setBounds(155,380,70,40);
        factorial.setBounds(250, 380, 50, 40); // Not used, but here for future upgrades
    }

    public NewCalculator() {

        // - - - Sets Frame and container as well as container layout- - -
        frame = new JFrame("NEW Calculator");
        container = new Container();
        container.setLayout(new FlowLayout());

        // - - - Text field - - -
        inputValues = new JTextField(10);

        // - - - Sets button text - - -
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        factorial = new JButton("n"); // Not used, but here for future upgrades
        equals = new JButton("=");

        dot = new JButton(".");
        delete = new JButton("delete"); // Not used, but here for future upgrades
        clear = new JButton("clear");

        // - - - Adds text field to container - - -
        container.add(inputValues);

        // - - - Adds buttons to container - - -
        container.add(zero);
        container.add(one);
        container.add(two);
        container.add(three);
        container.add(four);
        container.add(five);
        container.add(six);
        container.add(seven);
        container.add(eight);
        container.add(nine);

        container.add(plus);
        container.add(minus);
        container.add(multiply);
        container.add(divide);
        container.add(factorial); // Not used, but here for future upgrades
        container.add(equals);

        container.add(dot);
        container.add(delete); // Not used, but here for future upgrades
        container.add(clear);

        // Adds action listeners
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        factorial.addActionListener(this); // Not used, but here for future upgrades
        equals.addActionListener(this);

        dot.addActionListener(this);
        delete.addActionListener(this); // Not used, but here for future upgrades
        clear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {

        // - - - Holds the input value - - -
        String source = event.getActionCommand();

        // - - - if statement for number input values or dot - - -
        if(source.charAt(0) >= '0' && source.charAt(0) <= '9' || source.charAt(0) == '.') {
            if(!firstInput.equals("")) { // ! necessary to input multiple values into text field
                secondInput = secondInput + source;
            } else {
                neutralInput = neutralInput + source;
            }

            inputValues.setText(neutralInput + firstInput + secondInput);
        }

        // - - - Clears textfield of any inputs - - -
        else if(source.charAt(0) == 'c') {
            neutralInput = firstInput = secondInput = "";
            inputValues.setText(neutralInput + firstInput + secondInput);
        }

        // - - - if statement for equals button - - -
        else if(source.charAt(0) == '=') {

            // - - - double variable to store calculation - - -
            double combine = 0;

            // - - - Reads text field for any operands and will do specific operations - - -
            if(firstInput.equals("+")) {
                combine = (Double.parseDouble(neutralInput) + Double.parseDouble(secondInput));
            } else if(firstInput.equals("-")) {
                combine = (Double.parseDouble(neutralInput) - Double.parseDouble(secondInput));
            } else if(firstInput.equals("*")) {
                combine = (Double.parseDouble(neutralInput) * Double.parseDouble(secondInput));
            } else if(firstInput.equals("/")) {
                combine = (Double.parseDouble(neutralInput) / Double.parseDouble(secondInput));
            }

            // - - - Sets text to do operation requested and output the answer as a double - - -
            inputValues.setText(neutralInput + firstInput + secondInput + " = " + combine);

            // - - - Converts double in combine to a string - - -
            neutralInput = Double.toString(combine);

            firstInput = secondInput = "";

        } else {

            // - - - if statement sequence to place operand values into text field - - -
            if(firstInput.equals("") || secondInput.equals("")) {
                firstInput = source;
            }

            else {

                double stop = 0;

                // - - - Calculations for appropriate operand symbol - - -
                if(firstInput.equals("+")) {
                    stop = (Double.parseDouble(neutralInput) + Double.parseDouble(secondInput));
                } else if(firstInput.equals("-")) {
                    stop = (Double.parseDouble(neutralInput) - Double.parseDouble(secondInput));
                } else if(firstInput.equals("*")) {
                    stop = (Double.parseDouble(neutralInput) * Double.parseDouble(secondInput));
                } else if(firstInput.equals("/")) {
                    stop = (Double.parseDouble(neutralInput) / Double.parseDouble(secondInput));
                }

                // - - - Converts double stop to string - - -
                neutralInput = Double.toString(stop);

                firstInput = source;

                secondInput = "";
            }

            inputValues.setText(neutralInput + firstInput + secondInput);
        }

    }
}