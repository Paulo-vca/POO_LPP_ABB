CREATE TABLE
    tb_user(
        id int not null auto_increment,
		username varchar(255),
        password varchar(255),
        status int,
        token double,
        primary key(id));

    CREATE TABLE
    tb_Produto(
        id int not null auto_increment,
		nomeProduto varchar(255),
        marcaProduto varchar(255),
        precoProduto float,
        categoria varchar(255),
        primary key(id));

    CREATE TABLE
    tb_carro(
        id int not null auto_increment,
		name varchar(255),
        dt_fabricacao DATE,
        valor double,
        primary key(id));
    
    