/* Author: Soham Paik
   Purpose: The purpose of this program is to be a scientific calculator.
 */
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

class Calculator extends JFrame implements ActionListener {

    // Creates text field at top of calculator
    JTextArea txt1 = new JTextArea();

    // Determines the font of all text
    Font BTN_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 15);

    // Creates the window
    JPanel pnl = new JPanel();

    // Declares and initializes the digit buttons
    JButton[] jButtons = new JButton[10];

    // Declares and initializes function buttons
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton multButton = new JButton("*");
    JButton divButton = new JButton("/");
    JButton ansButton = new JButton("=");
    JButton decButton = new JButton(".");
    JButton clearButton = new JButton("C");
    JButton leftParent = new JButton("(");
    JButton rightParent = new JButton(")");
    JButton powButton = new JButton("^");
    JButton delButton = new JButton("⌫");
    JButton logButton = new JButton("log");
    JButton sinButton = new JButton("sin");
    JButton cosButton = new JButton("cos");
    JButton tanButton = new JButton("tan");
    JButton angModeButton = new JButton("deg");
    JButton lnButton = new JButton("ln");
    JButton asinButton = new JButton("asin");
    JButton acosButton = new JButton("acos");
    JButton atanButton = new JButton("atan");
    JButton piButton = new JButton("π");
    JButton eButton = new JButton("e");
    JButton sqrtButton = new JButton("√");
    JButton absButton = new JButton("|x|");
    JButton squareButton = new JButton("x²");
    JButton baseTenButton = new JButton("10^x");
    JButton baseEButton = new JButton("e^x");
    JButton reciprocalButton = new JButton("1/x");
    JButton base2Button = new JButton("2^x");
    JButton factorialButton = new JButton("x!");

    // Defines and initializes angle mode for calculator
    // Determines whether calculator is in degree or radian mode
    // 0 = rad
    // 1 = deg
    private int ANGLE_MODE = 0;

    // 0 = Text Area doesn't need to be cleared
    // 1 = Text Area needs to be cleared
