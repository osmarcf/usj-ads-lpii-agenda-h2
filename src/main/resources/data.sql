
insert into telefone (tipo, numero) values ('Residencial', '1234-1234');
insert into telefone (tipo, numero) values ('Comercial', '4321-4321');
insert into telefone (tipo, numero) values ('Celular', '9999-9999');

insert into contato (nome) values ('Maria');
insert into contato (nome) values ('José');

insert into contato_telefones (contato_id, telefones_id) values (1, 1);
insert into contato_telefones (contato_id, telefones_id) values (2, 2);
insert into contato_telefones (contato_id, telefones_id) values (1, 3);