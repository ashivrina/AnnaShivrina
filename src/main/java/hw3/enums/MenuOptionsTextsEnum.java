package hw3.enums;

public enum MenuOptionsTextsEnum {
    //"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
    TEXT_1("HOME"),
    TEXT_2("CONTACT FORM"),
    TEXT_3("SERVICE"),
    TEXT_4("METALS & COLORS");

    public String text;

    MenuOptionsTextsEnum(String text) {
        this.text = text;
    }
}
