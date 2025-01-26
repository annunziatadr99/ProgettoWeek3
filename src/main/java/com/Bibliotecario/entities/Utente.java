package com.Bibliotecario.entities;

import javax.persistence.*;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_di_nascita", nullable = false)
    private String dataDiNascita;

    @Column(name = "numero_di_tessera", nullable = false, unique = true)
    private String numeroDiTessera;

    public Utente() {}

    public Utente(String nome, String cognome, String dataDiNascita, String numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(String numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Data di Nascita: " + dataDiNascita + ", Numero di Tessera: " + numeroDiTessera;
    }
}
