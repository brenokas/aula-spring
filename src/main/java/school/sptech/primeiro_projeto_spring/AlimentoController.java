package school.sptech.primeiro_projeto_spring;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alimentos")
@AllArgsConstructor
public class AlimentoController {
    private AlimentosRepository repository;

    // CRUD DE ALIMENTOS
    // CREATE
    @PostMapping
    public Alimento cadastrarAlimento(@RequestBody Alimento alimento) {
        return repository.save(alimento);
    }

    // READ
    @GetMapping
    public List<Alimento> retornarAlimentos() {
       return repository.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Alimento atualizarPorIndice(@PathVariable int id, @RequestBody Alimento alimento) {
        if (repository.existsById(id)) {
            alimento.setId(id);
            return repository.save(alimento);
        }
        return null;
    }


    // DELETE
    @DeleteMapping("/{id}")
    public void removerPorIndice(@PathVariable int id) {
        repository.deleteById(id);
    }
}
