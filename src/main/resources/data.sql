INSERT INTO CATEGORY VALUES (1, 'Роллы');
INSERT INTO CATEGORY VALUES (2, 'WOK');
INSERT INTO CATEGORY VALUES (3, 'Морепродукты');
INSERT INTO CATEGORY VALUES (4, 'Поке и севиче');
INSERT INTO CATEGORY VALUES (5, 'Нигири и гунканы');
INSERT INTO CATEGORY VALUES (6, 'Барбекю');
INSERT INTO CATEGORY VALUES (7, 'Гарниры и соусы');
INSERT INTO CATEGORY VALUES (8, 'Напитки');

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
INSERT INTO INGREDIENT VALUES (11, 'Рис', 2);
INSERT INTO INGREDIENT VALUES (12, 'Цыпленок', 2);
INSERT INTO INGREDIENT VALUES (13, 'Перец чили', 2);
INSERT INTO INGREDIENT VALUES (14, 'Морепродукты', 2);
INSERT INTO INGREDIENT VALUES (15, 'Орехи', 2);
INSERT INTO INGREDIENT VALUES (16, 'Лемограсс', 2);
INSERT INTO INGREDIENT VALUES (17, 'Лосось', 6);
INSERT INTO INGREDIENT VALUES (18, 'Тунец', 6);
INSERT INTO INGREDIENT VALUES (19, 'Креветки', 6);

INSERT INTO ITEM VALUES (
    1,
    CURRENT_TIMESTAMP(),
    'лосось, авокадо, сливочный сыр Креметта, рис, нори, палочки для суши (1 комплект)',
    'Филадельфия (8 шт., 290 г.)',
    'src/main/resources/philadelphia.png',
    14.25,
    1
);

INSERT INTO ITEM VALUES (
    2,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, авокадо, огурец, томаго, соус унаги, кунжут белый и черный, сыр сливочный Креметта, такуан, нори, рис',
    'Ролл Колумбия (8 шт., 250 г.)',
    'src/main/resources/columbia.png',
    8.80,
    1
);

INSERT INTO ITEM VALUES (
    3,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, авокадо, огурец, сыр сливочный Креметта, нори, рис',
    'Ролл Нежный Принц (8 шт., 250 г.)',
    'src/main/resources/prince.png',
    12.60,
    1
);

INSERT INTO ITEM VALUES (
    4,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, салат айсберг, сыр сливочный Креметта, такуан, нори, рис',
    'Ролл c Тигровой Креветкой в Такуане (8 шт., 240 г.)',
    'src/main/resources/tiger.png',
    7.10,
    1
);

INSERT INTO ITEM VALUES (
    5,
    CURRENT_TIMESTAMP(),
    'лосось, огурец, икра летучей рыбы нори, сыр сливочный, нори, рис',
    'Ролл Филадельфия Блэк Стар (8 шт., 250 г.)',
    'src/main/resources/black_star.png',
    11.20,
    1
);

INSERT INTO ITEM VALUES (
    6,
    CURRENT_TIMESTAMP(),
    'лосось, тигровая креветка, тунец, салат айсберг, огурец, сыр сливочный, нори, рис',
    'Ролл Филадельфия Эдем (8 шт., 250 г.)',
    'src/main/resources/edem.png',
    13,
    1
);

INSERT INTO ITEM VALUES (
    7,
    CURRENT_TIMESTAMP(),
    'лосось, огурец, икра летучей рыбы вассабико, икра массаго, сыр сливочный Креметта, японский блинчик, нори, рис',
    'Ролл Акура Маки (8 шт., 250 г.)',
    'src/main/resources/acura.png',
    7.04,
    1
);

INSERT INTO ITEM VALUES (
    8,
    CURRENT_TIMESTAMP(),
    'угорь, лаймовый огурец, дайкон фрай, соус террияки, сыр сливочный, нори, рис',
    'Ролл Амаи (8 шт., 250 г.)',
    'src/main/resources/amai.png',
    14.90,
    1
);

INSERT INTO ITEM VALUES (
    9,
    CURRENT_TIMESTAMP(),
    'лосось, подкопченный тунец, авокадо, сыр сливочный, слайсы цуккини, нори, рис',
    'Ролл Каби (8 шт., 240 г.)',
    'src/main/resources/cabi.png',
    8,
    1
);

