/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author ADMUDS
 */
public class Optimizer {

    /**
     * @param args the command line arguments
     */
    public static JFrame startUpFrame;
    public static JPanel startUpPanel;
    public static int noOfIndustries;
    public static JPanel checkPanel;
    private static double constraint1[][];
    
    public static void displayStartUpInterface(){
        startUpFrame=new JFrame("Industrial Plant Building Layout Optimizer");
        startUpPanel=new JPanel();
        startUpPanel.setBackground(Color.PINK);
        startUpPanel.setSize(1280, 760);
        startUpPanel.setLayout(null);
            
        ImageIcon logo=new ImageIcon("logo.png");
        JLabel logoLabel=new JLabel(logo);
        logoLabel.setBounds(5, 10, logoLabel.getPreferredSize().width, logoLabel.getPreferredSize().height);
        startUpPanel.add(logoLabel);
        
        JLabel logoLabel2=new JLabel(logo);
        logoLabel2.setBounds(1000, 10, logoLabel2.getPreferredSize().width, logoLabel2.getPreferredSize().height);
        startUpPanel.add(logoLabel2);
        
        JLabel topLabel=new JLabel("Industrial Plant Building Layout Optimizer");
        topLabel.setFont(new Font("Times new roman", Font.BOLD, 38));
        topLabel.setBounds(250, 45, topLabel.getPreferredSize().width, topLabel.getPreferredSize().height);
        startUpPanel.add(topLabel);
        
        JLabel nameLabel=new JLabel("InduPark Optimizer 1.0");
        nameLabel.setFont(new Font("Times new roman", Font.BOLD, 25));
        nameLabel.setBounds(460, 100, nameLabel.getPreferredSize().width, nameLabel.getPreferredSize().height);
        startUpPanel.add(nameLabel);
        
        JLabel ownerLabel=new JLabel("BY: ATOYEBI, ADEYINKA ABIODUN");
        ownerLabel.setFont(new Font("Times new roman", Font.BOLD, 20));
        ownerLabel.setBounds(663, 140, ownerLabel.getPreferredSize().width, ownerLabel.getPreferredSize().height);
        startUpPanel.add(ownerLabel);
        
        JLabel supLabel=new JLabel("SUPERVISORS: PROF. B. O. AKINNULI");
        supLabel.setFont(new Font("Times new roman", Font.BOLD, 18));
        supLabel.setBounds(663, 165, supLabel.getPreferredSize().width, supLabel.getPreferredSize().height);
        startUpPanel.add(supLabel);
        
        JLabel supLabel1=new JLabel("PROF. B. KAREEM");
        supLabel1.setFont(new Font("Times new roman", Font.BOLD, 18));
        supLabel1.setBounds(797, 185, supLabel1.getPreferredSize().width, supLabel1.getPreferredSize().height);
        startUpPanel.add(supLabel1);
        
        JLabel supLabel2=new JLabel("PROF. S. A. OLUWADARE");
        supLabel2.setFont(new Font("Times new roman", Font.BOLD, 18));
        supLabel2.setBounds(797, 205, supLabel2.getPreferredSize().width, supLabel2.getPreferredSize().height);
        startUpPanel.add(supLabel2);
        
        JPanel infoPanel=new JPanel();
        infoPanel.setBounds(230, 250, 400, 450);
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        infoPanel.setLayout(null);
        startUpPanel.add(infoPanel);
        
        checkPanel=new JPanel();
        checkPanel.setBounds(650, 250, 400, 450);
        checkPanel.setBackground(Color.WHITE);
        checkPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        checkPanel.setLayout(null);
        startUpPanel.add(checkPanel);
        checkPanel.setVisible(false);
        
        JLabel topLabel2=new JLabel("Industries Saved");
        topLabel2.setFont(new Font("Monospaced", Font.BOLD, 16));
        topLabel2.setBounds(100, 5, topLabel2.getPreferredSize().width, topLabel2.getPreferredSize().height);
        checkPanel.add(topLabel2);
        
        JLabel infoLabel=new JLabel("Enter the number of industries: ");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        infoLabel.setBounds(5, 50, infoLabel.getPreferredSize().width, infoLabel.getPreferredSize().height);
        infoPanel.add(infoLabel);
        
        JTextField infoField=new JTextField();
        infoField.setFont(new Font("Arial", Font.BOLD, 14));
        infoField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        infoField.setBounds(300, 45, 70, 33);
        infoPanel.add(infoField);
        
        JButton startButton=new JButton("Start >>>");
        startButton.setFont(new Font("Times new roman", Font.PLAIN, 20));
        startButton.setBackground(Color.PINK);
        startButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        startButton.setBounds(100, 90, 200, 40);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startButtonButtonActionPerformed(evt, infoField, infoPanel);
                startButton.setEnabled(false);
                infoField.setEnabled(false);
                checkPanel.setVisible(true);
            }
        });
        infoPanel.add(startButton);
        
        
        
        startUpFrame.add(startUpPanel);
        startUpFrame.setSize(1280, 760);
        startUpFrame.setVisible(true);
        startUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void startButtonButtonActionPerformed(ActionEvent evt, JTextField field, JPanel panel){
        noOfIndustries=Integer.parseInt(field.getText());
        constraint1=new double[13+noOfIndustries*2+2][noOfIndustries*4+15];
        
        JLabel top=new JLabel("Enter name of Industry 1 below:");
        top.setFont(new Font("Arial", Font.PLAIN, 22));
        top.setBounds(50, 160, top.getPreferredSize().width, top.getPreferredSize().height);
        panel.add(top);
        
        JTextField nameField=new JTextField();
        nameField.setBounds(5, 195, 390, 40);
        nameField.setFont(new Font("Monospaced", Font.BOLD, 18));
        nameField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel.add(nameField);
        
        JButton doneButton=new JButton("Done");
        doneButton.setFont(new Font("Arial", Font.PLAIN, 20));
        doneButton.setBackground(Color.PINK);
        doneButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        doneButton.setBounds(100, 250, 200, 40);
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doneButtonButtonActionPerformed(evt, nameField, panel, top, doneButton);
            }
        });
        panel.add(doneButton);
        panel.setSize(401, 451);
        industryName=new String[noOfIndustries+1];
    }
    
    public static String industryName[];
    public static int countIndustriesDone=1;
    public static void doneButtonButtonActionPerformed(ActionEvent evt, JTextField field, JPanel panel, JLabel label, JButton button){
        checkPanel.setSize(401, 451);
        checkPanel.setVisible(true);

        if(countIndustriesDone==noOfIndustries){
            field.setEditable(false);
            button.setEnabled(false);
            JLabel optionLabel=new JLabel("Do you wish to edit any of the industry name provided above?");
            optionLabel.setFont(new Font("Times new roman", Font.BOLD, 14));
            optionLabel.setBounds(10, 380, optionLabel.getPreferredSize().width, optionLabel.getPreferredSize().height);
            checkPanel.add(optionLabel);
            
            JButton editButton=new JButton("Yes, I need to edit");
            editButton.setFont(new Font("Times new roman", Font.PLAIN, 14));
            editButton.setBackground(Color.PINK);
            editButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            editButton.setBounds(10, 400, 120, 30);
            editButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    editButtonButtonActionPerformed(evt);
                }
            });
            checkPanel.add(editButton);
        
            JButton confirmButton=new JButton("No, I don't");
            confirmButton.setFont(new Font("Times new roman", Font.PLAIN, 14));
            confirmButton.setBackground(Color.PINK);
            confirmButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            confirmButton.setBounds(250, 400, 120, 30);
            confirmButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    confirmButtonButtonActionPerformed(evt);
                }
            });
            checkPanel.add(confirmButton);
        }
        industryName[countIndustriesDone]=field.getText();
        JLabel nameLabel=new JLabel(""+countIndustriesDone+". "+industryName[countIndustriesDone]);
        nameLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        nameLabel.setBounds(5, 19+25*countIndustriesDone, nameLabel.getPreferredSize().width, nameLabel.getPreferredSize().height);
        checkPanel.add(nameLabel);
        field.setText("");

        countIndustriesDone++;
        if(countIndustriesDone<=noOfIndustries){
        label.setText("Enter name of Industry "+countIndustriesDone+" below:");
        }
        checkPanel.setSize(401, 451);
        startUpPanel.setSize(1281, 761);
    }
    public static void editButtonButtonActionPerformed(ActionEvent evt){
        
    }
    
    public static JFrame inputFrame;
    public static JPanel inputPanel;
    public static String unitOfMeasurementInfo="";
    public static String area;
    public static String currency;
    public static JTextField maxAreaField;
    public static JTextField costOfBuildingPerAreaField;
    public static JTextField initialInvestmentField;
    public static JTextField costField;
    public static JTextField maintenanceField;
    public static JTextField constantField;
    public static double unit=0.0;
    public static String unitM="";
    public static String unitW="";
    public static String curSym="";
    public static double percentage;
    public static double constant;
    public static void confirmButtonButtonActionPerformed(ActionEvent evt){
        inputFrame=new JFrame("Units declaration");
        
        inputPanel=new JPanel();
        inputPanel.setBounds(430, 230, 300, 300);
        inputPanel.setBackground(Color.PINK);
        inputPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        inputPanel.setLayout(null);
        
        JPanel panel1=new JPanel();
        panel1.setBounds(10, 10, 500, 700);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        panel1.setBackground(Color.WHITE);
        
        JLabel unitOfMeasurement=new JLabel("Working area");
        unitOfMeasurement.setFont(new Font("Arial", Font.BOLD, 20));
        unitOfMeasurement.setBounds(40, 10, unitOfMeasurement.getPreferredSize().width, unitOfMeasurement.getPreferredSize().height);
        panel1.add(unitOfMeasurement);
        
        JComboBox jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setBounds(43, 45, 125, 30);
        jComboBox1.setFont(new java.awt.Font("Arial", 1, 14));
        jComboBox1.setBackground(Color.PINK);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "per 92.90 sq. m", "per 46.45 sq. m", "per 1000 sq. ft.", "per 500 sq. ft."}));
        panel1.add(jComboBox1);
        
        
        JLabel currencyLabel=new JLabel("Currency");
        currencyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        currencyLabel.setBounds(270, 10, currencyLabel.getPreferredSize().width, currencyLabel.getPreferredSize().height);
        panel1.add(currencyLabel);
        
        JComboBox jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox2.setBounds(270, 45, 100, 30);
        jComboBox2.setFont(new java.awt.Font("Arial", 1, 14));
        jComboBox2.setBackground(Color.PINK);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Naira (₦)", "Dollar ($)", "Pounds (£)", "Euro (€)", "Cedi (GH₵)", "Rupee (₹)"}));
        panel1.add(jComboBox2);
        
              
        JLabel initialInvestmentFieldLabel=new JLabel("Initial Capital to Invest");
        initialInvestmentFieldLabel.setFont(new Font("Arial", Font.BOLD, 20));
        initialInvestmentFieldLabel.setBounds(131, 80, initialInvestmentFieldLabel.getPreferredSize().width, initialInvestmentFieldLabel.getPreferredSize().height);
        panel1.add(initialInvestmentFieldLabel);
        
        initialInvestmentField=new JTextField();
        initialInvestmentField.setBounds(137, 105, 200, 30);
        initialInvestmentField.setFont(new Font("Monospaced", Font.BOLD, 16));
        initialInvestmentField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel1.add(initialInvestmentField);


        JLabel costOfBuildingPerAreaLabel=new JLabel("Price per Acre");
        costOfBuildingPerAreaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        costOfBuildingPerAreaLabel.setBounds(172, 220, costOfBuildingPerAreaLabel.getPreferredSize().width, costOfBuildingPerAreaLabel.getPreferredSize().height);
        panel1.add(costOfBuildingPerAreaLabel);
        
        costOfBuildingPerAreaField=new JTextField();
        costOfBuildingPerAreaField.setBounds(137, 245, 200, 30);
        costOfBuildingPerAreaField.setFont(new Font("Monospaced", Font.BOLD, 16));
        costOfBuildingPerAreaField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel1.add(costOfBuildingPerAreaField);
        
        JLabel maxAreaLabel=new JLabel("Number of Acres");
        maxAreaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        maxAreaLabel.setBounds(160, 145, maxAreaLabel.getPreferredSize().width, maxAreaLabel.getPreferredSize().height);
        panel1.add(maxAreaLabel);
        
        maxAreaField=new JTextField();
        maxAreaField.setBounds(137, 170, 200, 30);
        maxAreaField.setFont(new Font("Monospaced", Font.BOLD, 16));
        maxAreaField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel1.add(maxAreaField);
        
        JButton proceedButton1=new JButton("Get Values");
        proceedButton1.setFont(new Font("Times new roman", Font.BOLD, 14));
        proceedButton1.setBackground(Color.PINK);
        proceedButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        proceedButton1.setBounds(342, 170, 80, 30);
        proceedButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                areaMax=0.7*Double.parseDouble(maxAreaField.getText());
                double areaWaste=0.3*Double.parseDouble(maxAreaField.getText());
                
                JLabel l1=new JLabel("PLANT BUILDING AREA (70%)");
                l1.setFont(new Font("Arial", Font.BOLD, 16));
                l1.setBounds(10, 495, l1.getPreferredSize().width, l1.getPreferredSize().height);
                panel1.add(l1);

                JTextField l1Field=new JTextField(String.format("%.2facres", areaMax));
                l1Field.setBounds(250, 490, 150, 30);
                l1Field.setFont(new Font("Monospaced", Font.BOLD, 16));
                l1Field.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
                l1Field.setEditable(false);
                panel1.add(l1Field);
                
                JLabel l2=new JLabel("SUPPORTING LAYOUTS (30%)");
                l2.setFont(new Font("Arial", Font.BOLD, 16));
                l2.setBounds(10, 520, l2.getPreferredSize().width, l2.getPreferredSize().height);
                panel1.add(l2);

                JTextField l2Field=new JTextField(String.format("%.2facres", areaWaste));
                l2Field.setBounds(250, 515, 150, 30);
                l2Field.setFont(new Font("Monospaced", Font.BOLD, 16));
                l2Field.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
                l2Field.setEditable(false);
                panel1.add(l2Field);
                
                inputPanel.setSize(1279, 760);
            }
        });
        panel1.add(proceedButton1);
        

        JLabel costLabel=new JLabel("Annual lease cost of Building Area per selected unit");
        costLabel.setFont(new Font("Arial", Font.BOLD, 18));
        costLabel.setBounds(15, 290, costLabel.getPreferredSize().width, costLabel.getPreferredSize().height);
        panel1.add(costLabel);
        
        costField=new JTextField();
        costField.setBounds(137, 315, 200, 30);
        costField.setFont(new Font("Monospaced", Font.BOLD, 16));
        costField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel1.add(costField);
        
        JLabel maintenanceLabel=new JLabel("Annual maintenance cost of Building Area per selected unit");
        maintenanceLabel.setFont(new Font("Arial", Font.BOLD, 17));
        maintenanceLabel.setBounds(15, 355, maintenanceLabel.getPreferredSize().width, maintenanceLabel.getPreferredSize().height);
        panel1.add(maintenanceLabel);
        
        maintenanceField=new JTextField();
        maintenanceField.setBounds(137, 380, 200, 30);
        maintenanceField.setFont(new Font("Monospaced", Font.BOLD, 16));
        maintenanceField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel1.add(maintenanceField);
        
        JLabel constantLabel=new JLabel("Tax on gross annual production value (%)");
        constantLabel.setFont(new Font("Arial", Font.BOLD, 20));
        constantLabel.setBounds(35, 420, constantLabel.getPreferredSize().width, constantLabel.getPreferredSize().height);
        panel1.add(constantLabel);
        
        
        constantField=new JTextField();
        constantField.setBounds(137, 445, 200, 30);
        constantField.setFont(new Font("Monospaced", Font.BOLD, 16));
        constantField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.PINK));
        panel1.add(constantField);
            
        JButton proceedButton=new JButton("Proceed");
        proceedButton.setFont(new Font("Times new roman", Font.BOLD, 20));
        proceedButton.setBackground(Color.PINK);
        proceedButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        proceedButton.setBounds(100, 630, 300, 50);
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(jComboBox1.getSelectedIndex()==0){
                    unit=1000;
                    unitM="sq. m.";
                    unitW="m";
                }
                else if(jComboBox1.getSelectedIndex()==1){
                    unit=46.45;
                    unitM="sq. m.";
                    unitW="m";
                }
                else if(jComboBox1.getSelectedIndex()==2){
                    unit=1000.0;
                    unitM="sq. ft.";
                    unitW="ft";
                }
                else if(jComboBox1.getSelectedIndex()==3){
                    unit=500.0;
                    unitM="sq. ft.";
                    unitW="ft";
                }
                
                if(jComboBox2.getSelectedIndex()==0){
                    curSym="₦";
                }
                else if(jComboBox2.getSelectedIndex()==1){
                    curSym="$";
                }
                else if(jComboBox2.getSelectedIndex()==2){
                    curSym="£";
                }
                else if(jComboBox2.getSelectedIndex()==3){
                    curSym="€";
                }
                else if(jComboBox2.getSelectedIndex()==4){
                    curSym="GH₵";
                }
                else if(jComboBox2.getSelectedIndex()==5){
                    curSym="₹";
                }
                area=jComboBox1.getSelectedItem().toString();
                currency=jComboBox2.getSelectedItem().toString();
                proceedButtonActionPerformed(evt);
            }
        });
        panel1.add(proceedButton);
        
        for(int i=1; i<=noOfIndustries; i++){
            if(i==1){
                JLabel topLabel=new JLabel("Industries");
                topLabel.setFont(new Font("Arial", Font.BOLD, 16));
                topLabel.setBounds(600, 10, topLabel.getPreferredSize().width, topLabel.getPreferredSize().height);
                inputPanel.add(topLabel);
            }
            JLabel industryNameLabel=new JLabel(""+i+". "+industryName[i]);
            industryNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            industryNameLabel.setBounds(550, 10+23*i, industryNameLabel.getPreferredSize().width, industryNameLabel.getPreferredSize().height);
            inputPanel.add(industryNameLabel);
        }
        
        ImageIcon logo=new ImageIcon("logo.png");
        JLabel logoLabel=new JLabel(logo);
        logoLabel.setBounds(1000, 7, logoLabel.getPreferredSize().width, logoLabel.getPreferredSize().height);
        inputPanel.add(logoLabel);
        
        inputPanel.add(panel1);
        inputFrame.add(inputPanel);
        inputFrame.setSize(1280, 760);
        inputFrame.setBackground(Color.DARK_GRAY);
        inputFrame.setVisible(true);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void proceedButtonActionPerformed(ActionEvent evt){
        try{
            
            costOfBuildingPerArea=Double.parseDouble(costOfBuildingPerAreaField.getText());
            initialInvestment=Double.parseDouble(initialInvestmentField.getText());
            percentage=0.01*(Double.parseDouble(constantField.getText()));
            constant=unit*(Double.parseDouble(costField.getText())-Double.parseDouble(maintenanceField.getText()));
            
            maintenanceField.setEditable(false);
            constantField.setEditable(false);
            costField.setEditable(false);
            
            JFrame cityUnitFrame=new JFrame("Unit Profits");
            JPanel cityUnitProfitPanel=new JPanel();
            cityUnitProfitPanel.setBounds(5, 5, 1275, 755);
            cityUnitProfitPanel.setLayout(null);
            cityUnitProfitPanel.setBackground(Color.white);
            cityUnitProfitPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
            
            ImageIcon logo=new ImageIcon("logo.png");
            JLabel logoLabel1=new JLabel(logo);
            logoLabel1.setBounds(1000, 400, logoLabel1.getPreferredSize().width, logoLabel1.getPreferredSize().height);
            cityUnitProfitPanel.add(logoLabel1);

            String cityUnitProfitInfo[]=new String[] {"", "Electricity ("+curSym+"/kW. hr)", "Water ("+curSym+"/million cu. "+unitW+".)", "Gas ("+curSym+"/cu."+unitW+".)", "Sewerage ("+curSym+"/million cu. "+unitW+".)", "Waste Disposal ("+curSym+"/Mg.)"};
            String utilityAndServiceInfo[]=new String[] {"", "Electricity (kW. hrs./yr.)", "Water (million cu. "+unitW+"./yr.)", "Gas (cu."+unitW+"./yr.)", "Sewerage (million cu. "+unitW+"./yr.)", "Waste Disposal (Mg/yr.)"};
            
            JLabel utilityAndServiceLevelTopLabel=new JLabel("Capacity for Utilities, Sewerage and Waste Disposal System");
            utilityAndServiceLevelTopLabel.setFont(new Font("Arial", Font.BOLD, 20));
            utilityAndServiceLevelTopLabel.setBounds(340, 40, utilityAndServiceLevelTopLabel.getPreferredSize().width, utilityAndServiceLevelTopLabel.getPreferredSize().height);
            cityUnitProfitPanel.add(utilityAndServiceLevelTopLabel);

            JTextField utilityAndServiceLevelField[][]=new JTextField[3][6];
            for(int i=1; i<=2; i++){
                for(int j=1; j<=5; j++){
                    utilityAndServiceLevelField[i][j]=new JTextField();
                    utilityAndServiceLevelField[i][j].setFont(new Font("Arial", Font.BOLD, 16));
                    utilityAndServiceLevelField[i][j].setBackground(Color.WHITE);
                    utilityAndServiceLevelField[i][j].setBounds(65+215*(j-1), 70+40*(i-1), 215, 40);
                    if(i==1){
                        utilityAndServiceLevelField[i][j].setText(utilityAndServiceInfo[j]);
                        utilityAndServiceLevelField[i][j].setBackground(Color.PINK);
                        utilityAndServiceLevelField[i][j].setEditable(false);
                    }
                    cityUnitProfitPanel.add(utilityAndServiceLevelField[i][j]);
                }
            }

            JLabel cityUnitProfitTopLabel=new JLabel("Unit Profit on Utilities, Sewerage and Waste Disposal System");
            cityUnitProfitTopLabel.setFont(new Font("Arial", Font.BOLD, 20));
            cityUnitProfitTopLabel.setBounds(310, 250, cityUnitProfitTopLabel.getPreferredSize().width, cityUnitProfitTopLabel.getPreferredSize().height);
            cityUnitProfitPanel.add(cityUnitProfitTopLabel);
            
            JTextField cityUnitProfitTextField[][]=new JTextField[3][6];
            for(int i=1; i<=2; i++){
                for(int j=1; j<=5; j++){
                    cityUnitProfitTextField[i][j]=new JTextField();
                    cityUnitProfitTextField[i][j].setFont(new Font("Arial", Font.BOLD, 16));
                    cityUnitProfitTextField[i][j].setBackground(Color.WHITE);
                    cityUnitProfitTextField[i][j].setBounds(65+215*(j-1), 280+40*(i-1), 215, 40);
                    if(i==1){
                        cityUnitProfitTextField[i][j].setText(cityUnitProfitInfo[j]);
                        cityUnitProfitTextField[i][j].setBackground(Color.PINK);
                        cityUnitProfitTextField[i][j].setEditable(false);
                    }
                    cityUnitProfitPanel.add(cityUnitProfitTextField[i][j]);
                }
            }

            
            JButton proceedFromUnitProfitButton=new JButton("Proceed");
            proceedFromUnitProfitButton.setFont(new Font("Arial", Font.BOLD, 16));
            proceedFromUnitProfitButton.setBackground(Color.PINK);
            proceedFromUnitProfitButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            proceedFromUnitProfitButton.setBounds(505, 500, 170, 40);
            proceedFromUnitProfitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    proceedFromUnitProfitButtonActionPerformed(evt, cityUnitProfitTextField, proceedFromUnitProfitButton, utilityAndServiceLevelField);
                }
            });
            cityUnitProfitPanel.add(proceedFromUnitProfitButton);
            cityUnitFrame.add(cityUnitProfitPanel);
            cityUnitFrame.setVisible(true);
            cityUnitFrame.setSize(1280, 760);
            cityUnitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }catch(NumberFormatException exp){
        JOptionPane.showMessageDialog(null, "Invalid input\n\nPlease input a valid data", "", JOptionPane.ERROR_MESSAGE);
    }
}
    public static JFrame tabFrame;
    public static JPanel[] panel;
    public static JTabbedPane tabPane;
    public static String info[];
    public static JTextField field[][][];
    public static JTextField areaInfo[][][];
    public static JTextField annualizedAddedValue[][];
    public static JButton proceedButton[];
    public static double areaMax;
    public static double costOfBuildingPerArea;
    public static double initialInvestment;
    public static double[] P;
    public static double cK[];
    
    public static void proceedFromUnitProfitButtonActionPerformed(ActionEvent evt, JTextField[][] cityUnitProfitTextField, JButton proceedFromUnitProfitButton, JTextField[][] utilityAndServiceLevelField){
        cK=new double[6];
        try{
            for(int i=1; i<=5; i++){
                cK[i]=Double.parseDouble(cityUnitProfitTextField[2][i].getText());
            }
            for(int i=1; i<=5; i++){
                constraint1[1+i][13+4*noOfIndustries+1]=Double.parseDouble(utilityAndServiceLevelField[2][i].getText());
            }
            proceedFromUnitProfitButton.setEnabled(false);
            P=new double[noOfIndustries+1];
            tabFrame=new JFrame("Industries Infomation");
            panel=new JPanel[noOfIndustries+1];
            tabPane=new JTabbedPane();
            field=new JTextField[noOfIndustries+1][3][24];
            info=new String[] {"", "Site Acre ", "Electricity (kW.hrs/yr)", "Water (million cu. "+unitW+"./yr)", "Gas (cu."+unitW+"/yr)", "Sewerage (million cu. "+unitW+"./yr)", "Waste (Mg./yr)", "Unskilled Labour", "Semi skilled Labour", "Skilled Labour", "Clerical worker", "Technical personnel", "Managerial", "Average Building Construction Cost "+area+" ("+curSym+")" };

            constraint1[13][13+4*noOfIndustries+1]=initialInvestment-areaMax*costOfBuildingPerArea;

            for(int i=1; i<=noOfIndustries; i++){
                for(int k=1; k<=2; k++){
                    for(int j=1; j<=13; j++){
                        field[i][k][j]=new JTextField();
                        field[i][k][j].setFont(new Font("Arial", Font.BOLD, 14));
                        if(k==1){
                            field[i][k][j].setText(info[j]);
                            field[i][k][j].setBackground(Color.PINK);
                            field[i][k][j].setEditable(false);
                        }
                        else{
                            field[i][k][j].setFont(new Font("Arial", Font.BOLD, 14));
                        }
                    }
                }
            }

            JLabel topLabel[]=new JLabel[noOfIndustries+1];
            ImageIcon logo=new ImageIcon("logo.png");
            JLabel logoLabel[]=new JLabel[noOfIndustries+1];

            JLabel[] siteAndService=new JLabel[noOfIndustries+1];
            JLabel[] laborForceSpending=new JLabel[noOfIndustries+1];
            JLabel[] buildingArea=new JLabel[noOfIndustries+1];
            
            for(int i=1; i<=noOfIndustries; i++){
                siteAndService[i]=new JLabel("Site and Services Requirements in Unit "+area+" of plant Building Area");
                siteAndService[i].setFont(new Font("Arial", Font.BOLD, 20));
                siteAndService[i].setBounds(220, 40, siteAndService[i].getPreferredSize().width, siteAndService[i].getPreferredSize().height);
                
                laborForceSpending[i]=new JLabel("Labour Force Requirement in Men/Day (8hrs shifts) "+area+" of Plant Building Area");
                laborForceSpending[i].setFont(new Font("Arial", Font.BOLD, 20));
                laborForceSpending[i].setBounds(170, 190, laborForceSpending[i].getPreferredSize().width, laborForceSpending[i].getPreferredSize().height);
                
                buildingArea[i]=new JLabel("Plant Building Area Requirements "+area);
                buildingArea[i].setFont(new Font("Arial", Font.BOLD, 20));
                buildingArea[i].setBounds(55, 460, buildingArea[i].getPreferredSize().width, buildingArea[i].getPreferredSize().height);
            }
            
            for(int i=1; i<=noOfIndustries; i++){
                panel[i]=new JPanel();
                panel[i].setBackground(Color.WHITE);
                panel[i].setLayout(null);

                topLabel[i]=new JLabel("Industry "+i+". "+industryName[i]);
                topLabel[i].setFont(new Font("Arial", Font.BOLD, 30));
                topLabel[i].setBounds(400, 1, topLabel[i].getPreferredSize().width, topLabel[i].getPreferredSize().height);

                logoLabel[i]=new JLabel(logo);
                logoLabel[i].setBounds(1010, 400, logoLabel[i].getPreferredSize().width, logoLabel[i].getPreferredSize().height);

                panel[i].add(topLabel[i]);
                panel[i].add(logoLabel[i]);
                panel[i].add(siteAndService[i]);
                panel[i].add(laborForceSpending[i]);
                panel[i].add(buildingArea[i]);
            }

            areaInfo=new JTextField[noOfIndustries+1][3][3];
            String areaInfoNeeded[]= new String[] {"", "Maximum Area ("+unitM+") x1000", "Minimum Area ("+unitM+") x1000"};
            for(int i=1; i<=noOfIndustries; i++){
                for(int j=1; j<=2; j++){
                    for(int k=1; k<=2; k++){
                        areaInfo[i][j][k]=new JTextField();
                        areaInfo[i][j][k].setBackground(Color.WHITE);
                        areaInfo[i][j][k].setFont(new Font("Arial", Font.BOLD, 14));
                        areaInfo[i][j][k].setBounds(50+220*(k-1), 490+50*(j-1), 220, 50);
                        if(j==1){
                            areaInfo[i][j][k].setText(areaInfoNeeded[k]);
                            areaInfo[i][j][k].setEditable(false);
                            areaInfo[i][j][k].setBackground(Color.PINK);
                        }
                        panel[i].add(areaInfo[i][j][k]);
                    }
                }
            }

            annualizedAddedValue=new JTextField[noOfIndustries+1][2];
            for(int i=1; i<=noOfIndustries; i++){
                for(int j=0; j<=1; j++){
                        annualizedAddedValue[i][j]=new JTextField();
                        annualizedAddedValue[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                        annualizedAddedValue[i][j].setBackground(Color.WHITE);
                        annualizedAddedValue[i][j].setBounds(450, 340+50*j, 505, 50);
                        if(j==0){
                            annualizedAddedValue[i][j].setText("Annual Industrial Production of plant building area "+area+" ("+curSym+")");
                            annualizedAddedValue[i][j].setEditable(false);
                            annualizedAddedValue[i][j].setBackground(Color.PINK);
                        }
                        panel[i].add(annualizedAddedValue[i][j]);
                }
            }

            proceedButton=new JButton[noOfIndustries+1];
            for(int i=1; i<=noOfIndustries; i++){
                int index=i;
                proceedButton[i]=new JButton();
                proceedButton[i].setText("Confirm Industry "+i+" setup and proceed");
                proceedButton[i].setBounds(600, 580, 300, 50);
                proceedButton[i].setBackground(Color.YELLOW);
                proceedButton[i].setFont(new Font("Arial", Font.BOLD, 16));
                proceedButton[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                proceedButton[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        proceedButtonButtonActionPerformed(evt, index);
                    }
                });
                panel[i].add(proceedButton[i]);
            }
            for(int i=1; i<=noOfIndustries; i++){   
                for(int k=1; k<=2; k++){
                    for(int j=1; j<=13; j++){
                        if(j<=6){
                            field[i][k][j].setBounds(10+200*(j-1), 70+50*(k-1), 200, 50);
                            panel[i].add(field[i][k][j]);
                        }
                        else if(j<=12){
                            field[i][k][j].setBounds(10+200*(j-7), 220+50*(k-1), 200, 50);
                            panel[i].add(field[i][k][j]);
                        }
                        else{
                            field[i][k][j].setBounds(10+420*(j-13), 340+50*(k-1), 420, 50);
                            panel[i].add(field[i][k][j]);
                        }
                    }
                }
                tabPane.addTab(industryName[i], panel[i]);
            }

            tabPane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            tabPane.setBackground(Color.PINK);
            tabPane.setFont(new Font("Times new roman", Font.BOLD, 16));
            tabFrame.add(tabPane);
            tabFrame.setSize(1280, 760);
            tabFrame.setVisible(true);
            tabFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "Invalid input\n\nPlease input a valid data", "", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    private static int countForFilledTab=0;
    private static JButton confirmFillAndProceedButton;
    
    
    public static void proceedButtonButtonActionPerformed(ActionEvent evt, int index){
        
        try{
            for(int i=1; i<=13; i++){
                if(i==13){
                    constraint1[i][index]=unit*Double.parseDouble(field[index][2][i].getText());
                }
                else{
                constraint1[i][index]=Double.parseDouble(field[index][2][i].getText());
                }
            }
            
            for(int i=1; i<=2; i++){
                constraint1[13+noOfIndustries*(i-1)+index][index]=1.0;
                constraint1[13+noOfIndustries*(i-1)+index][13+4*noOfIndustries+1]=unit*Double.parseDouble(areaInfo[index][2][i].getText())/unit;
                
            }
            
                P[index]=Double.parseDouble(annualizedAddedValue[index][1].getText());
            
            countForFilledTab++;
            int percentageDone=100*countForFilledTab/noOfIndustries;
            JOptionPane.showMessageDialog(null, "GREAT JOB!, You have successfully filled the informations needed for Industry "+index+"\n\nYou are "+percentageDone+"%  done");
           
            proceedButton[index].setEnabled(false);

            constraint1[1][13+4*noOfIndustries+1]=areaMax;
            for(int k=1; k<=2; k++){
                for(int j=1; j<=13; j++){
                    field[index][k][j].setEditable(false);
                }
            }
            
            for(int j=1; j<=2; j++){
                for(int k=1; k<=2; k++){
                    areaInfo[index][j][k].setEditable(false);
                }
            }
            
            if(countForFilledTab==noOfIndustries){
                tabPane.setEnabled(false);
                confirmFillAndProceedButton=new JButton("Click here to proceed");
                confirmFillAndProceedButton.setFont(new Font("Times new roman", Font.BOLD, 16));
                confirmFillAndProceedButton.setBackground(Color.PINK);
                confirmFillAndProceedButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                confirmFillAndProceedButton.setBounds(600, 490, 300, 50);
                confirmFillAndProceedButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    confirmFillAndProceedButtonActionPerformed(evt);
                }
                });
                panel[index].add(confirmFillAndProceedButton);
            }
        }catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "There are still empty fields, if there is no value for the field, input 0", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static JFrame cityUnitProfitFrame;
    public static JPanel parentPanel;
    public static void confirmFillAndProceedButtonActionPerformed(ActionEvent evt){
        
        cityUnitProfitFrame=new JFrame("Labour Force Spending Pattern");
        parentPanel=new JPanel();
        parentPanel.setBounds(0, 0, 1280, 760);
        parentPanel.setLayout(null);
        parentPanel.setBackground(Color.PINK);
        parentPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        
        JPanel laborForcePanel=new JPanel();
        laborForcePanel.setBounds(5,5, 1270, 750);
        laborForcePanel.setLayout(null);
        laborForcePanel.setBackground(Color.white);
        laborForcePanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        
        JLabel tLabel=new JLabel("Labour Force Spending Pattern");
        tLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tLabel.setBounds(500, 10, tLabel.getPreferredSize().width, tLabel.getPreferredSize().height);
        laborForcePanel.add(tLabel);

        
        String rowInfo[]=new String[] {"", "Type", "Unskilled Labour", "Semi Skilled", "Skilled Labour", "Clerical workers", "Technical Personnel", "Managers"};
        String columnInfo[]=new String[] {"Type", "Max No", "Avg. income ("+curSym+")", "State&fxd taxes (%)", "Ann. net inc. ("+curSym+")", "%spent on city", "Cash flow ("+curSym+")", "Avg rev. /worker ("+curSym+")"};
        JTextField laborForceField[][]=new JTextField[8][8];
        for(int i=1; i<=7; i++){
            for(int j=0; j<=7; j++){
                laborForceField[i][j]=new JTextField();
                laborForceField[i][j].setFont(new Font("Arial", Font.BOLD, 14));
                laborForceField[i][j].setBackground(Color.WHITE);
                laborForceField[i][j].setBounds(30+150*j, 40+50*(i-1), 150, 50);

                if(j==0){
                    laborForceField[i][j].setBackground(Color.PINK);
                    laborForceField[i][j].setText(rowInfo[i]);
                    laborForceField[i][j].setEditable(false);
                }
                if(i==1){
                    laborForceField[i][j].setBackground(Color.PINK);
                    laborForceField[i][j].setText(columnInfo[j]);
                    laborForceField[i][j].setEditable(false);
                }

                laborForcePanel.add(laborForceField[i][j]);
            }
        }
        parentPanel.add(laborForcePanel);
        parentPanel.setSize(1279, 761);
        laborForcePanel.setSize(1270, 750);

        JButton generateAnnualNeTIncomeButton=new JButton("Get Values");
        generateAnnualNeTIncomeButton.setFont(new Font("Times new roman", Font.BOLD, 12));
        generateAnnualNeTIncomeButton.setBackground(Color.PINK);
        generateAnnualNeTIncomeButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        generateAnnualNeTIncomeButton.setBounds(660, 397, 100, 30);
        generateAnnualNeTIncomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                generateAnnualNeTIncomeButtonActionPerformed(evt, laborForceField, generateAnnualNeTIncomeButton);

            }
        });
        laborForcePanel.add(generateAnnualNeTIncomeButton);

        JButton generateCashFlowButton=new JButton("Get Values");
        generateCashFlowButton.setFont(new Font("Times new roman", Font.BOLD, 12));
        generateCashFlowButton.setBackground(Color.PINK);
        generateCashFlowButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        generateCashFlowButton.setBounds(955, 397, 100, 30);
        generateCashFlowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                generateCashFlowButtonActionPerformed(evt, laborForceField, generateCashFlowButton);
            }
        });
        laborForcePanel.add(generateCashFlowButton);

        JButton generateAverageCityRevenuePerWorkerButton=new JButton("Get Values");
        generateAverageCityRevenuePerWorkerButton.setFont(new Font("Times new roman", Font.BOLD, 12));
        generateAverageCityRevenuePerWorkerButton.setBackground(Color.PINK);
        generateAverageCityRevenuePerWorkerButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        generateAverageCityRevenuePerWorkerButton.setBounds(1115, 397, 100, 30);
        generateAverageCityRevenuePerWorkerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                generateAverageCityRevenuePerWorkerButtonActionPerformed(evt, laborForceField, generateAverageCityRevenuePerWorkerButton, laborForcePanel);

            }
        });
        laborForcePanel.add(generateAverageCityRevenuePerWorkerButton);

    parentPanel.add(laborForcePanel);
    cityUnitProfitFrame.add(parentPanel);
    cityUnitProfitFrame.setSize(1280, 760);
    cityUnitProfitFrame.setVisible(true);
    cityUnitProfitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    public static void generateAnnualNeTIncomeButtonActionPerformed(ActionEvent evt, JTextField[][] laborForceField, JButton generateAnnualNeTIncomeButton){
        try{
            for(int i=2; i<=7; i++){
            laborForceField[i][4].setText(String.format("%.0f", Double.parseDouble(laborForceField[i][2].getText())*(100-Double.parseDouble(laborForceField[i][3].getText()))*0.01));
            }
            generateAnnualNeTIncomeButton.setEnabled(false);
        }catch(NumberFormatException exp){
                JOptionPane.showMessageDialog(null, "There are fields with invalid data\nNote: Do not leave a fieLd blank, if there is no value, enter 0\nAlso make sure you enter valid figures either integer or decimal");
        }
    }
    public static void generateCashFlowButtonActionPerformed(ActionEvent evt, JTextField[][] laborForceField, JButton generateCashFlowButton){
        try{
            for(int i=2; i<=7; i++){
                laborForceField[i][6].setText(String.format("%.1f", Double.parseDouble(laborForceField[i][4].getText())*Double.parseDouble(laborForceField[i][5].getText())*0.01));
            }
            generateCashFlowButton.setEnabled(false);
            }catch(NumberFormatException exp){
                    JOptionPane.showMessageDialog(null, "There are fields with invalid data\nNote: Do not leave a field blank, if there is no value, enter 0\nAlso make sure you enter valid figures either integer or decimal");
            }
        }
    
    private static double[] rJ;
    public static void generateAverageCityRevenuePerWorkerButtonActionPerformed(ActionEvent evt, JTextField[][] laborForceField, JButton generateAverageCityRevenuePerWorkerButton, JPanel laborForcePanel){
        try{
            double fixedPercentage=Double.parseDouble(JOptionPane.showInputDialog(null, "Enter % Tax on utility, fuel, sanitation, etc", "Annualized average revenue per worker", JOptionPane.QUESTION_MESSAGE));
            for(int i=2; i<=7; i++){
                laborForceField[i][7].setText(String.format("%d", Math.round(Double.parseDouble(laborForceField[i][6].getText())*fixedPercentage*0.01)));
            }
            
            rJ=new double[7];
            for(int i=1; i<=6; i++){
                rJ[i]=Double.parseDouble(laborForceField[i+1][7].getText());
            }
            for(int i=1; i<=6; i++){
                constraint1[6+i][13+4*noOfIndustries+1]=Double.parseDouble(laborForceField[i+1][1].getText());
            }
            generateAverageCityRevenuePerWorkerButton.setEnabled(false);
            JButton nextButton=new JButton("Next >>>");
            nextButton.setFont(new Font("Arial", Font.BOLD, 16));
            nextButton.setBackground(Color.PINK);
            nextButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            nextButton.setBounds(500, 450, 280, 45);
            nextButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    nextButtonActionPerformed(evt);
                }
            });
            laborForcePanel.add(nextButton);
            laborForcePanel.setSize(1275, 751);
            
        }catch(NumberFormatException exp){
                JOptionPane.showMessageDialog(null, "There are fields with invalid data\nNote: Do not leave a field blank, if there is no value, enter 0\nAlso make sure you enter valid figures either integer or decimal");
        }
        
    }
    public static double[][] L;
    public static double[][] U;
    public static void nextButtonActionPerformed(ActionEvent evt){
        
        L=new double[noOfIndustries+2][7];
        U=new double[noOfIndustries+2][6];
        
        
        for(int i=1; i<=noOfIndustries; i++){
            for(int j=1; j<=6; j++){
                L[i][j]=constraint1[6+j][i];
            }
        }
        
        for(int i=1; i<=noOfIndustries; i++){
            for(int j=1; j<=5; j++){
                U[i][j]=constraint1[j+1][i];
            }
        }
        
        JFrame equationFrame=new JFrame("Optimization Problems");
        JPanel equationPanel=new JPanel();
        equationPanel.setBounds(2, 2, 1278, 758);
        equationPanel.setLayout(null);
        equationPanel.setBackground(Color.PINK);
        equationPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        
        JButton forOptimizationProblemButton=new JButton("Create the Optimization Problem");
            forOptimizationProblemButton.setFont(new Font("Arial", Font.BOLD, 14));
            forOptimizationProblemButton.setBackground(Color.PINK);
            forOptimizationProblemButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            forOptimizationProblemButton.setBounds(50, 30, 250, 45);
            forOptimizationProblemButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    forOptimizationProblemButtonActionPerformed(evt, costField, maintenanceField, constantField, equationPanel, forOptimizationProblemButton);
                    
                }
            });
            equationPanel.add(forOptimizationProblemButton);
            equationPanel.setSize(1279, 759);
            equationFrame.add(equationPanel);
            equationFrame.setSize(1280, 760);
            equationFrame.setVisible(true);
            equationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void forOptimizationProblemButtonActionPerformed(ActionEvent evt, JTextField costField, JTextField maintenanceField, JTextField constantField, JPanel equationPanel, JButton forOptimizationProblemButton){
        //Forming Objective Function
        double sumRJ[]=new double[noOfIndustries+1];
        double sumCU[]=new double[noOfIndustries+1];
        double sumP[]=new double[noOfIndustries+1];
    
        String[] optimizationEquation=new String[13+noOfIndustries*2+2];
        String[] variable=new String[noOfIndustries+1];
        String optimizationEquation1="\n";
        for(int i=1; i<=noOfIndustries; i++){
            variable[i]="X"+i;
        }
        try{
            for(int i=1; i<=noOfIndustries; i++){
                for(int j=1; j<=6; j++){
                    sumRJ[i]+=rJ[j]*L[i][j];
                }
                

                for(int k=1; k<=5; k++){
                    sumCU[i]+=cK[k]*U[i][k];
                }

                sumP[i]=percentage*P[i];
            }
            for(int i=1; i<=noOfIndustries; i++){
                constraint1[13+noOfIndustries*2+1][i]=-(sumRJ[i]+sumCU[i]+sumP[i]+constant);
            }
            
            String add="+";
            String greater=">=";
            String lesser="<=";
            
            //Initializing
            for(int i=1; i<=13+2*noOfIndustries+1; i++){
                optimizationEquation[i]="   ";
            }
            for(int i=1; i<=13+2*noOfIndustries+1; i++){
                for(int j=1; j<=noOfIndustries; j++){
                    if(j==noOfIndustries){
                        optimizationEquation[i]+=String.format("%.2f", constraint1[i][j])+""+variable[j]+" ";
                    }
                    else{
                    optimizationEquation[i]+=String.format("%.2f", constraint1[i][j])+""+variable[j]+" "+add+" ";
                    }
                    
                }
                if(i<=13+noOfIndustries){
                    optimizationEquation[i]+=" "+lesser+" "+String.format("%.2f", constraint1[i][13+4*noOfIndustries+1]);
                }
                else if(i==13+2*noOfIndustries+1){
                    optimizationEquation[i]+=" = "+String.format("%.2f", constraint1[i][13+4*noOfIndustries+1]);
                }
                else{
                    optimizationEquation[i]+=" "+greater+" "+String.format("%.2f", constraint1[i][13+4*noOfIndustries+1]);
                }
                optimizationEquation1+=optimizationEquation[i]+"\n";
            }
            
            JTextArea equationArea=new JTextArea(optimizationEquation1);
            equationArea.setBounds(530, 20, 720, 680);
            equationArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            equationArea.setBackground(Color.WHITE);
            equationArea.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
            equationArea.setEditable(false);
            equationPanel.add(equationArea);
            
            JButton solveProblemButton=new JButton("Optimize");
            solveProblemButton.setFont(new Font("Arial", Font.BOLD, 16));
            solveProblemButton.setBackground(Color.PINK);
            solveProblemButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            solveProblemButton.setBounds(150, 500, 200, 45);
            solveProblemButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    solveProblemButtonActionPerformed(evt);
                    solveProblemButton.setEnabled(false);
                }
            });
            forOptimizationProblemButton.setEnabled(false);
            equationPanel.add(solveProblemButton);
            
            JLabel tagLabel=new JLabel("Use Simplex Method to solve linear programming model equations");
            tagLabel.setFont(new Font("Arial", Font.BOLD, 14));
            tagLabel.setBounds(30, 550, tagLabel.getPreferredSize().width, tagLabel.getPreferredSize().height);
            equationPanel.add(tagLabel);
            
            equationPanel.setSize(1280, 760);
        }catch(NumberFormatException exp){
            JOptionPane.showMessageDialog(null, "Invalid Input\nPlease, input valid values", "Input Mismatch", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private static int nConst; 
    private static int nVar;  //to save number of constraints
    private static int isNegative;  
    private static int xColumn[];
    private static int xRow[];
    private static double maxX[];
    private static int count=1;
    private static int nArtificialVariables;   //to save number of artificial variables
    public static double[][] constraint;
    public static String solution;
    public static double X[];
    public static void solveProblemButtonActionPerformed(ActionEvent evt){
        X=new double[noOfIndustries+1];
        solution="";
        //Introducing the slack variables
        nVar=noOfIndustries;
        nArtificialVariables=noOfIndustries;
        nConst=13+2*nVar;
        constraint=new double[nConst+2][nConst+nVar+2+nArtificialVariables];
       for(int i=1; i<=nConst+1; i++){
           for(int j=1; j<=2*nVar+nConst+1; j++){
               constraint[i][j]=constraint1[i][j];
           }
       }
        for(int i=1; i<=nConst; i++){
                constraint[i][nVar+i]=1.0;
                if(i>nConst-nArtificialVariables){
                    constraint[i][nVar+i]=-constraint[i][nVar+i];
                    constraint[i][nVar+i+nArtificialVariables]=1.0;
                }
        }
        
        for(int i=1; i<=nConst+1; i++){
            for(int j=1; j<=nConst+2*nVar+1; j++){
                solution+=String.format("%.2f\t", constraint[i][j]);
            }
            solution+="\n";
        }
        
        nVar=nVar+nArtificialVariables;
        xColumn=new int[nVar+nConst+1];
        xRow=new int[nVar+nConst+1];
        maxX=new double[nVar+nConst+1];
        
        while(isHavingNegativeEntity(constraint)==true){
            solveSimplex(getKeyColumn(constraint), getKeyRow(getKeyColumn(constraint)));
        }
        checkCompletion();
        if(notDoneRow!=0&&notDoneVar!=0){
            solveSimplex(notDoneVar, notDoneRow);
        }
        while(isHavingNegativeEntity(constraint)==true){
            solveSimplex(getKeyColumn(constraint), getKeyRow(getKeyColumn(constraint)));
        }
        solution+="\n";
        solution+="Maximum Value="+constraint[nConst+1][nVar+nConst+1];
        
        
        for(int i=1; i<=count; i++){
            maxX[xColumn[i]]=constraint[xRow[i]][nConst+nVar+1];
            if(xColumn[i]>0&&xColumn[i]<nVar-nArtificialVariables+1){
                solution+="\nX"+xColumn[i]+" = "+maxX[xColumn[i]];
                X[xColumn[i]]=maxX[xColumn[i]];
            }
        }
        
        double maxValue=constraint[nConst+1][nVar+nConst+1];
        
        double finalSolution[]=new double[14];
        for(int i=1; i<=13; i++){
            for(int j=1; j<=noOfIndustries; j++){
                finalSolution[i]+=constraint1[i][j]*X[j];
                solution+="\n.....";
            }
        }
        
        JFrame answerFrame=new JFrame("Solution");
        JPanel answerPanel=new JPanel();
        answerPanel.setBackground(Color.WHITE);
        answerPanel.setBounds(5, 5, 1275, 755);
        answerPanel.setLayout(null);
        answerPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        
        JLabel maxIncomeLabel=new JLabel("Maximum Annual Income = "+curSym+""+maxValue);
        maxIncomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        maxIncomeLabel.setBounds(100, 50, maxIncomeLabel.getPreferredSize().width, maxIncomeLabel.getPreferredSize().height);
        answerPanel.add(maxIncomeLabel);
        
        JLabel initialInvestmentLabel=new JLabel("Initial Investment = "+curSym+""+String.format("%.0f",finalSolution[13]));
        initialInvestmentLabel.setFont(new Font("Arial", Font.BOLD, 16));
        initialInvestmentLabel.setBounds(100, 75, initialInvestmentLabel.getPreferredSize().width, initialInvestmentLabel.getPreferredSize().height);
        answerPanel.add(initialInvestmentLabel);
        
        JLabel optimumAreaLabel=new JLabel("Optimum Plant Building Areas");
        optimumAreaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        optimumAreaLabel.setBounds(100, 100, optimumAreaLabel.getPreferredSize().width, optimumAreaLabel.getPreferredSize().height);
        answerPanel.add(optimumAreaLabel);
        
        JLabel induAreaLabel[]=new JLabel[noOfIndustries+1];
        int newP=0;
        double totalAreaUsed=0;
        double unusedArea=0;
        for(int i=1; i<=noOfIndustries; i++){
            induAreaLabel[i]=new JLabel(String.format("%s = %.2f %s", industryName[i], X[i]*unit, unitM));
            induAreaLabel[i].setFont(new Font("Arial", Font.BOLD, 16));
            induAreaLabel[i].setBounds(120, 125+25*(i-1), induAreaLabel[i].getPreferredSize().width, induAreaLabel[i].getPreferredSize().height);
            answerPanel.add(induAreaLabel[i]);
            newP=125+25*(i-1);
            answerPanel.add(induAreaLabel[i]);
            totalAreaUsed+=X[i]*unit;
        }
        JLabel optSpace=new JLabel(String.format("Optimum plant building area = %.2f acres", areaMax));
        optSpace.setFont(new Font("Arial", Font.BOLD, 16));
        optSpace.setBounds(100, newP+25, optSpace.getPreferredSize().width, optSpace.getPreferredSize().height);
        answerPanel.add(optSpace);
        newP=newP+100;
        
        totalAreaUsed=totalAreaUsed/4046.85;
        unusedArea=areaMax-totalAreaUsed;
        JLabel spaceUsedLabel=new JLabel(String.format("Total land space used = %.2f acres", totalAreaUsed));
        spaceUsedLabel.setFont(new Font("Arial", Font.BOLD, 16));
        spaceUsedLabel.setBounds(100, newP+25, spaceUsedLabel.getPreferredSize().width, spaceUsedLabel.getPreferredSize().height);
        answerPanel.add(spaceUsedLabel);
        
        JLabel unusedAreaLabel=new JLabel(String.format("Unused land space = %.2f acres", unusedArea));
        unusedAreaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        unusedAreaLabel.setBounds(100, newP+50, unusedAreaLabel.getPreferredSize().width, unusedAreaLabel.getPreferredSize().height);
        answerPanel.add(unusedAreaLabel);
        
        JLabel laborUtiLabel=new JLabel("Labour Utilization");
        laborUtiLabel.setFont(new Font("Arial", Font.BOLD, 16));
        laborUtiLabel.setBounds(700, 50, laborUtiLabel.getPreferredSize().width, laborUtiLabel.getPreferredSize().height);
        answerPanel.add(laborUtiLabel);
        
        String[] laborUti=new String[] {"", "Uskilled", "Semi Skilled", "Skilled Labour", "Clerical Worker", "Technical Personnel", "Managerial"};
        JLabel laborUtiLabel1[]=new JLabel[7];
        int newPP=0;
        for(int i=1; i<=6; i++){
            laborUtiLabel1[i]=new JLabel(i+". "+laborUti[i]+String.format(" = %.0f", finalSolution[i+6]));
            laborUtiLabel1[i].setFont(new Font("Arial", Font.BOLD, 16));
            laborUtiLabel1[i].setBounds(720, 75+25*(i-1), laborUtiLabel1[i].getPreferredSize().width, laborUtiLabel1[i].getPreferredSize().height);
            answerPanel.add(laborUtiLabel1[i]);
            newPP=75+25*(i-1);
        }
        JLabel utilityLabel=new JLabel("Utility and Service Levels");
        utilityLabel.setFont(new Font("Arial", Font.BOLD, 16));
        utilityLabel.setBounds(700, newPP+25, utilityLabel.getPreferredSize().width, utilityLabel.getPreferredSize().height);
        answerPanel.add(utilityLabel);
        
        int newPPP=0;
        String[] utiAndService=new String[] {"", "Electricity", "Water", "Gas", "Sewerage", "Waste"};
        String[] utiAndServiceUnit=new String[] {"", "kW. hr./yr", "million cu. "+unitW+"/yr", "cu. "+unitW+"./yr", "million cu."+unitW+"./yr", "Mg./yr"};
        JLabel utiAndServiceLabel[]=new JLabel[6];
        for(int i=1; i<=5; i++){
            utiAndServiceLabel[i]=new JLabel(i+". "+utiAndService[i]+String.format(" = %.2f %s", finalSolution[i+1], utiAndServiceUnit[i]));
            utiAndServiceLabel[i].setFont(new Font("Arial", Font.BOLD, 16));
            utiAndServiceLabel[i].setBounds(720, newPP+50+25*(i-1), utiAndServiceLabel[i].getPreferredSize().width, utiAndServiceLabel[i].getPreferredSize().height);
            answerPanel.add(utiAndServiceLabel[i]);
            newPPP=newPP+50+25*(i-1);
        }
        
        JButton showSolution=new JButton("Show the step by step solution");
        showSolution.setFont(new Font("Arial", Font.BOLD, 16));
        showSolution.setBackground(Color.PINK);
        showSolution.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        showSolution.setBounds(900, 600, 300, 45);
        showSolution.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                showSolutionButtonActionPerformed(evt);

            }
        });
        answerPanel.add(showSolution);
        
        answerFrame.add(answerPanel);
        answerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        answerFrame.setVisible(true);
        answerFrame.setSize(1280, 760);
        
    }
    private static void showSolutionButtonActionPerformed(ActionEvent evt){
        JFrame solutionFrame=new JFrame("Step by Step Simplex Solution");
        JPanel solutionPanel=new JPanel();
        solutionPanel.setLayout(null);
        solutionPanel.setBounds(5, 5, 1260, 750);
        solutionPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        solutionPanel.setBackground(Color.PINK);
        
        JTextArea solutionArea=new JTextArea(solution);
        solutionArea.setFont(new Font("Serif", Font.PLAIN, 14));
        solutionArea.setBackground(Color.WHITE);
        solutionArea.setSize(3000, 725);
        //solutionArea.setLineWrap(true);
        solutionArea.setVisible(true);
        solutionArea.setEditable(false);
        
        JScrollPane scroll=new JScrollPane(solutionArea);
        scroll.setBounds(10, 10, 1240, 700);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        solutionPanel.add(scroll);
        solutionFrame.add(solutionPanel);
        solutionFrame.setSize(1280, 760);
        solutionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        solutionFrame.setVisible(true);
    }
    private static boolean isHavingNegativeEntity(double[][] objFunction){
        boolean status=false;
        for(int i=1; i<=nVar+nConst-nArtificialVariables; i++){
            if(objFunction[nConst+1][i]<0){
                status=true;
                isNegative=i;
            }
        }
        return status;
    }
    
    private static int getKeyColumn(double objFunction[][]){
        int keyColumn=1;
        double check=objFunction[nConst+1][1];
        for(int i=1; i<=nVar+nConst; i++){
            if(objFunction[nConst+1][i]<check){
                keyColumn=i;
            }
        }
        return keyColumn;
    }
    private static int getKeyRow(int keyColumn){
        int keyRow=1;
        double check=(constraint[1][nConst+nVar+1])/(constraint[1][keyColumn]);
        for(int i=2; i<=nConst; i++){
            if(check<0){
                check=(constraint[i][nConst+nVar+1])/(constraint[i][keyColumn]);
                keyRow=i;
            }
            else if((check>(constraint[i][nConst+nVar+1])/(constraint[i][keyColumn]))&&((constraint[i][nConst+nVar+1])/(constraint[i][keyColumn])>0)){
                check=(constraint[i][nConst+nVar+1])/(constraint[i][keyColumn]);
                keyRow=i;
            }
        }
        return keyRow;
    }
    private static void solveSimplex(int keyColumn, int keyRow){
        xColumn[count]=keyColumn;
        xRow[count]=keyRow;
        if(nArtificialVariables>0&&keyColumn<=nVar-nArtificialVariables){
            for(int i=1; i<=nConst+1; i++){
                constraint[i][keyColumn+nVar-nArtificialVariables+nConst]=0;
            }
        }
        //In case a row has been done before and still taken again
        for(int i=1; i<=count-1; i++){
            if(keyRow==xRow[i]){
                xColumn[i]=0;
            }
        }
        
        double keyNumber=constraint[keyRow][keyColumn];
        solution+="\nKey Row = "+keyRow+" Key Column = "+keyColumn+" Key Number = "+keyNumber;

       //Dividing the key row by the key number to get pivot
       for(int i=1; i<=nConst+nVar+1; i++){
           constraint[keyRow][i]=(constraint[keyRow][i])/keyNumber;
       }
       //Printing the step
       solution+="\n";
       for(int i=1; i<=nConst+1; i++){
            for(int j=1; j<=nConst+nVar+1; j++){
                solution+=String.format("%.2f\t", constraint[i][j]);
            }
            solution+="\n";
        }

       //Duplicating the data in constraint array
       double dupConstraint[][]=new double[nConst+2][nConst+nVar+2];;
       for(int i=1; i<=nConst+1; i++){
           for(int j=1; j<=nVar+nConst+1; j++){
               dupConstraint[i][j]=constraint[i][j];
           }
       }
       //Zeroing other elements on the key column using the pivot
       for(int i=1; i<=nConst+1; i++){
           if(i==keyRow)
               continue;
           for(int j=1; j<=nVar+nConst+1; j++){
               double n=dupConstraint[keyRow][j];
               double m=dupConstraint[i][keyColumn];
               constraint[i][j]=constraint[i][j]-n*m;
           }
       }

       //Printing the step
       solution+="\n";
       for(int i=1; i<=nConst+1; i++){
            for(int j=1; j<=nConst+nVar+1; j++){
                solution+=String.format("%.2f\t", constraint[i][j]);
            }
            solution+="\n";
        }
       count++;
}
    private static int notDoneRow=0;
    private static int notDoneVar=0;
    private static void checkCompletion(){
        boolean status=true;
        int mustDoneRow[]=new int[nArtificialVariables+1];
        int mustDoneVar[]=new int[nVar-nArtificialVariables+1];
        String mustDoneRowStatus[]=new String[nVar-nArtificialVariables+1];
        String mustDoneColumnStatus[]=new String[nVar-nArtificialVariables+1];
        
        for(int i=1; i<=nArtificialVariables; i++){
            mustDoneRow[i]=nConst-nArtificialVariables+i;
        }

        for(int i=1; i<=nVar-nArtificialVariables; i++){
            mustDoneVar[i]=i;
            mustDoneRowStatus[i]="No";
            mustDoneColumnStatus[i]="No";
        }
        
        for(int i=1; i<=count; i++){
            for(int j=1; j<=nVar-nArtificialVariables; j++){
                if(xColumn[i]==mustDoneVar[j]){
                    mustDoneColumnStatus[j]="Yes";
                }
            }
        }
        
        for(int i=1; i<=count; i++){
            for(int j=1; j<=nArtificialVariables; j++){
                if(xRow[i]==mustDoneRow[j]){
                    mustDoneRowStatus[j]="Yes";
                }
            }
        }
        
        for(int i=1; i<=nVar-nArtificialVariables; i++){
            if(mustDoneColumnStatus[i].equalsIgnoreCase("No")){
                notDoneVar=mustDoneVar[i];
            }
        }
        
        for(int i=1; i<=nArtificialVariables; i++){
            if(mustDoneRowStatus[i].equalsIgnoreCase("No")){
                notDoneRow=mustDoneRow[i];
            }
        }
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // handle the exception
        }
        displayStartUpInterface();
        
    }   
}