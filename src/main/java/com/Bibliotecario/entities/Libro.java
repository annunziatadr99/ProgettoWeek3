package com.Bibliotecario.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro extends CatalogoArticolo {

    @Column(name = "autore", nullable = false)
    private String autore;

    @Column(name = "genere", nullable = false)
    private String genere;

    public Libro() {}

    public Libro(String isbn, String titolo, int annoDiPubblicazione, int numeroDiPagine, String autore, String genere) {
        super(isbn, titolo, annoDiPubblicazione, numeroDiPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autore: " + autore + ", Genere: " + genere;
    }
}
