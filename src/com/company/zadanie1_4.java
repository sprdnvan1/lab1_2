package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class zadanie1_4 {
    private static Scanner scanner = null;

    private static Info GetHeighestMountain(Info[] mountains) {
        Info highest = mountains[0];
        for (Info currentMountain : mountains) {
            if (highest.GetHeight() < currentMountain.GetHeight())
                highest = currentMountain;
        }
        return highest;
    }

    private static ArrayList<Info> GetHigherThan1000Mountains(Info[] mountains) {
        ArrayList<Info> higherThan1000Mountains = new ArrayList<Info>();
        for (Info currentMountain : mountains) {
            if (currentMountain.GetHeight() > 1000)
                higherThan1000Mountains.add(currentMountain);
        }
        return higherThan1000Mountains;
    }

    private static void sort(Info[] mountains) {
        for (int i = 0; i < mountains.length-1; i++) {
            for (int j = 0; j < mountains.length - i - 1; j++) {
                if (mountains[j].GetHeight() > mountains[j + 1].GetHeight()) {
                    Info temp = mountains[j]; // temp – временная переменная для перестановки
                    mountains[j] = mountains[j + 1];
                    mountains[j + 1] = temp;
                }
            }
        }
    }
    private static Info search(Info[] mountains, String name) {
        int nom = -1; // -1 – горы с искомым названием отсутствует
        for (int i = 0; i < mountains.length; i++) {
            if (name.equalsIgnoreCase(mountains[i].GetName()))
                nom = i;
        }
        if (nom >= 0)
            return mountains[nom];
        return null;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in, "cp1251");

        System.out.println("Введите количество гор => ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Info[] mountains = new Info[count];
        for (int i = 0; i < count; i++)
            mountains[i] = new Info();

        System.out.println("Введите информацию о горе: ");

        for (Info currentInfo : mountains) {
            System.out.print("Введите наименование горы => ");
            currentInfo.SetName(scanner.nextLine());
            System.out.print("Введите местоположение горы => ");
            currentInfo.SetPlace(scanner.nextLine());
            System.out.print("Введите высоту горы => ");
            currentInfo.SetHeight(scanner.nextInt());
            scanner.nextLine();
            System.out.print("\n");
        }

        // Поиск первой высочайшей горы
        Info highest = GetHeighestMountain(mountains);

        //выше 1000м
        ArrayList<Info> higherThan1000 = GetHigherThan1000Mountains(mountains);

        //сортировка
        sort(mountains);

        //поиск горы
        scanner.nextLine(); // очистка буфера
        System.out.println("Введите название искомой горы=> ");
        String name = scanner.nextLine();
        Info searchResult = search(mountains, name);
        if (searchResult != null)
            System.out.println("Такая гора есть в списке. Это " + searchResult.toString());
        else
            System.out.println("Такой горы нет в списке");
    }
}
