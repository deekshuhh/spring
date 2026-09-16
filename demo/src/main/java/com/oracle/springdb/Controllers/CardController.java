package com.oracle.springdb.Controllers;

import com.oracle.springdb.Model.Card;
import com.oracle.springdb.Repositories.CardRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {
    private final CardRepo repo;

    public CardController(CardRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@PathVariable int number) {
        Card card = new Card();
        card.setActive(true);
        card.setMonth("sep");
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(card));
    }
}