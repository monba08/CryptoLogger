import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    private JPanel setDailyValue;
    private JButton doneButton2;
    private JTextField dCurrentValue;
    private JButton addDailyValueCoinButton;
    public Accounts account;
    public InformationUser user;

    public static void main(String[] args) {
        JFrame frame = new JFrame("cryptoGui");
        frame.setContentPane(new cryptoGui().Verzameling);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        new cryptoGui();
            }

    public cryptoGui() {
        account = new Accounts();
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
                user = new InformationUser(rName.getText(),rPass.getText(),rCoin.getText(),Integer.parseInt(rValue.getText()),Integer.parseInt(rQuantity.getText())); //de naam, passwoord, coin, waarde en hoeveelheid worden hier doorgegeven

                try {
                    account.createNewAccount(user.getVoornaam(),user.getPassword(),user.getCoin(),user.getCoinValue(),user.getQuantityCoin());
                } catch (IOException e1) {
                    System.out.println("Het is niet gelukt!");
               }
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

        doneButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
            }
        });
        dCurrentValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue = Integer.parseInt(dCurrentValue.getText());
            }
        });
        addDailyValueCoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                setDailyValue.setVisible(true);
            }
        });
    };
}