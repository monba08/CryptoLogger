import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


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
    private JList<String> list1;
    private JScrollPane contentPane;
    private JLabel registerLabel;
    private JButton plotGraphButton;
    private JButton backButton;
    private JButton backButton1;
    private JButton logoutButton;
    private JButton backButton2;
    private JButton backButton3;
    private JLabel loginError;
    private JTextField plotCoin;
    private JButton removeCoinButton;
    private JPanel removeCoin;
    private JTextField delCoin;
    private JButton doneButton3;
    private JButton backButton4;
    private JLabel cryptoLabel;
    private JLabel nameLabel;
    private JLabel passLabel;
    private JLabel portLabel;
    private JLabel nCoinLabel;
    private JLabel accLabel;
    private JLabel dailyLabel;
    private JLabel totalValueLabel;
    private JLabel loginLabel;
    private JLabel existsLabel;
    private JLabel removingCoin;
    private ImageIcon image1;
    //public Accounts account;
    //public static InformationUser user;
    //public Portfolio port;
    //public ExistingUser eu;
    //public ExistingUser eu2;
    //public Coin coin;
    //public Coin coin2;
    static DefaultListModel<String> model;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        JFrame frame = new JFrame("cryptoGui");
        frame.setContentPane(new cryptoGui().Verzameling);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        InformationUser user = InformationUser.getiUserInstance();

        try {
            user.readFromFile("list.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public cryptoGui() {
        //zetten van fotos
        cryptoLabel.setIcon(new ImageIcon("img/Crypto.png"));
        dailyLabel.setIcon(new ImageIcon("img/daily.png"));

        //zetten van font
        portLabel.setFont(new Font("Setif",Font.PLAIN,25));
        nCoinLabel.setFont(new Font("Setif",Font.PLAIN,25));
        accLabel.setFont(new Font("Setif",Font.PLAIN,25));


        //account = new Accounts();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(true);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                loginLabel.setText("");
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

                //user = new InformationUser(); //de naam worden hier doorgegeven
                InformationUser user = InformationUser.getiUserInstance();
                Accounts account = Accounts.getAccountInstance();
                try {
                    if (!user.checkName(rName.getText())) {
                        user.writeToFile(rName.getText());
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
                        registerLabel.setText("");
                        rName.setText("");
                        rPass.setText("");
                        rCoin.setText("");
                        rValue.setText("");
                        rQuantity.setText("");
                        //registerLabel.setText("Het is gelukt!");
                    }
                    else{
                        registerLabel.setText("User already exists!");
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
                /*try {
                    port = new Portfolio();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }*/
                //als er op newCoin wordt gedrukt ----> zie hier onder
                String naam = nameField.getText(); //dit is waar de naam wordt opgeslagen
                String pass = pasField.getText(); //dit is waar de passwoord wordt opgeslagen.
                System.out.println(naam);
                //hier moet dus een manier bestaan om alle data van deze gebruiker te extracten uit de juiste files.
                //if persoon bestaat, laad juiste bestanden
                Accounts account = Accounts.getAccountInstance();
                Portfolio port = Portfolio.getPortfolioInstance();
                                    try {
                        if (account.logIn(naam, pass)) {
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

                            //Total value
                            totalValueLabel.setText("Total Value of portfolio: "+port.calculateTotalValue());

                            //Portfolio.getPortfolioInstance();
                            for (String str : port.UserInfoList) {

                                switch (i) {
                                    case 0:
                                        prefix = "Voornaam: ";
                                        break;
                                    case 2:
                                        prefix = "Coin: ";
                                        break;
                                    case 3:
                                        prefix = "Value: ";
                                       break;
                                    case 4:
                                        prefix = "Quantity: ";
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
                            loginLabel.setText("User doesn't exist or password is incorrect. Please try again.");
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
                //eu = new ExistingUser();
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);


                //hier worden de nieuwe gegevens opgeslagen van de coin

                String nameCoin = nName.getText();
                int newValue = Integer.parseInt(nValue.getText());
                int newQuantity= Integer.parseInt(nQuantity.getText());
                ExistingUser eUser = ExistingUser.getUserInstance();
                try {
                    eUser.newCoin(nameCoin,newValue,newQuantity);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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
                Portfolio port = Portfolio.getPortfolioInstance();
                try {
                    port.readFromFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                int i=0;
                model = new DefaultListModel<>();
                String prefix="";

                //update total value
                totalValueLabel.setText("Total Value of portfolio: "+port.calculateTotalValue());

                //try {
                    //Portfolio.getPortfolioInstance();
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
               /* } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }*/
                list1.setModel(model);
                //try {
                port.calculateTotalValue();
              //  } catch (FileNotFoundException e1) {
               //     e1.printStackTrace();
                //}
            }
        });
        doneButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //coin =new Coin(0,0," ");
                Coin coin = Coin.getCoinInstance();
                try {
                    if(coin.setCurrentValueCoin(nameCoin.getText(),Integer.parseInt(dCurrentValue.getText()))!=1)
                    {
                        existsLabel.setText("Coin doesn't exist");
                    }

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

                int mon = 0,tue=0,wen=0,thurs=0,fri=0,sat=0,sun=0;
                int index= 0;
                Coin coin = Coin.getCoinInstance();
                Portfolio port = Portfolio.getPortfolioInstance();
                try {
                    coin.createSecondArraylist(port.UserInfoList.get(0));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                index = coin.coinValueList.indexOf(plotCoin.getText());
                //System.out.println("Index is: "+index+". En in de list: "+Coin.coinValueList.get(index));

                for(int i=index+1;i<i+7;i++)
                {
                    if(i==index+1)
                        mon=Integer.parseInt(coin.coinValueList.get(i));
                    if(i==index+2)
                        tue=Integer.parseInt(coin.coinValueList.get(i));
                    if(i==index+3)
                        wen=Integer.parseInt(coin.coinValueList.get(i));
                    if(i==index+4)
                        thurs=Integer.parseInt(coin.coinValueList.get(i));
                    if(i==index+5)
                        fri=Integer.parseInt(coin.coinValueList.get(i));
                    if(i==index+6)
                        sat=Integer.parseInt(coin.coinValueList.get(i));
                    if(i==index+7)
                        sun=Integer.parseInt(coin.coinValueList.get(i));

                }

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.addValue(mon,"Crypto-"+plotCoin.getText(),"Monday");
                dataset.addValue(tue,"Crypto-"+plotCoin.getText(),"Tuesday");
                dataset.addValue(wen,"Crypto-"+plotCoin.getText(),"Wednesday");
                dataset.addValue(thurs,"Crypto-"+plotCoin.getText(),"Thursday");
                dataset.addValue(fri,"Crypto-"+plotCoin.getText(),"Friday");
                dataset.addValue(sat,"Crypto-"+plotCoin.getText(),"Saturday");
                dataset.addValue(sun,"Crypto-"+plotCoin.getText(),"Sunday");

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
                registerLabel.setText("");
                rName.setText("");
                rPass.setText("");
                rCoin.setText("");
                rValue.setText("");
                rQuantity.setText("");
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
                loginLabel.setText("");
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
                //////
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
                existsLabel.setText("");
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
        removeCoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
                removeCoin.setVisible(true);

            }
        });
        backButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(true);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
                removeCoin.setVisible(false);
                removingCoin.setText("");
            }
        });
        doneButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eu2=new ExistingUser();
                try {
                    if(ExistingUser.getUserInstance().removeCoin(delCoin.getText()))
                    {
                        removingCoin.setText("Coin removed");
                    }
                    else
                    {
                        removingCoin.setText("Coin doesn't exist.");
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                registerScherm.setVisible(false);
                loginScherm.setVisible(false);
                inlogScherm.setVisible(false);
                portfolio.setVisible(false);
                newCoin.setVisible(false);
                setDailyValue.setVisible(false);
                removeCoin.setVisible(true);
                delCoin.setText("");

            }
        });
    };
}