# Testausdokumentaatio

PrimeTools-luokan metodeita on testatta pienillä, keskisuurilla ja suurilla luvuilla. Testaus on tapahtunut pääasiassa JUnit-testien että ohjelmoijan omien testien kautta. Jokaista valmista metodia testataan syötteillä, jotka pyrkivät ottamaan huomioon myös mutaatiokattavuuden. Debugattavuuden nimissä testit ovat mahdollisimman pieniä ja yhtä metodia testaavia.

Polynomial-luokan metodeja on testattu kattavasti JUnit-testeillä. Testaus tapahtui kohtuullisen matala-asteisilla polynomeilla (≈6. asteen polynomit). Tämänkin luokan testauksessa on pyritty mahdollisimman suureen kattavuuteen ja testit on pyritty tekemään tavalla, joka mahdollistaa virheiden nopean paikannuksen.


## Suorituskykytestaus

AKS-algoritmi toimii tällä hetkellä melko hitaasti johtuen siihen tarvittavien Polynomial-metodien raskaudesta. Oheisessa kuvassa näkyy, kuinka monta millisekuntia kunkin luvun primaalisuuden testaamiseen kului. ![AKS-testin nopeus](time_in_milliseconds_200_first_primes.png).

### Yksittäisten metodien nopeus

Tässä vaiheessa testaan vain, että metodit ei vie näillä syötteillä liian kauan aikaa.


#### PrimeTools-luokka
1. phi(n) laskee arvon phi(100 000 000 000 000L) 50000 nanosekunnissa.
2. areCoprime(311343244232L, 33321332134214L); lasketaan alle 20000 nanosekunnissa.




#### Polynomial-luokka
1. exponentiation(long n) on aikaavaativa operaatio. Olkoon esimerkiksi laskun (x+4)^32 suorittaminen tällä metodilla kestää noin 214 397 nanosekuntia. Laskun (x+4)^320 suorittaminen kestää 10 546 885 nanosekuntia, eli noin 50-kertaisesti, vaikka eksponentti on kerrottu kymmenellä.
