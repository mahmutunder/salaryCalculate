package salaryCalculator;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Salary calculation app
 * @author Mahmut
 *
 * */

public class SalaryCalculator extends JFrame {
    private JLabel hourlyRateLabel, hoursWorkedLabel, taxRateLabel, federalTaxRateLabel, yearlySalaryLabel, stateTaxLabel, federalTaxLabel;
    private JTextField hourlyRateField, hoursWorkedField, taxRateField, federalTaxRateField;
    private JButton calculateButton;
    private Image icon;



    public SalaryCalculator() {
        // Set the layout of the frame to null for absolute positioning
        setLayout(null);

        // Initialize and add the hourly rate label
        hourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyRateLabel.setBounds(10, 10, 80, 25);
        add(hourlyRateLabel);

        // Initialize and add the hourly rate text field
        hourlyRateField = new JTextField();
        hourlyRateField.setBounds(100, 10, 165, 25);
        add(hourlyRateField);

        // Initialize and add the hours worked per week label
        hoursWorkedLabel = new JLabel("Hours Worked per Week:");
        hoursWorkedLabel.setBounds(10, 40, 165, 25);
        add(hoursWorkedLabel);

        // Initialize and add the hours worked per week text field
        hoursWorkedField = new JTextField();
        hoursWorkedField.setBounds(180, 40, 85, 25);
        add(hoursWorkedField);

        // Initialize and add the state tax rate label
        taxRateLabel = new JLabel("State Tax Rate (%):");
        taxRateLabel.setBounds(10, 70, 165, 25);
        add(taxRateLabel);

        // Initialize and add the state tax rate text field
        taxRateField = new JTextField();
        taxRateField.setBounds(100, 70, 165, 25);
        add(taxRateField);

        // Initialize and add the federal tax rate label
        federalTaxRateLabel = new JLabel("Federal Tax Rate (%):");
        federalTaxRateLabel.setBounds(10, 100, 165, 25);
        add(federalTaxRateLabel);

        // Initialize and add the federal tax rate text field
        federalTaxRateField = new JTextField();
        federalTaxRateField.setBounds(180, 100, 85, 25);
        add(federalTaxRateField);

        // Initialize and add the yearly salary label
        yearlySalaryLabel = new JLabel("");
        yearlySalaryLabel.setBounds(10, 170, 300, 25);
        add(yearlySalaryLabel);

        // Initialize and add the state tax label
        stateTaxLabel = new JLabel("");
        stateTaxLabel.setBounds(10, 200, 300, 25);
        add(stateTaxLabel);

        // Initialize and add the

        federalTaxLabel = new JLabel("");
        federalTaxLabel.setBounds(10, 230, 300, 25);
        add(federalTaxLabel);
        // Initialize and add the calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 130, 165, 25);
        add(calculateButton);

// Add an action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate the yearly salary
                double hourlyRate = Double.parseDouble(hourlyRateField.getText());
                int hoursWorked = Integer.parseInt(hoursWorkedField.getText());
                double yearlySalary = hourlyRate * hoursWorked * 52;
                yearlySalaryLabel.setText("Yearly Salary: $" + yearlySalary);

                // Calculate the state tax
                double taxRate = Double.parseDouble(taxRateField.getText());
                double stateTax = yearlySalary * (taxRate / 100);
                stateTaxLabel.setText("State Tax: $" + stateTax);

                // Calculate the federal tax
                double federalTaxRate = Double.parseDouble(federalTaxRateField.getText());
                double federalTax = yearlySalary * (federalTaxRate / 100);
                federalTaxLabel.setText("Federal Tax: $" + federalTax);
            }
        });

// Set the default close operation and size of the frame
        setTitle("Salary Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280, 320);
        icon= new ImageIcon("logo-top.png").getImage();
        setIconImage(icon);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new SalaryCalculator().setVisible(true);
    }
}