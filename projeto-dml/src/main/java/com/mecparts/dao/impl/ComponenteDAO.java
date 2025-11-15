package com.mecparts.dao.impl;

import com.mecparts.dao.interfaces.IGenericDAO;
import com.mecparts.dto.ComponenteDTO;
import com.mecparts.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComponenteDAO implements IGenericDAO<ComponenteDTO> {

    @Override
    public ComponenteDTO create(ComponenteDTO obj) {
        String sql = "INSERT INTO componentes (nome_componente, descricao, preco_unitario, quantidade_estoque) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getDescricao());
            pstmt.setDouble(3, obj.getPrecoUnitario());
            pstmt.setInt(4, obj.getQuantidadeEstoque());
            
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        obj.setId(rs.getLong(1));
                        System.out.println("Componente criado com sucesso: " + obj.getNome());
                        return obj;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir componente: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ComponenteDTO> readAll() {
        return new ArrayList<>();
    }

    @Override
    public ComponenteDTO readById(long id) {
        String sql = "SELECT * FROM componentes WHERE id_componente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDTO(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar componente por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ComponenteDTO> readByName(String nome) {
        List<ComponenteDTO> componentes = new ArrayList<>();
        String sql = "SELECT * FROM componentes WHERE nome_componente LIKE ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    componentes.add(mapResultSetToDTO(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar componente por nome: " + e.getMessage());
        }
        return componentes;
    }

    @Override
    public void update(ComponenteDTO obj) {
        String sql = "UPDATE componentes SET nome_componente = ?, descricao = ?, preco_unitario = ?, quantidade_estoque = ? WHERE id_componente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getDescricao());
            pstmt.setDouble(3, obj.getPrecoUnitario());
            pstmt.setInt(4, obj.getQuantidadeEstoque());
            pstmt.setLong(5, obj.getId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Componente atualizado: " + obj.getNome());
            } else {
                System.out.println("Nenhum componente encontrado com o ID: " + obj.getId());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar componente: " + e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM componentes WHERE id_componente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Componente ID " + id + " deletado com sucesso.");
                System.out.println("(Relações em 'componentes_fornecedores' foram removidas automaticamente via 'ON DELETE CASCADE' do banco.)");
            } else {
                System.out.println("Nenhum componente encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar componente: " + e.getMessage());
        }
    }
    
    public void associarFornecedor(long idComponente, long idFornecedor) {
        String sql = "INSERT INTO componentes_fornecedores (id_componente, id_fornecedor) VALUES (?, ?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, idComponente);
            pstmt.setLong(2, idFornecedor);
            
            pstmt.executeUpdate();
            System.out.println("Associado Componente ID " + idComponente + " ao Fornecedor ID " + idFornecedor);

        } catch (SQLException e) {
            System.err.println("Erro ao associar componente e fornecedor: " + e.getMessage());
        }
    }

    private ComponenteDTO mapResultSetToDTO(ResultSet rs) throws SQLException {
        ComponenteDTO dto = new ComponenteDTO();
        dto.setId(rs.getLong("id_componente"));
        dto.setNome(rs.getString("nome_componente"));
        dto.setDescricao(rs.getString("descricao"));
        dto.setPrecoUnitario(rs.getDouble("preco_unitario"));
        dto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
        return dto;
    }
}