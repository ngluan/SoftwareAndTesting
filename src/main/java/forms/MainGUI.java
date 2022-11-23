package forms;

import models.Car;
import models.CarAd;
import tools.Methods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private JPanel carsListPanel;
    private JPanel adsListPanel;
    private JButton logoutButton;

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
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Methods.login(0);
                changeCard(mainCardLayout, loginPanel);
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
                    showCars();
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
        List<CarAd> carAds = Methods.readAdsFromJSON();
        //foreach carAd in carAds, if renterID = 0, create element in adsPanel with data from carAd
        adsListPanel.removeAll();
        adsListPanel.setLayout(new GridLayout(carAds.size()+1, 0, 10, 10));
        for(CarAd carAd : carAds)
        {
            if(carAd.getRenterId() == 0 && Methods.getCar(carAd.getCarRegnum()) != null) //if car isn't rented && exists
            {
                // Create GUI
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.setLayout(new GridLayout(2, 5, 10, 10));
                Car car = Methods.getCar(carAd.getCarRegnum());
                panel.add(new JLabel(carAd.getCarRegnum()));
                panel.add(new JLabel());
                panel.add(new JLabel());
                panel.add(new JLabel());
                if (car.getUser() == Methods.userId) {
                    JButton buttonDelete = new JButton("Delete add");
                    panel.add(buttonDelete);
                    buttonDelete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Methods.deleteCarAd(carAd.getAdId());
                            System.out.println("delete car ad" + carAd.getAdId());
                            showCarAds();
                        }
                    });
                }
                else {
                    panel.add(new JLabel());
                }
                panel.add(new JLabel("Start: " + carAd.getStartDate()));
                panel.add(new JLabel("End: " + carAd.getEndDate()));
                panel.add(new JLabel());
                panel.add(new JLabel());
                if (car.getUser() != Methods.userId) {
                    JButton buttonRent = new JButton("Rent car");
                    panel.add(buttonRent);
                    buttonRent.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Methods.rentCarAd(carAd.getAdId());
                            System.out.println("rent car: " + carAd.getAdId());
                            showCarAds();
                        }
                    });
                }
                else {
                    panel.add(new JLabel());
                }
                adsListPanel.add(panel);
            }
        }
        revalidate();
        repaint();
        System.out.println("show car ads in adsPanel");
    }
    void showCars()
    {
        List<Car> cars = Methods.readCarsFromJSON(Methods.carsJSON);
        //foreach car in cars, create element in carsPanel with data from car
        carsListPanel.removeAll();
        //loop and find length with car.user == UserId?
        carsListPanel.setLayout(new GridLayout(cars.size()+1, 0, 10, 10));
        for(Car car : cars)
        {
            if (car.getUser() == Methods.userId)
            {
                // Create GUI
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.setLayout(new GridLayout(2, 6, 10, 10));
                panel.add(new JLabel(car.getMake() + " " + car.getModel() + " " + car.getModelYear()));
                panel.add(new JLabel());
                panel.add(new JLabel());
                panel.add(new JLabel());
                panel.add(new JLabel());
                JButton buttonDelete = new JButton("Delete car");
                panel.add(buttonDelete);
                panel.add(new JLabel("Registration number: " + car.getRegistrationnumber()));
                panel.add(new JLabel("Start date:", SwingConstants.RIGHT));
                JTextField startField = new JTextField();
                panel.add(startField);
                panel.add(new JLabel("End date:", SwingConstants.RIGHT));
                JTextField endField = new JTextField();
                panel.add(endField);
                JButton buttonCreateAd = new JButton("Create Ad");
                panel.add(buttonCreateAd);

                // Assign buttons
                buttonDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Methods.deleteCar(car.getRegistrationnumber());
                        System.out.println("delete car " + car.getRegistrationnumber());
                        showCars();
                    }
                });
                buttonCreateAd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try
                        {
                            Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startField.getText());
                            Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endField.getText());
                            Methods.createCarAd(car.getRegistrationnumber(), startDate, endDate);
                            System.out.println("create ad for car: " + car.getRegistrationnumber());
                            showCars();
                        }
                        catch (ParseException parseException)
                        {
                            System.out.println("Date must be in format dd/mm/yyyy");
                        }
                    }
                });

                carsListPanel.add(panel);
            }
        }
        revalidate();
        repaint();
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
