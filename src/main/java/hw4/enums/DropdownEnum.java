package hw4.enums;

public enum DropdownEnum {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String text;

    DropdownEnum(String text) {
        this.text = text;
    }
}
