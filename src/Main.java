import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame calendarFrame = new JFrame();
        calendarFrame.setSize(400, 500);

        _Calendar calendar = new _Calendar(calendarFrame);
        DateCalculator dateCalculator = new DateCalculator();
        Clock clock = new Clock();

        calendar.setCalendar();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Pages");
        JMenuItem menuItem = new JMenuItem("Calendar");
        JMenuItem menuItem1 = new JMenuItem("DateCalculator");
        JMenuItem menuItem2 = new JMenuItem("Clock");
        menu.add(menuItem);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        calendarFrame.setJMenuBar(menuBar);


        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendarFrame.getContentPane().removeAll();
                calendarFrame.add(calendar.main_panel);
                calendarFrame.revalidate();
                calendarFrame.repaint();
            }
        });
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendarFrame.getContentPane().removeAll();
                calendarFrame.add(dateCalculator.main_panel);
                calendarFrame.revalidate();
                calendarFrame.repaint();
            }
        });
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendarFrame.getContentPane().removeAll();
                calendarFrame.add(clock.main_panel);
                calendarFrame.revalidate();
                calendarFrame.repaint();
            }
        });

        calendarFrame.add(calendar.main_panel);
        calendarFrame.setVisible(true);
    }
}