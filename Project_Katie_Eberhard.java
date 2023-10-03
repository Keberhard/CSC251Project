import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
    This program asks and accepts a policyholder's information and creates an instance of the Policy class.
    It them displays the information and cost of the policy. 
 */
public class Project_Katie_Eberhard {
    
    public static void main(String[] args)
    {
        try
        {
            int insPolicyNum;               // The insurance policy number
            String insPolicyProvider;       // The insurance provider's name
            String personFirstName;         // The policyholder's first name
            String personLastName;          // The policyholder's last name
            int aAge;                       // the policyholder's age
            String personSmokingStatus;     // smoker or non-smoker
            double personHeight;            // The policyholder's height in inches
            double personWeight;            // The policyholder's weight in pounds
            double personBMI = 0;               // The policyholder's Body Mass Index
            double policyCost = 0;              // The Cost of the insurance policy

            //Create instance of the File Class
            File aFile = new File("PolicyInformation.txt");
            // Create a Scanner object to read input from file
            Scanner inputFile = new Scanner(aFile);
            //Create ArrayList to store Policy objects
            ArrayList<Policy> policies = new ArrayList<Policy>();



            // Read policy information from file and save as a policy object client
            while(inputFile.hasNext())
            {
                insPolicyNum = inputFile.nextInt();
                inputFile.nextLine();
                insPolicyProvider = inputFile.nextLine();
                personFirstName = inputFile.nextLine();
                personLastName = inputFile.nextLine();
                aAge = inputFile.nextInt();
                inputFile.nextLine();
                personSmokingStatus = inputFile.nextLine();
                personHeight = inputFile.nextDouble();
                inputFile.nextLine();
                personWeight = inputFile.nextDouble();

                if(inputFile.hasNext())     // Detecting blank lines 
                {
                    inputFile.nextLine();
                    inputFile.nextLine();
                }

        
                // Create a policy object while not at end of file 
                Policy policyEstimate = new Policy(insPolicyNum, insPolicyProvider, personFirstName, personLastName,
                                            aAge, personSmokingStatus, personHeight, personWeight);

                personBMI = policyEstimate.calculateBMI(personWeight, personHeight);
                policyCost = policyEstimate.priceOfPolicy(personBMI);
                // Add object to ArrayList<Policy> policies
                policies.add(policyEstimate);              
            } 

            //Close file
            inputFile.close();     
            
            //Create smoking and nonsmoking accumulators
            int smokers = 0;
            int nonsmokers = 0;

            //Create a for loop that displays all the Policy objects that are stored in ArrayList + BMI + policy cost
            for(int i = 0; i < policies.size(); i++)
            {
                
                
                System.out.printf("Policy Numer: %d\n", policies.get(i).getPolicyNum());
                System.out.printf("Provider Name: %s\n", policies.get(i).getProvider());
                System.out.printf("Policyholder's First Name: %s\n", policies.get(i).getFirstName());
                System.out.printf("Policyholder's Last Name: %s\n", policies.get(i).getLastName());
                System.out.printf("Policyholder's Age: %d\n", policies.get(i).getAge());
                System.out.printf("Policyholder's Smoking Status: %s\n", policies.get(i).getSmokingStatus());
                if(policies.get(i).getSmokingStatus().compareTo("smoking") == 0)
                     smokers++;
                else
                    nonsmokers++;
                System.out.printf("Policyholder's Height: %.1f inches\n", policies.get(i).getHeight());
                System.out.printf("Policyholder's Weight: %.1f pounds\n", policies.get(i).getWeight());
                System.out.printf("Policyholder's BMI: %.2f\n", personBMI);
                System.out.printf("Policy Price: $%.2f", policyCost);
                System.out.println("The number of policies with a smoker is: " + smokers);
                System.out.println("The number of policies with a non-smoker is: " + nonsmokers);

            }
        }
        
        catch(IOException e)//If something goes wrong, an IOException is "thrown" to us, and we "catch" it and deal with it
        {
           //use the getMessage method of the exception we "caught" to print out it's message about what went wrong
           System.out.println("Something went wrong reading the file: " + e.getMessage());
        }
                
        
    }
}