package com.Bibliotecario.entities;

import javax.persistence.*;

@Entity
@Table(name = "rivista")
public class Rivista extends CatalogoArticolo {
    public enum Periodicita {
        SETTIMANALE, MENSILE, SEMESTRALE
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicita", nullable = false)
    private Periodicita periodicita;

    public Rivista() {}

    public Rivista(String isbn, String titolo, int annoDiPubblicazione, int numeroDiPagine, Periodicita periodicita) {
        super(isbn, titolo, annoDiPubblicazione, numeroDiPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() + ", Periodicita: " + periodicita;
    }
}
