package com.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame jFrame = getFrame(); // наша форма

    public static void main(String[] args) {
        JComponent jComponent = new MyComponent();
        jFrame.add(jComponent);  // добавляем панель

        //активное действие мышки
        jFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) { // передвижение мышки
                super.mouseMoved(e);
                MyComponent.xCoord = e.getX(); // передаем координаты
                MyComponent.yCoord = e.getY();
                jComponent.revalidate(); // перерисовка панели и формы
                jFrame.repaint();
            }
        });
    }

    static class MyComponent extends JComponent{
        public static int xCoord;
        public static int yCoord;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // добавляем надпись
            ((Graphics2D)g).drawString("Coordinates x: "+xCoord+" y: "+yCoord, 50, 50);
        }
    }


    static JFrame getFrame(){
        JFrame jFrame = new JFrame(); // создается форма
        jFrame.setVisible(true); // влючаем видимость
        jFrame.setBounds(750,250,500,500); // размеры
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход
        return jFrame;
    }
}
