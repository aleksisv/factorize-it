# Aihemäärittely

"Factorize-it" on tietokoneohjelma kokonaislukujen ominaisuuksien tarkastelua varten. Käyttäjä antaa ohjelmalle syötteenä jonkin luonnollisen luvun, eli epänegatiivisen kokonaisluvun. Käyttäjä voi määrätä ohjelman tarkistamaan, onko kyseessä alkuluku. Halutessaan (ja jos luku ei ole alkuluku) käyttäjä voi pistää ohjelman jakamaan tämän kokonaisluvun tekijöihin aritmetiikan peruslauseen mukaan.

Ohjelma käyttää tunnettua AKS-algortmia testatessaan, onko kokonaisluku alkuluku. Tätä varten ohjelma tulee sisältämään useita apualgoritmeja, kuten jakojäännösalgoritmeja sekä algoritmeja, jotka laskevat kahden luvun multiplikatiivisen kertaluvun (multiplicative order).

Tarkoitukseni on myös toteuttaa algoritmi, jotka faktoroivat kokonaisluvun, mikäli se ei ole alkuluku. Ohjelma tulee käyttämään faktoroinnissa GNFS-algoritmia (General number field sieve).

AKS-algoritmin on todistettu olevan aikaluokkaa O(log(n)^12*log^k(log(n)^12)), missä k on jokin kokonaisluku. Tämän jälkeen on todistettu, että algoritmi on aikaluokkaa O(log(n)^6*log^k(log(n)^6)). Lisäksi jos niin sanottu Agrawalin konjektuuri on tosi, aikavaativuus on O(log(n)^3*log^k(log(n)^3)) jollekin k:lle. Tätä ei ole kuitenkaan todistettu todeksi tai epätodeksi.

GNFS:n aikavaativuus puolestaan on O(exp(((64/3)^(1/3) + o(1))*ln(n)^(1/3)*(ln((ln(n)))^(1/3)))).

Tällä hetkellä en tiedä vielä, missä muodossa tulen esittämään kokonaisluvut. Luultavasti parasta olisi käyttää bitti- tai kokonaislukulistaa ja toteuttaa näitä varten omat yhteen-, vähennys-, kerto- ja jakolaskut sekä modulaariaritmeettiset operaatiot, sillä javan omat Integerit ja Longit ovat liian pieniä tarkoitustani varten.

Pääasiallisena lähteenä käytän teoksia "A Course in Computational Algebraic Number Theory" (Henri Cohen) ja "Sieves in Number Theory" (George Greaves). Lisäksi käytän Wikipediaa.
