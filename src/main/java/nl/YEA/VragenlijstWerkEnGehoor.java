package nl.YEA;

import nl.YEA.model.*;

import java.util.List;
import java.util.Map;

public class VragenlijstWerkEnGehoor {

    /* Deel 1 Persoonlijke informatie */

    private final String naam = "Naam:";
    private final String geslacht = "Geslacht:";
    private final String adres = "Adres:";
    private final String postcodeEnWoonplaats = "Postcode + Woonplaats:";
    private final String telefoon = "Telefoon:";
    private final String nationaliteit = "Nationaliteit:";
    private final String moedertaal = "Moedertaal:";
    private final String geboortedatum = "Geboortedatum:";
    private final String woonsituatie = "Woonsituatie:";
    private final String oAlleen = "alleenwonend";
    private final String oSamen = "met anderen samen (partner, kinderen)";
    private final String opleiding = "Opleiding:";
    private final String oLagerOnderwijs = "lager onderwijs";
    private final String oLagerBeroepsonderwijs = "lager beroepsonderwijs (LTS)";
    private final String oMiddelbaarAlgemeenOnderwijs = "middelbaar algemeen onderwijs (ULO, MAVO)";
    private final String oMiddelbaarBeroepsonderwijs = "middelbaar beroepsonderwijs";
    private final String oVoortgezetAlgemeen = "voortgezet algemeen (HAVO, VWO)";
    private final String oHogerBeroepsonderwijs = "hoger beroepsonderwijs (HBO, HTS, HEAO)";
    private final String oHogerAlgemeenEnWetenschappelijkOnderwijs = "hoger algemeen en wetenschappelijk onderwijs";
    private final String hobby = "Heeft u hobby’s?";


    /* Deel 2 Algemene werkinformatie */

    private final String d2v1 = "Wat is uw beroep en hoeveel jaar oefent u dit beroep al uit?";
    private final String d2v1_2 = "Leidinggevende functie:";
    private final String d2v2 = "Hoeveel uren werkt u per week?";
    private final String d2v3 = "Over hoeveel dagen zijn die uren verdeeld?";
    private final String d2v4 = "Heeft u onregelmatige werktijden (zoals avond/nachtdiensten)?";
    private final String d2v5 = "Hoeveel jaar bent u al in dienst bij de huidige werkgever?";
    private final String d2v6 = "Heeft u een vast of een tijdelijk dienstverband?";
    private final String d2v7 = "Bent u (gedeeltelijk) afgekeurd?";
    private final String d2v8 = "Hoeveel dagen heeft u in de afgelopen 12 maanden verzuimd wegens ziekte of " +
            "overbelasting? Wat was de precieze reden van verzuim? Het gaat om de dagen die u volledig verzuimd heeft.";
    private final String d2v8_aangepast = "Heeft u in de afgelopen 12 maanden dagen verzuimd wegens ziekte of " +
            "overbelasting? Het gaat om de dagen die u volledig verzuimd heeft.";


    /* Deel 3 Gehoor, medische voorgeschiedenis en hoorhulpmiddelen */

    private final String d3v1 = "Sinds wanneer bent u slechthorend?";
    private final String d3v2 = "Wat weet u van de oorzaak van uw slechthorendheid?";
    private final String d3v3 = "Heeft u een verleden van operaties aan het oor en zo ja, kunt u omschrijven welke " +
            "operaties?";
    private final String d3v4 = "Heeft u vroeger speciaal onderwijs voor slechthorenden gevolgd?";
    private final String d3v5 = "Zijn er activiteiten waar u buiten werktijd NIET meer aan deelneemt, sinds u " +
            "slechthorend bent?";
    private final String d3v6 = "Denkt u dat u gebruik maakt van spraakafzien (liplezen)?";
    private final String d3v7 = "Heeft u last van oorsuizen?";
    private final String d3v8 = "Heeft u het gevoel dat u, meer dan andere mensen, last hebt van harde geluiden?";
    private final String d3v9 = "Hoe is op dit moment uw gezondheidstoestand?";
    private final String d3v10 = "Wordt u op dit moment begeleid door uw bedrijfsarts in verband met uw " +
            "slechthorendheid?";
    private final String d3v11 = "Wordt u op dit moment begeleid door uw bedrijfsarts in verband met een\n" +
            "     gezondheidsprobleem?";
    private final String d3v12 = "Heeft u behoefte aan begeleiding bij het omgaan met slechthorendheid op het werk?";
    private final String d3v13 = "Zijn er problemen thuis die uw functioneren op het werk belemmeren?";
    private final String d3v14 = "Draagt u hoortoestellen?";
    private final String d3v14_extra = "Aan welke kant draagt u hoortoestellen?";
    private final String d3v14_linksMerk = "Welk merk/type hoortoestellen draagt u links?";
    private final String d3v14_linksSinds = "Sinds wanneer draagt u links hoortoestellen?";
    private final String d3v14_rechtsMerk = "Welk merk/type hoortoestellen draagt u rechts?";
    private final String d3v14_rechtsSinds = "Sinds wanneer draagt u rechts hoortoestellen?";
    private final String d3v15 = "Draagt u tijdens uw werk uw hoortoestellen?";
    private final String d3v16 = "Draagt u buiten uw werk uw hoortoestellen?";
    private final String d3v17 = "Zijn er andere (hoor)hulpmiddelen die u op uw werk gebruikt (zoals bijv. solo " +
            "apparatuur)?";


