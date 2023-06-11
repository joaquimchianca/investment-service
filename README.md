# Investment Service


### Endpoints
Ao roda a aplicacao havera um swagger disponivel em `localhost:8080/swagger-ui.html`
Caso nao deseje executar a aplicao ha o arquivo `swagger.json` na raiz do projeto, este é atualizado manualmente, portanto pode estar desatualizado

### Como executar o projeto


#### Manualmente
Tenha um Postgres rodando na porta 8080 com senha postgres e usuario postgres (Ou altere o arquivo application.properties)

execute:


```bash
mvn dependency:copy-dependencies
mvn clean package -DskipTests
mvn spring-boot:run
```



#### Utilizando Docker
Tenha o Docker, Docker Compose, o Java e o Maven instalado

execute:
```bash
mvn dependency:copy-dependencies
mvn clean package -DskipTests
docker compose up
```

E o projeto estara rodando na porta 8080

