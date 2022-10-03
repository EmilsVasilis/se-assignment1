import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcInterface {
    calc calculator;
    calcInterface() {
        calculator = new calc();
    }
    public void draw () {
        Frame f = new Frame("Calculator");
        TextField t1 = new TextField("Enter Calculation"); // make placeholder
        JLabel header = new JLabel("Calculator");
        Button submit = new Button("Submit");
        t1.setBounds(50, 100, 200, 30);
        header.setBounds(50,50,200,30);
        submit.setBounds(50, 150, 200, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(t1.getText()); // Calculator action or error
            }
        });
        f.add(t1);
        f.add(header);
        f.add(submit);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}