    /* Deel 4 Werkzaamheden en werkruimte */

    private final String d4v1 = "Waar bestaan uw werkzaamheden voornamelijk uit? (vink maximaal 3 vakjes aan). Kunt " +
            "u aangeven hoeveel uur per dag u met de aangegeven werkzaamheden bezig bent?";
    private final String d4v1_o1 = "telefoneren";
    private final String d4v1_o2 = "gesprekken voeren (met 1 tot 3 personen)";
    private final String d4v1_o3 = "vergaderen (meer dan 3 personen)";
    private final String d4v1_o4 = "baliewerkzaamheden (receptionist, portier)";
    private final String d4v1_o5 = "geven van instructie/onderwijs";
    private final String d4v1_o6 = "verkoop van producten en diensten";
    private final String d4v1_o7 = "verzorging en verpleging";
    private final String d4v1_o8 = "bedienen en serveren";
    private final String d4v1_o9 = "administratief bureauwerk";
    private final String d4v1_o10 = "werken met computers";
    private final String d4v1_o11 = "werken met machines";
    private final String d4v1_o12 = "besturen van een voertuig";
    private final String d4v1_o13 = "musiceren of werken met geluid";
    private final String d4v1_o14 = "anders, namelijk.........";

    private final String d4v2a = "In wat voor ruimte voert u uw werkzaamheden voornamelijk uit? Welk deel van uw " +
            "werktijd (%) bent u werkzaam in de aangegeven ruimte?\n" +
            "Wilt u ook omcirkelen of er in elk van de door u aangegeven ruimte(n) sprake is van omgevingslawaai " +
            "en/of galm (0 = geen, 1 = een beetje, 2 = veel, 3 = erg veel)?";
    private final String d4v2a_o1 = "eigen kamer";
    private final String d4v2a_o2 = "kantoortuin";
    private final String d4v2a_o3 = "bibliotheek";
    private final String d4v2a_o4 = "lokaal";
    private final String d4v2a_o5 = "te-/ziekenhuis";
    private final String d4v2a_o6 = "winkel";
    private final String d4v2a_o7 = "restaurant/bar";
    private final String d4v2a_o8 = "hotel";
    private final String d4v2a_o9 = "magazijn";
    private final String d4v2a_o10 = "werkplaats";
    private final String d4v2a_o11 = "bouwlocatie";
    private final String d4v2a_o12 = "buiten";
    private final String d4v2a_o13 = "trein";
    private final String d4v2a_o14 = "vliegtuig";
    private final String d4v2a_o15 = "schip";
    private final String d4v2a_o16 = "(vracht)auto/bus";
    private final String d4v2a_o17 = "anders:";
    private final String d4v2b = "Geef een beschrijving van uw werkplek. Hangen er gordijnen in de ruimte waar u " +
            "werkt? Ligt er vloerbedekking? Werkt u met meerdere mensen op één kamer? Hoe is de ruimte ingedeeld?";
    private final String d4v3a = "Hoe vaak komt het voor dat u waarschuwingsgeluiden (telefoon, alarmbel, " +
            "infuuspomp, piep van een oven etc.) moet horen op uw werk?";
    private final String d4v3b = "Kost het u inspanning en concentratie om waarschuwingsgeluiden te horen?";
    private final String d4v4a = "Hoe vaak komt het voor dat u een gesprek in rumoer moet volgen op uw werk?";
    private final String d4v4b = "Kost het volgen van een gesprek in rumoer u inspanning en concentratie?";
    private final String d4v5a = "Bij een lawaaiige werkomgeving (omgeving met veel (machine) lawaai); heeft u " +
            "gehoorbeschermers tot uw beschikking?";
    private final String d4v5a_ja = "Welk soort? (bijv. kap, otoplastiek):";
    private final String d4v5b = "Kost het volgen van een gesprek i.c.m. gehoorbeschermers u " +
            "inspanning en concentratie (indien u in deze situatie gesprekken voert)?";
    private final String d4v6a = "Hoe vaak komt het voor dat u een gesprek in een stille omgeving moet volgen op uw " +
            "werk?";
    private final String d4v6b = "Kost het volgen van een gesprek in een stille omgeving u inspanning en " +
            "concentratie?";
    private final String d4v7a = "De onderstaande vragen gaan over de complexe luistersituaties op uw werk die u " +
            "veel luisterinspanning kosten en waar u graag iets aan zou willen doen om vermoeidheid tegen te gaan. " +
            "Beschrijf deze situaties en geef aan hoeveel luisterinspanning dit in de huidige situatie kost:";


