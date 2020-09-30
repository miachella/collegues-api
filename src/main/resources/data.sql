-- hôtels
insert into hotel(uuid,nom,nombre_etoiles) values ( '8539d931fe534b57a1281afc4ea9b21f', 'Première Classe', 0);
insert into hotel(uuid,nom,nombre_etoiles) values ( 'dcff0dbd041346b6b37acff5b92dc20c', 'Ibis Budget', 2);
--insert into hotel(uuid,nom,nombre_etoiles) values ( '4207a99b707c460cb295faa10a6eb163', 'Novotel', 3);
--insert into hotel(uuid,nom,nombre_etoiles) values ( 'cab545ea70e311eabc550242ac130003', 'Formule 1', 0);

-- clients
insert into client(uuid, nom, prenoms) values ('dcf129f1a2f947dc82651d844244b192', 'Odd', 'Ross');
insert into client(uuid, nom, prenoms) values ('f9a1817096054fe683c8d03a53e08bfe', 'Don', 'Duck');
insert into client(uuid, nom, prenoms) values ('91defde09ad34e4f886bf5f06f601a0d', 'Etienne', 'Joly');

-- chambres
insert into chambre(uuid, numero, surface, hotel_uuid) values ('754e6f53e8f549769fd295e6a427ef1c', 'P1', 10, '8539d931fe534b57a1281afc4ea9b21f');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('43793061f70b44b9a855adc66a2efb9f', 'P2', 20, '8539d931fe534b57a1281afc4ea9b21f');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('b13e05d9d9a949a980cbee03da248102', 'P3', 30, '8539d931fe534b57a1281afc4ea9b21f');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('666a21888be541ce88009f7ba4618521', 'I1', 10, 'dcff0dbd041346b6b37acff5b92dc20c');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('0a0d4672a2734e1fb3998272ae81296f', 'I2', 20, 'dcff0dbd041346b6b37acff5b92dc20c');
insert into chambre(uuid, numero, surface, hotel_uuid) values ('5eff715565f84fd09209bb10dfd086c7', 'I3', 30, 'dcff0dbd041346b6b37acff5b92dc20c');


insert into reservation(uuid,date_debut,date_fin) values ('82a23f74c93d46a3946ac196f6aa147a', '2020-03-01', '2020-04-01');
insert into reservation(uuid,date_debut,date_fin) values ('e2e6d98a00974de6b71aeecdabcfb7d9', '2020-03-01', '2020-04-01');


//
insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('82a23f74c93d46a3946ac196f6aa147a', '754e6f53e8f549769fd295e6a427ef1c');
insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('82a23f74c93d46a3946ac196f6aa147a', '43793061f70b44b9a855adc66a2efb9f');

insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('e2e6d98a00974de6b71aeecdabcfb7d9', '0a0d4672a2734e1fb3998272ae81296f');
insert into reservation_chambres(reservation_uuid,chambres_uuid) values ('e2e6d98a00974de6b71aeecdabcfb7d9', '5eff715565f84fd09209bb10dfd086c7');







