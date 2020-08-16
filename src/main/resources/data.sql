INSERT INTO CATEGORY VALUES (1, 'Роллы');
INSERT INTO CATEGORY VALUES (2, 'WOK');
INSERT INTO CATEGORY VALUES (3, 'Морепродукты');
INSERT INTO CATEGORY VALUES (4, 'Поке и севиче');
INSERT INTO CATEGORY VALUES (5, 'Нигири и гунканы');
INSERT INTO CATEGORY VALUES (6, 'Барбекю');
INSERT INTO CATEGORY VALUES (7, 'Гарниры и соусы');
INSERT INTO CATEGORY VALUES (8, 'Десерты и напитки');

INSERT INTO INGREDIENT VALUES (1, 'Лосось', 1);
INSERT INTO INGREDIENT VALUES (2, 'Авокадо', 1);
INSERT INTO INGREDIENT VALUES (3, 'Сливочный сыр', 1);
INSERT INTO INGREDIENT VALUES (4, 'Тигровая креветка', 1);
INSERT INTO INGREDIENT VALUES (5, 'Такуан', 1);
INSERT INTO INGREDIENT VALUES (6, 'Огурец', 1);
INSERT INTO INGREDIENT VALUES (7, 'Икра летучей рыбы', 1);
INSERT INTO INGREDIENT VALUES (8, 'Угорь', 1);
INSERT INTO INGREDIENT VALUES (9, 'Тунец', 1);
INSERT INTO INGREDIENT VALUES (10, 'Кунжут', 1);

INSERT INTO ITEM VALUES (
    1,
    CURRENT_TIMESTAMP(),
    'лосось, авокадо, сливочный сыр Креметта, рис, нори, палочки для суши (1 комплект)',
    'Филадельфия(8 шт., 290г.)',
    'src/main/resources/philadelphia.png',
    14.25,
    1
);

INSERT INTO ITEM VALUES (
    2,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, авокадо, огурец, томаго, соус унаги, кунжут белый и черный, сыр сливочный Креметта, такуан, нори, рис',
    'Ролл Колумбия(8 шт., 250г.)',
    'src/main/resources/columbia.png',
    8.80,
    1
);

INSERT INTO ITEM VALUES (
    3,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, авокадо, огурец, сыр сливочный Креметта, нори, рис',
    'Ролл Нежный Принц(8 шт., 250г.)',
    'src/main/resources/prince.png',
    12.60,
    1
);

INSERT INTO ITEM VALUES (
    4,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, салат айсберг, сыр сливочный Креметта, такуан, нори, рис',
    'Ролл c Тигровой Креветкой в Такуане(8 шт., 240г.)',
    'src/main/resources/tiger.png',
    7.10,
    1
);

INSERT INTO ITEM VALUES (
    5,
    CURRENT_TIMESTAMP(),
    'лосось, огурец, икра летучей рыбы нори, сыр сливочный, нори, рис',
    'Ролл Филадельфия Блэк Стар(8 шт., 250г.)',
    'src/main/resources/black_star.png',
    11.20,
    1
);

INSERT INTO ITEM VALUES (
    6,
    CURRENT_TIMESTAMP(),
    'лосось, тигровая креветка, тунец, салат айсберг, огурец, сыр сливочный, нори, рис',
    'Ролл Филадельфия Эдем(8 шт., 250г.)',
    'src/main/resources/edem.png',
    13,
    1
);

INSERT INTO ITEM VALUES (
    7,
    CURRENT_TIMESTAMP(),
    'лосось, огурец, икра летучей рыбы вассабико, икра массаго, сыр сливочный Креметта, японский блинчик, нори, рис',
    'Ролл Акура Маки(8 шт., 250г.)',
    'src/main/resources/acura.png',
    7.04,
    1
);

INSERT INTO ITEM VALUES (
    8,
    CURRENT_TIMESTAMP(),
    'угорь, лаймовый огурец, дайкон фрай, соус террияки, сыр сливочный, нори, рис',
    'Ролл Амаи(8 шт., 250г.)',
    'src/main/resources/amai.png',
    14.90,
    1
);

INSERT INTO ITEM VALUES (
    9,
    CURRENT_TIMESTAMP(),
    'лосось, подкопченный тунец, авокадо, сыр сливочный, слайсы цуккини, нори, рис',
    'Ролл Каби(8 шт., 240г.)',
    'src/main/resources/cabi.png',
    8,
    1
);

INSERT INTO ITEM VALUES (
    10,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, сливочный сыр, икра летучей рыбы, огурец, авокадо, рис, нори',
    'Ролл Калифорния(8 шт., 240г.)',
    'src/main/resources/cabi.png',
    11.90,
    1
);

INSERT INTO ITEM_INGREDIENTS VALUES (1, 1);
INSERT INTO ITEM_INGREDIENTS VALUES (1, 2);
INSERT INTO ITEM_INGREDIENTS VALUES (1, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (2, 4);
INSERT INTO ITEM_INGREDIENTS VALUES (2, 2);
INSERT INTO ITEM_INGREDIENTS VALUES (2, 6);
INSERT INTO ITEM_INGREDIENTS VALUES (2, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (2, 5);
INSERT INTO ITEM_INGREDIENTS VALUES (2, 10);
INSERT INTO ITEM_INGREDIENTS VALUES (3, 4);
INSERT INTO ITEM_INGREDIENTS VALUES (3, 2);
INSERT INTO ITEM_INGREDIENTS VALUES (3, 6);
INSERT INTO ITEM_INGREDIENTS VALUES (3, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (4, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (4, 4);
INSERT INTO ITEM_INGREDIENTS VALUES (4, 5);
INSERT INTO ITEM_INGREDIENTS VALUES (5, 1);
INSERT INTO ITEM_INGREDIENTS VALUES (5, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (5, 6);
INSERT INTO ITEM_INGREDIENTS VALUES (5, 7);
INSERT INTO ITEM_INGREDIENTS VALUES (6, 1);
INSERT INTO ITEM_INGREDIENTS VALUES (6, 4);
INSERT INTO ITEM_INGREDIENTS VALUES (6, 9);
INSERT INTO ITEM_INGREDIENTS VALUES (6, 6);
INSERT INTO ITEM_INGREDIENTS VALUES (6, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (7, 1);
INSERT INTO ITEM_INGREDIENTS VALUES (7, 6);
INSERT INTO ITEM_INGREDIENTS VALUES (7, 7);
INSERT INTO ITEM_INGREDIENTS VALUES (7, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (8, 8);
INSERT INTO ITEM_INGREDIENTS VALUES (8, 6);
INSERT INTO ITEM_INGREDIENTS VALUES (8, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (9, 1);
INSERT INTO ITEM_INGREDIENTS VALUES (9, 9);
INSERT INTO ITEM_INGREDIENTS VALUES (9, 2);
INSERT INTO ITEM_INGREDIENTS VALUES (9, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (10, 4);
INSERT INTO ITEM_INGREDIENTS VALUES (10, 3);
INSERT INTO ITEM_INGREDIENTS VALUES (10, 7);
INSERT INTO ITEM_INGREDIENTS VALUES (10, 2);
INSERT INTO ITEM_INGREDIENTS VALUES (10, 6);