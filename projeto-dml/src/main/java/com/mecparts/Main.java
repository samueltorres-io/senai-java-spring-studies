package com.mecparts;

import com.mecparts.dao.impl.ComponenteDAO;
import com.mecparts.dao.impl.FornecedorDAO;
import com.mecparts.dao.impl.OrdemProducaoDAO;
import com.mecparts.dto.ComponenteDTO;
import com.mecparts.dto.FornecedorDTO;
import com.mecparts.dto.OrdemProducaoDTO;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ComponenteDAO componenteDAO = new ComponenteDAO();
        OrdemProducaoDAO ordemDAO = new OrdemProducaoDAO();

        System.out.println("--- INICIANDO DESAFIOS PRÁTICOS MECPARTS ---");

        System.out.println("\n--- Desafio 1: Cadastro de Fornecedores ---");
        FornecedorDTO f1 = new FornecedorDTO("Metalúrgica União Ltda.", "12.345.678/0001-90");
        f1 = fornecedorDAO.create(f1);
        
        FornecedorDTO f2 = new FornecedorDTO("AutoPeças Brasil S.A.", "98.765.432/0001-10");
        f2 = fornecedorDAO.create(f2);

        System.out.println("\n--- Desafio 2: Cadastro de Componentes ---");
        ComponenteDTO c1 = new ComponenteDTO("Arruela de Pressão M8", "Arruela de aço carbono para fixação", 0.50, 5000);
        c1 = componenteDAO.create(c1);

        ComponenteDTO c2 = new ComponenteDTO("Parafuso Allen M6x20", "Parafuso de cabeça cilíndrica sextavada interna", 1.20, 2000);
        c2 = componenteDAO.create(c2);
        
        ComponenteDTO c3_del = new ComponenteDTO("Rebites de Alumínio 3mm", "Rebite para remoção", 0.10, 100);
        c3_del = componenteDAO.create(c3_del);

        System.out.println("\n--- Desafio 3: Associação ---");
        if (c1 != null && f1 != null && f2 != null) {
            componenteDAO.associarFornecedor(c1.getId(), f1.getId());
            componenteDAO.associarFornecedor(c1.getId(), f2.getId());
        }
        if (c2 != null && f1 != null) {
            componenteDAO.associarFornecedor(c2.getId(), f1.getId());
        }
        
        if (c3_del != null && f1 != null) {
             componenteDAO.associarFornecedor(c3_del.getId(), f1.getId());
        }

        System.out.println("\n--- Desafio 4: Atualização de Estoque ---");
        if (c1 != null) {
            System.out.println("Estoque ANTES: " + c1.getQuantidadeEstoque());
            c1.setQuantidadeEstoque(8000);
            componenteDAO.update(c1);
            
            ComponenteDTO c1_atualizado = componenteDAO.readById(c1.getId());
            System.out.println("Estoque DEPOIS: " + c1_atualizado.getQuantidadeEstoque());
        }

        System.out.println("\n--- Desafio 5: Criação de Ordem de Produção ---");
        if (c2 != null) {
            OrdemProducaoDTO op1 = new OrdemProducaoDTO(c2.getId(), 1000, "Pendente", "Setor Fabril A");
            op1 = ordemDAO.create(op1);
            System.out.println(op1);
        }

        System.out.println("\n--- Desafio 6: Atualização de Status ---");

        OrdemProducaoDTO ordemParaAtualizar = ordemDAO.readById(1);
        
        if (ordemParaAtualizar != null) {
            System.out.println("Status ANTES: " + ordemParaAtualizar.getStatus());
            ordemParaAtualizar.setStatus("Em Produção");
            ordemDAO.update(ordemParaAtualizar);
            
            OrdemProducaoDTO ordemAtualizada = ordemDAO.readById(ordemParaAtualizar.getId());
            System.out.println("Status DEPOIS: " + ordemAtualizada.getStatus());
        } else {
             System.out.println("Ordem com ID 5 (ou 1) não encontrada para atualização.");
        }
        
        System.out.println("\n--- Desafio 7: Remoção de Componente ---");
        if (c3_del != null) {
            componenteDAO.delete(c3_del.getId());
        } else {
             List<ComponenteDTO> listaRemover = componenteDAO.readByName("Rebites de Alumínio 3mm");
             if (!listaRemover.isEmpty()) {
                 componenteDAO.delete(listaRemover.get(0).getId());
             } else {
                 System.out.println("Componente 'Rebites de Alumínio 3mm' não encontrado para remoção.");
             }
        }
    }
}