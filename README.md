# API Weather Automation

Este é um script de automação para consultas de climas pela API Open Weather.

Duvidas consulte a documentação da api no link:

https://openweathermap.org/current

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de avaliação e teste.


# 📋 Pré-requisitos

Voce precisa ter instalado e configurado em sua maquina:
```
-Java JDK 11
-Git 
-Maven
```

Abra seu terminal de comando e rode o seguinte comando (escolha uma pasta para isso)
```
git clone https://github.com/marcospaulo7/automationAPIWeather
```

### 🔧 Instalação

Na pasta raiz do projeto, onde encontra-se o POM.xml execute seguinte comando para instalar as dependencias necessárias

```
mvn clean install
```

## ⚙️ Executando os testes

Na pasta raiz do projeto, onde encontra-se o POM.xml execute o comando

```
mvn test
```
Ou voce pode executar os testes pela classe RunTest dentro do caminho

```
\src\test\RunTest
```

### ⌨️Sobre Evidencias

No seguinte caminho
```
src/main/java/com/br/currentweather/reports
```
Há uma classe chamada "generateHTMLReport" que ao executar o metodo main dela, gera um arquivo HTML que voce pode abrir em seu navegador para ver os
cenários executados e status.
obs: Ele só é gerado caso tenha um arquivo cucumber.json na pasta "reports" (que é gerado após rodados os
testes via RunTest)

O arquivo sera gerado em:
```
/reports
```

### ⌨️Sobre Logs

É gerado um arquivo de log contendo informaçoes sobre a execução no cenário na seguinte pasta:
```
Log
```
## 🛠️ Construção

Tecnologias utilizadas:

* [Java JDK 8+](https://www.oracle.com/br/java/technologies/javase-downloads.html)
* [jUnit 4](https://junit.org/junit4/)
* [Rest-assured](https://rest-assured.io/)
* [Cucumber 6.10.2](https://cucumber.io/)
* [Maven](https://maven.apache.org/)
* [Repositório Maven](https://mvnrepository.com/)
* https://openweathermap.org/current
