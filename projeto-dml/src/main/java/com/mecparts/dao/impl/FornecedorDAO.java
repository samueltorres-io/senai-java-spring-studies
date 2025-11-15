package com.mecparts.dao.impl;

import com.mecparts.dao.interfaces.IGenericDAO;
import com.mecparts.dto.FornecedorDTO;
import com.mecparts.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements IGenericDAO<FornecedorDTO> {

    @Override
    public FornecedorDTO create(FornecedorDTO obj) {
        String sql = "INSERT INTO fornecedores (nome_fornecedor, cnpj) VALUES (?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getCnpj());
            
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        obj.setId(rs.getLong(1));
                        System.out.println("Fornecedor criado com sucesso: " + obj.getNome());
                        return obj;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir fornecedor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<FornecedorDTO> readAll() {
        return new ArrayList<>(); 
    }

    @Override
    public FornecedorDTO readById(long id) {
        String sql = "SELECT * FROM fornecedores WHERE id_fornecedor = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDTO(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar fornecedor por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<FornecedorDTO> readByName(String nome) {
        List<FornecedorDTO> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores WHERE nome_fornecedor LIKE ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    fornecedores.add(mapResultSetToDTO(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar fornecedor por nome: " + e.getMessage());
        }
        return fornecedores;
    }

    @Override
    public void update(FornecedorDTO obj) {
        String sql = "UPDATE fornecedores SET nome_fornecedor = ?, cnpj = ? WHERE id_fornecedor = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getCnpj());
            pstmt.setLong(3, obj.getId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Fornecedor atualizado: " + obj.getNome());
            } else {
                System.out.println("Nenhum fornecedor encontrado com o ID: " + obj.getId());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM fornecedores WHERE id_fornecedor = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Fornecedor ID " + id + " deletado com sucesso.");
            } else {
                System.out.println("Nenhum fornecedor encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar fornecedor: " + e.getMessage());
        }
    }
    
    private FornecedorDTO mapResultSetToDTO(ResultSet rs) throws SQLException {
        FornecedorDTO dto = new FornecedorDTO();
        dto.setId(rs.getLong("id_fornecedor"));
        dto.setNome(rs.getString("nome_fornecedor"));
        dto.setCnpj(rs.getString("cnpj"));
        return dto;
    }
}