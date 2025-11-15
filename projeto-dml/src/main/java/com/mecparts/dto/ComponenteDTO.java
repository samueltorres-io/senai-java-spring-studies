package com.mecparts.dto;

public class ComponenteDTO {
    private long id;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private int quantidadeEstoque;

    public ComponenteDTO() {}

    public ComponenteDTO(String nome, String descricao, double precoUnitario, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    @Override
    public String toString() {
        return "Componente [ID=" + id + ", Nome=" + nome + ", Preço=" + precoUnitario + ", Estoque=" + quantidadeEstoque + "]";
    }
}
