/**
   The Policy class will model an insurance policy. 
*/
public class Policy
{
   private String policyNum;          // The policy number
   private String provider;           // The provider's name
   private PolicyHolder policyHolder; // 
   


      /**
      This constructor sets all fields to the value passed as an argument.
      @param policyNumber The policy number.
      @param providerName The provider's name.
      @param fName The policyholder's first name.
      @param lName The policyholder's last name.
      @param personAge The policyholder's age.
      @param smokerStat The policyholder's smoking status smoker or non-smoker.
      @param heightInInches The policyholder's height in inches.
      @param weightInLbs The policyholder's weight in pounds.
   */
   
   public Policy(String policyNumber, String providerName, PolicyHolder holder)
    {
        policyNum = policyNumber;
        provider = providerName;
        
        policyHolder = new PolicyHolder(holder);
    }

    /**
       The getPolicyNum method returns the insurance policy number.
       @return The insurance policy number.
     */

    public String getPolicyNum()
    {
        return policyNum;
    }

    /**
       The setPolicyNum method sets the insurance policy number.
       @param policyNumber The insurance policy number.
     */

    public void setPolicyNum(String policyNumber)
    {
        policyNum = policyNumber;
    }

    /**
        The getProvider method returns the insurance provider's name.
        @return The name of the insurance provider.
     */

    public String getProvider() 
    {
        return provider;
    }

    /**
        The setProvider method sets the insurance provider's name.
        @param provider The insurance provider's name.
     */

    public void setProvider(String providerName) 
    {
        provider = providerName;
    }

    
    /**
        The calculateBMI methods returns the BMI calculated from the policyholder's weight and height.
        @param weight The policyholder's weight in pounds.
        @param height The policyholder's height in inches.
        @return The Body Mass Index.
     */

    public double calculateBMI(double weightPounds, double heightInches)
    {
        final int CONV_FACT = 703; // This conversion factor converts pounds to kg 
        double bmi = (weightPounds * CONV_FACT)/(heightInches * heightInches); // Body Mass Index calculation
        return bmi;
    }

    /**
        The priceOfPolicy method calculates the cost of the insurance policy 
        @param bmi The policyholder's Body Mass Index
        @return The cost of the insurance policy
     */

    public double priceOfPolicy()
    {
        double bmi = calculateBMI(policyHolder.getWeight(), policyHolder.getWeight());
        final int BASE_FEE = 600;                       // Insurance policy base fee
        final int SMOKER_FEE = 100;                     // Additional fee if the policyholder is a smoker
        final int OVER_50_FEE = 75;                     // Additional fee if the policyholder is over the age of 50
        final double BMI_OVER_35_FEE = (bmi - 35) * 20;    // Additional fee if the policyholder's BMI is over 35
        double policyPrice = BASE_FEE;                  // Beginning price of the insurance policy

        // Adding additional fee if age is over 50
        if(policyHolder.getAge() > 50)
        {  
            policyPrice += OVER_50_FEE;
        }
        
        // Adding additional fee if the BMI is over 35
        if(bmi > 35)
        {
            policyPrice += BMI_OVER_35_FEE;
        } 

        // Adding additional fee if the policyholder is a smoker
        if(policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) 
        {
            policyPrice += SMOKER_FEE;
        }

        return policyPrice;
    }







}