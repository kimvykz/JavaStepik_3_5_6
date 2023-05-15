import javax.swing.*;
import java.awt.*;

public class Program {

    public static boolean checkContainsDigits(String str_) {
        for (char c : str_.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkContainsLetter(String str_) {
        for (char c : str_.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String loginStr = new String();
        String passStr_01, passStr_02 ;


        JFrame frameMain = new JFrame("Main Frame");
        JPanel panelMain = new JPanel(new GridLayout(1,2));
        JLabel labelWelcome = new JLabel("Welcome!");
        JLabel labelNULL = new JLabel("");

        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelMain.setSize(new Dimension(500, 100));
        panelMain.add(labelNULL);
        panelMain.add(labelWelcome);
        panelMain.setAlignmentX(Component.CENTER_ALIGNMENT);
        frameMain.getContentPane().add(panelMain);
        frameMain.setSize(panelMain.getSize());

        JPanel panelAuth = new JPanel(new GridLayout(2,2));
        panelAuth.setPreferredSize(new Dimension(300,50));
        JTextField tfLogin = new JTextField();
        JPasswordField pfPassword1 = new JPasswordField('*');
        JPasswordField pfPassword2 = new JPasswordField('*');
        boolean goAhead = true;

        panelAuth.add(new JLabel("Password:"));
        panelAuth.add(pfPassword1);
        panelAuth.add(new JLabel("Repeat password:"));
        panelAuth.add(pfPassword2);

        int greetDialog = JOptionPane.showConfirmDialog(null, "Do you want to register?",
                "Confirmation", JOptionPane.OK_CANCEL_OPTION);

        if (greetDialog == JOptionPane.OK_OPTION){
            goAhead = true;
        }
        else {
            goAhead = false;
        }

        boolean do_ = true;

        if (goAhead) {

            while (do_) {
                Object optLogin = JOptionPane.showInputDialog(null, "Input login", "Enter Login",
                        JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (optLogin != null) {
                    loginStr = optLogin.toString();
                    if (loginStr.length() < 5) {
                        JOptionPane.showMessageDialog(null, "Login must contain more that 5 letter!",
                                "Warning!", JOptionPane.WARNING_MESSAGE);
                    } else if (loginStr.contains(" ")) {
                        JOptionPane.showMessageDialog(null, "Login can't contain spaces", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        do_ = false;
                    }
                }
                else {
                    goAhead = false;
                    do_ = false;
                }
            }
        }

        if (goAhead) {
            do_ = true;
            while (do_) {
                int result = JOptionPane.showOptionDialog(null, panelAuth, "Enter Password",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION) {
                    passStr_01 = String.valueOf(pfPassword1.getPassword());
                    passStr_02 = String.valueOf(pfPassword2.getPassword());
                    System.out.println(passStr_01);
                    if (passStr_01.equals("")  || passStr_01.equals(null)) {
                        JOptionPane.showMessageDialog(null, "password cannot be empty",
                                "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else if (passStr_01.length() < 8) {
                        JOptionPane.showMessageDialog(null, "Length of password must be more than 8 characters",
                                "Error", JOptionPane.WARNING_MESSAGE);
                    } else if (!checkContainsDigits(passStr_01)) {
                        JOptionPane.showMessageDialog(null, "Password must have at least 1 digit",
                                "Error!", JOptionPane.WARNING_MESSAGE);

                    } else if (!checkContainsLetter(passStr_01)) {
                        JOptionPane.showMessageDialog(null, "password must have at least 1 letter",
                                "Error", JOptionPane.WARNING_MESSAGE);

                    } else if (!passStr_01.equals(passStr_02)) {
                        JOptionPane.showMessageDialog(null, "passwords must be equals",
                                "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        do_ = false;
                    }

                }
                else {
                    do_ = false;
                    goAhead = false;
                }
            }

        }

        if (goAhead) {
            labelWelcome.setText(labelWelcome.getText() + " - " + loginStr);
            frameMain.setVisible(true);
        }
        else {
            System.exit(0);
        }

    }
}
