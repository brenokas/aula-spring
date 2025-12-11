package school.sptech.primeiro_projeto_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alimentos")
public class AlimentoController {
    Conexao conexao = new Conexao();
    JdbcTemplate template = new JdbcTemplate(conexao.getConexao());

    // CRUD DE ALIMENTOS
    // CREATE
    @PostMapping
    public ResponseEntity<String> cadastrarAlimento(@RequestBody Alimento alimento) {
        try {
            String query = "INSERT INTO alimento (nome, preco, peso, quantidade) VALUES (?, ?, ?, ?)";
            template.update(query, alimento.getNome(), alimento.getPreco(), alimento.getPeso(), alimento.getQuantidade());
            return ResponseEntity.ok("Alimento cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar alimento: " + e.getMessage());
            return ResponseEntity.internalServerError().body("Erro ao cadastrar alimento! " + e.getMessage());
        }
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Alimento>> retornarAlimentos() {
        try {
            String query = "SELECT * FROM alimento";
            List<Alimento> lista = template.query(
                    query,
                    new BeanPropertyRowMapper<>(Alimento.class)
            );

            if (lista.isEmpty()) {
                return ResponseEntity.status(204).build();
            }

            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPorIndice(@PathVariable int id, @RequestBody Alimento alimento) {
        try {
            String query = "UPDATE alimento SET nome = ?, preco = ?, peso = ?, quantidade = ? WHERE id = ?";
            template.update(query, alimento.getNome(), alimento.getPreco() ,alimento.getPeso(),
                    alimento.getQuantidade(), id);
            return ResponseEntity.ok().body("Alimento com o id " + id + " atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao fazer update: " + e.getMessage());
        }
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerPorIndice(@PathVariable int id) {
        try {
            String query = "DELETE FROM alimento WHERE id = ?";
            template.update(query, id);
            return ResponseEntity.ok().body("Remoçao do elemento com id: " + id + " feita com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Erro ao fazer delete: " + e.getMessage());
        }
    }
}
