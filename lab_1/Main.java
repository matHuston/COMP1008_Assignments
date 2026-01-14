package lab_1;

import java.util.Scanner;

/*
    Week 2 Lab: Weather Report Program
    Topics: Conditional statements, loops, typecasting, input validation
    Objective: Ask the user for weather info, validate input, and display a full report
*/
 
public class Main {
    public static void main(String[] args) {
 
        Scanner input = new Scanner(System.in);
 
        /*
        STEP 1: Declare variables for weather information
        a) Today's weather conditions (String)
        b) Possibility of precipitation (String)
        c) Wind speed (String)
        d) Daily high temperature (int or double)
        e) Daily low temperature (int or double)
        f) UV index (int)
        */
 
        // TODO: Declare your variables here
        String weather;
        String precipitation;
        String windSpeed;
        double dailyHigh;
        double dailyLow;
        int uvIndex;
        String weatherTips;
        boolean userInput;
        String moreReports;
        boolean inputAgain;

        /*
        STEP 2: Get input from the user using Scanner
        - Ask for each variable above
        - Validate numeric input using loops
        - Example: Ensure highTemp >= lowTemp
        */
        
        // TODO: Prompt user and read input
            userInput = true;
            do {
                System.out.print("Enter today's weather (ex. Sunny, Cloudy): ");
                weather = input.nextLine();
                System.out.print("Enter precipitation chance (0-100%): ");
                precipitation = input.nextLine();
                System.out.print("Enter wind speed (km/h): ");
                windSpeed = input.nextLine();
                System.out.print("Enter daily high temperature: ");
                dailyHigh = input.nextDouble();
                System.out.print("Enter daily low temperature: ");
                dailyLow = input.nextDouble();
                System.out.print("Enter UV index: ");
                uvIndex = input.nextInt();
                userInput = false;
            } while (userInput==true);

        // TODO: Use loops to validate high/low temperatures and UV index
            while(dailyLow > dailyHigh){
                System.out.println("Error: Lowest temp cannot be higher than highest temp.");
                System.out.print("Re-enter daily low temperature: ");
                dailyLow = input.nextDouble();
            }
        
            while(uvIndex < 0 || uvIndex > 11){
                System.out.println("Error: UV index must be between 0 and 11.");
                System.out.print("Re-enter UV index: ");
                uvIndex = input.nextInt();
            }
 
        /*
        STEP 3: Typecasting (if needed)
        - Example: if you read a double but want to display as int
        */
 
        // TODO: Apply typecasting where necessary
        int highTemp = (int) dailyHigh;
        int lowTemp = (int) dailyLow;
        int windInt = Integer.parseInt(windSpeed);
        int rainInt = Integer.parseInt(precipitation);
 
        /*
        STEP 4: Conditional statements
        - Example: 
          - If UV index >= 6, suggest "Use sunscreen"
          - If precipitation >= 50%, suggest "Carry an umbrella"
          - If wind speed > 40 km/h, suggest "Windy conditions"
        */
 
        // TODO: Write if, if-else, or nested if statements to display tips
            weatherTips = "";
            if (uvIndex >= 6) {
                weatherTips += "\nHigh UV today; Don't forget sunscreen!";
            }
            if (rainInt >= 50) {
                weatherTips += "\nRisk of rain today; Bring an umbrella!";
            } 
            if (windInt >= 40) {
                weatherTips += "\nWindy conditions; Secure loose items outdoors!";
            }
 
        /*
        STEP 5: Create a fullReport String
        - Combine all user inputs and tips into one formatted sentence or paragraph
        - Use String concatenation (+) or String.format()
        */

        // TODO: Construct your full weather report here
        String fullReport = String.format("Today's weather is %s with a high of %d°C and a low of %d°C. " + "Precipitation chance is %s%% and wind speed is %s km/h. UV index is %d.%s", weather, highTemp, lowTemp, precipitation, windSpeed, uvIndex, weatherTips);
 
        /*
        STEP 6: Print the full weather report
        */
 
        // TODO: Output your report using System.out.println()
        System.out.println(fullReport);

        /*
        STEP 7: Optional extra challenge
        - Use loops to ask if the user wants to enter another day's report
        - Continue until the user types "no"
        */
       
        // TODO: Implement loop for multiple reports
        input.close();
    }
}
