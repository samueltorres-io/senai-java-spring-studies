package com.mecparts.dto;

import java.time.LocalDateTime;

public class OrdemProducaoDTO {
    private long id;
    private LocalDateTime dataCriacao;
    private long idComponente;
    private int quantidadeSolicitada;
    private String status;
    private String responsavel;

    public OrdemProducaoDTO() {}

    public OrdemProducaoDTO(long idComponente, int quantidadeSolicitada, String status, String responsavel) {
        this.idComponente = idComponente;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.status = status;
        this.responsavel = responsavel;
        this.dataCriacao = LocalDateTime.now();
    }
    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public long getIdComponente() { return idComponente; }
    public void setIdComponente(long idComponente) { this.idComponente = idComponente; }
    public int getQuantidadeSolicitada() { return quantidadeSolicitada; }
    public void setQuantidadeSolicitada(int quantidadeSolicitada) { this.quantidadeSolicitada = quantidadeSolicitada; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    @Override
    public String toString() {
        return "OrdemProducao [ID=" + id + ", ComponenteID=" + idComponente + ", Qtd=" + quantidadeSolicitada + ", Status=" + status + "]";
    }
}