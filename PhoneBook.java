import java.util.HashMap;

public class PhoneBook {

    private  Person person;
    private  Fields fields;

    private HashMap<Person, Fields> hashMap;


    public String getPhone () {
        return this.fields.phone;
    }

    public String getEmail () {
        return this.fields.email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public  HashMap<Person, Fields> getHashMap() {
        HashMap<Person, Fields>  map = new HashMap<>();
        map.put(new Person("ЧААВА"), new PhoneBook.Fields("600524", "chaava@mai.ru"));
        map.put(new Person("ЧАБАН"), new PhoneBook.Fields("365290", "chabanVA@mai.ru"));
        map.put(new Person("ЧАБАН"), new PhoneBook.Fields("07883", "chabanVN@mai.ru"));
        map.put(new Person("ЧАБАН"), new PhoneBook.Fields("307883"));
        map.put(new Person("ПАВИЛОВ"), new PhoneBook.Fields("585941", "pavilov@mai.ru"));
        map.put(new Person("ПАВИНА"), new PhoneBook.Fields("455747", "pavina@mai.ru"));

        return map;
    }


    public static class Fields {

        private String phone;
        private String email;

        public Fields (String phone) {
            this.phone = phone;
        }

        public Fields(String phone, String email) {
            this.phone = phone;
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return String.format("телефон %s  e-mail  %s", this.phone, this.email);
        }
    }//class Fields

}//PhoneBook
