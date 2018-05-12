import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.UIManager.*;


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
    private JButton backButton;
    private JButton backButton1;
    private JButton logoutButton;
    private JButton backButton2;
    private JButton backButton3;
    private JLabel loginError;
    public Accounts account;
    public static InformationUser user;
    public Portfolio port;
    public ExistingUser eu;
    public Coin coin;
    static DefaultListModel<String> model;
    public static ArrayList<String> coinList = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
                try {
                    if (!user.checkName(rName.getText())) {
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
                        textVeld.setText("User already exists!");
                        registerScherm.setVisible(true);
                        loginScherm.setVisible(false);
                        inlogScherm.setVisible(false);
                        portfolio.setVisible(false);
                        newCoin.setVisible(false);
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
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

                            for (String str : port.UserInfoList) {

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
                        else
                            loginError.setText("User doesn't exist or password is incorrect. Please try again.");
                            nameField.setText("");
                            pasField.setText("");
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

        /*doneButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
            }
        });*/
        /*dCurrentValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                coin.setValueCoin(Integer.parseInt(dCurrentValue.getText()));
            }
        });*/
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

                for (String str : port.UserInfoList) {

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

            }
        });
        doneButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coin =new Coin(0,0," ");
                try {
                    coin.setCurrentValueCoin(nameCoin.getText(),Integer.parseInt(dCurrentValue.getText()));
                    System.out.println("currentvalue "+dCurrentValue.getText()+ " Second: " +Integer.parseInt(dCurrentValue.getText()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                nameCoin.setText("");
                dCurrentValue.setText("");
            }
        });

        plotGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coinList.clear();
                Scanner scanFile = null;
                System.out.println("fileName: "+port.UserInfoList.get(0)+".txt");
                try {
                    scanFile = new Scanner(new File(port.UserInfoList.get(0)+".txt"));
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                scanFile.nextLine();

                while(scanFile.hasNextLine())
                {
                    coinList.add(scanFile.next());
                    if(scanFile.hasNextInt())
                    {
                        coinList.add(Integer.toString(scanFile.nextInt()));
                    }
                }
                scanFile.close();
                int mon = 0,tue=0,wen=0,thurs=0,fri=0,sat=0,sun=0;
                Scanner scan = new Scanner(System.in);
                /**
                System.out.println("Which coin would you like to plot a graph of: ");
                String inpUser = scan.next();
                scan.close();
                Dit moet verwerkt worden in de GUI waarbij er dan gevraagd wordt van welke munt er een plot moet komen. **/
                int index=coinList.indexOf(inpUser);
                System.out.println("Index is: "+index+". En in de list: "+coinList.get(index));

                for(int i=index+1;i<i+7;i++)
                {
                    if(i==index+1)
                        mon=Integer.parseInt(coinList.get(i));
                    if(i==index+2)
                        tue=Integer.parseInt(coinList.get(i));
                    if(i==index+3)
                        wen=Integer.parseInt(coinList.get(i));
                    if(i==index+4)
                        thurs=Integer.parseInt(coinList.get(i));
                    if(i==index+5)
                        fri=Integer.parseInt(coinList.get(i));
                    if(i==index+6)
                        sat=Integer.parseInt(coinList.get(i));
                    if(i==index+7)
                        sun=Integer.parseInt(coinList.get(i));

                }

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.addValue(mon,"Crypto-BTC","Maandag");
                dataset.addValue(tue,"Crypto-BTC","Dinsdag");
                dataset.addValue(wen,"Crypto-BTC","Woensdag");
                dataset.addValue(thurs,"Crypto-BTC","Donderdag");
                dataset.addValue(fri,"Crypto-BTC","Vrijdag");
                dataset.addValue(sat,"Crypto-BTC","Zaterdag");
                dataset.addValue(sun,"Crypto-BTC","Zondag");

                JFreeChart chart = ChartFactory.createLineChart("CryptoChart","Days","Values",dataset, PlotOrientation.VERTICAL,true,true,false);
                chart.setBackgroundPaint(Color.GREEN);
                ChartFrame frame = new ChartFrame("CryptoChart",chart);
                frame.setVisible(true);
                frame.setSize(450,500);
                //http://www.java2s.com/Code/Java/Chart/JFreeChartLineChartDemo1.htm
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(true);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
            }
        });
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(true);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(true);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
            }
        });
        backButton2.addActionListener(new ActionListener() {
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
        backButton3.addActionListener(new ActionListener() {
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
    };
}