import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Calculator {

    public static void AgeCalculator(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Date of Birth (DOB) in the format DD-MM-YYYY: ");
        String dobInput = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate dob = LocalDate.parse(dobInput, formatter);

            LocalDate currentDate = LocalDate.now();

            if (dob.isAfter(currentDate)) {
                System.out.println("The date of birth cannot be in the future.");
            } else {
                long years = ChronoUnit.YEARS.between(dob, currentDate);
                LocalDate ageInYears = dob.plusYears(years);

                long months = ChronoUnit.MONTHS.between(ageInYears, currentDate);
                ageInYears = ageInYears.plusMonths(months);

                long days = ChronoUnit.DAYS.between(ageInYears, currentDate);

                System.out.printf("Your age is %d years, %d months, and %d days.%n", years, months, days);
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format DD-MM-YYYY.");
        } //finally {
           // scanner.close();
        //}   
    }

    public static void DOBcalculator(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the reference date (format: DD-MM-YYYY): ");
        String referenceDateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate referenceDate = LocalDate.parse(referenceDateStr, formatter);

            System.out.print("Enter your age in years: ");
            int years = scanner.nextInt();

            System.out.print("Enter additional months: ");
            int months = scanner.nextInt();

            System.out.print("Enter additional days: ");
            int days = scanner.nextInt();

            LocalDate dob = referenceDate.minusYears(years).minusMonths(months).minusDays(days);

            System.out.println("Your Date of Birth is: " + dob.format(formatter));

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format DD-MM-YYYY.");
        } //finally {
           // scanner.close();
        //}

    
    }   
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int ch;

        
	
	do	{

		System.out.println("\n*** Calculator ***"); 
        System.out.println("\n\n1.Age Calulator\n2.Date of birth Calculator \n3.Exit");
        System.out.println("\n\nEnter your choice(1-3):");
    	
        ch = scanner.nextInt();
		
		
		switch(ch)
		{
			case 1: AgeCalculator();
					break;
			case 2: DOBcalculator();
					break;
			case 3: System.out.println("exiting the program");
                break;
            default: System.out.println("\nWrong Choice!!");
		}
	}while (ch!= 3);
  
   }

}



