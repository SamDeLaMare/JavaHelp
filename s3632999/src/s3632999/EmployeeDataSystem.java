package s3632999;

import java.util.Scanner;

/*
 * class EmployeeDataSystem
 * 
 * This class represents the portion of the Employee Data System 
 * program that has been completed by the previous programmer.
 * 
 * You are expected to complete the implementation of this class
 * progressively as you work through the various stages in the
 * assignment specification.
 */ 
 
public class EmployeeDataSystem
{

   // declaring the array of Employee references and the employee
   // count here at the class level so that our helper methods can
   // access the array
   private static final Employee[] employees = new Employee[50];
   private static int employeeCount = 0;

   // also declaring a Scanner here for shared use
   private static final Scanner sc = new Scanner(System.in);

   public static void main(String[] args)
   {
      char selection = '\0';
      String userInput;
      
      // program menu - implements requirement B for stage 2
      
      // repeat until the user selects the "Exit" option
      do
      {
         // display menu options to the screen
         printMenu();
         
         // prompt the user to enter their selection
         userInput = sc.nextLine();
         System.out.println();
         
         if (userInput.length() != 1)
         {
            System.out.println("Error - invalid selection!");
         }
         else
         {
            // extract user's selection from the input String
            selection = userInput.charAt(0);
            
            // convert selection to upper case to make menu case-insensitive
            selection = Character.toUpperCase(selection);
            
            // process selection
            switch (selection)
            {
               case 'A':
                  addNewEmployee();
                  break;
                  
               case 'B':
                  displayEmployeeSummary();
                  break;
                  
               case 'C':
                  updateEmployeePayScaleAndRole();
                  break;
                  
               case 'D':
                  addNewAcademicEmployee();
                  break;
                  
               case 'E':
                  recordPHDforAcademicEmployee();
                  break;                
               
               case 'X':
                  System.out.println("Exiting the program...");
                  break;
                  
               default:
                  System.out.println("Error - invalid selection!");
            }
         }
         
         System.out.println();
         
      } while (selection != 'X');

   }



   // Helper methods
   
   public static void printMenu()
   {
      System.out.println("***** Employee Management System Menu *****");
      System.out.println();
      
      System.out.println("A. Add New Employee");
      System.out.println("B. Display Employee Summary");
      System.out.println("C. Update Employee Pay Scale Level / Role");
      System.out.println("D. Add New Academic Employee");
      System.out.println("E. Record PhD for Academic Employee"); 
      System.out.println("X. Exit");
      
      System.out.println();
      System.out.print("Enter your selection: ");
   }
   
   
   public static void addNewEmployee()
   {
      System.out.println();
      System.out.println("Add New Employee Feature Selected");
      System.out.println();
      
      Scanner sc = new Scanner(System.in);
      System.out.printf("Please enter new Employee ID number");
      String employeeNumberInput = sc.nextLine();
      System.out.printf("Please enter new Employee name");
      String nameInput = sc.nextLine();
      System.out.printf("Please enter new Employee role");
      String roleInput = sc.nextLine();
      System.out.printf("Please enter new Employee pay level A-E");
      char levelInput = sc.next().trim().charAt(0);
      
      employees[employeeCount] = new Employee(employeeNumberInput, nameInput,
    	            roleInput, levelInput);
      
      /*if(sc != null)
	  {
		  sc.close();
	  }*/
      
      System.out.println();
      System.out.println("NEW EMPLOYEE ADDED " );
      System.out.println("****************** ");
      employees[employeeCount].printDetails();
      employeeCount++;
      System.out.println("Number of Employees: " + employeeCount);
    }

   
   public static void displayEmployeeSummary()
   {
      System.out.println();
      System.out.println("Display Employee Summary Feature Selected");
      System.out.println();
      
      for (int i = 0; i < employees.length; i++)
      {
    	  if (employees[i] != null)
    		   employees[i].printDetails();
      }
   }
   
   // updateEmployeeTitleAndRole()
   //
   // Implement the functionality required for Stage 2 
   // requirement C in this method if you wish, otherwise you
   // can implement the feature in the relevant case within
   // the switch statement in the main() method above.
   
   public static void updateEmployeePayScaleAndRole()
   {
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println(
                   "Update Employee Pay Scale Level / Role Feature Selected");
      System.out.println();
      
      System.out.println("Please enter employee number to begin search: ");
      String employeeNumberIn = sc.nextLine();
      
      Employee foundEmployeeNumber = findEmployee(employeeNumberIn);
      
      if(foundEmployeeNumber == null)
      {
    	  System.out.println("An employee with code" + employeeNumberIn + "does not exist." );
      }
      else
      {
    	  System.out.println("Employee has been found: " + employeeNumberIn);
    	  System.out.println("Please enter new Pay Scale level for employee : ");
          char level = sc.next().charAt(0);
          boolean newLevel = foundEmployeeNumber.updateLevel(level);
          
          System.out.println();
          System.out.println("NEW PAY SCALE UPDATED " );
          System.out.println("****************** ");
          System.out.println("New Pay Scale: " + newLevel);
          
          System.out.println("Please enter new role for employee or press enter to leave current: ");
          String employeeRoleIn =  sc.nextLine();
          //Employee updateRole = setRole(employeeRoleIn);
          
          if(employeeRoleIn == null)
          {
        	  System.out.println("Employee Role has been left as current role");
          }
          else
          {
        	  System.out.println();
        	  
          }
          
      }
   }
   
   // search helper method
   
   private static Employee findEmployee(String employeeNumber)
   {
	   for (Employee e : employees)
		   if(e.getEmployeeNumber().equals(employeeNumber))
			   return e;
	   return null;
   }
   
   private static Employee setRole(String employeeRole)
   {
	   for (Employee e : employees)
		   if(e.getRole().equals(employeeRole))
			   return e;
	   return null;
   }
   
   //
  
   
   // addNewAcademicEmployee()
   //
   // Implement the functionality required for Stage 4 
   // requirement B in this method if you wish, otherwise you
   // can implement the feature in the relevant case within
   // the switch statement in the main() method above.
   
   public static void addNewAcademicEmployee()
   {
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println("Add New Academic Employee Feature Selected");
      System.out.println();
   }
   
   // recordPHDForAcademicEmployee()
   //
   // Implement the functionality required for Stage 4 
   // requirement C in this method if you wish, otherwise you
   // can implement the feature in the relevant case within
   // the switch statement in the main() method above.
   
   private static void recordPHDforAcademicEmployee()
   {
      // delete this code when you start implementing this feature
      System.out.println();
      System.out.println("Record PhD for Academic Employee Feature Selected");
      System.out.println();
      
   }
   
}