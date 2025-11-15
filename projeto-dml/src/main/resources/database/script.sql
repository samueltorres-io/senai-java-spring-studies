CREATE DATABASE IF NOT EXISTS mecparts;
USE mecparts;

CREATE TABLE fornecedores (
  id_fornecedor BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome_fornecedor VARCHAR(100) NOT NULL UNIQUE,
  cnpj CHAR(18) UNIQUE,
  endereco VARCHAR(200),
  telefone VARCHAR(20)
);

CREATE TABLE componentes (
  id_componente BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome_componente VARCHAR(100) NOT NULL UNIQUE,
  descricao TEXT,
  preco_unitario DECIMAL(10,2) NOT NULL,
  quantidade_estoque INT NOT NULL DEFAULT 0
);

CREATE TABLE componentes_fornecedores (
  id_componente BIGINT NOT NULL,
  id_fornecedor BIGINT NOT NULL,
  PRIMARY KEY (id_componente, id_fornecedor),
  CONSTRAINT fk_cf_componente FOREIGN KEY (id_componente) 
    REFERENCES componentes(id_componente) ON DELETE CASCADE,
  CONSTRAINT fk_cf_fornecedor FOREIGN KEY (id_fornecedor) 
    REFERENCES fornecedores(id_fornecedor) ON DELETE CASCADE
);

CREATE TABLE ordens_producao (
  id_ordem BIGINT PRIMARY KEY AUTO_INCREMENT,
  data_criacao DATETIME NOT NULL,
  id_componente BIGINT NOT NULL,
  quantidade_solicitada INT NOT NULL,
  status ENUM('Pendente', 'Em Produção', 'Concluído', 'Cancelado') DEFAULT 'Pendente',
  data_atualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  responsavel VARCHAR(100),
  CONSTRAINT fk_op_componente FOREIGN KEY (id_componente) 
    REFERENCES componentes(id_componente) ON DELETE CASCADE
);

CREATE INDEX idx_componentes_nome ON componentes(nome_componente);
CREATE INDEX idx_fornecedores_nome ON fornecedores(nome_fornecedor);
CREATE INDEX idx_ordens_status ON ordens_producao(status);