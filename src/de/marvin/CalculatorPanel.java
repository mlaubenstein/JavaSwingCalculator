package de.marvin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.green;

class CalculatorPanel extends JPanel
{
    private JTextField display;
    private JPanel panel;

    private Calculator calculator;

    CalculatorPanel()
    {



        this.calculator = new Calculator();

        setLayout(new BorderLayout());// Startflag setzen

        display = new JTextField("0");
        display.setBackground(Color.BLACK);
        display.setForeground ( Color.WHITE );
        add(display, BorderLayout.NORTH);



        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3));
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.GREEN);





        ActionListener appendAction = new AppendAction();// ActionListener appendAction erzeugen
        ClearAction clearAction = new ClearAction();
        PlusAction plusAction = new PlusAction();
        MinusAction minusAction = new MinusAction();
        MalAction malAction = new MalAction();
        DurchAction durchAction = new DurchAction();
        EnterAction enterAction =new EnterAction();
        PotenzAction potenzAction = new PotenzAction();
        SqrtAction sqrtAction = new SqrtAction();
        LogAction logAction = new LogAction();
        M1Action m1Action = new M1Action();
        M2Action m2Action = new M2Action();
        M3Action m3Action = new M3Action();
        M4Action m4Action = new M4Action();





        addButton("M1",m1Action);
        addButton("M2",m2Action);
        addButton("M3",m3Action);
        addButton("M4",m4Action);

        addButton("√", sqrtAction);// Die Aktion appendAction als zweiten Parameter hinzufügen
        addButton("ln", logAction);
        addButton("^2", potenzAction);
        addButton("+", plusAction);

        addButton("7", appendAction);
        addButton("8", appendAction);
        addButton("9", appendAction);
        addButton("-", minusAction);

        addButton("4", appendAction);
        addButton("5", appendAction);
        addButton("6", appendAction);
        addButton("*", malAction);

        addButton("1", appendAction);
        addButton("2", appendAction);
        addButton("3", appendAction);
        addButton("/", durchAction);

        addButton("C", clearAction);
        addButton("0", appendAction);
        addButton(".", appendAction);



        add(panel, BorderLayout.CENTER);



        JPanel enterlabel = new JPanel();

        enterlabel.setLayout(new GridLayout(1,3));
        addEnter(enterAction);
        add(enterlabel,BorderLayout.SOUTH);


    }

    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label); // Ereignisempfänger für die Schaltfläche
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(1,1));
        button.setBackground(Color.GREEN);


        panel.add(button);
    }

    private void addEnter(ActionListener listeners)
    {
        JButton enter = new JButton("=");
        enter.addActionListener(listeners);
        enter.setPreferredSize(new Dimension(60,60));
        enter.setBackground(Color.GREEN);
        panel.add(enter);

    }


    class AppendAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if (input.length() ==1){
                calculator.addInput(input.charAt(0));
            }

            display.setText(calculator.toString());
        }
    }
    class ClearAction implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            //display.setText("0");
            calculator.addInput('#');
            calculator.clear();
            display.setText("0");
        }
    }
    class PlusAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            calculator.addInput('+');
            display.setText(calculator.toString());
        }
    }
    class MinusAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            calculator.addInput('-');
            display.setText(calculator.toString());
        }
    }
    class MalAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            calculator.addInput('*');
            display.setText(calculator.toString());

        }
    }
    class DurchAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            calculator.addInput('/');
            display.setText(calculator.toString());
        }
        }
    class EnterAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            //
            String result = calculator.calculateResult();
            display.setText(result);

        }
    }
    class PotenzAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {


            calculator.addInput('^');
            display.setText(calculator.toString());
        }
    }
    class LogAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {


            calculator.addInput('l');
            display.setText(calculator.toString());
        }
    }
    class SqrtAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {


            calculator.addInput('v');
            display.setText(calculator.toString());
        }

    }
    private float MNumber=0.0f;
    class M1Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            MNumber = 1;
            calculator.inputSaveFunction(MNumber);
            display.setText(Calculator.getMNumber());
        }
    }
    class M2Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            MNumber = 2;
            calculator.inputSaveFunction(MNumber);
            display.setText(Calculator.getMNumber());
        }
    }
    class M3Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            MNumber = 3;
            calculator.inputSaveFunction(MNumber);
            display.setText(Calculator.getMNumber());
        }
    }
    class M4Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            MNumber = 4;
            calculator.inputSaveFunction(MNumber);
            display.setText(Calculator.getMNumber());
        }
    }



}

