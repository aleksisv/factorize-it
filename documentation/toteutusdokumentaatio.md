# Factorize-it –toteutusdokumentti

## Ohjelman rakenne

Ohjelman tarkoitus on antaa käyttäjälle mahdollisuus testata, onko jokin kokonaisluku alkuluku. Luokkia on tällä hetkellä kaksi pääasiallista: PrimeTools ja Polynomial.

PrimeTools-luokka pitää sisällään lukuteoreettiset työkalut, joilla alkeellisuutta testataan. Ohjelman aikana käyttäjä tarvitsee vain yhden PrimeTools-olion käyttöönsä. Metodeista tärkein on aksPrimalityTest, joka on toteutus nopeasta AKS-testistä potentiaalisille alkuluvuille. Tätä metodia avustamaan on toteutettu joukko apumetodeita, joita tarvitaan algoritmia ajaessa. Näihin kuuluvat suurimman yhteisen tekijän määrittävä gcd-metodi, suhteellista alkeellisuutta testaava areCoprime-metodi sekä modulaarisesta eksponentiaatiosta vastaava modularExponentiation-metodi.

Polynomial-luokan oliot ovat yhden muuttujan kokonaislukukertoimisia polynomeja. Luokkaa tarvitaan AKS-algoritmin viimeiseen ja tärkeimpään vaiheeseen, jossa lasketaan modulaariaritmetiikkaa tietyillä polynomeilla. Tätä varten luokkaan on toteutettu joukko polynomien algebraan liittyviä metodeja. Polynomial-luokan olioilla on kaksi attribuuttia: kertoimet määrittävä, long[]-tyyppinen coefficients" sekä polynomin asteen säilövä "degree".

Käyttäjän on tarkoitus käyttää ohjelmaa yksinkertaisen komentorivikäyttöliittymän kautta.

## Aikavaativuus

Ideaalitapauksessa algoritmin aikavaativuuden tulisi olla luokkaa O(log(n)^6*log^6(log(n)^6)). Tässä vaiheessa koodissa on vielä paljon turhaa, joten tämänhetkinen aikavaativuus tuskin yltää tähän tasolle.


## Tilavaativuus

Arviointi kesken.



## Lähteet

* AKS:
	.. [AKS yleisesti](https://en.wikipedia.org/wiki/AKS_primality_test)
	.. [Alkuperäinen artikkeli](http://annals.math.princeton.edu/2004/160-2/p12)
* Lukuteoria:
	.. H. Cohen. _A Course in Computational Algebraic Number Theory_. 1993
