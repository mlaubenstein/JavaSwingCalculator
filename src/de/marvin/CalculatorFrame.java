package de.marvin;

import javax.swing.*;
import java.awt.*;

class CalculatorFrame extends JFrame
{
    CalculatorFrame()
    {
        setTitle("Calculator");
        setForeground ( Color.GREEN );
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}
