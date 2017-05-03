# Aihemäärittely

"Factorize-it" on tietokoneohjelma kokonaislukujen ominaisuuksien tarkastelua varten. Käyttäjä antaa ohjelmalle syötteenä jonkin luonnollisen luvun, eli epänegatiivisen kokonaisluvun. Käyttäjä voi määrätä ohjelman tarkistamaan, onko kyseessä alkuluku. Halutessaan (ja jos luku ei ole alkuluku) käyttäjä voi pistää ohjelman jakamaan tämän kokonaisluvun tekijöihin aritmetiikan peruslauseen mukaan.

Ohjelma käyttää tunnettua *AKS-algortmia* testatessaan, onko kokonaisluku alkuluku. Tätä varten ohjelma tulee sisältämään useita apualgoritmeja, kuten jakojäännösalgoritmeja sekä algoritmeja, jotka laskevat kahden luvun multiplikatiivisen kertaluvun (multiplicative order).

AKS-algoritmin on todistettu olevan aikaluokkaa O(log(n)^12*log^k(log(n)^12)), missä k on jokin kokonaisluku. Tämän jälkeen on todistettu, algoritmi voi hyvinkin olla aikaluokkaa O(log(n)^6 * log^k(log(n)^6)). Jos niin sanottu Agrawalin konjektuuri on tosi, aikavaativuus on O(log(n)^3*log^k(log(n)^3)) jollekin k:lle. Tätä ei ole kuitenkaan todistettu todeksi tai epätodeksi.

Ohjelmassa on toteutettu pääasiallista algoritmia auttamaan joukko lukuteoreettisia
algoritmeja. Tämän lisäksi on toteutettu Polynomial-luokka, jonka olioita tarvitaan
algoritmin yhdessä vaiheessa, jossa testataan polynomien kongruenssia polynomirenkaissa.


## Käyttö

* Käyttäjä antaa kokonaisluvun, josta haluaa testata, onko se alkuluku.
* Käyttäjä painaa "test"-nappia.
* Ohjelma määrittää, onko kyseessä alkuluku vai ei.


## Lähteet

* AKS:
	* [AKS yleisesti](https://en.wikipedia.org/wiki/AKS_primality_test)
	* [Alkuperäinen artikkeli](http://annals.math.princeton.edu/2004/160-2/p12)

* Lukuteoria:
	.. H. Cohen. _A Course in Computational Algebraic Number Theory_. 1993
