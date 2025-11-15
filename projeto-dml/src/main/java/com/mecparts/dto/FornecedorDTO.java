package com.mecparts.dto;

public class FornecedorDTO {
    private long id;
    private String nome;
    private String cnpj;
    
    public FornecedorDTO() {}

    public FornecedorDTO(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    @Override
    public String toString() {
        return "Fornecedor [ID=" + id + ", Nome=" + nome + ", CNPJ=" + cnpj + "]";
    }
}
