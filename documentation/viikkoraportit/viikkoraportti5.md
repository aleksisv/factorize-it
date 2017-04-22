### Viikkoraportti 5

Tällä kahden viikon periodilla jatkoin kamppailuani algoritmin haastavimman vaiheen, polynomimodulaariaritmetiikan, kanssa. Sain toteutettua polynomien jakolaskun, mutta kongruenssien laskeminen on edelleen kesken.

Eräs ongelma, johon olen törmännyt, on polynomijakolaskun luotettavuus. Tätä hoitava metodi toimii varsin hyvin suurimmassa osassa tapauksista, mutta joissain kohdissa metodi jää pyörimään ikuiseen kehään. Erityisesti varsin triviaalin oloiset jakolaskut, kuten (2x^2 + x) / x tuottavat algoritmille ongelmia, joita en ole vielä saanut ratkaistua.

Toinen ongelma, joka minun tulisi ratkaista, on kuinka käyttää polynomijakolaskua kongruenssin tarkistamiseen. Yksi vaihtoehto on tehdä erillinen metodi, joka tarkistaa aina, onko jokin
polynomi jaettavissa toisella polynomilla, ja vasta tämän jälkeen suorittaa jakolasku. En tässä vaiheessa kuitenkaan ole täysin varma, kuinka toteuttaisin tämän metodin, etenkin kun jakolaskumetodikaan ei toimi virheettä.

Olen tehnyt lisäämiini metodeihin asianmukaiset Javadoc-dokumentaatiot ja jatkanut ohjelman kattavaa testaamista. Haluaisin mutaatiokattavuudesta vielä hieman korkeamman ja rivikattavuuden lähes täysiin prosentteihin. Valitettavasti tällä viikolla sen kehittäminen jäi vielä hieman varsinaisen ohjelmoinnin taakse. Rivikattavuudesta syö erityisesti se, että päämetodini aksPrimalityTest ei vielä toimi tavalla, joka menisi testeistä läpi.

Tällä poikkeuksellisella kahden viikon jaksolla käytin projektiin aikaa yhteensä noin 13 tuntia. Suurin osa ajasta meni kuitenkin melko epätehokkaaseen manuaaliseen testaukseen ja ihmettelyyn edellä mainitun polynomien jakolaskun kanssa.

Ensi viikolla aion viimeistellä algoritmin sellaiseen pisteeseen, että voin alkaa tehdä aika- ja tilavaativuuteen liittyvää dokumentaatiota sekä keskittyä algoritmin optimointiin. Tällä hetkellä suurin osa metodeista toimii kuten pitää, mutta ne voisivat olla elegantimmin toteutettuja ja aika- ja tilavaativuuksiltaan optimaalisempia. Haluaisin myös perehtyä aiheeseen liittyään kirjallisuuteen tarkemmin kuin parina edellisenä viikkona, koska juuri teoreettisen kiinnostavuuden vuoksi valitsin tämän aiheen.
