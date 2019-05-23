package src;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Graphical User Interface of the application
 */
public class GUI {
	
	static Scanner scanner;
	
	
	/**
	 * Prints the first menu of the application
	 * 
	 * @return
	 */
	public static String firstMenu() {
		String menu = "";
		String lines = "------------------------------\n";
		String title =  lines + "Business Processes Application\n" + lines + "\n" + "Select one of the following options: \n\n";
		String choice1 = "1. Employee hiring \n";
		String choice2 = "2. Job hunting \n";
		String choice3 = "3. Find qualified employees for a job position \n";
		menu += title += choice1 += choice2 += choice3;
		
		return menu;
	}
	
	
	/**
	 * Prints the GUI for the job hunting program
	 * 
	 * @param con
	 */
	public static void jobHuntingMenu(Connection con) {
		System.out.println("\n" + "Job Hunting Process \n\n" + "Given a person's identifier, this process finds the job position with the highest\n" + 
				"pay rate for this person according to his/her skill possession.\n\n" + "Person id: ");
		
		scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
		JobHunting jh = new JobHunting(choice, con);
        ArrayList<String[]> jobs = jh.getJobWithHighestSalary();
        
        System.out.println("\n" + "Highest salary position: \n");
        for (int i = 0; i < jobs.size(); i++) {
        	for (int j = 0; j < jobs.get(0).length; j++) {
        		if (j == 0) {
        			System.out.print("Pos_code: " + jobs.get(i)[j] + " ");
        		} else {
        			System.out.println("Salary: " + jobs.get(i)[j]);
        		}
        	}
        }
        System.out.println();
        Controller controller = new Controller(con);
        controller.showMenu();
	}

	
	/**
	 * Prints the GUI for the Optimal Candidate program
	 * 
	 * @param con
	 */
	public static void optimalCandidatesMenu(Connection con) {
		System.out.println("\n" + "Optimal Candidates Process \n\n" + 
				"Finds the best choice of people for a job position with training.\n\n" + "Position code: ");
		
		scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
		OptimalCandidates oc = new OptimalCandidates(choice, con);
        ArrayList<String[]> candidates = oc.getQualifiedPeople();
        
        if (candidates.size() > 0) {
        	System.out.println("\n"+ "Qualified people for the job: \n");
        	for (int i = 0; i < candidates.size(); i++) {
            	for (int j = 0; j < candidates.get(0).length; j++) {
            		if (j == 0) {
            			System.out.print("Per_id: " + candidates.get(i)[j] + " ");
            		} else if (j == 1) {
            			System.out.print("Name: " + candidates.get(i)[j] + " ");
            		} else {
            			System.out.println("Email: " + candidates.get(i)[j]);
            		}
            	}
            }
        	
        } else {
        	candidates = oc.getAlmostQualifiedPeople();
        	System.out.println("\n"+ "People with the least number of missing skills for the job: \n");
        	
        	for (int i = 0; i < candidates.size(); i++) {
            	for (int j = 0; j < candidates.get(0).length; j++) {
            		if (j == 0) {
            			System.out.print("Per_id: " + candidates.get(i)[j] + " ");
            		} else {
            			System.out.println("Least_number: " + candidates.get(i)[j]);
            		}
            	}
            }
        }
        System.out.println("\n");
        Controller controller = new Controller(con);
        controller.showMenu();
        
	}

	
	/**
	 * Prints the GUI for the Employee Hiring program
	 * 
	 * @param con
	 */
	public static void employeeHiringMenu(Connection con) {
		System.out.println("\n" + "Employee Hiring Process \n\n" + "Given a person's identifier and a position code, "
				+ "this process finds the training program according to his/her skill possession.\n"); 
        
        System.out.println("Position code: ");
        scanner = new Scanner(System.in);
        String pos_code = scanner.nextLine();
        
		System.out.println("Person id: ");
		scanner = new Scanner(System.in);
        String per_id = scanner.nextLine();
        
		EmployeeHiring eh;
		
		try {
			eh = new EmployeeHiring(con, pos_code, per_id);

			ArrayList<String[]> courses = eh.findTrainingProg();
			
			if (courses ==  null) {
				System.out.println("The person is qualified for the job. No training programm is necessary.");
				return;
				
			} else if (courses.get(0).length == 2) {
				System.out.println("Course required: \n");
				for (int i = 0; i < courses.size(); i++) {
		        	for (int j = 0; j < courses.get(0).length; j++) {
		        		if (j == 0) {
		        			System.out.print("C_code: " + courses.get(i)[j] + " ");
		        		} else {
		        			System.out.println("Title: " + courses.get(i)[j]);
		        		}
		        	}
		        }
			} else {
				System.out.println("Courses required: \n");
				for (int i = 0; i < courses.size(); i++) {
		        	for (int j = 0; j < courses.get(0).length; j++) {
		        		if (j == 0) {
		        			System.out.print("Cset_id: " + courses.get(i)[j] + " ");
		        		} if (j == 1) {
		        			System.out.print("C_code1: " + courses.get(i)[j] + " ");
		        		} if (j == 2) {
		        			System.out.print("C_code2: " + courses.get(i)[j] + " ");
		        		} if (j == 3) {
		        			System.out.print("C_code3: " + courses.get(i)[j]);
		        		}
		        	}
		        	System.out.println();
		        }
			}
			System.out.println("\n");
	        Controller controller = new Controller(con);
	        //controller.showMenu();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
