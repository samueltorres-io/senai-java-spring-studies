Atividade Prática – Comandos DML no Contexto Industrial
Cenário
A Indústria MecParts Ltda. é uma fábrica de autopeças que utiliza um banco de dados MySQL para controlar:
o estoque de componentes utilizados na produção,

os fornecedores que entregam essas peças,

e as ordens de produção abertas pelo setor fabril.

Recentemente, a equipe de dados foi encarregada de atualizar informações no banco e registrar novas operações utilizando comandos DML (Data Manipulation Language) — ou seja, comandos do tipo INSERT, UPDATE e DELETE.
Você foi designado como analista de dados responsável por essas operações.

Objetivos de Aprendizagem
Integrar Java com MySQL utilizando JDBC
Configurar projetos com Maven e gerenciar dependências
Implementar operações DML programaticamente via PreparedStatement
Aplicar boas práticas de conexão com banco de dados
Desenvolver uma aplicação robusta com tratamento de exceções

Estrutura do Banco de Dados
O banco contém as seguintes tabelas:

fornecedores
Campo
Tipo
Descrição
id_fornecedor
INT (PK, AI)
Identificador único do fornecedor
nome_fornecedor
VARCHAR(100)
Nome da empresa fornecedora
cnpj
VARCHAR(18)
Cadastro Nacional da Pessoa Jurídica
endereco
VARCHAR(200)
Endereço completo
telefone
VARCHAR(20)
Telefone de contato

componentes
Campo
Tipo
Descrição
id_componente
INT (PK, AI)
Identificador único do componente
nome_componente
VARCHAR(100)
Nome do componente
descricao
TEXT
Detalhes técnicos do item
preco_unitario
DECIMAL(10,2)
Valor unitário
quantidade_estoque
INT
Quantidade disponível em estoque

componentes_fornecedores
Tabela associativa (relação N:N entre componentes e fornecedores)
Campo
Tipo
Descrição
id_componente
INT (FK)
Código do componente
id_fornecedor
INT (FK)
Código do fornecedor

ordens_producao
Campo
Tipo
Descrição
id_ordem
INT (PK, AI)
Identificador da ordem
data_criacao
DATE
Data de emissão da ordem
componente_id
INT (FK)
Código do componente solicitado
quantidade_solicitada
INT
Quantidade a ser produzida
status
VARCHAR(20)
Situação da ordem (“Pendente”, “Em Produção”, etc.)

Desafios Propostos
1️⃣ Cadastro de Fornecedores
Insira dois novos fornecedores no sistema:
Metalúrgica União Ltda. – CNPJ: 12.345.678/0001-90
Endereço: Rua das Indústrias, 150, Distrito Industrial
Telefone: (11) 98765-4321

AutoPeças Brasil S.A. – CNPJ: 98.765.432/0001-10
Endereço: Av. do Progresso, 500, São Paulo
Telefone: (11) 99999-8888

2️⃣ Cadastro de Componentes
Registre dois componentes utilizados na linha de montagem:
Arruela de Pressão M8 – “Arruela de aço carbono para fixação”, preço unitário R$ 0,50, quantidade inicial 5000.
Parafuso Allen M6x20 – “Parafuso de cabeça cilíndrica sextavada interna”, preço unitário R$ 1,20, quantidade inicial 2000.

3️⃣ Associação entre Componentes e Fornecedores
Crie os vínculos de fornecimento:
A Arruela de Pressão M8 é fornecida por ambos os fornecedores.
O Parafuso Allen M6x20 é fornecido apenas pela Metalúrgica União Ltda.

4️⃣ Atualização de Estoque
Devido a uma nova entrega, atualize a quantidade em estoque da Arruela de Pressão M8 para 8000 unidades.

5️⃣ Criação de Ordem de Produção
O setor fabril abriu uma ordem de produção para 1000 unidades do Parafuso Allen M6x20, criada na data atual, com status “Pendente”.

6️⃣ Atualização de Status
A ordem de produção criada no item anterior (id_ordem = 5) iniciou sua fabricação.
Atualize o status para “Em Produção”.

7️⃣ Remoção de Componente Obsoleto
O componente “Rebites de Alumínio 3mm” foi descontinuado.
Remova-o do banco de dados, garantindo antes que suas relações na tabela componentes_fornecedores sejam excluídas.

Instruções ao Aluno
Crie as tabelas conforme o modelo apresentado.
Execute cada comando DML solicitado (INSERT, UPDATE, DELETE).
Teste o resultado de cada operação usando consultas SELECT.
Registre cada comando executado, mensagens de retorno e validações.
Se ocorrer algum erro (por exemplo, violação de chave estrangeira), analise e descreva a causa.
