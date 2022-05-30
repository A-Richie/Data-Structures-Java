import java.util.Scanner;

class UserDataBase {
    private ArrayList<Person> list;

    public UserDataBase()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String line = sc.nextLine();
        Person newPerson = new Person(line);
    }




}