package school.sptech.primeiro_projeto_spring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexao {
    public DriverManagerDataSource getConexao() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Dotenv dotenv = Dotenv.load();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/" + dotenv.get("DB_DATABASE") + "?useSSL=false&serverTimezone" +
                "=UTC");
        dataSource.setUsername(dotenv.get("DB_USER"));
        dataSource.setPassword(dotenv.get("DB_PASSWORD"));
        return dataSource;
    }
}