INSERT INTO ITEM VALUES (
    10,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, сливочный сыр, икра летучей рыбы, огурец, авокадо, рис, нори',
    'Ролл Калифорния (8 шт., 240 г.)',
    'src/main/resources/california.png',
    11.90,
    1
);

INSERT INTO ITEM VALUES (
    11,
    CURRENT_TIMESTAMP(),
    'тигровые креветки, рисовая лапша с яйцом, ростки сои, тофу, кисло-сладкий тамариндовый соус, арахис, перец чили, зеленый лук, лайм',
    'Пад Тай с тигровыми креветками (300 г.)',
    'src/main/resources/pad_tai_tiger.png',
    13.90,
    2
);

INSERT INTO ITEM VALUES (
    12,
    CURRENT_TIMESTAMP(),
    '1 ролл(8 шт) - Филадельфия Каппа (лосось, огурец, сыр сливочный, нори, рис),
     1 ролл(8 шт) – Фантини Маки (лосось террияки, китайская груша, сливочный сыр, соус сладкий чили, кунжут, нори, рис),
     2 порции пад-тай с цыплёнком (филе цыпленка, рисовая лапша, яйцо, ростки сои, тофу, арахис, лайм, перец чили, зеленый лук, соус пад-тай)',
    'Сет легкость бытия (1030 г.)',
    'src/main/resources/set_light.png',
    28.50,
    2
);

INSERT INTO ITEM VALUES (
    13,
    CURRENT_TIMESTAMP(),
    'тигровые креветки, куриный бульон, лемонграсс, галангал, грибы шитаки, листья кафир-лайма, перец чили, кинза, паста том-ям',
    'Том-Ям с тигровыми креветками (300 г./100 г.)',
    'src/main/resources/tom_yam_tiger.png',
    10.80,
    2
);

INSERT INTO ITEM VALUES (
    14,
    CURRENT_TIMESTAMP(),
    'куринный бульон, кокосовое молоко, лемонграсс, галангал, лисья кафир-лайма, лук-шалот, цыпленок; подается с рисом (100 г.)',
    'Том Кха с цыпленком (280 г./100 г.)',
    'src/main/resources/tom_kha.png',
    8.80,
    2
);

INSERT INTO ITEM VALUES (
    15,
    CURRENT_TIMESTAMP(),
    'цыпленок, рис с овощами, яйцо, ростки сои, фирменный соус для тайского риса, лайм, ростки сои, перец чили, зеленый лук',
    'Тайский рис с цыпленком (320 г.)',
    'src/main/resources/tai_rice.png',
    9,
    2
);

INSERT INTO ITEM VALUES (
    16,
    CURRENT_TIMESTAMP(),
    'жаренный рис с морепродуктами, овощами, яйцом, ростками сои, перцем чили, зеленным луком с фирменным соусом',
    'Тайский рис с морепродуктами (320 г.)',
    'src/main/resources/tai_rice_sea.png',
    12,
    2
);

INSERT INTO ITEM VALUES (
    17,
    CURRENT_TIMESTAMP(),
    'цыпленок, перец, кешью, тамариндовый соус; подается с рисом',
    'Стир-Фрай с цыпленком и кешью (280 г.)',
    'src/main/resources/stir_fri.png',
    9.60,
    2
);

INSERT INTO ITEM VALUES (
    18,
    CURRENT_TIMESTAMP(),
    'рисовая лапша с цыпленком, яйцом, ростками сои, тофу, арахисом, лаймом, перцем чили, зеленым луком, кисло-сладким тамариндовым соусом',
    'Пад Тай с цыпленком (300 г.)',
    'src/main/resources/pad_tai_chicken.png',
    10.90,
    2
);

INSERT INTO ITEM VALUES (
    19,
    CURRENT_TIMESTAMP(),
    'цыпленок, стеклянная лапша с овощами, тамариндовый соус, устричный соус',
    'Пад Кхи Мао с цыпленком (320 г.)',
    'src/main/resources/pad_khi_mao.png',
    9.60,
    2
);

INSERT INTO ITEM VALUES (
    20,
    CURRENT_TIMESTAMP(),
    'стеклянная лапша с морепродуктами, яйцо, фирменный соус',
    'Пад Кхи Мао с морепродуктами (340 г.)',
    'src/main/resources/pad_khi_mao_sea.png',
    12.60,
    2
);

