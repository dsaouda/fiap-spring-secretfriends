# Descrição dos pacotes

- app: Contém os endpoints do sistema via API, que será acesso via URL. Essa parte está dividia em duas partes, rest e rpc (cada pacote representa o protocolo correspondente ao nome)
- controller: Contém as rotas que redirecinam uma página HTML
- dto: Contém transformações de JSON/XML para Objeto e Objeto para JSON/XML
- exception: São as exceptions especialistas do sistema
- middleware: Contém os filtros HTTP, para CORS (https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) e autenticação
- model: Contém as entidades do sistema representadas via JPA
- repository: Contém classes para manipulação das informações no banco de dados
- request: Classe utilitária para representar um request genérico
- response: Representa uma classe de resposta que é utilizado em todas as respotas do sistema
- service: Classes com regra de negócio dos controllers e app.rest e app.rpc
- session: Classes que são armazenadas na sessão
- task: Serviços que são executados em background
- validator: Classes utilitários para trabalhar com validação no sistema
