create table angajat (id bigint not null, adresa varchar(255) not null, nume varchar(255) not null, prenume varchar(255) not null, telefon varchar(255) not null, version integer, primary key (id)) engine=InnoDB;
create table client (id bigint not null, adresa varchar(255) not null, email varchar(255) not null, nume varchar(255) not null, telefon varchar(255) not null, version integer, primary key (id)) engine=InnoDB;
create table constatare (id bigint not null, descriere varchar(4000) not null, version integer, primary key (id)) engine=InnoDB;
create table echipament_productie (id bigint not null, nume varchar(255) not null, operatiune varchar(255) not null, status varchar(255) not null, version integer, primary key (id)) engine=InnoDB;
create table echipament_productie_material (echipament_productie_id bigint not null, material_id bigint not null, primary key (echipament_productie_id, material_id)) engine=InnoDB;
create table echipament_service (id bigint not null, nume varchar(255) not null, serie varchar(255) not null, tip varchar(255) not null, version integer, primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table interventie (id bigint not null, data_inceput datetime(6) not null, data_sfarsit datetime(6), descriere_defect varchar(4000) not null, version integer, angajat_id bigint not null, client_id bigint not null, constatare_id bigint not null, echipament_id bigint not null, primary key (id)) engine=InnoDB;
create table job (id bigint not null, data_finalizarii datetime(6), data_primirii datetime(6) not null, latime double precision, lungime double precision, status_job varchar(255) not null, tip_finisare varchar(255) not null, version integer, client_id bigint not null, echipament_id bigint not null, material_id bigint not null, responsabil_id bigint not null, primary key (id)) engine=InnoDB;
create table material (id bigint not null, cantitate_mp double precision, nume varchar(255) not null, version integer, primary key (id)) engine=InnoDB;
create table rol (id bigint not null, nume_rol varchar(255) not null, version integer, primary key (id)) engine=InnoDB;
create table utilizator (id bigint not null, nume_utilizator varchar(255) not null, parola varchar(255) not null, version integer, angajat_id bigint, primary key (id)) engine=InnoDB;
create table utilizator_rol (utilizator_id bigint not null, rol_id bigint not null, primary key (utilizator_id, rol_id)) engine=InnoDB;
alter table echipament_service add constraint UK_kh8way8697y1eyvbk6336kgkv unique (serie);
alter table utilizator add constraint UK_7a0arqndk0gwr1wdf9quuf7hm unique (nume_utilizator);
alter table echipament_productie_material add constraint FKknw3rcqve0psj21k5fgb6desw foreign key (material_id) references material (id);
alter table echipament_productie_material add constraint FK2l3nntce8vhs9e94kycyyjshy foreign key (echipament_productie_id) references echipament_productie (id);
alter table interventie add constraint FKpp2pii7nugv3wcy4p8roigs2m foreign key (angajat_id) references angajat (id);
alter table interventie add constraint FKdnqlpbs7wyc1r0oayvruf0juc foreign key (client_id) references client (id);
alter table interventie add constraint FKmcqqjxly11avjct9ekcrsj7r0 foreign key (constatare_id) references constatare (id);
alter table interventie add constraint FK47hmkw9o7kpv5qgdcrtcb8197 foreign key (echipament_id) references echipament_service (id);
alter table job add constraint FK17amy3r92wfc4rwxm15q4t252 foreign key (client_id) references client (id);
alter table job add constraint FKauct4lm5r3kxxpmq3ogqaf7c0 foreign key (echipament_id) references echipament_productie (id);
alter table job add constraint FKraxpdokvb25ecksjk1i1ftg8r foreign key (material_id) references material (id);
alter table job add constraint FKhkywthhlrmwcrskoxh6taq10f foreign key (responsabil_id) references angajat (id);
alter table utilizator add constraint FKinoj3bf5pex5wd4d0cf0m4f80 foreign key (angajat_id) references angajat (id);
alter table utilizator_rol add constraint FK6v0r0ljpv5h6jdeqnqlm5tv51 foreign key (rol_id) references rol (id);
alter table utilizator_rol add constraint FKlymi61ov41o3qd9yotyxi7qtl foreign key (utilizator_id) references utilizator (id);