INSERT INTO ITEM VALUES (
    21,
    CURRENT_TIMESTAMP(),
    'охлажденная Дорадо с головой; страна происхождения - Турция',
    'Дорадо охлажденная (1 кг.)',
    'src/main/resources/dorado.png',
    28,
    3
);

INSERT INTO ITEM VALUES (
    22,
    CURRENT_TIMESTAMP(),
    'стейки тунца',
    'Стейки тунца (1 кг.)',
    'src/main/resources/stake.png',
    38,
    3
);

INSERT INTO ITEM VALUES (
    23,
    CURRENT_TIMESTAMP(),
    'стейки лосося (охлаждённые); страна происхождения - Норвегия',
    'Стейки лосося (1 кг.)',
    'src/main/resources/salmon.png',
    38,
    3
);

INSERT INTO ITEM VALUES (
    24,
    CURRENT_TIMESTAMP(),
    'королевские креветки глубокой заморозки без головы',
    'Креветки Ваннамей (1 кг.)',
    'src/main/resources/vannamei.png',
    55,
    3
);

INSERT INTO ITEM VALUES (
    25,
    CURRENT_TIMESTAMP(),
    'лосось маринованный, соус манго-чили, икра летучей рыбы, авокадо, манго, ферментированный огурец, редис, бобы эдамэ, такуан, соус грин-лайт',
    'Поке с лососем (1 шт., 280 г.)',
    'src/main/resources/poke_salmon.png',
    12.80,
    4
);

INSERT INTO ITEM VALUES (
    26,
    CURRENT_TIMESTAMP(),
    'тунец маринованный, соус манго-чили, икра летучей рыбы, авокадо, манго, ферментированный огурец, редис, бобы эдамэ, такуан, соус грин-лайт, волосы лука зеленого',
    'Поке с тунцом (1 шт., 290 г.)',
    'src/main/resources/poke_tuna.png',
    12,
    4
);

INSERT INTO ITEM VALUES (
    27,
    CURRENT_TIMESTAMP(),
    'лосось маринованный, соус манго-маракуйя, манго, ферментированный огурец, редис, руколла, лайм, кунжут ким-чи, соус грин-лайт',
    'Севиче с лососем Гравлакс и манго (1 шт., 190 г.)',
    'src/main/resources/seviche_salmon.png',
    12.80,
    4
);

INSERT INTO ITEM VALUES (
    28,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, соус манго-маракуйя, груша террияки, манго, ферментированный огурец ,редис, кунжут ким-чи, слайсы миндаля, соус грин-лайт, соус ширачи',
    'Севиче с тигровой креветкой (1 шт., 190 г.)',
    'src/main/resources/seviche_tiger.png',
    12.80,
    4
);

INSERT INTO ITEM VALUES (
    29,
    CURRENT_TIMESTAMP(),
    'лосось, рис',
    'Нигири с лососем (1 шт., 30 г.)',
    'src/main/resources/nigiri_salmon.png',
    2.40,
    5
);

INSERT INTO ITEM VALUES (
    30,
    CURRENT_TIMESTAMP(),
    'тигровая креветка, рис',
    'Нигири с тигровой креветкой (1 шт., 30 г.)',
    'src/main/resources/nigiri_tiger.png',
    2.85,
    5
);

INSERT INTO ITEM VALUES (
    31,
    CURRENT_TIMESTAMP(),
    'томаго, соус унаги, кунжут, рис, нори',
    'Нигири с томаго (1 шт., 43 г.)',
    'src/main/resources/nigiri_tomago.png',
    1.65,
    5
);

INSERT INTO ITEM VALUES (
    32,
    CURRENT_TIMESTAMP(),
    'тунец, рис',
    'Нигири с тунцом (1 шт., 30 г.)',
    'src/main/resources/nigiri_tuna.png',
    2.40,
    5
);

INSERT INTO ITEM VALUES (
    33,
    CURRENT_TIMESTAMP(),
    'угорь, рис, нори, соус унаги, кунжут',
    'Нигири с угрем (1 шт., 38 г.)',
    'src/main/resources/nigiri_eel.png',
    3.20,
    5
);

