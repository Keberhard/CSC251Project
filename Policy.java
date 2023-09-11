/**
   The Policy class will model an insurance policy. 
*/
public class Policy
{
   private int policyNum;        // The policy number
   private String provider;      // The provider's name
   private String firstName;     // The policyholder's first name
   private String lastName;      // The policyholder's last name
   private int age;              // The policyholder's age
   private String smokingStatus;// The policyholder's smoking status smoker or non-smoker
   private double height;        // The policyholder's height in inches
   private double weight;        // The policyholder's weight in pounds
   
   /**
      This constructor sets fields to 0 or null or false.
   */
   
   public Policy()
   {
      policyNum = 0;
      provider = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0.0;
      weight = 0.0;
   }

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
   
   public Policy(int policyNumber, String providerName, String fName, String lName,
   int personAge, String smokerStat, double heightInInches, double weightInLbs)
    {
        policyNum = policyNumber;
        provider = providerName;
        firstName = fName;
        lastName = lName;
        age = personAge;
        smokingStatus = smokerStat;
        height = heightInInches;
        weight = weightInLbs;
    }

    /**
       The getPolicyNum method returns the insurance policy number.
       @return The insurance policy number.
     */

    public int getPolicyNum()
    {
        return policyNum;
    }

    /**
       The setPolicyNum method sets the insurance policy number.
       @param policyNumber The insurance policy number.
     */

    public void setPolicyNum(int policyNumber)
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
        The getFirstName method returns the policyholder's first name.
        @return The first name of the policyholder.
     */

    public String getFirstName() 
    {
        return firstName;
    }

    /**
        The setFirstName method sets the policyholder's first name.
        @param fName The policyholder's first name.
     */

    public void setFirstName(String fName) 
    {
        firstName = fName;
    }

    /**
        The getLastName method returns the policyholder's last name.
        @return The policyholder's last name.
     */

    public String getLastName() 
    {
        return lastName;
    }

    /**
        The setLastName method sets the policyholder's last name.
        @param lName The policyholder's last name.
     */

    public void setLastName(String lName) 
    {
        lastName = lName;
    }

    /**
        The getAge method returns the age of the policholder's age.
        @return The policyholder's age.
     */

    public int getAge() 
    {
        return age;
    }

    /**
        The setAge method sets the age of the policyholer.
        @param personAge The policyholder's age.
     */

    public void setAge(int personAge) 
    {
        age = personAge;
    }

    /**
        The getSmokingStatus method returns smoker or non-smoker.
        @return Smoker or non-smoker.
     */

    public String getSmokingStatus() 
    {
        return smokingStatus;
    }

    /**
        The setSmokingStatus method sets the string to smoker or non-smoker.
        @param smoking Smoker or non-smoker.
     */

    public void setSmokingStatus(String smoking) 
    {
        smokingStatus = smoking;
    }

    /**
        The getHeigth method returns the policyholder's height in inches.
        @return The policyholder's height in inches.
     */

    public double getHeight() 
    {
        return height;
    }

    /**
        The setHeight method sets policyholder's height in inches.
        @param heightInInches The policyholder's height in inches.
     */

    public void setHeight(double heightInInches) 
    {
        height = heightInInches;
    }

    /**
        The getWeight method returns the policyholder's weight in pounds.
        @return The policyholder's weight in pounds.
     */

    public double getWeight() 
    {
        return weight;
    }

    /**
        The setWeight method sets the ppolicyholder's weight in pounds.
        @param weightInLbs The policyholder's weight in pounds.
     */

    public void setWeight(double weightInLbs) 
    {
        weight = weightInLbs;
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
        double bmi = (weightPounds * CONV_FACT)/(Math.pow(heightInches, 2)); // Body Mass Index calculation
        return bmi;
    }

    /**
        The priceOfPolicy method calculates the cost of the insurance policy 
        @param bmi The policyholder's Body Mass Index
        @return The cost of the insurance policy
     */

    public double priceOfPolicy(double bmi)
    {
        final int BASE_FEE = 600;                       // Insurance policy base fee
        final int SMOKER_FEE = 100;                     // Additional fee if the policyholder is a smoker
        final int OVER_50_FEE = 75;                     // Additional fee if the policyholder is over the age of 50
        final double BMI_OVER_35_FEE = (bmi - 35) * 20;    // Additional fee if the policyholder's BMI is over 35
        double policyPrice = BASE_FEE;                  // Beginning price of the insurance policy

        // Adding additional fee if age is over 50
        if(age > 50)
        {  
            policyPrice += OVER_50_FEE;
        }
        
        // Adding additional fee if the BMI is over 35
        if(bmi > 35)
        {
            policyPrice += BMI_OVER_35_FEE;
        } 

        // Adding additional fee if the policyholder is a smoker
        if(smokingStatus.compareTo("smoker") == 0) 
        {
            policyPrice += SMOKER_FEE;
        }

        return policyPrice;
    }






}