    /* Deel 5 Psychosociale factoren in het werk i.r.t. slechthorendheid */

    private final String d5v1a = "Weten één of meer directe collega’s dat u slechthorend bent?";
    private final String d5v1b = "Weet uw directe leidinggevende dat u slechthorend bent?";
    private final String d5v1c = "Houden uw collega’s rekening met uw slechthorendheid?";
    private final String d5v1d = "Durft u over uw slechthorendheid met collega’s te praten?";
    private final String d5v1e = "Heeft u op dit moment behoefte aan verandering van uw takenpakket of aanpassing " +
            "van de ruimte waarin u werkt in verband met uw slechthorendheid?";
    private final String d5v1f = "Heeft u zelf ooit initiatief genomen om uw functie of ruimte te laten aanpassen?";
    private final String d5v1g = "Is uw takenpakket of werkruimte aangepast in verband met uw slechthorendheid?";
    private final String d5v1h = "Bent u, vanwege uw slechthorendheid, wel eens overgeplaatst naar een andere " +
            "afdeling?";
    private final String d5v1i = "Bent u, vanwege uw slechthorendheid, wel eens van baan veranderd?";
    private final String d5v1j = "Zijn er op het werk wel eens dingen ernstig mis gegaan, omdat u iets niet (goed) " +
            "hoorde?";
    private final String d5v1j_ja = "Kunt u beschrijven wat er mis ging?";
    private final String d5v1k = "Heeft u wel eens hulp gezocht voor coaching/ondersteuning bij uw slechthorendheid " +
            "op de werkvloer?";
    private final String d5v1k_ja = "Wat voor hulp heeft u gehad?";


    private final String overig = "In het volgende veld kunt u nog andere zaken kwijt die niet in de vragen naar " +
            "voren zijn gekomen, maar die u ons toch wilt meegeven:";


