Agrix é uma API RESTful que facilita a gestão de Fazendas de Plantação. Essa API foi desenvolvida a partir de um projeto do módulo de Eletiva simulando a vida real do curso de Desenvolvimento Full Stack da escola Trybe, ao qual fiz parte no período de Janeiro/2023 até Março /2024. A carga horário do curso foi de 1500h, dividido em módulos de Fundamentos (Javascript), Front-End (React), Back-End (Nodejs, Sequelize), Ciências da Computação (Python) e Eletiva em JAVA (Spring Framework, Hibernate).
Essa API foi desenvolvida utilizando o Framework Spring, sendo utilizado as dependências Spring Web, Spring Devtools, Spring Security, Spring Tests e Junit, Java JWT. No Banco de Dados foi utilizado MySQL para uso local e PostgresSQL no servidor onde a API encontra-se hospedada.
Utilizei também o Swagger Springdoc para documentar a API, sendo possível acessar para testes através do link https://fernando-arvelos-agrix.fly.dev/swagger-ui/index.html
Também há a possibilidade de testar localmente, para isso basta clonar o projeto e rodar o Docker, já está configurado para rodar o sistema, facilitando assim a implementação local.

Com essa API, é possível cadastrar, buscar, atualizar e deletar informações sobre as fazendas, plantações, e os fertilizantes, sendo as buscas filtradas por nome ou id.
Além disso, é possível cadastrar e buscar informações sobre os funcionários que trabalham na fazenda.

As rotas já desenvolvidas estão abaixo:
O arquivo JSON com as rotas configuradas no Insominia está na raiz do projeto.

Gestão de pessoas

POST
/persons - Cadastrar novos usuários do sistema

----------------------------------------------------------------------------------------
POST
/auth/login - Efetua o login do usuário, gerando o Token de segurança. Token com validade de 2h

----------------------------------------------------------------------------------------
Gestão de fertilizantes

GET
/fertilizers - Busca todos os fertilizantes cadastrados
/fertilizers/{fertilizerId} - Buscar fertilizantes pelo ID

POST
/fertilizers - Cadastra novos fertilizantes

----------------------------------------------------------------------------------------
Gestão de fazendas

GET
/farms - Busca todas as fazendas cadastradas
/farms/{farmId} - Busca fazendas pelo ID
/farms/{farmId}/crops - Busca as plantações pelo ID da fazenda

POST
/farms - Cadastra novas fazendas
/farms/{farmId}/crops - Cadastra as plantações pelo ID da fazenda

----------------------------------------------------------------------------------------
Gestão de plantações

GET
/crops - Busca todas as plantações
/crops/{cropId} - Busca as plantações pelo ID
/crops/{cropId}/fertilizers - Busca os fertilizantes pelo ID da plantação
/crops/search - Busca todas as plantações com datas de colheita entre as datas informadas

POST
/crops/{cropId}/fertilizers/{fertilizerId} - Cadastra fertilizante utilizado pelo ID da plantação
