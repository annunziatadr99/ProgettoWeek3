package com.Bibliotecario;

import com.Bibliotecario.DAO.*;
import com.Bibliotecario.entities.CatalogoArticolo;
import com.Bibliotecario.entities.Libro;
import com.Bibliotecario.entities.Prestito;
import com.Bibliotecario.entities.Utente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class Biblioteca {

    private static final Logger logger = LoggerFactory.getLogger(Biblioteca.class);

    private final CatalogoArticoloDAO catalogoArticoloDAO = new CatalogoArticoloDAO();
    private final LibroDAO libroDAO = new LibroDAO();
    private final RivistaDAO rivistaDAO = new RivistaDAO();
    private final UtenteDAO utenteDAO = new UtenteDAO();
    private final PrestitoDAO prestitoDAO = new PrestitoDAO();

    public void aggiungiElemento(CatalogoArticolo articolo) {
        catalogoArticoloDAO.save(articolo);
    }

    public CatalogoArticolo ricercaPerIsbn(String isbn) {
        return catalogoArticoloDAO.findById(isbn);
    }

    public List<CatalogoArticolo> ricercaPerAnno(int anno) {
        return catalogoArticoloDAO.findAll().stream()
                .filter(articolo -> articolo.getAnnoDiPubblicazione() == anno)
                .toList();
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return libroDAO.findAll().stream()
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .toList();
    }

    public List<CatalogoArticolo> ricercaPerTitolo(String titolo) {
        return catalogoArticoloDAO.findAll().stream()
                .filter(articolo -> articolo.getTitolo().toLowerCase().contains(titolo.toLowerCase()))
                .toList();
    }

    public void rimuoviElemento(String isbn) {
        catalogoArticoloDAO.deleteById(isbn);
    }

    public void aggiungiPrestito(Utente utente, CatalogoArticolo articolo) {
        Prestito prestito = new Prestito(utente, articolo, new Date());
        prestitoDAO.save(prestito);
    }

    public List<Prestito> ricercaPrestitiUtente(String numeroDiTessera) {
        return prestitoDAO.findAll().stream()
                .filter(prestito -> prestito.getUtente().getNumeroDiTessera().equals(numeroDiTessera) && prestito.getDataRestituzioneEffettiva() == null)
                .toList();
    }

    public List<Prestito> ricercaPrestitiScaduti() {
        return prestitoDAO.findAll().stream()
                .filter(prestito -> prestito.getDataRestituzioneEffettiva() == null && prestito.getDataRestituzionePrevista().before(new Date()))
                .toList();
    }

    public void aggiungiUtente(Utente utente) {
        utenteDAO.save(utente);
    }
}
