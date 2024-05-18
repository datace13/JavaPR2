package ExamPaper;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String company;
    private String email;
    private String phone;

    public Contact(String name, String company, String email, String phone) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nCompany: " + company + "\nEmail: " + email + "\nPhone: " + phone + "\n";
    }
}

public class AddressBooks {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public AddressBooks() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter company: ");
        String company = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, company, email, phone);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void findContactByName() {
        System.out.print("Enter name to find: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Phone number: " + contact.getPhone());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        System.out.println("Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        AddressBooks addressBooks = new AddressBooks();
        addressBooks.start();
    }
}

