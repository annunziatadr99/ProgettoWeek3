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
        logger.info("Elemento aggiunto: {}", articolo);
    }

    public CatalogoArticolo ricercaPerIsbn(String isbn) {
        CatalogoArticolo articolo = catalogoArticoloDAO.findById(isbn);
        logger.info("Articolo trovato per ISBN {}: {}", isbn, articolo);
        return articolo;
    }

    public List<CatalogoArticolo> ricercaPerAnno(int anno) {
        List<CatalogoArticolo> articoli = catalogoArticoloDAO.findAll().stream()
                .filter(articolo -> articolo.getAnnoDiPubblicazione() == anno)
                .toList();
        logger.info("Articoli trovati per anno {}: {}", anno, articoli);
        return articoli;
    }

    public List<Libro> ricercaPerAutore(String autore) {
        List<Libro> libri = libroDAO.findAll().stream()
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .toList();
        logger.info("Libri trovati per autore {}: {}", autore, libri);
        return libri;
    }

    public List<CatalogoArticolo> ricercaPerTitolo(String titolo) {
        List<CatalogoArticolo> articoli = catalogoArticoloDAO.findAll().stream()
                .filter(articolo -> articolo.getTitolo().toLowerCase().contains(titolo.toLowerCase()))
                .toList();
        logger.info("Articoli trovati per titolo {}: {}", titolo, articoli);
        return articoli;
    }

    public void rimuoviElemento(String isbn) {
        catalogoArticoloDAO.deleteById(isbn);
        logger.info("Elemento rimosso con ISBN: {}", isbn);
    }

    public void aggiungiPrestito(Utente utente, CatalogoArticolo articolo) {
        Prestito prestito = new Prestito(utente, articolo, new Date());
        prestitoDAO.save(prestito);
        logger.info("Prestito aggiunto: Utente {} - Articolo {}", utente, articolo);
    }

    public List<Prestito> ricercaPrestitiUtente(String numeroDiTessera) {
        List<Prestito> prestiti = prestitoDAO.findAll().stream()
                .filter(prestito -> prestito.getUtente().getNumeroDiTessera().equals(numeroDiTessera) && prestito.getDataRestituzioneEffettiva() == null)
                .toList();
        logger.info("Prestiti trovati per utente con numero di tessera {}: {}", numeroDiTessera, prestiti);
        return prestiti;
    }

    public List<Prestito> ricercaPrestitiScaduti() {
        List<Prestito> prestitiScaduti = prestitoDAO.findAll().stream()
                .filter(prestito -> prestito.getDataRestituzioneEffettiva() == null && prestito.getDataRestituzionePrevista().before(new Date()))
                .toList();
        logger.info("Prestiti scaduti e non restituiti: {}", prestitiScaduti);
        return prestitiScaduti;
    }

    public void aggiungiUtente(Utente utente) {
        utenteDAO.save(utente);
        logger.info("Utente aggiunto: {}", utente);
    }
}
