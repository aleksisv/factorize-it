### Viikkoraportti 3

Hitaan edellisen viikon jälkeen pääsin tällä viikolla taas koodauksen makuun. Alkuviikosta tajusin, että minun tarvitsisi koodata valtavan paljon enemmän kuin olin aikaisemmin kuvitellut ja tämä herätti minut panostamaan hieman enemmän itse koodaukseen.

Merkittävin lisä, jonka tein, oli uuden luokan toteuttaminen. Uuden Polynomial-luokan oliot ovat yhden muuttujan polynomeja, ja luokassa on erilaisia metodeja näiden algebralliseen manipulointiin. Lisäsin luokkaan metodin, jonka avulla kaksi polynomia voi lisätä yhteen, ja metodit polynomien kertomiselle, skaalaamiselle ja arvioimiselle tietyssä pisteessä x. Tämä Polynomial-luokka tulee toimimaan apuvälineenä AKS-algoritmin vaativimmassa vaiheessa, jossa pitää vertailla polynomeja modulo polynomi.

Polynomial luokan toteuttaminen vaati jonkin verran taustatyötä. En ollut aluksi aivan varma, mikä olisi paras tapa toteuttaa polynomit, mutta päädyin lopulta ratkaisuun, jossa polynomi on lista, jonka indeksit kertovat x:n potenssit ja arvo ko. indeksissä kertoo tämän x:n potenssin kertoimen. Esimerkiksi polynomia P(x) = 3x^2 + 10x + 2 vastaa lista [2, 10, 3]. Tämän lisäksi polynomiin liittyy aste (degree), joka kertoo, mikä on suurin x:n eksponentti, jonka kerroin on erisuuri kuin 0. Siis edellä mainitun polynomin aste on 2. On syytä huomata, että tässä vaiheessa polynomial-luokka tukee ainoastaan polynomeja, joiden kertoimet ovat kokonaislukuja. En ole vielä täysin varma, tarvitseeko minun muuttaa tätä jossain vaiheessa.

Suurin haaste tällä hetkellä liittyy polynomien jakojäännöksen laskemiseen. Minun tulisi pikimmiten toteuttaa algoritmi, joka laskee polynomin arvon modulo joku toinen polynomi. Tämä on AKS-algoritmin kannalta välttämätön vaihe enkä pysty kunnolla testaamaan sen toimivuutta ennen kuin minulla on metodi käytössäni. Koitin tällä viikolla etsiä tietoa siitä, miten kyseisen metodin voisi toteuttaa, mutta en vielä saanut mitään suurempaa tämän suhteen aikaiseksi. Ensi viikolla aion toteuttaa metodin. Toivon, että pystyn toteuttamaan metodin tavalla joka ei aiheuta merkittäviä aikakustannuksia algoritmin toiminnalle, mutta olen hieman skeptinen tämän suhteen.

Loppuajan käytin testien kirjoittamiseen ja dokumentaatioon. Pyrin saamaan testien rivikattavuuden Polynomial-luokan kannalta täysin kuntoon ja tässä onnistuinkin. PrimeTools-luokan rivikattavuus ei vielä ole yli 90%, sillä osaa metodeista en vielä pysty testaamaan niiden keskeneräisyyden takia. Erityisesti AKS-testimetodi on vielä testaamatta koska se ei tällä hetkellä toimi oikein (viimeinen askel algoritmista puuttuu).

Tein kattavan Javadoc-dokumentaation uudelle Polynomial-luokalle ja päivitin dokumentaatiota myös PrimeTools-luokassa. Uusi dokumentaatio löytyy projektin apidocs-kansiosta.

Viikon aikana projektin tekoon kului aikaa suunnilleen 8 tuntia. Olisin halunnut käyttää hieman enemmän, mutta muilla kursseilla aiheutuneet kiireet söivät pakostakin aikaa tästä projektista. Ensi viikolla aion saattaa projektini ydinalueen täysin kuntoon ja pyrin aloittamaan käyttöliittymän ohjelmoinnin.