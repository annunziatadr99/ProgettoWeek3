package com.Bibliotecario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CatalogoArticolo {
    @Id
    private String isbn;
    private String titolo;
    private int annoDiPubblicazione;
    private int numeroDiPagine;

    public CatalogoArticolo(){}

    public CatalogoArticolo(String isbn, String titolo, int annoDiPubblicazione, int numeroDiPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroDiPagine = numeroDiPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public int getNumeroDiPagine() {
        return numeroDiPagine;
    }

    public void setNumeroDiPagine(int numeroDiPagine) {
        this.numeroDiPagine = numeroDiPagine;
    }

    @Override
    public String toString() {
        return "ISBN:'" + isbn +
                ", Titolo:'" + titolo +
                ", Anno:" + annoDiPubblicazione +
                ",  Pagine:" + numeroDiPagine;
    }
}
