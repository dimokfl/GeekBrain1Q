package geekbrains.quarter1.home_work_1_8_calc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcPanel extends JPanel {

    JPanel panel;
    private boolean start;
    private JButton display;
    private double result;
    private String lastCommand;

    public CalcPanel(){
        super();

        start = true;
        lastCommand = "=";

        setLayout(new BorderLayout());
        display = new JButton("0");
        display.setFont(new Font(display.getFont().getName(), display.getFont().getStyle(), 30));
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        InsertAction insert = new InsertAction();
        CommandAction command = new CommandAction();


        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("5", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);

    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

   private class InsertAction implements ActionListener{

       @Override
       public void actionPerformed(ActionEvent actionEvent) {
           String input = actionEvent.getActionCommand();
           if (start){
               display.setText("");
               start = false;
           }
           if (input != "." || display.getText().indexOf(".") == -1)
           display.setText(display.getText() + input);

       }
   }

    private class CommandAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String command = actionEvent.getActionCommand();
            if (start){
                lastCommand = command;
            } else {
                calc(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }

        }

        public void calc (double x) {
            if (lastCommand.equals("+")) result += x;
            else if (lastCommand.equals("-")) result -= x;
            else if (lastCommand.equals("*")) result *= x;
            else if (lastCommand.equals("/")) result /= x;
            else if (lastCommand.equals("=")) result = x;
            display.setText("" + result);
        }

    }

}