    public List<Vraag> vragenlijstWerkEnGehoorSamenstellen() {
        List<String> optiesNeeJa = List.of("nee", "ja");
        List<String> optiesFrequentie = List.of("bijna nooit", "soms", "vaak", "bijna altijd");
        List<String> optiesHoeveelheid = List.of("nee", "een beetje", "veel", "zeer veel");
        List<String> optiesHoeveelheid2 = List.of("geen", "een beetje", "matig", "veel", "zeer veel");
        /*Map<String, List<Vraag>> optiesNeeJaNamelijk = Map.of(
                "nee", null,
                "ja", List.of(new OpenVraag("namelijk?")));*/

        List<Vraag> vlWerkEnGehoor = List.of(
                new MeerkeuzeVraag("is kaas",List.of("1","2","3","4"),1,3),
                /* Deel 1 Persoonlijke informatie */
                new OpenVraag(naam),
                new MeerkeuzeVraag(geslacht, List.of("V", "M")),
                new OpenVraag(adres),
                new OpenVraag(postcodeEnWoonplaats),
                new OpenVraag(telefoon),
                new OpenVraag(nationaliteit),
                new OpenVraag(moedertaal),
                new OpenVraag(geboortedatum),
                new MeerkeuzeVraag(woonsituatie, List.of(oAlleen, oSamen)),
                new MeerkeuzeVraag(opleiding, List.of(oLagerOnderwijs, oLagerBeroepsonderwijs,
                        oMiddelbaarAlgemeenOnderwijs, oMiddelbaarBeroepsonderwijs, oVoortgezetAlgemeen, oHogerBeroepsonderwijs,
                        oHogerAlgemeenEnWetenschappelijkOnderwijs)),
                //new ComplexeVraag(hobby, optiesNeeJaNamelijk),


                /* Deel 2 Algemene werkinformatie */
                new OpenVraag(d2v1),
                new MeerkeuzeVraag(d2v1_2, optiesNeeJa),
                new NumeriekeVraag(d2v2, 1, 80),
                new NumeriekeVraag(d2v3, 1, 7),
                new MeerkeuzeVraag(d2v4, optiesNeeJa),
                new NumeriekeVraag(d2v5, 0, 70),
                new MeerkeuzeVraag(d2v6, List.of("vast", "tijdelijk")),
                /*new ComplexeVraag(d2v7, Map.of(
                        "nee", null,
                        "ja", List.of(new OpenVraag("sinds?"), new OpenVraag("vanwege?")))),*/


                /* Deel 3 Gehoor, medische voorgeschiedenis en hoorhulpmiddelen */
                new OpenVraag(d3v1),
                new OpenVraag(d3v2),
                //new ComplexeVraag(d3v3, optiesNeeJaNamelijk),
                new MeerkeuzeVraag(d3v4, optiesNeeJa),
                //new ComplexeVraag(d3v5, optiesNeeJaNamelijk),
                new MeerkeuzeVraag(d3v6, optiesNeeJa),
                new MeerkeuzeVraag(d3v7, optiesNeeJa),
                new MeerkeuzeVraag(d3v8, optiesNeeJa),
                new MeerkeuzeVraag(d3v9, List.of("goed", "redelijk", "slecht")),
                new MeerkeuzeVraag(d3v10, optiesNeeJa),
                //new ComplexeVraag(d3v11, optiesNeeJaNamelijk),
                new MeerkeuzeVraag(d3v12, optiesNeeJa),
                new MeerkeuzeVraag(d3v13, optiesNeeJa),
                /*new ComplexeVraag(d3v14, Map.of(
                        "nee", null,
                        "ja", List.of(
                                new ComplexeVraag(d3v14_extra, Map.of(
                                        "links", List.of(
                                                new OpenVraag(d3v14_linksMerk),
                                                new OpenVraag(d3v14_linksSinds)
                                        ),
                                        "rechts", List.of(
                                                new OpenVraag(d3v14_rechtsMerk),
                                                new OpenVraag(d3v14_rechtsSinds)
                                        )
                                )),
                                new OpenVraag(d3v15),
                                new OpenVraag(d3v16)
                        )
                )),*/
                //new ComplexeVraag(d3v17, optiesNeeJaNamelijk),


                /* Deel 4 Werkzaamheden en werkruimte */
                new OpenVraag(d4v2b),
                new MeerkeuzeVraag(d4v3a, optiesFrequentie),
                new MeerkeuzeVraag(d4v3b, optiesHoeveelheid),
                new MeerkeuzeVraag(d4v4a, optiesFrequentie),
                new MeerkeuzeVraag(d4v4b, optiesHoeveelheid),
                /*new ComplexeVraag(d4v5a, Map.of(
                        "nee", null,
                        "ja", List.of(
                                new OpenVraag(d4v5a_ja),
                                new MeerkeuzeVraag(d4v5b, optiesHoeveelheid)
                        )
                )),*/

                new MeerkeuzeVraag(d4v6a, optiesFrequentie),
                new MeerkeuzeVraag(d4v6b, optiesHoeveelheid),


                /* Deel 5 Psychosociale factoren in het werk i.r.t. slechthorendheid */
                new MeerkeuzeVraag(d5v1a, optiesNeeJa),
                new MeerkeuzeVraag(d5v1b, optiesNeeJa),
                new MeerkeuzeVraag(d5v1c, optiesNeeJa),
                new MeerkeuzeVraag(d5v1d, optiesNeeJa),
                new MeerkeuzeVraag(d5v1d, optiesNeeJa),
                new MeerkeuzeVraag(d5v1e, optiesNeeJa),
                new MeerkeuzeVraag(d5v1f, optiesNeeJa),
                new MeerkeuzeVraag(d5v1g, optiesNeeJa),
                new MeerkeuzeVraag(d5v1h, optiesNeeJa),
                new MeerkeuzeVraag(d5v1i, optiesNeeJa),
                /*new ComplexeVraag(d5v1j, Map.of(
                        "nee", null,
                        "ja", List.of(new OpenVraag(d5v1j_ja))
                )),
                new ComplexeVraag(d5v1k, Map.of(
                        "nee", null,
                        "ja", List.of(new OpenVraag(d5v1k_ja))
                )),*/

                new OpenVraag(overig)
        );

        voegNummeringToe(vlWerkEnGehoor);

        return vlWerkEnGehoor;
    }


    private void voegNummeringToe(List<Vraag> vragenlijst) {
        int i = 1;
        for (Vraag v : vragenlijst) {
            v.setVraagnummer(i++);
            if (v instanceof ComplexeVraag) {
                for (Map.Entry<String, List<Vraag>> e : ((ComplexeVraag) v).getKeuzemogelijkheden().entrySet()) {
                    if (e.getValue() != null) {
                        for (Vraag w : e.getValue()) {
                            w.setVraagnummer(i++);
                        }
                    }
                }
            }
        }
    }
}
