import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;


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
    private JLabel naamVeld;
    private JLabel coinVeld;
    private JLabel valueVeld;
    private JLabel quantityVeld;
    private JButton updatePortfolioButton;
    private JTextField nameCoin;
    private JTextArea textArea1;
    private JList<String> list1;
    private JScrollPane contentPane;
    private JLabel textVeld;
    private JButton plotGraphButton;
    public Accounts account;
    public static InformationUser user;
    public Portfolio port;
    public ExistingUser eu;
    public Coin coin;
    static DefaultListModel<String> model;

    public static void main(String[] args) {
        JFrame frame = new JFrame("cryptoGui");
        frame.setContentPane(new cryptoGui().Verzameling);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        user = new InformationUser();
        try {
            user.fillList("list.txt"); //er is hier iets mis ma
            //weet ni wa er mis is
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
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

                user = new InformationUser(); //de naam worden hier doorgegeven
                if (!user.namen.contains(rName.getText())) {
                    user.addPerson(rName.getText());
                    registerScherm.setVisible(false);
                    loginScherm.setVisible(true);
                    inlogScherm.setVisible(false);
                    portfolio.setVisible(false);
                    newCoin.setVisible(false);
                    try {
                        account.createNewAccount(rName.getText(),rPass.getText(),rCoin.getText(),Integer.parseInt(rValue.getText()),Integer.parseInt(rQuantity.getText()));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    textVeld.setText("Het is gelukt!");
                }
                else{
                    textVeld.setText("Gebruiker bestaat al!");
                    registerScherm.setVisible(true);
                    loginScherm.setVisible(false);
                    inlogScherm.setVisible(false);
                    portfolio.setVisible(false);
                    newCoin.setVisible(false);
                }

            }
        });
        loginButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    port = new Portfolio();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                //als er op newCoin wordt gedrukt ----> zie hier onder
                String naam = nameField.getText(); //dit is waar de naam wordt opgeslagen
                String pass = pasField.getText(); //dit is waar de passwoord wordt opgeslagen.
                System.out.println(naam);
                //hier moet dus een manier bestaan om alle data van deze gebruiker te extracten uit de juiste files.
                //if persoon bestaat, laad juiste bestanden
                    try {
                        if (account.logIn(naam, pass) == true) {
                            registerScherm.setVisible(false);
                            loginScherm.setVisible(false);
                            inlogScherm.setVisible(false);
                            portfolio.setVisible(true);
                            newCoin.setVisible(false);
                            try {
                                port.readFromFile();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            int i = 0;
                            model = new DefaultListModel<>();
                            String prefix = "";

                            for (String str : port.Account) {

                                switch (i) {
                                    case 0:
                                        prefix = "Voornaam: ";
                                        break;
                                    case 2:
                                        prefix = "Coin: ";
                                        //model.addElement("Coin: "+str);
                                        break;
                                    case 3:
                                        prefix = "Value: ";
                                        //model.addElement("Value: "+str);
                                        break;
                                    case 4:
                                        prefix = "Quantity: ";
                                        //model.addElement("Quantity: "+str);
                                        break;
                                    default:
                                        break;
                                }
                                if (i != 1) {
                                    model.addElement(prefix + str);
                                }

                                i++;
                                if (i > 4) {
                                    i = 2;
                                }

                            }
                            list1.setModel(model);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                //else
                    //toon in een text area da het mislukt is


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
                eu = new ExistingUser();
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);


                //hier worden de nieuwe gegevens opgeslagen van de coin

                String nameCoin = nName.getText();
                int newValue = Integer.parseInt(nValue.getText());
                int newQuantity= Integer.parseInt(nQuantity.getText());
                try {
                    eu.newCoin(nameCoin,newValue,newQuantity);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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
        updatePortfolioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    port.readFromFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                int i=0;
                model = new DefaultListModel<>();
                String prefix="";

                for (String str : port.Account) {

                    switch (i) {
                        case 0:
                            prefix="Voornaam: ";
                            break;
                        case 2:
                            prefix="Coin: ";
                            //model.addElement("Coin: "+str);
                            break;
                        case 3:
                            prefix="Value: ";
                            //model.addElement("Value: "+str);
                            break;
                        case 4:
                            prefix="Quantity: ";
                           //model.addElement("Quantity: "+str);
                            break;
                        default:
                            break;
                }
                    if(i!=1)
                    {
                        model.addElement(prefix+str);
                    }

                    i++;
                    if(i>4)
                    {
                        i=2;
                    }

                }
                list1.setModel(model);
                //ArrayList<String> myArrayList = port.Account;
                //model.clear();
                //String[] myArray=myArrayList.toArray(new String[myArrayList.size()]);
                //list1 = new JList<String>(myArray);
                //list1.setVisibleRowCount(10);
                //contentPane.add(list1);
                //contentPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                //contentPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


                //System.out.println("Fuck:"+myArrayList.get(3));
               // (new JScrollPane((list1)));
            }
        });
        doneButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coin =new Coin(0,0,"");
                try {
                    coin.setCurrentValueCoin(nameCoin.getText(),Integer.parseInt(dCurrentValue.getText()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        plotGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.addValue(200,"Crypto-BTC","Maandag");
                dataset.addValue(100,"Crypto-BTC","Dinsdag");
                dataset.addValue(300,"Crypto-BTC","Woensdag");
                dataset.addValue(10,"Crypto-BTC","Donderdag");
                dataset.addValue(600,"Crypto-BTC","Vrijdag");
                dataset.addValue(452,"Crypto-BTC","Zaterdag");
                dataset.addValue(635,"Crypto-BTC","Zondag");
                JFreeChart chart = ChartFactory.createLineChart("CryptoChart","Days","Values",dataset, PlotOrientation.VERTICAL,true,true,false);
                chart.setBackgroundPaint(Color.GREEN);
                ChartFrame frame = new ChartFrame("CryptoChart",chart);
                frame.setVisible(true);
                frame.setSize(450,500);
                //http://www.java2s.com/Code/Java/Chart/JFreeChartLineChartDemo1.htm
            }
        });
    };
}