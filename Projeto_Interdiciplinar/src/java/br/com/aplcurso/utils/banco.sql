create table jogador_lol(
	idjogador serial primary key,
	nomejogador varchar(100) not null,
	kda numeric not null,
	csminute numeric not null,
	goldminute integer not null,
	participacao varchar(6)not null
	
);

insert into jogador_lol(nomejogador,kda,csminute,goldminute,participacao) values('Robo',2.6,8.1,413,'55.7%');

create table partida_lol (
	idpartida serial primary key,
	jogopart varchar (50) not null,
	camppart varchar (50) not null,
	teamone varchar (50) not null,
	teamtwo varchar (50) not null,
	datapart varchar (10) not null,
	horapart varchar (5) not null
);

insert into partida_lol(jogopart,camppart,teamone,teamtwo,datapart,horapart) values('LoL','CBLOL','LOUD','Pain', '26/03/2023','13:00');

create table tipo(
	idtipo serial primary key,
	nome varchar(50)
);
insert into tipo(nome)values('MOBA');

create table jogo(
	idjogo serial primary key,
	tipo integer references tipo(idtipo),
	descricao varchar(50)
);

create table jogadores_geral(
	idplayer serial primary key,
	idjogo integer references jogo(idjogo),
	nome varchar(50)
);

insert into jogo(descricao,tipo)values('LOL',1);
insert into jogadores_geral(nome,idjogo) values('Ranger',1);


create table times(
	idtime serial primary key,
	idjogo integer references jogo(idjogo),
	nometime varchar(50)
);

insert into times(idjogo, nometime)values('1','LOUD');
insert into times(idjogo, nometime)values('1','Flamengo');


create table partida(
	idpartida serial primary key,
	idjogo integer references jogo(idjogo),
	idtimeum integer references times(idtime),
	idtimedois integer references times(idtime),
	datapartida date,
	hora varchar(20)
);

insert into partida(idjogo,idtimeum,idtimedois,datapartida,hora)values(1,1,2,'2022-02-15','13:00h');