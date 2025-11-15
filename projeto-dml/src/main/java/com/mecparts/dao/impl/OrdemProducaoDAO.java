package com.mecparts.dao.impl;

import com.mecparts.dao.interfaces.IGenericDAO;
import com.mecparts.dto.OrdemProducaoDTO;
import com.mecparts.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemProducaoDAO implements IGenericDAO<OrdemProducaoDTO> {

    @Override
    public OrdemProducaoDTO create(OrdemProducaoDTO obj) {
        String sql = "INSERT INTO ordens_producao (data_criacao, id_componente, quantidade_solicitada, status, responsavel) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(obj.getDataCriacao()));
            pstmt.setLong(2, obj.getIdComponente());
            pstmt.setInt(3, obj.getQuantidadeSolicitada());
            pstmt.setString(4, obj.getStatus());
            pstmt.setString(5, obj.getResponsavel());
            
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        obj.setId(rs.getLong(1));
                        System.out.println("Ordem de Produção criada com sucesso: ID " + obj.getId());
                        return obj;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir ordem de produção: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<OrdemProducaoDTO> readAll() {
        return new ArrayList<>();
    }

    @Override
    public OrdemProducaoDTO readById(long id) {
        String sql = "SELECT * FROM ordens_producao WHERE id_ordem = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDTO(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar ordem por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<OrdemProducaoDTO> readByName(String nome) {
        List<OrdemProducaoDTO> ordens = new ArrayList<>();
        String sql = "SELECT * FROM ordens_producao WHERE responsavel LIKE ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ordens.add(mapResultSetToDTO(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar ordem por responsável: " + e.getMessage());
        }
        return ordens;
    }

    @Override
    public void update(OrdemProducaoDTO obj) {
        String sql = "UPDATE ordens_producao SET id_componente = ?, quantidade_solicitada = ?, status = ?, responsavel = ? WHERE id_ordem = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, obj.getIdComponente());
            pstmt.setInt(2, obj.getQuantidadeSolicitada());
            pstmt.setString(3, obj.getStatus());
            pstmt.setString(4, obj.getResponsavel());
            pstmt.setLong(5, obj.getId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Ordem de Produção atualizada: ID " + obj.getId());
            } else {
                System.out.println("Nenhuma ordem encontrada com o ID: " + obj.getId());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar ordem: " + e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM ordens_producao WHERE id_ordem = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Ordem ID " + id + " deletada com sucesso.");
            } else {
                System.out.println("Nenhuma ordem encontrada com o ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar ordem: " + e.getMessage());
        }
    }

    private OrdemProducaoDTO mapResultSetToDTO(ResultSet rs) throws SQLException {
        OrdemProducaoDTO dto = new OrdemProducaoDTO();
        dto.setId(rs.getLong("id_ordem"));
        dto.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
        dto.setIdComponente(rs.getLong("id_componente"));
        dto.setQuantidadeSolicitada(rs.getInt("quantidade_solicitada"));
        dto.setStatus(rs.getString("status"));
        dto.setResponsavel(rs.getString("responsavel"));
        return dto;
    }
}