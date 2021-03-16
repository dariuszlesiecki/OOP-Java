abstract class Man {
    private final String name;
    private final String surname;


    Man(String _name, String _surname){
        name=_name;
        surname=_surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String toString() {
        return name + " " + surname+", ";
    }

    abstract public Man compare(Man ob);

    public double average() {
        return 0.0;
    }
}