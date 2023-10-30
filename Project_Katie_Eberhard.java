import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
    This program asks and accepts a policyholder's information and creates an instance of the Policy class.
    It them displays the information and cost of the policy. 
 */
public class Project_Katie_Eberhard extends Policy {
    
    public static void main(String[] args)
    {
        try
        {
            String insPolicyNum;               // The insurance policy number
            String insPolicyProvider;       // The insurance provider's name
            String personFirstName;         // The policyholder's first name
            String personLastName;          // The policyholder's last name
            int aAge;                       // the policyholder's age
            String personSmokingStatus;     // smoker or non-smoker
            double personHeight;            // The policyholder's height in inches
            double personWeight;            // The policyholder's weight in pounds


            //Create instance of the File Class
            File aFile = new File("PolicyInformation.txt");
            // Create a Scanner object to read input from file
            Scanner inputFile = new Scanner(aFile);
            //Create ArrayList to store Policy objects
            ArrayList<Policy> policies = new ArrayList<Policy>();



            // Read policy information from file and save as a policy object client
            while(inputFile.hasNext())
            {
                insPolicyNum = inputFile.nextLine();
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
                Policy policy = new Policy(insPolicyNum, insPolicyProvider, personFirstName, personLastName,
                                            aAge, personSmokingStatus, personHeight, personWeight);

            
                // Add object to ArrayList<Policy> policies
                policies.add(policy);              
            } 

            //Close file
            inputFile.close();     
            
            //Create smoking and nonsmoking accumulators
            int smokers = 0;
            int nonsmokers = 0;

            //Create a for loop that displays all the Policy objects that are stored in ArrayList + BMI + policy cost
            for(Policy p : policies)
            {
                
                
                System.out.printf("Policy Numer: %s\n", p.getPolicyNum());
                System.out.printf("Provider Name: %s\n", p.getProvider());
                System.out.printf("Policyholder's First Name: %s\n", p.getFirstName());
                System.out.printf("Policyholder's Last Name: %s\n", p.getLastName());
                System.out.printf("Policyholder's Age: %d\n", p.getAge());
                System.out.printf("Policyholder's Smoking Status: %s\n", p.getSmokingStatus());
                if(p.getSmokingStatus().equalsIgnoreCase("smoker"))
                     smokers++;
                else
                    nonsmokers++;
                
                System.out.printf("Policyholder's Height: %.1f inches\n", p.getHeight());
                System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getWeight());
                System.out.printf("Policyholder's BMI: %.2f\n", p.calculateBMI(p.getWeight(), p.getHeight()));
                System.out.printf("Policy Price: $%.2f\n\n", p.priceOfPolicy());

            }
                System.out.println("The number of policies with a smoker is: " + smokers);
                System.out.println("The number of policies with a non-smoker is: " + nonsmokers);

            
        }
        
        catch(IOException e)//If something goes wrong, an IOException is "thrown" to us, and we "catch" it and deal with it
        {
           //use the getMessage method of the exception we "caught" to print out it's message about what went wrong
           System.out.println("Something went wrong reading the file: " + e.getMessage());
        }
                
        
    }
}