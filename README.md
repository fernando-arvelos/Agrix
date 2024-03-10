Agrix é uma API RESTful que facilita a gestão de Fazendas de Plantação. Essa API foi desenvolvida a partir de um projeto do módulo de Eletiva simulando a vida real do curso de Desenvolvimento Full Stack da escola Trybe, ao qual fiz parte no período de Janeiro/2023 até Março /2024. A carga horário do curso foi de 1500h, dividido em módulos de Fundamentos (Javascript), Front-End (React), Back-End (Nodejs, Sequelize), Ciências da Computação (Python) e Eletiva em JAVA (Spring Framework, Hibernate). <br />
Essa API foi desenvolvida utilizando o Framework Spring, sendo utilizado as dependências Spring Web, Spring Devtools, Spring Security, Spring Tests e Junit, Java JWT. No Banco de Dados foi utilizado MySQL para uso local e PostgresSQL no servidor onde a API encontra-se hospedada. <br />
Utilizei também o Swagger Springdoc para documentar a API, sendo possível acessar para testes através do link https://fernando-arvelos-agrix.fly.dev/swagger-ui/index.html <br />
Também há a possibilidade de testar localmente, para isso basta clonar o projeto e rodar o Docker, já está configurado para rodar o sistema, facilitando assim a implementação local. <br /><br />

Com essa API, é possível cadastrar, buscar, atualizar e deletar informações sobre as fazendas, plantações, e os fertilizantes, sendo as buscas filtradas por nome ou id. <br />
Além disso, é possível cadastrar e buscar informações sobre os funcionários que trabalham na fazenda. <br />

As rotas já desenvolvidas estão abaixo: <br />
O arquivo JSON com as rotas configuradas no Insominia está na raiz do projeto. <br />

Gestão de pessoas <br /><br />

POST <br />
/persons - Cadastrar novos usuários do sistema <br />
/auth/login - Efetua o login do usuário, gerando o Token de segurança. Token com validade de 2h

----------------------------------------------------------------------------------------
Gestão de fertilizantes <br /><br />

GET <br />
/fertilizers - Busca todos os fertilizantes cadastrados <br />
/fertilizers/{fertilizerId} - Buscar fertilizantes pelo ID <br /><br />

POST <br />
/fertilizers - Cadastra novos fertilizantes <br />

----------------------------------------------------------------------------------------
Gestão de fazendas <br /><br />

GET<br />
/farms - Busca todas as fazendas cadastradas <br />
/farms/{farmId} - Busca fazendas pelo ID <br />
/farms/{farmId}/crops - Busca as plantações pelo ID da fazenda <br /><br />

POST <br />
/farms - Cadastra novas fazendas <br />
/farms/{farmId}/crops - Cadastra as plantações pelo ID da fazenda <br />

----------------------------------------------------------------------------------------
Gestão de plantações <br /><br />

GET <br />
/crops - Busca todas as plantações <br />
/crops/{cropId} - Busca as plantações pelo ID <br />
/crops/{cropId}/fertilizers - Busca os fertilizantes pelo ID da plantação <br />
/crops/search - Busca todas as plantações com datas de colheita entre as datas informadas <br /><br />

POST <br />
/crops/{cropId}/fertilizers/{fertilizerId} - Cadastra fertilizante utilizado pelo ID da plantação <br />
