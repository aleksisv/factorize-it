Testausdokumentti

Mitä on testattu, miten tämä tehtiin
Minkälaisilla syötteillä testaus tehtiin (vertailupainotteisissa töissä tärkeää)
Miten testit voidaan toistaa
Ohjelman toiminnan empiirisen testauksen tulosten esittäminen graafisessa muodossa.
Testaus on ideaalitapauksessa suoritettava ohjelma. Tällöin testi on helposti toistettavissa, mikä helpottaa toteutuksen tekoa jo varhaisessa vaiheessa. Javalla tehdyissä töissä on erittäin suositeltavaa käyttää testaukseen JUnitia.

# Testausdokumentaatio

PrimeTools-luokan metodeita on testatta pienillä, keskisuurilla ja suurilla luvuilla. Testaus on tapahtunut pääasiassa JUnit-testien että ohjelmoijan omien testien kautta. Jokaista valmista metodia testataan syötteillä, jotka pyrkivät ottamaan huomioon myös mutaatiokattavuuden. Debugattavuuden nimissä testit ovat mahdollisimman pieniä ja yhtä metodia testaavia.

## Yksikkötestit

Yksikkötestit testaavat algormin kannalta tärkeimpiä luokkia (fp.utils.PrimeTools ja
fp.utils.Polynomial) hyvin kattavasti. Luokkien jokaista metodia kohden on ainakin
yksi testi, jotka koostuvat useista assertion-ehdoista.

PrimeTools-luokassa testit testasivat lähinnä, tuottavatko lukuteoreettiset algoritmit
oikeita tuloksia. Tämä on ehdottoman tärkeää alkulukutestauksessa, sillä jos
jokin apumetodeista antaa vähänkin väärän vastauksen, voidaan alkuluku luokitella
vahingossa yhdistetyksi luvuksi ja päin vastoin.

Polynomial-luokassa testit testaavat myös, että polynomien laskutoimitukset suoritetaan
oikein ja tulokset ovat oikeita. Lisäksi testit tarkistavat, pidetäänkö operaatioiden
yhteydessä polynomeja siistissä muodossa, eli siistitäänkö polynomin kertoimet sisällään
pitävä lista tilanteessa, jossa korkeimman asteen kertoimet ovat nollia. Tätä
testataan siksi, että polynomeihin ei säilöttäisi turhaa tietoa (0-kertoimisia muuttujia).
Testit menevät läpi.

### Rivikattavuus

Rivikattavuus luokkien PrimeTools ja Polynomial kohdalla on korkea, noin 93%.

### Mutaatiotestaus

Mutaatiokattavuus on niin ikään korkea, noin 90%.

### Yksittäisten metodien nopeuden testaaminen

#### PrimeTools-luokka
1. phi(n) laskee arvon phi(100 000 000 000 000L) 50000 nanosekunnissa.
2. areCoprime(311343244232L, 33321332134214L); lasketaan alle 20000 nanosekunnissa.

#### Polynomial-luokka
1. exponentiation(long n) on aikaavaativa operaatio. Olkoon esimerkiksi laskun (x+4)^32 suorittaminen tällä metodilla kestää noin 214 397 nanosekuntia. Laskun (x+4)^320 suorittaminen kestää 10 546 885 nanosekuntia, eli noin 50-kertaisesti, vaikka eksponentti on kerrottu kymmenellä.
