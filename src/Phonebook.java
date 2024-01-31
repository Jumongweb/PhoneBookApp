import java.util.ArrayList;
import java.util.Scanner;

public class Phonebook {
    private static final Scanner scanner = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private static int phoneBook;
    private static ArrayList<String> firstNameContainer = new ArrayList<>();
    private static ArrayList<String> lastNameContainer = new ArrayList<>();
    private static ArrayList<String> phoneNumberContainer = new ArrayList<>();

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }


    public void displayPhoneBook(){
        mainMenu();
        System.out.print("Your choice: ");
        phoneBook = scanner.nextInt();
        scanner.nextLine();

        while (phoneBook < 1 || phoneBook > 6){
            System.out.println("Number should be between 1 - 6");
            System.out.print("Your choice: ");
            phoneBook = scanner.nextInt();
            scanner.nextLine();
        }
        if (phoneBook == 1){
            if (firstNameContainer.size() != 0) {
                System.out.println();
                System.out.println("*".repeat(40));
                System.out.printf("%s%30s%n", "Name", "Phone Number");
            }
            for (int count = 0; count < firstNameContainer.size(); count++) {
                    System.out.printf("%s %s %25s%n", firstNameContainer.get(count), lastNameContainer.get(count), phoneNumberContainer.get(count));
            }
            System.out.printf("%nTotal number of Contacts: %d%n", firstNameContainer.size());

            if (firstNameContainer.isEmpty()) {
                System.out.println("This phonebook is empty");
            }
            System.out.println("*".repeat(40));
        }
        if (phoneBook == 2){
            System.out.println("Enter phone number: ");
            String number = scanner.nextLine();
            System.out.println("Enter first name: ");
            String name1 = scanner.nextLine();
            System.out.println("Enter last name: ");
            String name2 = scanner.nextLine();

            setFirstName(name1);
            setLastName(name2);
            setPhoneNumber(number);
            phoneNumberContainer.add(getPhoneNumber());
            firstNameContainer.add(getFirstName());
            lastNameContainer.add(getLastName());
            System.out.println("Added");
        }

        if (phoneBook == 3){
            System.out.println("which name do you want to remove");
            System.out.println("You are free to type either the first or last name");
            String nameToRemove = scanner.nextLine();
            deleteContact(nameToRemove);

        }

        if (phoneBook == 4){
            System.out.print("Type name to search: ");
            System.out.println("You are free to type either the first or last name");
            String searchName = scanner.nextLine();
            searchContact(searchName);
        }
        if (phoneBook == 5){
            updateContact();
        }
        if (phoneBook == 6){
            exit();
        }

        while (phoneBook != 6){
            displayPhoneBook();
        }

    }

    public void mainMenu() {
        System.out.println("\nPHONEBOOK");
        System.out.println("=".repeat(30));
        System.out.println("What would you like to do?");
        System.out.println("1. Show all contact ");
        System.out.println("2. Add new contact ");
        System.out.println("3. Delete contact ");
        System.out.println("4. Search contact ");
        System.out.println("5. Update contact ");
        System.out.println("6. Exit ");
        System.out.println("=".repeat(30));
    }
    public void deleteContact(String name){
        for (int index = 0; index < firstNameContainer.size(); index++){
            if (name.equals(firstNameContainer.get(index)) || name.equals(lastNameContainer.get(index))){
                firstNameContainer.remove(firstNameContainer.get(index));
                lastNameContainer.remove(lastNameContainer.get(index));
                phoneNumberContainer.remove(phoneNumberContainer.get(index));
                System.out.println("Deleted");
            }
        }
    }
    public void searchContact(String name){
        for (int index = 0; index < firstNameContainer.size(); index++){
            if (name.equals(firstNameContainer.get(index)) || name.equals(lastNameContainer.get(index))){
                System.out.printf("%s found%n",firstNameContainer.get(index));
                System.out.printf("%s found%n",lastNameContainer.get(index));
                System.out.println(phoneNumberContainer.get(index));
            }
        }
    }

    public void updateContact(){
        System.out.println("Option: ");
        System.out.println("1. Change name");
        System.out.println("2. Change number");
        int updateContact = scanner.nextInt();
        scanner.nextLine();
        if (updateContact == 1){
            System.out.println("Enter old name: ");
            String oldName = scanner.nextLine();
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            for (int index = 0; index < firstNameContainer.size(); index++){
                if (oldName.equals(firstNameContainer.get(index))){
                    firstNameContainer.set(index, newName);
                    System.out.println("Change successful");
                }
                if (oldName.equals(lastNameContainer.get(index))){
                    lastNameContainer.set(index, newName);
                    System.out.println("Change successful");
                }
            }
        }
        if (updateContact == 2){
            System.out.println("Enter old number: ");
            String oldNumber = scanner.nextLine();
            System.out.println("Enter new number: ");
            String newNumber = scanner.nextLine();
            scanner.nextLine();
            for (int index = 0; index < firstNameContainer.size(); index++){
                if (oldNumber.equals(phoneNumberContainer.get(index))){
                    phoneNumberContainer.set(index, newNumber);
                    System.out.println("Change successful");
                }
            }
        }
    }
    public void exit(){
        System.out.println("NOTE:");
        System.out.println("This is the first prototype of this application. The programme is still a work in progress. Give us your a feedback by dropping a comment. ");
        System.out.println("Goodbye and Thank You!!!");
    }

}