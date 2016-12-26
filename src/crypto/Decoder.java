package crypto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by LINKOR on 26.12.2016 in 10:14.
 * Date: 2016.12.26
 */
public class Decoder extends JFrame implements ActionListener {

    private JButton decode = new JButton("Encrypt");

    private Decoder() {
        setTitle("Encryptor");
        decode.setIcon(new ImageIcon("decimg/dec.gif"));
        setLayout(new FlowLayout());
        add(decode);
        decode.addActionListener(this);
        setVisible(true);
        setSize(200, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && e.getSource() == decode) {
            String encText = JOptionPane.showInputDialog("Enter encrypted text");
            int randVal = Integer.parseInt(encText.split(" ")[0]);
            String text = "", encc[] = encText.split(" ");
            for (int i = 1; i < encc.length; i ++ ){
                for (int j = 0; j < encc[i].toCharArray().length; j++) {
                    char c = encc[i].toCharArray()[j];
                    char r = (char) (c - randVal);
                    text += r;
                }
            }
            JOptionPane.showMessageDialog(null, "Decoded text: \n" + text);
        }
    }

    public static void main(String[] args) {
        new Decoder().setVisible(true);
    }
}