INSERT INTO ITEM VALUES (
    34,
    CURRENT_TIMESTAMP(),
    'лосось, соус спайси, рис, нори',
    'Гункан с лососем спайси (1 шт., 43 г.)',
    'src/main/resources/gunkan_salmon.png',
    2.70,
    5
);

INSERT INTO ITEM VALUES (
    35,
    CURRENT_TIMESTAMP(),
    'морской гребешок, соус спайси, рис, нори',
    'Гункан c гребешком спайси (1 шт., 40 г.)',
    'src/main/resources/gunkan_scallop.png',
    3.15,
    5
);

INSERT INTO ITEM VALUES (
    36,
    CURRENT_TIMESTAMP(),
    'икра летучей рыбы, рис, нори',
    'Гункан c икрой летучей рыбы (1 шт., 40 г.)',
    'src/main/resources/gunkan_caviar.png',
    2.10,
    5
);

INSERT INTO ITEM VALUES (
    37,
    CURRENT_TIMESTAMP(),
    'лососевая икра, сыр сливочный Креметта, нори, рис',
    'Гункан с красной икрой и сливочным сыром (1 шт., 40 г.)',
    'src/main/resources/gunkan_red_cavier.png',
    2.85,
    5
);

INSERT INTO ITEM VALUES (
    38,
    CURRENT_TIMESTAMP(),
    'салат чука, ореховый соус, кунжут, рис, нори',
    'Гункан с чука салатом (1 шт., 45 г.)',
    'src/main/resources/gunkan_chuka.png',
    1.80,
    5
);

INSERT INTO ITEM VALUES (
    39,
    CURRENT_TIMESTAMP(),
    'тунец, соус спайси, рис, нори',
    'Гункан с тунцом спайси (1 шт., 45 г.)',
    'src/main/resources/gunkan_tuna.png',
    2.70,
    5
);

INSERT INTO ITEM VALUES (
    40,
    CURRENT_TIMESTAMP(),
    'охлажденный лосось, соус "Зеленые острова"',
    'Стейки лосося в соусе "Зеленые острова" (1 кг.)',
    'src/main/resources/steak_salmon.png',
    38,
    6
);

INSERT INTO ITEM VALUES (
    41,
    CURRENT_TIMESTAMP(),
    'охлажденный лосось, соус "Красная Азия"',
    'Стейки лосося в соусе "Красная Азия" (1 кг.)',
    'src/main/resources/steak_salmon_red.png',
    38,
    6
);


INSERT INTO ITEM VALUES (
    42,
    CURRENT_TIMESTAMP(),
    'охлажденный тунец, соус "Зеленые острова"',
    'Стейки тунца в соусе "Зеленые острова" (1 кг.)',
    'src/main/resources/steak_tuna.png',
    38,
    6
);

INSERT INTO ITEM VALUES (
    43,
    CURRENT_TIMESTAMP(),
    'охлажденный тунец, соус "Красная Азия"',
    'Стейки тунца в соусе "Красная Азия" (1 кг.)',
    'src/main/resources/steak_tuna_red.png',
    38,
    6
);

INSERT INTO ITEM VALUES (
    44,
    CURRENT_TIMESTAMP(),
    'охлажденные креветки Ванамей, соус "Красная Азия"',
    'Креветки в соусе "Красная Азия" (1 кг.)',
    'src/main/resources/shrimp_red.png',
    55,
    6
);

INSERT INTO ITEM VALUES (
    45,
    CURRENT_TIMESTAMP(),
    'охлажденные креветки Ванамей, соус "Зеленые острова"',
    'Креветки в соусе "Зеленые острова" (1 кг.)',
    'src/main/resources/shrimp.png',
    55,
    6
);

INSERT INTO ITEM VALUES (
    46,
    CURRENT_TIMESTAMP(),
    'соус кунжутовый в пластиковом контейнере',
    'Соус кунжутный (25 мл.)',
    'src/main/resources/sesame.png',
    2,
    7
);

INSERT INTO ITEM VALUES (
    47,
    CURRENT_TIMESTAMP(),
    'соус Спайси в пластиковом контейнере',
    'Соус Спайси (25 мл.)',
    'src/main/resources/spicy.png',
    2,
    7
);

