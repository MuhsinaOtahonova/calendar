import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateCalculator {
    public JPanel main_panel;
    private JComboBox monthComboBox;
    private JComboBox dayComboBox;
    private JButton calculateDaysButton;
    private JPanel resultPanel;
    private JButton button2;
    private JLabel todayDateLabel;
    private JComboBox yearComboBox;
    private JLabel daysDifferenceLabel;
    private JLabel birthdayLabel;

    _Date date;
    DateCalculator(){
        int []years = new int[500];
        DefaultComboBoxModel model = (DefaultComboBoxModel) yearComboBox.getModel();
        for(int i = 2022; i >= 1700; i--){
            model.addElement(i);
        }

        date = new _Date();
        date.setYear(LocalDate.now().getYear());
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setMonth(monthComboBox.getSelectedIndex() - 1);
            }
        });
        dayComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setDay(dayComboBox.getSelectedIndex());
            }
        });
        yearComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setYear(2022 - (yearComboBox.getSelectedIndex() - 1));
            }
        });
        calculateDaysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate today = LocalDate.now();
                LocalDate birthday = LocalDate.of( date.getYear(), date.getMonth().getMonthIndex() + 1, date.getDay());
                LocalDate nextBirthday;
                if (today.isAfter(birthday) || today.isEqual(birthday)) {
                    int yearsToAdd = today.getYear() - birthday.getYear() + 1;
                    nextBirthday = birthday.plusYears(yearsToAdd);
                } else {
                    nextBirthday = birthday;
                }

                long days = ChronoUnit.DAYS.between(today, nextBirthday);
                daysDifferenceLabel.setText(String.valueOf(days));
                birthdayLabel.setText( birthday.getDayOfWeek().toString().substring(0, 1).toUpperCase()
                        + birthday.getDayOfWeek().toString().substring(1).toLowerCase()
                        + ", "
                        + birthday.toString()
                );
            }
        });
        setTodayDate();
    }

    private void setTodayDate(){
        LocalDate todayDate = LocalDate.now();
        todayDateLabel.setText("Today is: "
                + todayDate.getDayOfWeek().toString().substring(0, 1).toUpperCase()
                + todayDate.getDayOfWeek().toString().substring(1).toLowerCase()
                + ", "
                + todayDate.getMonth().toString().substring(0, 1).toUpperCase()
                + todayDate.getMonth().toString().substring(1).toLowerCase()
                + " "
                + todayDate.getMonth().getValue()
                + ", "
                + todayDate.getYear()
            );
    }

}
