package spring.boot.desafio.gps.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.boot.desafio.gps.controller.PontosInteresseController;
import spring.boot.desafio.gps.model.PontosInteresse;
import spring.boot.desafio.gps.model.PontosInteresseDTO;
import spring.boot.desafio.gps.repository.PontosInteresseRepository;

import java.util.List;

@Service
public class PontosInteresseService {


    @Autowired
    PontosInteresseRepository repository;

    public List<PontosInteresse> findAll() {
        return repository.findAll();
    }

    public List<PontosInteresse> findPontosProximos(long xMin, long xMax, long yMin, long yMax) {
        return repository.findPontosProximos(xMin, xMax, yMin, yMax);
    }

    public PontosInteresse adicionarPonto(PontosInteresseDTO ponto) {
        PontosInteresse pontoInteresse = new PontosInteresse(ponto.nome(), ponto.x(), ponto.y());

        repository.save(pontoInteresse);
        return pontoInteresse;

    }
}
