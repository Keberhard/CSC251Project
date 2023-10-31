public class PolicyHolder {
    private String firstName;     // The policyholder's first name
    private String lastName;      // The policyholder's last name
    private int age;              // The policyholder's age
    private String smokingStatus;// The policyholder's smoking status smoker or non-smoker
    private double height;        // The policyholder's height in inches
    private double weight;        // The policyholder's weight in pounds

    public PolicyHolder(String fName, String lName,
    int personAge, String smokerStat, double heightInInches, double weightInLbs)
    {
        firstName = fName;
        lastName = lName;
        age = personAge;
        smokingStatus = smokerStat;
        height = heightInInches;
        weight = weightInLbs;
    }
    
    public PolicyHolder(PolicyHolder object2)
    {
        firstName = object2.firstName;
        lastName = object2.lastName;
        age = object2.age;
        smokingStatus = object2.smokingStatus;
        height = object2.height;
        weight = object2.weight;
        
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
 
     public String toString()
     {
        String str = "Policyholder's First Name: " + firstName + 
                     "\nPolicyholder's Last Name: " + lastName +
                     "\nPolicyholder's Age: " + age +
                     "\nPolicyholder's Smoking Status: " + smokingStatus +
                     "\nPolicyholder's Height: " + height +
                     "\nPolicyholder's Weight: " + weight;
        return str;
     }
    
}
