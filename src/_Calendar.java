import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _Calendar {
    public JPanel main_panel;
    public JPanel row1;
    public JPanel row2;
    public JButton next;
    public JButton previous;
    public _Date date;

    private JFrame frame;

    _Calendar(JFrame frame){
        date = new _Date();
        this.frame = frame;
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                date.setYear( date.getYear() + (int) Math.floor(date.getMonth().getMonthIndex() + 1) / 12);
                date.setMonth( (date.getMonth().getMonthIndex() + 1) % 12);
                setCalendar();
            }
        });

        previous.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println((int) Math.floor((double)( date.getMonth().getMonthIndex() - 1) / 12));
                date.setYear(date.getYear() + (int) Math.floor((double)( date.getMonth().getMonthIndex() - 1) / 12));
                date.setMonth( Math.floorMod((date.getMonth().getMonthIndex() - 1), 12));
                setCalendar();
            }
        });
    }

    public void setCalendar(){
        int daysCount = 1;
        clearCalendar();
        ((JLabel)((JPanel) row1.getComponent(0)).getComponent(0)).setText(date.getMonth().getLabel()); // set month
        ((JLabel)((JPanel) row1.getComponent(0)).getComponent(1)).setText(String.valueOf(date.getYear())); // set year
        frame.setTitle(date.getMonth().getLabel() + " " + date.getYear());
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 7; j++){
                if( ( i == 0 && j < date.getMonthStartDayIndex() ) || (daysCount > date.getMonth().getTotalDays()) ) continue;
                ((JLabel)((JPanel) row2.getComponent(j)).getComponent(i)).setText(String.valueOf(daysCount));
                daysCount++;
            }
        }

    }

    public void clearCalendar(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 7; j++){
                ((JLabel)((JPanel) row2.getComponent(j)).getComponent(i)).setText(" ");
            }
        }
    }
}
