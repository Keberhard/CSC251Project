import java.util.Scanner;
import java.io.*;

/**
    This program asks and accepts a policyholder's information and creates an instance of the Policy class.
    It them displays the information and cost of the policy. 
 */
public class Project_Katie_Eberhard {
    
    public static void main(String[] args)
    {
        int insPolicyNum;               // The insurance policy number
        String insPolicyProvider;       // The insurance provider's name
        String personFirstName;         // The policyholder's first name
        String personLastName;          // The policyholder's last name
        int aAge;                       // the policyholder's age
        String personSmokingStatus;     // smoker or non-smoker
        double personHeight;            // The policyholder's height in inches
        double personWeight;            // The policyholder's weight in pounds
        double personBMI;               // The policyholder's Body Mass Index
        double policyCost;              // The Cost of the insurance policy

        // Create a Scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Get the policyholder's information
        System.out.print("Please enter the policy number: ");
        insPolicyNum = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Please enter the Provider Name: ");
        insPolicyProvider = keyboard.nextLine();
        System.out.print("Please enter the Policyholder's First Name: ");
        personFirstName = keyboard.nextLine();
        System.out.print("Please enter the Policyholder's Last Name: ");
        personLastName = keyboard.nextLine();
        System.out.print("Please enter the Policyholder's Age: ");
        aAge = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        personSmokingStatus = keyboard.nextLine();
        System.out.print("Please enter the Policyholder's Height (in inches): ");
        personHeight = keyboard.nextDouble();
        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        personWeight = keyboard.nextDouble();

        // Create a policy object
        Policy policyEstimate = new Policy(insPolicyNum, insPolicyProvider, personFirstName, personLastName,
                                            aAge, personSmokingStatus, personHeight, personWeight);

        personBMI = policyEstimate.calculateBMI(personWeight, personHeight);
        policyCost = policyEstimate.priceOfPolicy(personBMI);

        System.out.printf("Policy Numer: %d\n", insPolicyNum);
        System.out.printf("Provider Name: %s\n", insPolicyProvider);
        System.out.printf("Policyholder's First Name: %s\n", personFirstName);
        System.out.printf("Policyholder's Last Name: %s\n", personLastName);
        System.out.printf("Policyholder's Age: %d\n", aAge);
        System.out.printf("Policyholder's Smoking Status: %s\n", personSmokingStatus);
        System.out.printf("Policyholder's Height: %.1f inches\n", personHeight);
        System.out.printf("Policyholder's Weight: %.1f pounds\n", personWeight);
        System.out.printf("Policyholder's BMI: %.2f\n", personBMI);
        System.out.printf("Policy Price: $%.2f", policyCost);

        keyboard.close();
    }
}