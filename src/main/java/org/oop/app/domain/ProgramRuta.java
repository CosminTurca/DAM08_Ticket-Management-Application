package org.oop.app.domain;

public class ProgramRuta {
    private int programId;
    private String oraPlecare;
    private String oraSosire;

    // Constructor
    public ProgramRuta(int programId, String oraPlecare, String oraSosire) {
        this.programId = programId;
        this.oraPlecare = oraPlecare;
        this.oraSosire = oraSosire;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getOraPlecare() {
        return oraPlecare;
    }

    public void setOraPlecare(String oraPlecare) {
        this.oraPlecare = oraPlecare;
    }

    public String getOraSosire() {
        return oraSosire;
    }

    public void setOraSosire(String oraSosire) {
        this.oraSosire = oraSosire;
    }
}

