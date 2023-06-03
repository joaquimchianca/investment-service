# Investment Service

### Como executar o projeto
Tenha o Docker, Docker Compose, o Java e o Maven instalado

execute:
```bash
mvn dependency:copy-dependencies
mvn clean package -DskipTests
docker compose up
```

E o projeto estara rodando na porta 8080