//    private int CLEAR_TEXT_AREA = 0;
//
//    private void setCLEAR_TEXT_AREA() {
//        if (CLEAR_TEXT_AREA == 1) {
//            txt1.setText(null);
//            CLEAR_TEXT_AREA = 0;
//        }
//    }

    // Each row of buttons is in one JPanel
    // Each JPanel variable is layered on top of the pnl variable
    JPanel pnlSub1 = new JPanel(new FlowLayout());
    JPanel pnlSub2 = new JPanel(new FlowLayout());
    JPanel pnlSub3 = new JPanel(new FlowLayout());
    JPanel pnlSub4 = new JPanel(new FlowLayout());
    JPanel pnlSub5 = new JPanel(new FlowLayout());
    JPanel pnlSub6 = new JPanel(new FlowLayout());

    public static void main(String[] args) {
        Calculator gui = new Calculator();
    }

    // Constructor
    public Calculator() {
        super("Scientific Calculator");
        setSize(700, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txt1.setLineWrap(true);
        txt1.setWrapStyleWord(true);

        // Sets text, title, and action listener for every number button
        for ( int i = 0; i < 10; i++ ) {
            jButtons[i] = new JButton(String.valueOf(i));
            jButtons[i].setFont(BTN_FONT);
            jButtons[i].addActionListener(Calculator.this);
        }

        // Sets fonts for all function buttons
        addButton.setFont(BTN_FONT);
        subButton.setFont(BTN_FONT);
        multButton.setFont(BTN_FONT);
        divButton.setFont(BTN_FONT);
        ansButton.setFont(BTN_FONT);
        decButton.setFont(BTN_FONT);
        clearButton.setFont(BTN_FONT);
        leftParent.setFont(BTN_FONT);
        rightParent.setFont(BTN_FONT);
        powButton.setFont(BTN_FONT);
        delButton.setFont(BTN_FONT);
        logButton.setFont(BTN_FONT);
        sinButton.setFont(BTN_FONT);
        cosButton.setFont(BTN_FONT);
        tanButton.setFont(BTN_FONT);
        angModeButton.setFont(BTN_FONT);
        lnButton.setFont(BTN_FONT);
        asinButton.setFont(BTN_FONT);
        acosButton.setFont(BTN_FONT);
        atanButton.setFont(BTN_FONT);
        piButton.setFont(BTN_FONT);
        eButton.setFont(BTN_FONT);
        sqrtButton.setFont(BTN_FONT);
        absButton.setFont(BTN_FONT);
        squareButton.setFont(BTN_FONT);
        baseTenButton.setFont(BTN_FONT);
        reciprocalButton.setFont(BTN_FONT);
        baseEButton.setFont(BTN_FONT);
        base2Button.setFont(BTN_FONT);
        factorialButton.setFont(BTN_FONT);

        // Adds action listeners for all function buttons
        addButton.addActionListener(Calculator.this);
        subButton.addActionListener(Calculator.this);
        multButton.addActionListener(Calculator.this);
        divButton.addActionListener(Calculator.this);
        ansButton.addActionListener(Calculator.this);
        decButton.addActionListener(Calculator.this);
        clearButton.addActionListener(Calculator.this);
        leftParent.addActionListener(Calculator.this);
        rightParent.addActionListener(Calculator.this);
        powButton.addActionListener(Calculator.this);
        delButton.addActionListener(Calculator.this);
        logButton.addActionListener(Calculator.this);
        sinButton.addActionListener(Calculator.this);
        cosButton.addActionListener(Calculator.this);
        tanButton.addActionListener(Calculator.this);
        angModeButton.addActionListener(Calculator.this);
        lnButton.addActionListener(Calculator.this);
        asinButton.addActionListener(Calculator.this);
        acosButton.addActionListener(Calculator.this);
        atanButton.addActionListener(Calculator.this);
        piButton.addActionListener(Calculator.this);
        eButton.addActionListener(Calculator.this);
        sqrtButton.addActionListener(Calculator.this);
        absButton.addActionListener(Calculator.this);
        squareButton.addActionListener(Calculator.this);
        baseTenButton.addActionListener(Calculator.this);
        reciprocalButton.addActionListener(Calculator.this);
        baseEButton.addActionListener(Calculator.this);
        base2Button.addActionListener(Calculator.this);
        factorialButton.addActionListener(Calculator.this);

        // Sets pnl layout
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        // Sets size of text field
        txt1.setPreferredSize(new Dimension(525,50));

        // pnlSub1 contains text field
        pnlSub1.add(txt1);

        // pnlSub2 contains clear, delete, left parentheses, right parentheses, power,
        // angle mode, pi, and base ten buttons
        pnlSub2.add(clearButton);
        pnlSub2.add(delButton);
        pnlSub2.add(leftParent);
        pnlSub2.add(rightParent);
        pnlSub2.add(powButton);
        pnlSub2.add(angModeButton);
        pnlSub2.add(piButton);
        pnlSub2.add(baseTenButton);
        pnlSub2.add(Box.createHorizontalStrut(15));

        // pnlsub3 contains 7,8,9 buttons
        // contains divide, log, ln, e, and base e buttons
        pnlSub3.add(jButtons[7]);
        pnlSub3.add(jButtons[8]);
        pnlSub3.add(jButtons[9]);
        pnlSub3.add(divButton);
        pnlSub3.add(logButton);
        pnlSub3.add(lnButton);
        pnlSub3.add(eButton);
        pnlSub3.add(baseEButton);
        pnlSub3.add(Box.createHorizontalStrut(15));

        // pnlsub4 contains 4,5,and 6 buttons
        // contains multiply, sin, asin, square root, and 1/x buttons
        pnlSub4.add(jButtons[4]);
        pnlSub4.add(jButtons[5]);
        pnlSub4.add(jButtons[6]);
        pnlSub4.add(multButton);
        pnlSub4.add(sinButton);
        pnlSub4.add(asinButton);
        pnlSub4.add(sqrtButton);
        pnlSub4.add(reciprocalButton);
        pnlSub4.add(Box.createHorizontalStrut(15));

        // pnlSub5 contains 1,2,and 3 buttons
        // Also contains addition, subtraction, cosine, arc cosine, absolute value,
        // and base 2 log buttons
        pnlSub5.add(jButtons[1]);
        pnlSub5.add(jButtons[2]);
        pnlSub5.add(jButtons[3]);
        pnlSub5.add(addButton);
        pnlSub5.add(cosButton);
        pnlSub5.add(acosButton);
        pnlSub5.add(absButton);
        pnlSub5.add(base2Button);
        pnlSub5.add(Box.createHorizontalStrut(15));

        // Adds 0, answer, decimal point, subtraction, tangent, arc tangent, square, and factorial buttons
        pnlSub6.add(jButtons[0]);
        pnlSub6.add(ansButton);
        pnlSub6.add(decButton);
        pnlSub6.add(subButton);
        pnlSub6.add(tanButton);
        pnlSub6.add(atanButton);
        pnlSub6.add(squareButton);
        pnlSub6.add(factorialButton);
        pnlSub6.add(Box.createHorizontalStrut(15));

        // Adds all subpanels to main panel
        pnl.add(pnlSub1);
        pnl.add(pnlSub2);
        pnl.add(pnlSub3);
        pnl.add(pnlSub4);
        pnl.add(pnlSub5);
        pnl.add(pnlSub6);

        // Adds main panel to window and makes it visible
        add(pnl);
        setVisible(true);
    }

    // Enters text into text field based on which button was pressed
    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == jButtons[0] ) {
            //setCLEAR_TEXT_AREA();
            txt1.append("0");
        }

        if ( e.getSource() == jButtons[1] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("1");
        }

        if ( e.getSource() == jButtons[2] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("2");
        }

        if ( e.getSource() == jButtons[3] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("3");
        }

        if ( e.getSource() == jButtons[4] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("4");
        }

        if ( e.getSource() == jButtons[5] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("5");
        }

        if ( e.getSource() == jButtons[6] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("6");
        }

        if ( e.getSource() == jButtons[7] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("7");
        }

        if ( e.getSource() == jButtons[8] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("8");
        }

        if ( e.getSource() == jButtons[9] ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("9");
        }

        if ( e.getSource() == decButton ) {
            txt1.append(".");
        }

        if ( e.getSource() == clearButton ) {
            txt1.setText(null);
            //CLEAR_TEXT_AREA = 0;
        }

        if ( e.getSource() == addButton ) {
            txt1.append("+");
        }

        if ( e.getSource() == subButton ) {
            txt1.append("-");
        }

        if ( e.getSource() == multButton ) {
            txt1.append("*");
        }

        if ( e.getSource() == divButton ) {
            txt1.append("/");
        }

        if ( e.getSource() == leftParent ) {
            txt1.append("(");
        }

        if ( e.getSource() == rightParent ) {
            txt1.append(")");
        }

        if ( e.getSource() == powButton ) {
            txt1.append("^");
        }

        if ( e.getSource() == ansButton ) {
            parseEx(txt1.getText());
//            CLEAR_TEXT_AREA = 1;
        }

        if ( e.getSource() == delButton ) {
            String text = txt1.getText();
            txt1.setText(text.substring(0, text.length() - 1));
        }

        if ( e.getSource() == logButton ) {
            txt1.setText("log(" + txt1.getText() + ")");
        }

        if ( e.getSource() == lnButton ) {
            txt1.setText("ln(" + txt1.getText() + ")");
        }

        if ( e.getSource() == sinButton ) {
            txt1.setText("sin(" + txt1.getText() + ")");
        }

        if ( e.getSource() == cosButton ) {
            txt1.setText("cos(" + txt1.getText() + ")");
        }

        if ( e.getSource() == tanButton ) {
            txt1.setText("tan(" + txt1.getText() + ")");
        }

        if ( e.getSource() == asinButton ) {
            txt1.setText("asin(" + txt1.getText() + ")");
        }

        if ( e.getSource() == acosButton ) {
            txt1.setText("acos(" + txt1.getText() + ")");
        }

        if ( e.getSource() == atanButton ) {
            txt1.setText("atan(" + txt1.getText() + ")");
        }

        if ( e.getSource() == piButton ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("π");
        }

        if ( e.getSource() == eButton ) {
//            setCLEAR_TEXT_AREA();
            txt1.append("e");
        }

        if ( e.getSource() == sqrtButton ) {
            txt1.setText("sqrt(" + txt1.getText() + ")");
        }

        if ( e.getSource() == angModeButton ) {
            if ( ANGLE_MODE == 0 ) {
                angModeButton.setText("rad");
                ANGLE_MODE = 1;
            }
            else if ( ANGLE_MODE == 1 ) {
                angModeButton.setText("deg");
                ANGLE_MODE = 0;
            }
        }

        if ( e.getSource() == absButton ) {
            txt1.setText("abs(" + txt1.getText() + ")");
        }

        if ( e.getSource() == squareButton ) {
            txt1.setText(txt1.getText() + "^2");
        }

        if ( e.getSource() == baseTenButton ) {
            txt1.setText("10^(" + txt1.getText() + ")");
        }

        if ( e.getSource() == reciprocalButton ) {
            txt1.setText("1/(" + txt1.getText() + ")");
        }

        if ( e.getSource() == baseEButton ) {
            txt1.setText("e^(" + txt1.getText() + ")");
        }

        if ( e.getSource() == base2Button ) {
            txt1.setText("2^(" + txt1.getText() + ")");
        }

        if ( e.getSource() == factorialButton ) {
            txt1.setText(txt1.getText() + "!");
        }
    }

    // When the answer button is pressed, all expressions in the text field will be evaluated using parseEx class
    // This class uses exp4j to evaluate mathematical expressions
    public void parseEx(String ex) {

        try {

            // Overrides exp4j's default log function, which evaluates ln
            Function logTen = new Function("log", 1) {
                @Override
                public double apply(double... doubles) {
                    return Math.log10(doubles[0]);
                }
            };

            Function sin = new Function("sin", 1) {
                @Override
                public double apply(double... doubles) {
                    if ( ANGLE_MODE == 1) {
                        double inRadians = Math.toRadians(doubles[0]);

                        if ( (inRadians % Math.PI) == 0 ) {
                            return 0;
                        }

                        return Math.sin(inRadians);
                    }
                    else
                    {
                        if ( (doubles[0] % Math.PI) == 0 ) {
                            return 0;
                        }

                        return Math.sin(doubles[0]);
                    }

                }
            };

            Function cos = new Function("cos", 1) {
                @Override
                public double apply(double... doubles) {
                    if ( ANGLE_MODE == 1) {
                        double inRadians = Math.toRadians(doubles[0]);

                        if ( (inRadians % (Math.PI / 2) ) == 0 ) {
                            return 0;
                        }

                        return Math.cos(inRadians);
                    }
                    else {

                        if ( (doubles[0] % (Math.PI / 2) ) == 0 ) {
                            return 0;
                        }

                        return Math.cos(doubles[0]);
                    }
                }
            };

            // Make sure that whenever tan() equals -1 or 1, it actually outputs an integer
            // not an approximation like 0.9999999999 or -1.09090890128390, etc.
            // Also ensure that tan() prints DNE instead of a large integer whenever the angle is a multiple
            // of pi/2 or 90 degrees
            Function tan = new Function("tan", 1) {
                @Override
                public double apply(double... doubles) {
                    if ( ANGLE_MODE == 1 ) {
                        double inRadians = Math.toRadians(doubles[0]);

                        if ( inRadians % (Math.PI) == 0 ) {
                            return 0;
                        }
                        if ( inRadians % (Math.PI) == (Math.PI / 4) ) {
                            return 1;
                        }
                        if ( inRadians % (Math.PI) == (3 * Math.PI / 4) ) {
                            return -1;
                        }
                        if ( inRadians % (Math.PI) == (Math.PI / 2) ) {
                            throw new IndexOutOfBoundsException("number too big");
                        }
                        if ( inRadians % (Math.PI) == (3 * Math.PI / 2) ) {
                            throw new IndexOutOfBoundsException("number too big");
                        }

                        return Math.tan(inRadians);
                    }
                    else {

                        if ( doubles[0] % (Math.PI) == 0) {
                            return 0;
                        }
                        if ( doubles[0] % (Math.PI) == (Math.PI / 4) ) {
                            return 1;
                        }
                        if ( doubles[0] % (Math.PI) == (3 * Math.PI / 4)) {
                            return -1;
                        }
                        if ( doubles[0] % (Math.PI) == (Math.PI / 2) ) {
                            throw new IndexOutOfBoundsException("number too big");
                        }
                        if ( doubles[0] % (Math.PI) == (3 * Math.PI / 2) ) {
                            throw new IndexOutOfBoundsException("number too big");
                        }

                        return Math.tan(doubles[0]);
                    }
                }
            };

            Function asin = new Function("asin", 1) {
                @Override
                public double apply(double... doubles) {
                    if ( ANGLE_MODE == 1 ) {
                        return Math.toDegrees(Math.asin(doubles[0]));
                    }
                    else {
                        return Math.asin(doubles[0]);
                    }
                }
            };

            Function acos = new Function("acos", 1) {
                @Override
                public double apply(double... doubles) {
                    if ( ANGLE_MODE == 1 ) {
                        return Math.toDegrees(Math.acos(doubles[0]));
                    }
                    else {
                        return Math.acos(doubles[0]);
                    }
                }
            };

            Function atan = new Function("atan", 1) {
                @Override
                public double apply(double... doubles) {
                    if ( ANGLE_MODE == 1 ) {
                        return Math.toDegrees(Math.atan(doubles[0]));
                    }
                    else {
                        return Math.atan(doubles[0]);
                    }
                }
            };

            Function ln = new Function("ln", 1) {
                @Override
                public double apply(double... doubles) {
                    return Math.log(doubles[0]);
                }
            };

            Operator factorial = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {
                @Override
                public double apply(double... doubles) {
                    int arg = (int) doubles[0];
                    if (arg != doubles[0]) {
                        throw new IllegalArgumentException();
                    }
                    if (arg < 0) {
                        throw new IllegalArgumentException();
                    }

                    int res = 1;
                    for (int i = 2; i <= arg; i++) {
                        res *= i;
                    }

                    return res;
                }
            };

            Expression expression = new ExpressionBuilder(ex).operator(factorial).function(logTen).
                    function(sin).function(cos).function(tan).function(ln).
                    function(asin).function(acos).function(atan).build();

            double result = expression.evaluate();

            boolean isInt = isInteger(Double.toString(result));

            // This allows me to format the output, so that only decimal numbers are output-ed
            // and integers remain integers without an extra decimal place
            DecimalFormat df = new DecimalFormat("#.######################################");

            if (isInt) {
                System.out.println(result);
                txt1.setText(String.valueOf(result));
            }
            else
            {
                txt1.setText(df.format(result));
            }
        }
        catch ( ArithmeticException e ) {
            txt1.setText("ERROR: DIV BY 0");
        }
        catch ( UnknownFunctionOrVariableException e) {
            txt1.setText("ERROR: UNKNOWN FUNCTION OR VARIABLE");
        }
        catch ( IllegalArgumentException e ) {
            txt1.setText("ERROR: ILLEGAL ARGUMENT OR NUMBER OF OPERANDS");
        }
        catch ( IndexOutOfBoundsException e) {
            txt1.setText("undefined");
        }
    }

    // Checks if a number is an integer
    // Used in parseEx to print out integer results in calculator
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
}