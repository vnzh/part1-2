//
//1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
//        - Найти список слов, из которых состоит текст (дубликаты не считать);
//        - Посчитать сколько раз встречается каждое слово (использовать HashMap);
//        2. Написать простой класс PhoneBook(внутри использовать HashMap):
//        - В качестве ключа использовать фамилию
//        - В каждой записи всего два поля: phone, e-mail
//        - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
//        и отдельный метод для поиска e-mail по фамилии. Следует учесть,
//        что под одной фамилией может быть несколько записей.
//        Итого должно получиться 3 класса Main, PhoneBook, Person.


import java.util.*;

public class Main {

    private static String[] words = {"Алёша", "c" , "сестрой",  "купили",  "букет",  "мимоз",
        "Они",  "весело", "вбежали", "в",  "дом", "Чудный", "запах", "лился", "от", "цветов",
        "Вот",  "пушистый", "букет",  "на", "столе",
        "Малышка", "Аннушка", "сунула", "нос", "в", "букет",
        "С",  "щеки",  "упала",  "пыльца", "Как",  "хороши", "были", "мимозы",
        "Это", "цветы", "для", "мамы", "Светланы"};

    private static ArrayList<String> listWords;

   private static  HashMap  countWords;

   private static HashMap phoneBook;



    public static void main (String[] args) {

//        listWords = listWords(words);
//        System.out.println(listWords);
//
//        countWords = сountWords(words, listWords);
//        System.out.println(countWords);
        PhoneBook book = new PhoneBook();
        phoneBook =   book.getHashMap();
        phoneBookPrint(phoneBook);

        ArrayList<String> listPhone  = serchPhone(phoneBook, "ЧАБАН");

 //       listPhone = serchPhone(phoneBook, "ПАВИНА");

        System.out.println(listPhone.toString());

        ArrayList<String> listEmail = serchEmail(phoneBook, "ЧАБАН");
        System.out.println(listEmail.toString());

    }

    static ArrayList listWords (String[] strings){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s: strings) {
            if (!arrayList.contains(s)) {
                arrayList.add(s);
            }
        }
     return arrayList;
    }



    static HashMap сountWords (String[] strings, ArrayList<String> stringArrayList) {
       HashMap  hashMap = new HashMap<String, Integer>();
        for (String s: stringArrayList ) {
            int i = 0;
            for (String s1: strings) {
                if ( s.equals(s1)) {
                    i++;
                }
            }
        hashMap.put(s, i) ;
        }
    return hashMap;
    }//countWords

    public static void phoneBookPrint (HashMap<Person, PhoneBook.Fields> map) {
        Iterator<Map.Entry<Person, PhoneBook.Fields>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<Person, PhoneBook.Fields> pair = iterator.next();
            Person key = pair.getKey();
            PhoneBook.Fields value = pair.getValue();
            System.out.println("фамилия" + key + ":" + value);
        }
    }

    public static ArrayList serchPhone (HashMap map, String sur) {
        ArrayList<String> listPhone = new ArrayList<>();
        Iterator<Map.Entry<Person, PhoneBook.Fields>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<Person, PhoneBook.Fields> pair = iterator.next();
            Person key = pair.getKey();
            if (!sur.equals(key.toString())) { continue;
            }
            PhoneBook.Fields value = pair.getValue();
            listPhone.add(value.getPhone());
        }
       return listPhone;
    }

    public static ArrayList serchEmail (HashMap map, String sur) {
        ArrayList<String> listEm = new ArrayList<>();
        Iterator<Map.Entry<Person, PhoneBook.Fields>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<Person, PhoneBook.Fields> pair = iterator.next();
            Person key = pair.getKey();
            if (!sur.equals(key.toString())) { continue;
            }
            PhoneBook.Fields value = pair.getValue();
            listEm.add(value.getEmail());
        }
        return listEm;
    }



}//class  main
