# Java com JPA

Projeto de persistência com a JPA2 e Hibernate

# Dependências

Agroal:
é uma implementação de pool de conexão de fonte de dados com integração com transações, segurança e outros sistemas.
```sh
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-agroal</artifactId>
    <version>5.4.20.Final</version>
    <type>pom</type>
</dependency>
```

Connector/J:
que é o driver JDBC do MySQL
```sh
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.21</version>
</dependency>
```

Java Faker:
gerador de dados falsos.
```sh
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```

# Java Persistence API

  - Como relacionar uma entidade com uma coleção de uma outra entidade
    - Para tal, temos as anotações @OneToMany e @ManyToMany, dependendo da cardinalidade
    - Um relacionamento @*ToMany precisa de uma tabela extra para a representação no banco de dados
  - Aprendemos também como relacionar uma entidade com uma outra entidade
    - Para tal, temos as anotações @OneToOne e @ManyToOne, dependendo da cardinalidade
  - Ao persistir uma entidade, devemos persistir as entidades transientes do relacionamento
  - Como executar queries com JPA, usando JPQL
    - A linguagem JPQL é bem parecida com SQL, no entanto orientada a objetos
    - Com JPQL, usamos as classes e atributos (no lugar das tabelas e colunas) para definir a pesquisa
  - O objeto do tipo javax.persistence.Query encapsula a query
    - javax.persistence.TypedQuery é a versão tipada do javax.persistence.Query
