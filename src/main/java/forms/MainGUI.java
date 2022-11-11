package forms;

import models.Car;
import tools.Methods;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel mainCardLayout;
    private JPanel loginPanel;
    private JPanel adsPanel;
    private JPanel registerPanel;

    private JButton loginButtonUser1;
    private JButton loginButtonUser2;
    private JButton loginButtonAdmin;

    private JPanel carsPanel;
    private JButton navButAds;
    private JButton navButCars;
    private JButton navButBook;
    private JPanel navPanel;
    private JPanel pagesPanel;
    private JPanel pagesCardLayout;
    private JPanel bookingsPanel;
    private JButton navButReg;
    private JButton addCarBut;
    private JTextField makeField;
    private JTextField yearField;
    private JTextField modelField;
    private JTextField regnumField;

    public MainGUI(String title){
        super(title);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        // ADD EVENTS TO BUTTONS

        //login buttons
        loginButtonUser1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Methods.login(1);
                changeCard(mainCardLayout, pagesPanel);
                showCarAds();
            }
        });
        loginButtonUser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Methods.login(2);
                changeCard(mainCardLayout, pagesPanel);
                showCarAds();
            }
        });
        loginButtonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Methods.login(3);
                changeCard(mainCardLayout, pagesPanel);
                showCarAds();
            }
        });

        //nav buttons
        navButAds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard(pagesCardLayout, adsPanel);
                showCarAds();
            }
        });
        navButCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard(pagesCardLayout, carsPanel);
                showCars();
            }
        });
        navButBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard(pagesCardLayout, bookingsPanel);
                showBookings();
            }
        });
        navButReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard(pagesCardLayout, registerPanel);
            }
        });

        //other buttons
        addCarBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String make = makeField.getText();
                    int year = Integer.parseInt(yearField.getText());
                    String model = modelField.getText();
                    String regnum = regnumField.getText();

                    Methods.registerCar(make, year, model, regnum);

                    changeCard(pagesCardLayout, carsPanel);
                }
                catch (NumberFormatException numberFormatException) {
                    System.out.println("Model year must be an int");
                }
            }
        });
    }

    void changeCard(JPanel cardLayoutPanel, JPanel pagePanel)
    {
        cardLayoutPanel.removeAll();
        cardLayoutPanel.add(pagePanel);
        cardLayoutPanel.repaint();
        cardLayoutPanel.revalidate();
    }

    void showCarAds()
    {
        //List<CarAd> carAds = Methods.readCarAdsFromJson();
        //foreach carAd in carAds, if renterID = 0, create element in adsPanel with data from carAd
        System.out.println("show car ads in adsPanel");
    }
    void showCars()
    {
        //List<Car> cars = Methods.readCarsFromJson();
        //foreach car in cars, create element in carsPanel with data from car
        System.out.println("show car in carsPanel");
    }
    void showBookings()
    {
        //List<CarAd> carAds = Methods.readCarAdsFromJson();
        //foreach car
        //Ad in carAds, if renterID != 0, create element in bookingsPanel with data from carAd
        System.out.println("show car ads in adsPanel");
    }
}