INSERT INTO ITEM VALUES (
    48,
    CURRENT_TIMESTAMP(),
    'соус Терияки в пластиковом контейнере',
    'Соус Терияки (25 мл.)',
    'src/main/resources/teriyaki.png',
    2,
    7
);

INSERT INTO ITEM VALUES (
    49,
    CURRENT_TIMESTAMP(),
    'салат из водорослей Хияши Вакамэ, сушенные древесные грибы, семена кунжута, агар-агар, кунжутное масло, соль, сахар, ореховый соус (25 мл.)',
    'Чука-салат (90 г.)',
    'src/main/resources/chuka.png',
    4,
    7
);

INSERT INTO ITEM VALUES (
    50,
    CURRENT_TIMESTAMP(),
    'соевый соус в пластиковом контейнере',
    'Соевый соус (50 мл.)',
    'src/main/resources/soy.png',
    1,
    7
);

INSERT INTO ITEM VALUES (
    51,
    CURRENT_TIMESTAMP(),
    'белый маринованный имбирь, производство - Китай',
    'Белый имбирь (200 г.)',
    'src/main/resources/white_ginger.png',
    3.60,
    7
);

INSERT INTO ITEM VALUES (
    52,
    CURRENT_TIMESTAMP(),
    'розовый маринованный имбирь, производство - Китай',
    'Розовый имбирь (200 г.)',
    'src/main/resources/rose_ginger.png',
    3.60,
    7
);

INSERT INTO ITEM VALUES (
    53,
    CURRENT_TIMESTAMP(),
    'картофель по-деревенски',
    'Картофель по-деревенски (150 г.)',
    'src/main/resources/potato.png',
    3.50,
    7
);

INSERT INTO ITEM VALUES (
    54,
    CURRENT_TIMESTAMP(),
    'васаби',
    'васаби (10 г.)',
    'src/main/resources/wasabi.png',
    1,
    7
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
INSERT INTO ITEM_INGREDIENTS VALUES (11, 14);
INSERT INTO ITEM_INGREDIENTS VALUES (11, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (11, 13);
INSERT INTO ITEM_INGREDIENTS VALUES (11, 15);
INSERT INTO ITEM_INGREDIENTS VALUES (12, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (12, 12);
INSERT INTO ITEM_INGREDIENTS VALUES (12, 13);
INSERT INTO ITEM_INGREDIENTS VALUES (12, 14);
INSERT INTO ITEM_INGREDIENTS VALUES (12, 15);
INSERT INTO ITEM_INGREDIENTS VALUES (13, 13);
INSERT INTO ITEM_INGREDIENTS VALUES (13, 14);
INSERT INTO ITEM_INGREDIENTS VALUES (13, 16);
INSERT INTO ITEM_INGREDIENTS VALUES (14, 12);
INSERT INTO ITEM_INGREDIENTS VALUES (14, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (14, 16);
INSERT INTO ITEM_INGREDIENTS VALUES (15, 12);
INSERT INTO ITEM_INGREDIENTS VALUES (15, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (15, 13);
INSERT INTO ITEM_INGREDIENTS VALUES (16, 14);
INSERT INTO ITEM_INGREDIENTS VALUES (16, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (16, 13);
INSERT INTO ITEM_INGREDIENTS VALUES (17, 12);
INSERT INTO ITEM_INGREDIENTS VALUES (17, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (17, 15);
INSERT INTO ITEM_INGREDIENTS VALUES (18, 11);
INSERT INTO ITEM_INGREDIENTS VALUES (18, 12);
INSERT INTO ITEM_INGREDIENTS VALUES (18, 15);
INSERT INTO ITEM_INGREDIENTS VALUES (18, 13);
INSERT INTO ITEM_INGREDIENTS VALUES (19, 12);
INSERT INTO ITEM_INGREDIENTS VALUES (20, 14);
INSERT INTO ITEM_INGREDIENTS VALUES (40, 17);
INSERT INTO ITEM_INGREDIENTS VALUES (41, 17);
INSERT INTO ITEM_INGREDIENTS VALUES (42, 18);
INSERT INTO ITEM_INGREDIENTS VALUES (43, 18);
INSERT INTO ITEM_INGREDIENTS VALUES (44, 19);
INSERT INTO ITEM_INGREDIENTS VALUES (45, 19);