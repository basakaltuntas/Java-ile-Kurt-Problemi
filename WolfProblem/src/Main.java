package org.example;
import java.util.HashMap;
import java.util.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Random nesnesi olusturduk
        Random random = new Random();
        int minimum = 5;
        int maximum = 200000;

        //Rastgele dizi uzunlugu
        int arrayLength = random.nextInt((maximum - minimum ) + 1) + minimum;

        //Toplam kurt sayisi ekrana yazdirma
        System.out.println("Kurt Sayisi = "+arrayLength);

        int[] arr=new int[arrayLength];

        //olusturdugumuz diziye random sayilar atayalim.
        for (int i = 0; i < arrayLength ; i++) {
            //rastgele sayi uretip diziye ekliyoruz
            arr[i]=random.nextInt(5)+1;
        }

        //Kurt turlerini iceren HashMap tanımı
        HashMap <Character,Integer> wolfType = new HashMap<Character, Integer>();
        wolfType.put('a',0);//Wolf type 1
        wolfType.put('b',0);//Wolf type 2
        wolfType.put('c',0);//Wolf type 3
        wolfType.put('d',0);//Wolf type 4
        wolfType.put('e',0);//Wolf type 5

        //Rastgele olusturulan kurt turlerini HashMap icinde sınıflandırma
        for (int ar:arr) {
            switch (ar){
                case 1:
                    wolfType.merge('a',1,Integer::sum);//Wolf type 1 number increase
                    break;
                case 2:
                    wolfType.merge('b',1,Integer::sum);//Wolf type 2 number increase
                    break;
                case 3:
                    wolfType.merge('c',1,Integer::sum);//Wolf type 3 number increase
                    break;
                case 4:
                    wolfType.merge('d',1,Integer::sum);//Wolf type 4 number increase
                    break;
                case 5:
                    wolfType.merge('e',1,Integer::sum);//Wolf type 5 number increase
                    break;
            }
        }

        //HashMap i sıralayıp bağlı listeye (Linked List) dönüştürme
        List<Map.Entry<Character, Integer>> sortedWolfType = sortByValue(wolfType);

        //Tur basina dusen kurt sayisinin ekrana yazilmasi
        System.out.println("1. Tur Kurt Sayisi: "+wolfType.get('a'));
        System.out.println("2. Tur Kurt Sayisi: "+wolfType.get('b'));
        System.out.println("3. Tur Kurt Sayisi: "+wolfType.get('c'));
        System.out.println("4. Tur Kurt Sayisi: "+wolfType.get('d'));
        System.out.println("5. Tur Kurt Sayisi: "+wolfType.get('e'));
        System.out.print("Cevap: ");

        //En cok tespit edilen en dusuk ID degerini ekrana yazdirma (istege bagli olarak return de edilebilir)
        switch (sortedWolfType.get(0).getKey()){
            case 'a':
                System.out.println(1);//Wolf type 1
                break;
            case 'b':
                System.out.println(2);//Wolf type 2
                break;
            case 'c':
                System.out.println(3);//Wolf type 3
                break;
            case 'd':
                System.out.println(4);//Wolf type 4
                break;
            case 'e':
                System.out.println(5);//Wolf type 5
                break;
        }
    }
    public static List<Map.Entry<Character, Integer>> sortByValue(HashMap<Character, Integer> wolfs)
    {
        // Mapi bağlı listeye (Linked List) döndüştürme
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer> >(wolfs.entrySet());

        // listeyi sıralama
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        return list;
    }
}