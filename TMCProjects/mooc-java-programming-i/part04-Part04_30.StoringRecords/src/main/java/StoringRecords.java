
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StoringRecords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Filename:");
        String file = scan.nextLine();

        ArrayList<Person> records = readRecordsFromFile(file);
        System.out.println("Persons: " + records.size());
        System.out.println("Persons:");
        for (Person person : records) {
            System.out.println(person);

        }
    }

    public static ArrayList<Person> readRecordsFromFile(String file) {
        ArrayList<Person> persons = new ArrayList<>();
        try(Scanner readFile = new Scanner(Paths.get(file))){
            while(readFile.hasNextLine()){
                String read = readFile.nextLine();
                String[] parts = read.split(",");
                persons.add(new Person(parts[0],Integer.valueOf(parts[1])));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return persons;

    }
}
