package ru.geekbrains.java.katsenelenbogen.account;

import java.util.Random;

public class AccountDataGenerator {
    private static final int COUNTRY_ID = 21;
    private static final String[] FIRST_NAMES = {
            "Liam",
            "Noah",
            "Mason",
            "Ethan",
            "Logan",
            "Lucas",
            "Jackson",
            "Aiden",
            "Oliver",
            "Jacob",
            "Elijah",
            "Alexander",
            "James",
            "Benjamin",
            "Jack"
    };

    private static final String[] LAST_NAMES = {
            "Smith",
            "Johnson",
            "Williams",
            "Brown",
            "Jones",
            "Miller",
            "Davis",
            "Garcia",
            "Rodriguez",
            "Wilson",
            "Martinez",
            "Anderson",
            "Taylor",
            "Thomas",
            "Hernandez"
    };
    public int randomNames() {
        int min = 0;
        int max = FIRST_NAMES.length - 1;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    public String genMail(String firstName, String lastName) {
        StringBuilder mailBuilder = new StringBuilder();
        return mailBuilder.
                append(lastName.toLowerCase()).append("_").
                append(firstName.toLowerCase()).append("@gmail.com").toString();
    }
    public int genInt(int min, int max){
        max = max - min + 1;
        return (int) (Math.random() * max) + min;
    }
    public String genString(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
    public BuildAccount genAccount() {
        String firstName = FIRST_NAMES[randomNames()];
        String lastName = LAST_NAMES[randomNames()];

        return new BuildAccount(
                firstName,
                lastName,
                genMail(firstName, lastName),
                genString(),
                genString(),
                genString(),
                genInt(1, randomNames()),
                genString(),
                COUNTRY_ID,
                genString(),
                genString()
        );
    }

}
