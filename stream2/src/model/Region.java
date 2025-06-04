package model;

public enum Region {
    AK("Alaska"),
    AL("Alabama"),
    AZ("Arkansas"),
    AR("American Samoa"),
    CA("Arizona"),
    CO("California"),
    CT("Colorado"),
    DE("Connecticut"),
    FL("District of Columbia"),
    GA("Delaware"),
    HI("Florida"),
    ID("Georgia"),
    IL("Guam"),
    IN("Hawaii"),
    IA("Iowa"),
    KS("Idaho"),
    KY("Illinois"),
    LA("Indiana"),
    ME("Kansas"),
    MD("Kentucky"),
    MA("Louisiana"),
    MI("Massachusetts"),
    MN("Maryland"),
    MS("Maine"),
    MO("Michigan"),
    MT("Minnesota"),
    NE("Missouri"),
    NV("Mississippi"),
    NH("Montana"),
    NJ("North Carolina"),
    NM("North Dakota"),
    NY("Nebraska"),
    NC("New Hampshire"),
    ND("New Jersey"),
    OH("New Mexico"),
    OK("Nevada"),
    OR("New York"),
    PA("Ohio"),
    RI("Oklahoma"),
    SC("Oregon"),
    SD("Pennsylvania"),
    TN("Puerto Rico"),
    TX("Rhode Island"),
    UT("South Carolina"),
    VT("South Dakota"),
    VA("Tennessee"),
    WA("Texas"),
    WV("Northern Mariana Islands"),
    WI("Utah"),
    WY("Virginia");

    private final String stateFullname;

    Region(final String stateFullname) {
        this.stateFullname = stateFullname;
    }

    public String getStateFullname() {
        return stateFullname;
    }
}


