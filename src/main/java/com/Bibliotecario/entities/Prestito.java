package com.Bibliotecario.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "articolo_id", nullable = false)
    private CatalogoArticolo articolo;

    @Column(name = "data_inizio_prestito", nullable = false)
    private Date dataInizioPrestito;

    @Column(name = "data_restituzione_prevista", nullable = false)
    private Date dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private Date dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, CatalogoArticolo articolo, Date dataInizioPrestito) {
        this.utente = utente;
        this.articolo = articolo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = new Date(dataInizioPrestito.getTime() + (30L * 24 * 60 * 60 * 1000));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public CatalogoArticolo getArticolo() {
        return articolo;
    }

    public void setArticolo(CatalogoArticolo articolo) {
        this.articolo = articolo;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito [ID: " + id + ", Utente: " + utente + ", Articolo: " + articolo + ", Data Inizio Prestito: " + dataInizioPrestito
                + ", Data Restituzione Prevista: " + dataRestituzionePrevista + ", Data Restituzione Effettiva: " + dataRestituzioneEffettiva + "]";
    }
}
