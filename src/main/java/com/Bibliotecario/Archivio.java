package com.Bibliotecario;

import com.Bibliotecario.entities.*;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Biblioteca.class);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Faker faker = new Faker();


        List<Libro> libri = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Libro libro = new Libro(
                    faker.code().isbn13(),
                    faker.book().title(),
                    faker.number().numberBetween(1980, 2025),
                    faker.number().numberBetween(100, 500),
                    faker.book().author(),
                    faker.book().genre()
            );
            libri.add(libro);
            biblioteca.aggiungiElemento(libro);
        }


        List<Rivista> riviste = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Rivista rivista = new Rivista(
                    faker.code().isbn13(),
                    faker.book().title(),
                    faker.number().numberBetween(1950, 2025),
                    faker.number().numberBetween(50, 200),
                    Rivista.Periodicita.values()[faker.number().numberBetween(0, Rivista.Periodicita.values().length)]
            );
            riviste.add(rivista);
            biblioteca.aggiungiElemento(rivista);
        }


        List<Utente> utenti = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Utente utente = new Utente(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.date().birthday().toString(),
                    faker.number().digits(5)
            );
            utenti.add(utente);
            biblioteca.aggiungiUtente(utente);
        }


        for (int i = 0; i < 4; i++) {
            Utente utente = utenti.get(faker.number().numberBetween(0, utenti.size()));
            CatalogoArticolo articolo = libri.get(faker.number().numberBetween(0, libri.size()));
            biblioteca.aggiungiPrestito(utente, articolo);
        }


        // Dovrebbe Rimuovere un elemento del catalogo un elemento con un codice ISBN
        if (!libri.isEmpty()) {
            biblioteca.rimuoviElemento(libri.get(0).getIsbn());
        }


        // Ricerca per ISBN
        if (!libri.isEmpty()) {
            CatalogoArticolo foundByIsbn = biblioteca.ricercaPerIsbn(libri.get(1).getIsbn());
            logger.info("Trovato ISBN: {}",foundByIsbn);

        }


        // Ricerca per anno di pubblicazione
        List<CatalogoArticolo> foundByYear = biblioteca.ricercaPerAnno(2025);
        logger.info("Ricerca per anno : {}",foundByYear);



        // Ricerca per Autore
        List<Libro> foundByAuthor = biblioteca.ricercaPerAutore(libri.get(0).getAutore());
        logger.info("Ricerca per Autore : {}",foundByAuthor);




        // Ricerca per Titolo
        List<CatalogoArticolo> foundByTitle = biblioteca.ricercaPerTitolo("title");
        logger.info("Ricerca per Titolo : {}",foundByYear);




        // Ricerca per Prestito in base al numero di tessera dell'Utente
        if (!utenti.isEmpty()) {
            List<Prestito> loansByCardNumber = biblioteca.ricercaPrestitiUtente(utenti.get(0).getNumeroDiTessera());
            logger.info("Prestiti per numero di Tessera dell'Utente: {}",loansByCardNumber);


        }


        // Ricerca prestiti scaduti e non ancora Restituiti
        List<Prestito> expiredLoans = biblioteca.ricercaPrestitiScaduti();
        logger.info("Lista Prestiti scaduti: {}",expiredLoans);

    }
}
