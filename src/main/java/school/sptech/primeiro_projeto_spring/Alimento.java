package school.sptech.primeiro_projeto_spring;

public class Alimento {
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Double peso;

    public Alimento(String nome, Double preco, Integer quantidade, Double peso) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
