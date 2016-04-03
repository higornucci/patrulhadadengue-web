# Patrulha da Dengue 

Este pequeno projeto Open Source visa ajudar a localizar os focos da dengue em todo o Brasil.

A ideia consiste em cada usuário marcar no mapa os focos de dengue que encontrar em seu dia-a-dia e, 
de forma colaborativa, todos poderão ficar atentos aos focos próximo de sua residência.

A prefeitura também pode usar os dados da Patrulha para saber onde atacar.

Qualquer um que quiser contribuir será bem vindo.


## Como rodar o projeto em sua máquina

Basicamente, o Patrulha da Dengue é um projeto Java 8 usando SpringBoot.

Isso quer dizer que você precisa ter instalado os seguintes itens:
 - [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) instalada.
 - [Maven 3.x](https://maven.apache.org/download.cgi) instalado.
 - Um banco de dados de sua preferência. Recomendo usar [Postgresql 9.x](http://www.postgresql.org/download/)

> Não se esqueça de configurar o Java 8 e o Maven 3.x nas variáveis de ambiente de sua máquina

Com tudo instalado e as variáveis de ambiente configuradas, abra um *prompt* de comando, caminhe até a pasta raiz do projeto,
onde encontra-se o arquivo *pom.xml*, e rode o seguinte comando:

```
$ mvn spring-boot:run
```

Agora o projeto já deve poder ser acessado de [http://localhost:8080/](http://localhost:8080/)