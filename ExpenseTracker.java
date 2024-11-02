package motionCutWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
	private List<Expense> expenses;
	
	public ExpenseTracker() {
		expenses = new ArrayList<>();
	}
	
	public void addExpense(double amount, String category, String description) {
		Expense expense = new Expense(amount, category, description);
		expenses.add(expense);
		System.out.println("Expense added: "+ expense);
	}
	
	public void viewExpense() {
		for (Expense expense : expenses) {
            System.out.println(expense.toString());
        }
	}
	
	public void deleteExpense(int index) {
		if(index >= 0 && index < expenses.size()) {
			expenses.remove(index);
			System.out.println("Expense deleted.");
		}
		else {
			System.out.println("Invalid index.");
		}
	}
	
	public void summariseExpense() {
		double total = 0;
		for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total spending: " + total);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ExpenseTracker tracker = new ExpenseTracker();
		
		while(true) {
			System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Summarize Expenses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
            case 1:
            	System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                tracker.addExpense(amount, category, description);
                break;
            case 2:
            	tracker.viewExpense();
            	break;
            case 3:
            	System.out.print("Enter index to delete: ");
                int index = scanner.nextInt();
                tracker.deleteExpense(index);
                break;
            case 4:
            	tracker.summariseExpense();
            	break;
            case 5:
            	scanner.close();
            	System.exit(0);
            default:
            	System.out.println("Invalid choice.");
            }
		}
	}
}
