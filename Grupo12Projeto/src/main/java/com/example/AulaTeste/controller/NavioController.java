    package com.example.AulaTeste.controller;

    import com.example.AulaTeste.model.Navio;
    import com.example.AulaTeste.service.NavioService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/navios")
    public class NavioController {

        @Autowired
        private NavioService navioService;

        @PostMapping("/")
        public void cadastrar(@RequestBody Navio navio) {
            navioService.cadastrar(navio);
        }

        @GetMapping("/")
        public List<Navio> consultar() {
            return navioService.consultar();
        }

        @PutMapping("/")
        public void atualizar(@RequestBody Navio navio) {
            navioService.atualizar(navio);
        }
    }

