package hw4.enums;

public enum ServiceMenuTextsEnum {

    TEXT_1("SUPPORT"),
    TEXT_2("DATES"),
    TEXT_3("COMPLEX TABLE"),
    TEXT_4("SIMPLE TABLE"),
    TEXT_5("USER TABLE"),
    TEXT_6("TABLE WITH PAGES"),
    TEXT_7("DIFFERENT ELEMENTS"),
    TEXT_8("PERFORMANCE");

    public String text;

    ServiceMenuTextsEnum(String text) {
        this.text = text;
    }
}
