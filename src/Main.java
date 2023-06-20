import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<String> bingoNumber = Arrays.asList(
                "N63", "N54",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "S23", "S3", "S17",
                "O71"
        );


        bingoNumber.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                System.out.println(number);
            }
        });
        System.out.println(".".repeat(40));

        List<String> gNumbers = new ArrayList<>();
        //the code below can be also done much shorter with streams
        /*
        bingoNumber.forEach(number -> {
            if(number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
            }
        });
        System.out.println(".".repeat(40));
        gNumbers.sort(Comparator.naturalOrder());
        gNumbers.forEach( (String s) -> System.out.println(s));
        */

        bingoNumber
                .stream()   //1
                .map(String::toUpperCase)  //2    // is the same as .map(s -> toUpperCase())
                .filter(s -> s.startsWith("G"))  //3
                .sorted() //4
                .forEach(System.out::println); //5   //forEach is a terminal operation it forces the end of the chain

        //1 -> A Stream that contains all the items in the bingoNumbers list,in the same order
        //2 -> A Stream that contains all the bingoNumbers uppercased
        //3 -> A Stream containing all the items beginning with "G"
        //4 -> A Stream containing the sorted items
        //5 -> Each "G" item is printed to the console.Void result.The chain ends

        System.out.println(".".repeat(40));


        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        System.out.println(".".repeat(40));

        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("jack Does", 34);
        Employee brandon = new Employee("brandon Doed", 20);
        Employee dude = new Employee("dude Doev", 24);

        Department hr = new Department("Human Resources");
        hr.AddEmployee(john);
        hr.AddEmployee(jack);
        hr.AddEmployee(brandon);
        Department accounting = new Department("Accounting");
        accounting.AddEmployee(dude);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println(".".repeat(40));

        List<String> sortedGNumbers = bingoNumber
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        System.out.println(".".repeat(40));

        List<String> sortedGNumbers2 = bingoNumber
                .stream()
                .map(String::toUpperCase)
                .filter(st -> st.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for (String string : sortedGNumbers) {
            System.out.println(string);
        }

        System.out.println(".".repeat(40));

        //The youngest employee
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1:e2)
                .ifPresent(System.out::println);


        System.out.println(".".repeat(40));

        Stream.of("ABC","AC","BAA","CCCC","XY","ST")
                .filter(s ->{
                    System.out.println(s);
                    return s.length()==3;
                })
                .count();

    }
}