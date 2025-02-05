import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;


public class FileReader {
    public static void main(String[] args) {
        FileReader fr = new FileReader();

        System.out.println("TASK 1 test:");
        fr.validatePhoneNumber("./src/main/java/task1.txt");
        System.out.println("-----------------------------");

        System.out.println("TASK 2 test:");
        fr.textJsonConverter("./src/main/java/task2.txt");
        System.out.println("-----------------------------");

        System.out.println("TASK 3 test:");
        fr.wordsCounter("./src/main/java/task3.txt");
        System.out.println("-----------------------------");
    }

    // TASK 1 Method
    public void validatePhoneNumber(String filePath) {
        File file = getFile(filePath);
        if (file == null) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.matches("\\(\\d{3}\\) \\d{3}-\\d{4}") || line.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(line);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error while reading file:");
            ex.printStackTrace();
        }

    }

    // TASK 2 Method
    public void textJsonConverter(String filePath) {
        File file = getFile(filePath);
        if (file == null) {
            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> users = new ArrayList<>();
        List<String> columns = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            boolean firstRow = true;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (firstRow) {
                    columns = new ArrayList<>(List.of(line.toLowerCase().split(" ")));
                    firstRow = false;
                } else {
                    String[] lineData = line.split(" ");
                    User user = new User();

                    for (int i = 0; i < lineData.length; i++) {
                        user.setProperty(columns.get(i), lineData[i]);
                    }
                    users.add(user);
                }
            }

            String json = gson.toJson(users);
            System.out.println(json);

        } catch (Exception ex) {
            System.out.println("Error while reading file:");
            ex.printStackTrace();
        }
    }

    // TASK 3 Method
    public void wordsCounter(String filePath) {
        File file = getFile(filePath);
        if (file == null) {
            return;
        }

        List<String> words = new ArrayList<>();
        List<Integer> frequency = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineWords = line.split(" ");
                for (String word : lineWords) {
                    int i = words.indexOf(word);
                    if (i < 0) {
                        words.add(word);
                        frequency.add(1);
                    } else {
                        frequency.set(i, frequency.get(i) + 1);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error while reading file:");
            ex.printStackTrace();
            return;
        }

        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < frequency.size(); i++) {
            Integer key = frequency.get(i);
            String value = treeMap.get(key);
            String newValue = (value == null) ? words.get(i) : value + " " + words.get(i);
            treeMap.put(key, newValue);
        }

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            List<String> freqWords = new ArrayList<>(List.of(entry.getValue().split(" ")));
            freqWords.sort(Comparator.naturalOrder());
            for (String word : freqWords) {
                System.out.println(word + " " + entry.getKey());
            }
        }
    }

    private File getFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found! Can't do task!");
            return null;
        }

        if (file.isDirectory()) {
            System.out.println("File is a directory! Can't do task!");
            return null;
        }

        return file;
    }

    static class User {
        String name;
        int age;

        void setProperty(String property, String value) {
            switch (property) {
                case "name":
                    setName(value);
                    break;
                case "age":
                    setAge(Integer.parseInt(value));
                    break;
            }
        }

        void setName(String name) {
            this.name = name;
        }

        void setAge(int age) {
            this.age = age;
        }
    }
}