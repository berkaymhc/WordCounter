//import Java GUI files

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectGUI {
    public JFrame frame;
    public String string = "";
    public JLabel text = new JLabel();
    public WordCounter essay;

    /*
     * Constructor
     */
    public ProjectGUI() {
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.add(outputText(), BorderLayout.CENTER);
        frame.add(enterText(), BorderLayout.NORTH);
        frame.setVisible(true);
    }


    public JScrollPane outputText() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(panel);

        panel.add(text);

        return scroll;
    }

    /*
     * Clears the screen so the user can start again
     */
    public JPanel enterText() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea textField = new JTextArea();
        JScrollPane pane = new JScrollPane(textField);
        textField.setLineWrap(true);
        textField.setRows(8);
        textField.addMouseListener(new ContextMenuMouseListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        JButton alphabeticalButton = new JButton("Alphabetize");
        alphabeticalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                essay = new WordCounter(textField.getText());
                essay.alphabetical();
                text.setText(essay.finishedProduct);
            }

            ;
        });

        JButton numericalButton = new JButton("Order by Occurance");
        numericalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                essay = new WordCounter(textField.getText());
                essay.numerical();
                text.setText(essay.finishedProduct);
            }

            ;
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
            }

            ;
        });


        ;
        panel.add(pane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.EAST);
        buttonPanel.add(alphabeticalButton);
        buttonPanel.add(numericalButton);
        buttonPanel.add(clear);

        return panel;
    }


}
