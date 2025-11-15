Sistema de Pagamentos com Regras de Fraude (Nível: Intermediário/Avançado)

Contexto
Você está desenvolvendo um sistema de pagamentos para um banco. O sistema precisa processar transações de diferentes tipos (cartão de crédito, Pix, TED) com regras específicas de validação de fraude e taxas.

Tarefa

Crie uma classe abstrata Transacao com os seguintes atributos/métodos:

    Atributos: valor (double), dataHora (LocalDateTime), status (String).
    Métodos abstratos: validarFraude(), calcularTaxa().
    Método concreto: processar() (deve chamar validarFraude() e calcularTaxa()).

Crie subclasses TransacaoCartao, TransacaoPix e TransacaoTED, cada uma com:

Regras específicas:

    Cartão: Taxa de 2% + R$ 1,50. Validação de fraude se valor > R$ 5.000.
    Pix: Taxa fixa de R$ 0,50. Validação de fraude se valor > R$ 10.000.
    TED: Taxa de R$ 15,00. Validação de fraude se valor > R$ 50.000.
    Implemente os métodos abstratos de acordo com as regras.
    Adicione uma exceção personalizada FraudeDetectadaException se a validação de fraude falhar.

Dica de Solução

    Use herança para evitar duplicação de código nas subclasses.
    Utilize super() no construtor das subclasses.
    No método processar(), atualize o status para "APROVADA" ou "REJEITADA".
