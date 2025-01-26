package com.Bibliotecario.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalogo_articolo")
public abstract class CatalogoArticolo {
    @Id
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "anno_di_pubblicazione", nullable = false)
    private int annoDiPubblicazione;

    @Column(name = "numero_di_pagine", nullable = false)
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
