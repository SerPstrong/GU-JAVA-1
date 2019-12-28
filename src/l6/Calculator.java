package l6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator
{

    public static void main(String[] args) {
        //создание окна
        CalculatorFrame frame = new CalculatorFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Видимость окна
        frame.setVisible(true);
    }
}

