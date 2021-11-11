package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PlanningApplication {
    public static void main(String[] args) throws FileNotFoundException {
        JobCatalog jobs = new JobCatalog();
        // make read from file job list
        Scanner fin = new Scanner(new File("resources/joblist.txt"));
        while (fin.hasNextLine()) {
            // for the address
            String line = fin.nextLine();
            Scanner parse = new Scanner(line).useDelimiter("; ");
            String street = parse.next();
            int number = parse.nextInt();
            String zipCode = parse.next();
            String city = parse.next();
            Address address = new Address(street, number, zipCode, city);
            // for the job descr
            line = fin.nextLine();
            String description = line;
            // for the req equipment
            ArrayList<Equipment> reqEq = new ArrayList<>();
            line = fin.nextLine();
            if (line.length() > 0) {
                parse = new Scanner(line).useDelimiter("; ");
                while (parse.hasNext()) {
                    String eq = parse.next();
                    Scanner words = new Scanner(eq).useDelimiter(", ");
                    String tool = words.next();
                    String req = words.next();
                    if (tool.equals("JackHammer")) {
                        JackHammer x = new JackHammer(req);
                        reqEq.add(x);
                    } else if (tool.equals("ConcreteMixer")) {
                        ConcreteMixer x = new ConcreteMixer(req);
                        reqEq.add(x);
                    } else if (tool.equals("Torch")) {
                        Torch x = new Torch(req);
                        reqEq.add(x);
                    } else {
                        ScaffoldingTower x = new ScaffoldingTower(req);
                        reqEq.add(x);
                    }
                }
            }
            // date
            line = fin.nextLine();
            parse = new Scanner(line).useDelimiter("-");
            int day, month, year;
            day = parse.nextInt();
            month = parse.nextInt();
            year = parse.nextInt();
            Date date = new Date(day, month, year);
            // making the job
            Job job = new Job(address, description, reqEq, date);
            jobs.addJob(job);
        }
        Scanner cin = new Scanner(System.in); // Scanner object
        while (true) {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("1 - Show all jobs in the catalog.\n2 - Add a new job.\n3-6 - To be implemented.\n7 - Quit application.\n");
            System.out.print("Choice: ");
            int choice = cin.nextInt();
            if (choice == 1)
                System.out.println(jobs);
            else if (choice == 2) {

                System.out.print("Enter job information:\n");
                System.out.print("Location:\n");
                String street = "", zipCode = "", city = "";
                int number;
                System.out.print("Street:\n");
                street = cin.next();
                System.out.print("Number:\n");
                number = cin.nextInt();
                System.out.print("Zip Code:\n");
                zipCode = cin.next();
                System.out.print("City:\n");
                city = cin.next();
                Address location = new Address(street, number, zipCode, city);
                System.out.print("Description:\n");
                String description = cin.next();
                System.out.print("Equipment:\n");
                ArrayList<Equipment> list = new ArrayList<>();

                System.out.print("Do you need to use a Torch? y/n\n");
                String ans = cin.next();
                String req = "";
                if (ans.equals("y")) {
                    req = cin.next();
                    Torch x = new Torch(req);
                    list.add(x);
                }
                System.out.print("Do you need a Jack Hammer? y/n\n");
                ans = cin.next();
                if (ans.equals("y")) {
                    req = cin.next();
                    JackHammer x = new JackHammer(req);
                    list.add(x);
                }
                System.out.print("Do you need a Scaffolding Tower? y/n\n");
                ans = cin.next();
                if (ans.equals("y")) {
                    req = cin.next();
                    ScaffoldingTower x = new ScaffoldingTower(req);
                    list.add(x);
                }
                System.out.print("Now please enter the date in the format dd mm yy:\n");

                int day, month, year;
                day = cin.nextInt();
                month = cin.nextInt();
                year = cin.nextInt();

                Date date = new Date(day, month, year);

                Job job = new Job(location, description, list, date);

                jobs.addJob(job);
            } else if (choice == 7) //exit program
                System.exit(0);
        }
    }
}
