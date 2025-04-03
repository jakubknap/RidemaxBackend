--liquibase formatted sql
--changeset jknap:28
insert into users (id, username, password, enabled)
values (2, 'user1@ridemax.pl', '{bcrypt}$2a$10$upzXFsFUOClFRR69OMKF8eajGMRs0vhcSHqvNDKy9yfW45w7o9z6O', true),
       (3, 'user2@ridemax.pl', '{bcrypt}$2a$10$upzXFsFUOClFRR69OMKF8eajGMRs0vhcSHqvNDKy9yfW45w7o9z6O', true);

--changeset jknap:29
insert into authorities (username, authority)
values ('user1@ridemax.pl', 'ROLE_CUSTOMER'),
       ('user2@ridemax.pl', 'ROLE_CUSTOMER');

--changeset jknap:30
insert into category (id, name, description, slug)
values (1, 'Komplety ubrań', '', 'komplety-ubran'),
       (2, 'Kaski', '', 'kaski'),
       (3, 'Gogle', '', 'gogle'),
       (4, 'Buty', '', 'buty'),
       (5, 'Oleje', '', 'oleje');

--changeset jknap:31
INSERT INTO product (id, name, category_id, description, full_description, price, currency, image, slug, sale_price)
VALUES (1,
        'Komplet cross FOX 180',
        1,
        'Komplet cross FOX 180 Lean Extd. kolor czerwony fluo, czarny',
        'Komplet na crossa FOX 180 Lean Extd. zawiera wygodną i odporną na użytkowanie w trudnych warunkach koszulkę na crossa i dobrze skrojone, wygodne spodnie crossowe Fox. Komplet w kolorze czerwono-czarnym.',
        768.38,
        'PLN',
        'komplet-cross-fox-180.jpg',
        'komplet-cross-fox-180',
        722.69),

       (2,
        'Strój na crossa Leatt Ride Kit 3.5',
        1,
        'Strój na crossa ( bluza + spodnie cross) Leatt Ride Kit 3.5 biały',
        '',
        521.13,
        'PLN',
        'leatt-ride-kit.jpg',
        'leatt-ride-kit',
        499.99),

       (3,
        'Kask cross Airoh AVIATOR 3 Glory',
        2,
        'Airoh Aviator 3 to najwyższy model kasków cross Arioh. Gwarantuje najwyższy poziom ochrony głowy i zapewnia najlepsze rozwiązania poprawiające komfort',
        'Kask motocyklowy Airoh Aviator 3 składa się z 2 warstw EPS, poruszających się względem siebie (system A.M.S.S. plus). Pozwala to na rozproszenie energii podczas uderzenia. Airoh Aviator 3 ma rozbudowany system wentylacji usprawniający cyrkulację powietrza wewnątrz kasku.',
        3357.08,
        'PLN',
        'airoh-aviator-3-glory.jpg',
        'airoh-aviator-3-glory',
        3250.00),

       (4,
        'Kask + gogle cross Leatt Kit Moto 9.5 Carbon V25',
        2,
        'Leatt Kit Moto 9.5 Carbon V25',
        '',
        3050.00,
        'PLN',
        'kask-gogle-cross-leatt-kit-moto-carbon-V25.jpg',
        'kask-gogle-cross-leatt-kit-moto-carbon-V25',
        null),

       (5,
        'SCOTT Gogle Prospect 2.0 kolor czerwony, żółty, zielony, szyba zielone lustro',
        3,
        'Quick Lens Release - szybka i łatwa wymiana szybki',
        'SCOTT Prospect 2.0 to druga generacja flagowych gogli motocrossowych SCOTT. Wyposażono je w przełomowy system Quick Lens Release System firmy SCOTT, który umożliwia użytkownikom natychmiastowe odblokowanie czterech sworzni blokujących szybkę.',
        446.20,
        'PLN',
        'scott-gogle-prospect.jpg',
        'scott-gogle-prospect',
        null),

       (6,
        'Buty cross Gaerne SG22 Gore Tex Wodoodporne kolor czarny / fluo',
        4,
        'Wodoodporne buty enduro z membraną Gore Tex. Garene SG22 przeznaczone do jazdy cross i enduro w najtrudniejszych warunkach terenowych.',
        '',
        2260.00,
        'PLN',
        'buty-cross-gaerne-sg22.jpg',
        'buty-cross-gaerne-sg22',
        null),

       (7,
        'Buty Leatt 4.5 z zawiasem Enduro GRAPHENE',
        4,
        'Buty Leatt 4.5 to najtańsze buty enduro z zawiasem. Model 4.5 jest wzorowany na topowym modelu 5.5 Flexlock. Buty Leatt 4.5 chronią nogę przed kontuzją.',
        '',
        1739.13,
        'PLN',
        'buty-leatt-4-5.jpg',
        'buty-leatt-4-5',
        1500.00),

       (8,
        'Olej Ipone KATANA 10W50 Offroad 2L',
        5,
        'Olej 4T do motocykli cross i enduro. Najwyższa półka oleju do crossa 4T. Doskonałe smarowanie i czyszczenie silnika czterosuwowego.',
        '',
        123.00,
        'PLN',
        'iphone-katana-10w50.jpg',
        'iphone-katana-10w50',
        null),

       (9,
        'Olej silnikowy Motul 300V 4T FACTORY LINE 10W40 1L',
        5,
        'Wyczynowy olej silnikowy MOTUL 300V. Był opracowywany przez zespoły mechaników i naukowców pracujących w firmach produkujących motocykle. Skutecznie chroni silnik, pomaga uzyskać największą wydajność.',
        '',
        70.00,
        'PLN',
        'motul-300v-10w40.jpg',
        'motul-300v-10w40',
        null);
