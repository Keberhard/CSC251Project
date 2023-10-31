import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
    This program asks and accepts a policyholder's information and creates an instance of the Policy class.
    It them displays the information and cost of the policy. 
 */
public class Project_Katie_Eberhard  {
    
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

                //Create a PolicyHolder object
                PolicyHolder pHolder = new PolicyHolder(personFirstName, personLastName, aAge, personSmokingStatus, personHeight, personWeight);
                

                // Create a policy object while not at end of file 
                Policy policy = new Policy(insPolicyNum, insPolicyProvider, pHolder);

            
                // Add object to ArrayList<Policy> policies
                policies.add(policy);              
            } 

            //Close file
            inputFile.close();     
            
            
        
            int smokers = 0;
            int policyCount = 0;
            for(Policy p : policies)
                {
                    System.out.println(p);
                    policyCount = p.getInstanceCount();
                    smokers = p.getSmokerCount();
                }
            int nonSmokers = policyCount - smokers;
            System.out.println("There were " + policyCount + " Policy objects created.");    
            System.out.println("The number of policies with a smoker is: " + smokers);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
        }
        
        catch(IOException e)//If something goes wrong, an IOException is "thrown" to us, and we "catch" it and deal with it
        {
           //use the getMessage method of the exception we "caught" to print out it's message about what went wrong
           System.out.println("Something went wrong reading the file: " + e.getMessage());
        }
                
        
    }
}