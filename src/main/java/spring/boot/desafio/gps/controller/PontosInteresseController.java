package spring.boot.desafio.gps.controller;


import spring.boot.desafio.gps.model.PontosInteresse;
import spring.boot.desafio.gps.model.PontosInteresseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.desafio.gps.repository.PontosInteresseRepository;
import spring.boot.desafio.gps.services.PontosInteresseService;

import java.util.List;

@RestController
public class PontosInteresseController {


    @Autowired
    private PontosInteresseService service;

    @PostMapping("/pontos-interesse")
    public ResponseEntity<?> postPontosInteresse(@RequestBody PontosInteresseDTO body) {
        PontosInteresse ponto = service.adicionarPonto(body);
        return ResponseEntity.ok(ponto);
    }

    @GetMapping("/pontos-interesse")
    public ResponseEntity<List<PontosInteresse>> findAll() {
       List<PontosInteresse> listaInteresses = service.findAll();
       return ResponseEntity.ok(listaInteresses);
    }

    @GetMapping("/listar/pontos")
    public ResponseEntity<List<PontosInteresse>> listarPontosProximos(@RequestParam("x") Long x, @RequestParam("y") Long y, @RequestParam("dmax") Long dmax) {
        long xMin = x - dmax;
        long xMax = x + dmax;
        long yMin = y - dmax;
        long yMax = y + dmax;

        List<PontosInteresse> pontosFiltrados = service.findPontosProximos(xMin, xMax, yMin, yMax).stream().filter(p -> distancia(x, y, p.getX(), p.getY()) <= dmax).toList();

        return ResponseEntity.ok(pontosFiltrados);
    }

    public double distancia(long x1, long y1, long x2, long y2) {
        return Math.hypot(x2 - x1, y2 - y1);
    }

}
