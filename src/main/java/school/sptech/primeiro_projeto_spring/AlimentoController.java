package school.sptech.primeiro_projeto_spring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {
    private List<Alimento> alimentos;

    public AlimentoController() {
        this.alimentos = new ArrayList<>();
    }

    // CRUD DE ALIMENTOS
    // CREATE
    @PostMapping
    public void cadastrarAlimento(@RequestBody Alimento alimento) {
        alimentos.add(alimento);
    }

    // READ
    @GetMapping
    public List<Alimento> retornarAlimentos() {
        return alimentos;
    }

    // UPDATE
    @PutMapping("/{indice}")
    public void atualizarPorIndice(@PathVariable int indice, @RequestBody Alimento alimento) {
        alimentos.get(indice).setNome(alimento.getNome());
        alimentos.get(indice).setPeso(alimento.getPeso());
        alimentos.get(indice).setPreco(alimento.getPreco());
        alimentos.get(indice).setQuantidade(alimento.getQuantidade());
    }


    // DELETE
    @DeleteMapping("/{indice}")
    public void removerPorIndice(@PathVariable int indice) {
        alimentos.remove(indice);
    }
}
