import java.util.*;
import java.util.stream.Collectors;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Adina", 18);
        Person p2 = new Person("Maria", 40);
        Person p3 = new Person("George", 15);
        Person p4 = new Person("Alex", 35);
        Person p5 = new Person("Mihai", 12);

        // **** POINT 1
        System.out.println("1 - The list of persons is : ");
        List<Person> persList = Arrays.asList(p1, p2, p3, p4, p5);
        persList.forEach(System.out::println);

        System.out.println("---------------------");

        // **** POINT 2
        function2(persList);
        System.out.println("---------------------");

        // **** POINT 3
        function3(persList);
        System.out.println("---------------------");

        // **** POINT 4
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            String x = generateRandomString();
            System.out.println(x);
            stringSet.add(x);
        }

        function4(stringSet);
        System.out.println("---------------------");

        // **** POINT 5
        function5();
        System.out.println("---------------------");

        // **** POINT 6
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("a1", 5);
        myMap.put("a2", 50);
        myMap.put("a3", 3);
        myMap.put("a4", 25);
        myMap.put("a5", 3);

        System.out.println("The elements of the map are:");
        myMap.entrySet().stream().forEach(System.out::println);

        function6(myMap);
        System.out.println("---------------------");

        // **** POINT 7
        function7(stringSet);
        System.out.println("---------------------");

        // **** POINT 8
        function8(persList);
        System.out.println("---------------------");

        // **** POINT 9
        // Check if any person has age = 15
        function9(persList);
        System.out.println("---------------------");

        // **** POINT 10
        function10(p1, p2);
        System.out.println("---------------------");

        // **** POINT 11
        function11(stringSet);
        System.out.println("---------------------");
    }

    public static Set<Person> getPersonsSet(List<Person> persList) {
        return persList.stream().filter(p -> p.getName().contains("a") && p.getName().charAt(0) == 'M').collect(Collectors.toSet());
    }

    public static String generateRandomString() {
        int leftLim = 97, rightLim = 122;
        Random randLength = new Random();
        Random random = new Random();

        String generatedString = random.ints(leftLim, rightLim + 1)
                .limit(randLength.nextInt(10) + 5)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static int[] generateRandomIntegers() {
        Random random = new Random();
        int x = random.nextInt(9) + 1;
        int[] myArray = new int[x];

        myArray = new Random().ints(x, 1, 50).toArray();
        return myArray;
    }

    public static void function2(List<Person> persList) {
        System.out.println("2 - The elements containing the letter \"a\" that start with \"M\": ");
        persList.stream().filter(p -> p.getName().contains("a") && p.getName().charAt(0) == 'M').collect(Collectors.toSet()).forEach(System.out::println);
    }

    public static void function3(List<Person> persList) {
        System.out.println("3 - The person with the minimum age is :");
        System.out.println(persList.stream().min(Comparator.comparing(Person::getAge)).get().toString());
    }

    public static void function4(Set<String> stringSet) {
        /**
         * This method determines the maximum string in an array of strings.
         * The maximum in this case is considered to be the last in alphabetical order.
         */
        System.out.println("4 - The maximum (the last in alphabetical order) string in the list is:");
        System.out.println(stringSet.stream().max(Comparator.comparing(String::toString)).get());
    }

    public static void function5()
    {
        int[] numbersArray = generateRandomIntegers();

        System.out.println("5 - There are : " + numbersArray.length + " random integer numbers ");
        List<Integer> numbersList = new ArrayList<>();
        Collections.addAll(numbersList, Arrays.stream(numbersArray).boxed().toArray(Integer[]::new));

        System.out.println("5 - The random integers are : ");
        numbersList.stream().forEach(System.out::println);

        System.out.println("5 - Each element at power 2 is : ");
        numbersList.stream().map(nb -> Math.pow(nb,2)).forEach(System.out::println);
    }

    public static void function6(Map<String, Integer> myMap) {
        long nr = myMap.entrySet().stream().filter(map -> map.getValue() > 10).count();
        System.out.println("6 - Found: " + nr + " elements with value > 10");
    }

    public static void function7(Set<String> stringSet)
    {
        System.out.println("7 - The array of strings sorted alphabetically in reverse order is:");
        stringSet.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    public static void function8(List<Person> persList)
    {
        System.out.println("8 - The list of persons sorted by age is:");
        persList.stream().sorted((Person pe1, Person pe2) -> ((Integer) pe1.getAge()).compareTo(pe2.getAge())).forEach(p -> System.out.println(p));
    }

    public static void function9(List<Person> persList)
    {
        System.out.println("9 - Check if any person has age = 15. The answer is: ");
        boolean answer = persList.stream().anyMatch(s -> {
            return s.getAge() == 15;
        });

        System.out.println(answer);
    }

    public static void function10(Person p1, Person p2)
    {
        Optional<Person> perso1 = Optional.of(p1);
        Optional<Person> perso2 = Optional.ofNullable(p2);
        Optional<Person> perso3 = Optional.ofNullable(null);

        perso1.ifPresent(value -> System.out.println("10 - Optional print value: " + perso1));
        perso2.ifPresent(value -> System.out.println("10 - Optional print value: " + perso2));
        perso3.ifPresent(value -> System.out.println("10 - Optional print value: " + perso3));
    }

    public static void function11(Set<String> stringSet)
    {
        System.out.println("11 - The shortest string in the array of strings is:");
        System.out.println(stringSet.stream().min(Comparator.comparing(String::length)).get());
    }

}
