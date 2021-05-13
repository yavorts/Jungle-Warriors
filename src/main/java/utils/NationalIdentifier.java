package utils;

public enum NationalIdentifier {

    CPF("0"),
    PIS("1"),
    PASEP("2"),
    NIT("3"),
    RG("4"),
    RNE("5"),
    RIC("6"),
    OC("7"),
    CNS("8"),
    DNV("9"),
    NATIONAL("10");

    private String option;
    public String getOption()
    {
        return this.option;
    }

    private NationalIdentifier(String option) {
        this.option = option;
    }
}
