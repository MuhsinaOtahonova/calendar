import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock implements Runnable{
    Thread t=null;
    int hours=0, minutes=0, seconds=0, colorChanger=0, changeInSeconds = 1, length = 30;
    String timeString = "";
    Color[] colors = new Color[length];
    private JLabel clockLabel;
    public JPanel main_panel;

    Clock() {
        t = new Thread(this);
        t.start();

        Font fnt = new Font("Calibri",Font.BOLD | Font.ITALIC, 40);
        clockLabel.setFont(fnt);
        clockLabel.setBounds(400,400,300,150);
        clockLabel.setForeground(Color.red);
        clockLabel.setOpaque(true);
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setVerticalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < length; i++)
            colors[i] = Color.getHSBColor((float) i / length, 1, 1);
    }

    @Override
    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                hours = cal.get( Calendar.HOUR_OF_DAY );
                if ( hours > 12 ) hours -= 12;
                minutes = cal.get( Calendar.MINUTE );
                seconds = cal.get( Calendar.SECOND );

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format( date );

                printTime();

                if(colorChanger % changeInSeconds == 0){
                    clockLabel.setForeground(colors[ (colorChanger / changeInSeconds) % (colors.length) ]);
                }
                colorChanger++;

                t.sleep( 1000 );
            }
        }
        catch (Exception e) { }
    }
    public void printTime(){
        System.out.println(timeString);
        clockLabel.setText(timeString);
    }
}
