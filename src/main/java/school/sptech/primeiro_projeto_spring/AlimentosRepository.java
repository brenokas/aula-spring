package school.sptech.primeiro_projeto_spring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentosRepository extends JpaRepository<Alimento, Integer> {
}
