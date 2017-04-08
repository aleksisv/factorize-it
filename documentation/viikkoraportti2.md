### Viikkoraportti 2

Tällä viikolla itse ohjelma eteni hitaasti – sen sijaan edistin projektin dokumentaatiota ja suunnittelin mielessäni, miten minun tulisi toteuttaa muutamian algoritmin kannalta keskeisiä kohtia.

Lisäsin ohjelmaan yksinkertaisia lukuteoreettisia metodeita, kuten kahden luvun suurimman yhteisen tekijän testaavan metodin sekä metodin, joka tarkastaa, ovatko kaksi lukua suhteessa toisiinsa alkulukuja. Tarvitsen nämä metodit AKS-testin toteuttamiseen.

Lisäsin projektiin checkstyle- ja javadoc-plugit, jotka auttavat projektin dokumentoinnissa. Kirjoitin myös kattavan javadoc-dokumentaation niiltä osin kuin se on koodin kannalta oleellista. Pääasiassa keskityin luokkaa PrimeTools, joka on ohjelmani ydin ja tärkein komponentti. Lisäsin README.md-filesta linkit checkstyleen ja pit-raporttiin ja siirsin apidocsin projektin juureen. Lisäsin hieman testejä metodeille, jotka olin tällä viikolla kirjoittanut.

Olen käyttänyt jonkin aikaa teoreettiseen taustatyöhön. Kävi ilmi, että AKS-testi vaatii toimiakseen nopean metodin, joka testaa onko luku täydellinen potenssi (perfect power) vai ei. Kirjoitin ensin naiivin implementaation, joka testaa tämän, mutta tajusin hieman asiaan perehdyttyäni että tällaisella implementaatiolla testi onnistuu ajassa O(sqrt(N)), missä N on testatta luku. Jos siis haluan, että koko algoritmini asymptoottinen aika on paras mahdollinen (Õ(log^6(N))), en voi jättää tätä osaa naiivin implementaation varaan.

Tähän liittyen aloin kaivaa kirjallisuudesta tietoa täydellisen potenssin testin nopeasta toteutuksesta. Sain selville, että Daniel Bernstein on esittänyt algoritmin, joka testaa luvusta N, onko se täydellinen potenssi vai ei, "oleellisesti lineaarisessa ajassa". Algoritmi on julkaistu artikkelissa "Detecting perfect powers in essentially linear time" (Bernestein 1998). Algoritmi on kuitenkin melko vaikea toteuttaa, joten uskon tuskailevani sen kanssa vielä ensi viikolla. Lisäksi vaikuttaa siltä, että minun pitää toteuttaa luvut bittimuodossa, jotta voin käyttää suoraa hänen kuvaamaansa algoritmia. Tämä vaatinee oman lukuluokan toteuttamista, mikä vaikuttaa melko suurelta työltä. Saisikohan tällaisessa tilanteessa käyttää jotain valmiiksi toteutettua kirjastoa?

Opin tällä viikolla, kuinka vaikea on toteuttaa nopeita ja suurien lukujen kanssa toimivia lukuteoreettisia algoritmeja. Otan tämän kuitenkin vastaan kiinnostavana haasteena.

Viikon aikana projektin tekoon kului aikaa suunnilleen 6-7 tuntia. Olisin halunnut käyttää enemmän aikaa itse koodaukseen, mutta tällä viikolla kiireet estivät suuremmissa määrin etenemisen. Sain kuitenkin tehtyä dokumentaatiota ja lisättyä plugeja projektiin, mistä olen tyytyväinen.
