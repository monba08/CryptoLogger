import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptoGui {
    private JPanel Verzameling;
    private JPanel inlogScherm;
    private JPanel registerScherm;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel loginScherm;
    private JTextField pasField;
    private JTextField nameField;
    private JButton loginButton1;
    private JTextField rName;
    private JTextField rPass;
    private JTextField rCoin;
    private JTextField rValue;
    private JTextField rQuantity;
    private JButton doneButton;
    private JPanel portfolio;
    private JButton addNewCoinButton;
    private JPanel newCoin;
    private JTextField nName;
    private JTextField nValue;
    private JTextField nQuantity;
    private JButton doneButton1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("cryptoGui");
        frame.setContentPane(new cryptoGui().Verzameling);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); //r
    }

    public cryptoGui() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(true);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);

                // hier gebeurt de eigenlijke login check.
                String naam = nameField.getText(); //dit is waar de naam wordt opgeslagen
                String pass = pasField.getText(); //dit is waar de passwoord wordt opgeslagen.

                //hier komt de verwijzing nr de code of de code zelf ik ben niet zeker.
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(true);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                //wanneer er op DONE wordt gedrukt zal hij overgaan naar opslagen van de gegevens.
            }
        });
        doneButton.addActionListener(new ActionListener() { //als de DONE knop bij registratie wordt ingeduwd
            @Override
            public void actionPerformed(ActionEvent e) {
                //hier komt de code voor de verwerking van de gegevens naar de bestanden.
                registerScherm.setVisible(false);
                loginScherm.setVisible(true);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                //de eigenlijke verwerking van de gegevens die worden ingegeven.
                String registNaam = rName.getText(); //naam bij registratie
                String registPass = rPass.getText(); //pass voor inlog
                String coin = rCoin.getText(); //coin bij registratie (kan later aangevuld worden)
                int value = Integer.parseInt(rValue.getText()); //de waarde van 1 coin!!
                int quantity = Integer.parseInt(rQuantity.getText()); //de hoeveelheid van de coin
            }
        });
        loginButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);
                //als er op newCoin wordt gedrukt ----> zie hier onder
            }
        });
        addNewCoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(true);
            }
        });
        doneButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);


                //hier worden de nieuwe gegevens opgeslagen van de coin

                String newCoin = nName.getText();
                int newValue = Integer.parseInt(nValue.getText());
                int newQuantity= Integer.parseInt(nQuantity.getText());

            }
        });
    };

    private void createUIComponents() { //bruh geen idee wrm dees hier is.........
        // TODO: place custom component creation code here
    }
}