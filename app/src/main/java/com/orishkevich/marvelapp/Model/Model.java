package com.orishkevich.marvelapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Инженер-конструктор on 03.05.2017.
 */

public class Model {

    private RegionsListBean regions_list;

    public RegionsListBean getRegions_list() {
        return regions_list;
    }

    public void setRegions_list(RegionsListBean regions_list) {
        this.regions_list = regions_list;
    }

    public static class RegionsListBean {
        private List<RegionBeanXXX> region;

        public List<RegionBeanXXX> getRegion() {
            return region;
        }

        public void setRegion(List<RegionBeanXXX> region) {
            this.region = region;
        }

        public static class RegionBeanXXX {
            /**
             * -type : continent
             * -name : europe
             * -translate : =Europe
             * -inner_download_suffix : europe
             * -boundary : no
             * -poly_extract : europe
             * region : [{"-name":"denmark","-lang":"da","-poly_extract":"north-europe"},{"-name":"estonia","-lang":"et","-poly_extract":"north-europe"},{"-name":"iceland","-lang":"is","-poly_extract":"north-europe"},{"-name":"faroe-islands","-translate":"Faroe Islands;entity=node","-lang":"fo","-poly_extract":"north-europe"},{"-name":"finland","-inner_download_prefix":"$name","-srtm":"no","-lang":"fi,sv","-poly_extract":"north-europe","region":[{"-map":"no","-name":"aland","-translate":"name:fi=Ahvenanmaa;admin_level=3;entity=relation"},{"-type":"srtm","-name":"eastern-finland","-translate":"Eastern Finland;entity=relation"},{"-name":"northern-finland","-map":"no","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Northern Finland;entity=relation","-boundary":"no","region":[{"-type":"srtm","-name":"lapland","-translate":"Lapland;entity=relation"},{"-type":"srtm","-name":"northern-ostrobothnia","-translate":"name:en=Northern Ostrobothnia;entity=relation"}]},{"-type":"srtm","-name":"southern-finland","-translate":"Southern Finland;entity=relation"},{"-type":"srtm","-name":"western-finland","-translate":"Western Finland;entity=relation"}]},{"-name":"latvia","-lang":"lv","-poly_extract":"north-europe"},{"-name":"lithuania","-lang":"lt","-poly_extract":"north-europe"},{"-name":"norway","-srtm":"no","-inner_download_prefix":"$name","-lang":"nb,nn","-poly_extract":"north-europe","-join_map_files":"yes","region":[{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"akershus"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"astfold","-translate":"Østfold;entity=node"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"aust-agder"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"buskerud"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"finnmark"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"hedmark"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"hordaland"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"more-og-romsdal","-translate":"Møre og Romsdal;entity=node"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"nordland"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"nord-trondelag","-translate":"Nord-Trøndelag;entity=node"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"oppland"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"oslo"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"rogaland"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"sogn-og-fjordane","-translate":"Sogn og Fjordane;entity=node"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"sor-trondelag","-translate":"Sør-Trøndelag;entity=node"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"telemark"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"troms"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"vest-agder"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"vestfold"},{"-name":"svalbard-and-jan-mayen","-translate":"Svalbard;entity=relation"}]},{"-name":"sweden","-inner_download_prefix":"$name","-srtm":"no","-lang":"sv","-poly_extract":"north-europe","region":[{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"blekinge","-translate":"Blekinge län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"dalarna","-translate":"Dalecarlia;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"gavleborg","-translate":"Gävleborgs län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"gotland","-translate":"Gotlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"halland","-translate":"Hallands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"jamtland","-translate":"Jämtlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"jonkoping","-translate":"Jönköpings län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"kalmar","-translate":"Kalmar län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"kronoberg","-translate":"Kronobergs län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"norrbotten","-translate":"Norrbottens län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"orebro","-translate":"Örebro län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"ostergotland","-translate":"Östergötlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"skane","-translate":"Skåne län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"sodermanland","-translate":"Södermanlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"stockholm","-translate":"Stockholms län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"uppsala","-translate":"Uppsala län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"varmland","-translate":"Värmlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"vasterbotten","-translate":"Västerbottens län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"vasternorrland","-translate":"Västernorrlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"vastmanland","-translate":"Västmanlands län;entity=relation"},{"-map":"yes","-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"vastra-gotaland","-translate":"Västra Götalands län;entity=relation"}]},{"-name":"belarus","-lang":"be,ru","-poly_extract":"east-europe"},{"-name":"bulgaria","-lang":"bg","-poly_extract":"east-europe"},{"-name":"czech-republic","-inner_download_prefix":"$name","-translate":"Czech Republic;entity=node","-lang":"cs,sk","-poly_extract":"east-europe","-join_map_files":"yes","region":[{"-name":"jihovychod","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Southeast;ref=CZ06;entity=relation"},{"-name":"jihozapad","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Southwest;ref=CZ03;entity=relation"},{"-name":"moravskoslezsko","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Moravia-Silesia;entity=relation"},{"-name":"praha","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Prague;entity=relation"},{"-name":"severovychod","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Northeast;ref=CZ05;entity=relation"},{"-name":"severozapad","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Northwest;ref=CZ04;entity=relation"},{"-name":"stredni-cechy","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Central Bohemia;entity=relation"},{"-name":"stredni-morava","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Central Moravia;entity=relation"}]},{"-name":"hungary","-lang":"hu","-poly_extract":"east-europe"},{"-name":"moldova","-lang":"ro","-poly_extract":"east-europe"},{"-name":"poland","-inner_download_prefix":"$name","-lang":"pl","-poly_extract":"east-europe","-join_map_files":"yes","region":[{"-name":"greater-poland","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Greater Poland;entity=node"},{"-name":"kuyavian-pomeranian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Kuyavian-Pomerania;entity=node"},{"-name":"lesser-poland","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Lesser Poland;entity=node"},{"-name":"lodz","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Łódź;entity=node"},{"-name":"lower-silesian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Lower Silesia;entity=node"},{"-name":"lublin","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Lublin Voivodeship;entity=relation"},{"-name":"lubusz","-srtm":"no","-hillshade":"no","-wiki":"no"},{"-name":"masovian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Masovia;entity=node"},{"-name":"opole","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Opole Voivodeship;entity=node"},{"-name":"podlachian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Podlachia;entity=node"},{"-name":"pomeranian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Pomerania;entity=node"},{"-name":"silesian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Silesia;entity=node"},{"-name":"subcarpathian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Subcarpathia;entity=node"},{"-name":"swietokrzyskie","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Holy Cross;entity=node"},{"-name":"warmian-masurian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"Warmian-Masurian Voivodeship;entity=node"},{"-name":"west-pomeranian","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"West Pomerania;entity=node"}]},{"-name":"romania","-lang":"ro","-poly_extract":"east-europe"},{"-name":"slovakia","-lang":"sk","-poly_extract":"east-europe"},{"-name":"transnistria","-hillshade":"no","-lang":"ru,uk,ro","-poly_extract":"east-europe"},{"-name":"ukraine","-inner_download_prefix":"$name","-lang":"uk,ru","-poly_extract":"east-europe","region":[{"-name":"cherkasy","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Cherkasy Oblast;entity=relation"},{"-name":"chernihiv","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Chernihiv Oblast;entity=relation"},{"-name":"chernivtsi","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Chernivtsi Oblast;entity=relation"},{"-name":"crimea","-hillshade":"no","-srtm":"no","-wiki":"no","-boundary":"ukraine/crimea","-translate":"name:en=Autonomous Republic of Crimea;entity=relation"},{"-name":"dnipropetrovsk","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Dnipropetrovsk Oblast;entity=relation"},{"-name":"donetsk","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Donetsk Oblast;entity=relation"},{"-name":"ivano-frankivsk","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Ivano-Frankivsk Oblast;entity=relation"},{"-name":"kharkiv","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Kharkiv Oblast;entity=relation"},{"-name":"kherson","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Kherson Oblast;entity=relation"},{"-name":"khmelnytskyy","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Khmelnytskyi Oblast;entity=relation"},{"-name":"kiev","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Kyiv Oblast;entity=relation"},{"-name":"kiev-city","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Kyiv;entity=relation"},{"-name":"kirovohrad","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Kirovohrad Oblast;entity=relation"},{"-name":"luhansk","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Luhansk Oblast;entity=relation"},{"-name":"lviv","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Lviv Oblast;entity=relation"},{"-name":"mykolayiv","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Mykolaiv Oblast;entity=relation"},{"-name":"odessa","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Odessa Oblast;entity=relation"},{"-name":"poltava","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Poltava Oblast;entity=relation"},{"-name":"rivne","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Rivne Oblast;entity=relation"},{"-name":"sumy","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Sumy Oblast;entity=relation"},{"-name":"ternopil","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Ternopil Oblast;entity=relation"},{"-name":"transcarpathia","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Zakarpattia Oblast;entity=relation"},{"-name":"vinnytsya","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Vinnytsia Oblast;entity=relation"},{"-name":"volyn","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Volyn Oblast;entity=relation"},{"-name":"zaporizhzhya","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Zaporizhia Oblast;entity=relation"},{"-name":"zhytomyr","-hillshade":"no","-srtm":"no","-wiki":"no","-translate":"name:en=Zhytomyr Oblast;entity=relation"}]},{"-name":"albania","-lang":"sq","-poly_extract":"south-europe"},{"-name":"andorra","-lang":"ca","-poly_extract":"south-europe"},{"-name":"azores","-translate":"Azores;entity=relation","-hillshade":"no","-lang":"pt","-poly_extract":"south-europe"},{"-name":"bosnia-herzegovina","-translate":"Bosnia and Herzegovina;entity=node","-lang":"bs,hr,sr","-poly_extract":"south-europe"},{"-name":"croatia","-lang":"hr","-poly_extract":"south-europe"},{"-name":"cyprus","-translate":"name:en=Cyprus;entity=node","-lang":"el,tr","-left_hand_navigation":"yes","-poly_extract":"south-europe"},{"-name":"greece","-lang":"el","-poly_extract":"south-europe"},{"-name":"italy","-map":"no","-inner_download_prefix":"$name","-lang":"it","-poly_extract":"south-europe","-join_road_files":"yes","region":[{"-name":"abruzzo","-hillshade":"no"},{"-name":"basilicata","-hillshade":"no"},{"-name":"calabria","-hillshade":"no"},{"-name":"campania","-hillshade":"no"},{"-name":"emilia-romagna","-hillshade":"no"},{"-name":"friuli-venezia-giulia","-translate":"Friuli Venezia Giulia;entity=node","-hillshade":"no"},{"-name":"lazio","-hillshade":"no"},{"-name":"liguria","-hillshade":"no"},{"-name":"lombardia","-hillshade":"no"},{"-name":"marche","-hillshade":"no"},{"-name":"molise","-hillshade":"no"},{"-name":"piemonte","-hillshade":"no"},{"-name":"puglia","-hillshade":"no"},{"-name":"sardegna","-hillshade":"no"},{"-name":"sicilia","-hillshade":"no"},{"-name":"toscana","-hillshade":"no"},{"-name":"trentino-alto-adige","-translate":"Trentino-Alto Adige/Südtirol;entity=node","-hillshade":"no"},{"-name":"umbria","-hillshade":"no"},{"-name":"valle-aosta","-translate":"Valle d'Aosta;entity=node","-hillshade":"no"},{"-name":"veneto","-hillshade":"no"}]},{"-name":"kosovo","-translate":"name:en=Kosovo;entity=relation","-lang":"sq,sr","-poly_extract":"south-europe"},{"-name":"macedonia","-lang":"mk","-poly_extract":"south-europe"},{"-name":"malta","-translate":"name:en=Malta;admin_level=2;entity=relation","-lang":"mt,en","-left_hand_navigation":"yes","-poly_extract":"south-europe"},{"-name":"montenegro","-lang":"sr,bs,hr,sq","-poly_extract":"south-europe"},{"-name":"portugal","-lang":"pt","-poly_extract":"south-europe"},{"-name":"san-marino","-translate":"San Marino;entity=node","-lang":"it","-poly_extract":"south-europe"},{"-name":"serbia","-lang":"sr","-poly_extract":"south-europe"},{"-name":"slovenia","-lang":"sl","-poly_extract":"south-europe"},{"-name":"spain","-inner_download_prefix":"$name","-srtm":"no","-lang":"es,ca,gl,eu","-poly_extract":"south-europe","-join_road_files":"yes","region":[{"-name":"andalusia","-hillshade":"no"},{"-name":"aragon","-hillshade":"no"},{"-name":"asturias","-translate":"Principality of Asturias;entity=node","-hillshade":"no"},{"-name":"baleares","-translate":"Balearic Islands;entity=relation","-hillshade":"no"},{"-name":"basque-country","-translate":"Basque Country;entity=node","-hillshade":"no"},{"-name":"canarias","-translate":"Canary Islands;entity=relation","-hillshade":"no"},{"-name":"cantabria","-hillshade":"no"},{"-name":"castilla-la-mancha","-translate":"Castile-La Mancha;entity=node","-hillshade":"no"},{"-name":"castilla-leon","-translate":"Castile and León;entity=node","-hillshade":"no"},{"-name":"catalunya","-hillshade":"no"},{"-name":"ceuta","-hillshade":"no"},{"-name":"extremadura","-hillshade":"no"},{"-name":"galicia","-hillshade":"no"},{"-name":"madrid","-translate":"Community of Madrid;entity=relation","-hillshade":"no"},{"-name":"melilla","-hillshade":"no"},{"-name":"murcia","-translate":"Region of Murcia;entity=node","-hillshade":"no"},{"-name":"navarra","-translate":"name:en=Navarre;entity=relation","-hillshade":"no"},{"-name":"rioja","-translate":"Rioja;entity=relation","-hillshade":"no"},{"-name":"valencia","-translate":"Valencian Community;entity=node","-hillshade":"no"},{"-type":"hillshade","-name":"gibraltar","-translate":"name:en=Gibraltar;entity=relation","-boundary":"no"}]},{"-name":"turkey","-inner_download_prefix":"$name","-srtm":"no","-lang":"tr","-poly_extract":"south-europe","region":[{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"aegean","-translate":"Aegean Region;entity=relation"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"black-sea","-translate":"Black Sea Region;entity=relation"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"central-anatolia","-translate":"Central Anatolia Region;entity=relation"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"eastern-anatolia","-translate":"Eastern Anatolia Region;entity=relation"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"marmara","-translate":"Marmara Region;entity=relation"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"mediterranean","-translate":"Mediterranean Region;entity=relation"},{"-srtm":"yes","-hillshade":"no","-wiki":"no","-name":"southeastern-anatolia","-translate":"Southeastern Anatolia Region;entity=relation"}]},{"-name":"austria","-lang":"de","-poly_extract":"west-europe"},{"-name":"belgium","-lang":"nl,fr,de","-poly_extract":"west-europe"},{"-name":"france","-inner_download_prefix":"$name","-srtm":"no","-map":"no","-roads":"yes","-lang":"fr","-poly_extract":"france","-join_road_files":"yes","region":[{"-name":"corse","-hillshade":"no"},{"-name":"ile-de-france","-hillshade":"no"},{"-name":"pays-de-la-loire","-translate":"name:en=Pays de la Loire;entity=relation","-hillshade":"no"},{"-name":"provence-alpes-cote-d-azur","-translate":"Provence-Alpes-Côte d'Azur;entity=node","-hillshade":"no"},{"-name":"auvergne-rhone-alpes","-translate":"Rhône-Alpes;entity=node","-hillshade":"no"},{"-name":"bourgogne-franche-comte","-translate":"Bourgogne-Franche-Comté;entity=relation","-hillshade":"no"},{"-name":"brittany","-translate":"name:en=Brittany;entity=relation","-hillshade":"no"},{"-name":"centre-loire-valley","-translate":"name:en=Centre-Loire Valley;entity=relation","-hillshade":"no"},{"-name":"great-east","-translate":"name:en=Great East;entity=relation","-hillshade":"no"},{"-name":"hauts-de-france","-translate":"name=Hauts-de-France;entity=relation","-hillshade":"no"},{"-name":"new-aquitaine","-translate":"name:en=New Aquitaine;entity=relation","-hillshade":"no"},{"-name":"normandy","-translate":"name:en=Normandy;entity=relation","-hillshade":"no"},{"-name":"occitania","-translate":"name:en=Occitania;entity=relation","-hillshade":"no"}]},{"-name":"germany","-inner_download_prefix":"$name","-map":"no","-roads":"yes","-lang":"de","-poly_extract":"germany","region":[{"-name":"baden-wuerttemberg","-translate":"Baden-Württemberg;entity=node","-hillshade":"no"},{"-name":"bayern","-hillshade":"no"},{"-name":"berlin","-hillshade":"no"},{"-name":"brandenburg","-hillshade":"no"},{"-name":"bremen","-translate":"Free and Hanseatic City of Bremen;entity=node","-hillshade":"no"},{"-name":"hamburg","-hillshade":"no"},{"-name":"hessen","-hillshade":"no"},{"-name":"mecklenburg-vorpommern","-hillshade":"no"},{"-name":"niedersachsen","-hillshade":"no"},{"-name":"nordrhein-westfalen","-hillshade":"no"},{"-name":"rheinland-pfalz","-hillshade":"no"},{"-name":"saarland","-hillshade":"no"},{"-name":"sachsen","-hillshade":"no"},{"-name":"sachsen-anhalt","-hillshade":"no"},{"-name":"schleswig-holstein","-hillshade":"no"},{"-name":"thueringen","-translate":"Thuringia;entity=node","-hillshade":"no"}]},{"-name":"gb","-translate":"United Kingdom;entity=relation","-boundary":"no","-map":"no","-hillshade":"yes","-srtm":"no","-inner_download_prefix":"$name","-lang":"en","-metric":"miles","-left_hand_navigation":"yes","region":[{"-name":"scotland","-hillshade":"no","-poly_extract":"west-europe"},{"-name":"wales","-hillshade":"no","-poly_extract":"west-europe"},{"-name":"northern_ireland","-translate":"Northern Ireland;entity=relation","-hillshade":"no","-poly_extract":"west-europe"},{"-name":"england","-translate":"England;entity=relation","-inner_download_prefix":"gb_england","-hillshade":"no","-poly_extract":"west-europe","-join_map_files":"yes","region":[{"-name":"east-midlands","-translate":"East Midlands;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"east-of-england","-translate":"East of England;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"north-east-england","-translate":"North East England;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"north-west-england","-translate":"North West England;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"south-east-england","-translate":"South East;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"south-west-england","-translate":"South West England;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"west-midlands","-translate":"West Midlands;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"yorkshire-and-the-humber","-translate":"Yorkshire and the Humber;entity=relation","-srtm":"no","-hillshade":"no"},{"-name":"channel-islands","-translate":"=Channel Islands","-hillshade":"no","region":[{"-name":"jersey","-map":"no"},{"-name":"guernsey","-translate":"Guernsey;admin_level=2;entity=relation","-map":"no","-hillshade":"no"}]},{"-name":"greater-london","-translate":"Greater London;entity=relation","-srtm":"no","-hillshade":"no"}]}]},{"-name":"ireland","-lang":"ga,en","-translate":"name:en=Ireland;entity=node","-poly_extract":"west-europe","-left_hand_navigation":"yes"},{"-name":"isle-of-man","-translate":"Isle of Man;entity=relation","-lang":"en,gv","-poly_extract":"west-europe"},{"-name":"liechtenstein","-translate":"Liechtenstein;entity=relation","-lang":"de","-poly_extract":"west-europe"},{"-name":"luxembourg","-lang":"fr,de,lb","-poly_extract":"west-europe"},{"-name":"monaco","-translate":"Monaco;border_type=nation;entity=relation","-lang":"fr","-poly_extract":"west-europe"},{"-name":"netherlands","-inner_download_prefix":"$name","-translate":"The Netherlands;entity=node","-lang":"nl","-poly_extract":"west-europe","-join_map_files":"yes","region":[{"-type":"map","-name":"drenthe","-translate":"Drenthe;entity=relation"},{"-type":"map","-name":"flevoland","-translate":"Flevoland;entity=relation"},{"-type":"map","-name":"friesland","-translate":"Friesland;entity=relation"},{"-type":"map","-name":"gelderland","-translate":"Gelderland;entity=relation"},{"-type":"map","-name":"groningen","-translate":"Groningen;entity=relation"},{"-type":"map","-name":"limburg","-translate":"Limburg;entity=relation"},{"-type":"map","-name":"noord-brabant","-translate":"Noord-Brabant;entity=relation"},{"-type":"map","-name":"noord-holland","-translate":"Noord-Holland;entity=relation"},{"-type":"map","-name":"overijssel","-translate":"Overijssel;entity=relation"},{"-type":"map","-name":"utrecht","-translate":"Utrecht;entity=relation"},{"-type":"map","-name":"zeeland","-translate":"Zeeland;entity=relation"},{"-type":"map","-name":"zuid-holland","-translate":"Zuid-holland;entity=relation"}]},{"-name":"switzerland","-lang":"de,fr,it","-poly_extract":"west-europe"}]
             * -map : no
             * -hillshade : no
             * -srtm : no
             * -inner_download_prefix : $name
             * -download_suffix : asia
             * -lang : ru
             * -wiki : no
             * -left_hand_navigation : yes
             * -roads : no
             */

            @SerializedName("-type")
            private String type;
            @SerializedName("-name")
            private String name;
            @SerializedName("-translate")
            private String translate;
            @SerializedName("-inner_download_suffix")
            private String inner_download_suffix;
            @SerializedName("-boundary")
            private String boundary;
            @SerializedName("-poly_extract")
            private String poly_extract;
            @SerializedName("-map")
            private String map;
            @SerializedName("-hillshade")
            private String hillshade;
            @SerializedName("-srtm")
            private String srtm;
            @SerializedName("-inner_download_prefix")
            private String inner_download_prefix;
            @SerializedName("-download_suffix")
            private String download_suffix;
            @SerializedName("-lang")
            private String lang;
            @SerializedName("-wiki")
            private String wiki;
            @SerializedName("-left_hand_navigation")
            private String left_hand_navigation;
            @SerializedName("-roads")
            private String roads;
            private List<RegionBeanXX> region;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTranslate() {
                return translate;
            }

            public void setTranslate(String translate) {
                this.translate = translate;
            }

            public String getInner_download_suffix() {
                return inner_download_suffix;
            }

            public void setInner_download_suffix(String inner_download_suffix) {
                this.inner_download_suffix = inner_download_suffix;
            }

            public String getBoundary() {
                return boundary;
            }

            public void setBoundary(String boundary) {
                this.boundary = boundary;
            }

            public String getPoly_extract() {
                return poly_extract;
            }

            public void setPoly_extract(String poly_extract) {
                this.poly_extract = poly_extract;
            }

            public String getMap() {
                return map;
            }

            public void setMap(String map) {
                this.map = map;
            }

            public String getHillshade() {
                return hillshade;
            }

            public void setHillshade(String hillshade) {
                this.hillshade = hillshade;
            }

            public String getSrtm() {
                return srtm;
            }

            public void setSrtm(String srtm) {
                this.srtm = srtm;
            }

            public String getInner_download_prefix() {
                return inner_download_prefix;
            }

            public void setInner_download_prefix(String inner_download_prefix) {
                this.inner_download_prefix = inner_download_prefix;
            }

            public String getDownload_suffix() {
                return download_suffix;
            }

            public void setDownload_suffix(String download_suffix) {
                this.download_suffix = download_suffix;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public String getWiki() {
                return wiki;
            }

            public void setWiki(String wiki) {
                this.wiki = wiki;
            }

            public String getLeft_hand_navigation() {
                return left_hand_navigation;
            }

            public void setLeft_hand_navigation(String left_hand_navigation) {
                this.left_hand_navigation = left_hand_navigation;
            }

            public String getRoads() {
                return roads;
            }

            public void setRoads(String roads) {
                this.roads = roads;
            }

            public List<RegionBeanXX> getRegion() {
                return region;
            }

            public void setRegion(List<RegionBeanXX> region) {
                this.region = region;
            }

            public static class RegionBeanXX {
                /**
                 * -name : denmark
                 * -lang : da
                 * -poly_extract : north-europe
                 * -translate : Faroe Islands;entity=node
                 * -inner_download_prefix : $name
                 * -srtm : no
                 * region : [{"-map":"no","-name":"aland","-translate":"name:fi=Ahvenanmaa;admin_level=3;entity=relation"},{"-type":"srtm","-name":"eastern-finland","-translate":"Eastern Finland;entity=relation"},{"-name":"northern-finland","-map":"no","-srtm":"no","-hillshade":"no","-wiki":"no","-translate":"name:en=Northern Finland;entity=relation","-boundary":"no","region":[{"-type":"srtm","-name":"lapland","-translate":"Lapland;entity=relation"},{"-type":"srtm","-name":"northern-ostrobothnia","-translate":"name:en=Northern Ostrobothnia;entity=relation"}]},{"-type":"srtm","-name":"southern-finland","-translate":"Southern Finland;entity=relation"},{"-type":"srtm","-name":"western-finland","-translate":"Western Finland;entity=relation"}]
                 * -join_map_files : yes
                 * -hillshade : no
                 * -left_hand_navigation : yes
                 * -map : no
                 * -join_road_files : yes
                 * -roads : yes
                 * -boundary : no
                 * -metric : miles
                 */

                @SerializedName("-name")
                private String name;
                @SerializedName("-lang")
                private String lang;
                @SerializedName("-poly_extract")
                private String poly_extract;
                @SerializedName("-translate")
                private String translate;
                @SerializedName("-inner_download_prefix")
                private String inner_download_prefix;
                @SerializedName("-srtm")
                private String srtm;
                @SerializedName("-join_map_files")
                private String join_map_files;
                @SerializedName("-hillshade")
                private String hillshade;
                @SerializedName("-left_hand_navigation")
                private String left_hand_navigation;
                @SerializedName("-map")
                private String map;
                @SerializedName("-join_road_files")
                private String join_road_files;
                @SerializedName("-roads")
                private String roads;
                @SerializedName("-boundary")
                private String boundary;
                @SerializedName("-metric")
                private String metric;
                private List<RegionBeanX> region;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLang() {
                    return lang;
                }

                public void setLang(String lang) {
                    this.lang = lang;
                }

                public String getPoly_extract() {
                    return poly_extract;
                }

                public void setPoly_extract(String poly_extract) {
                    this.poly_extract = poly_extract;
                }

                public String getTranslate() {
                    return translate;
                }

                public void setTranslate(String translate) {
                    this.translate = translate;
                }

                public String getInner_download_prefix() {
                    return inner_download_prefix;
                }

                public void setInner_download_prefix(String inner_download_prefix) {
                    this.inner_download_prefix = inner_download_prefix;
                }

                public String getSrtm() {
                    return srtm;
                }

                public void setSrtm(String srtm) {
                    this.srtm = srtm;
                }

                public String getJoin_map_files() {
                    return join_map_files;
                }

                public void setJoin_map_files(String join_map_files) {
                    this.join_map_files = join_map_files;
                }

                public String getHillshade() {
                    return hillshade;
                }

                public void setHillshade(String hillshade) {
                    this.hillshade = hillshade;
                }

                public String getLeft_hand_navigation() {
                    return left_hand_navigation;
                }

                public void setLeft_hand_navigation(String left_hand_navigation) {
                    this.left_hand_navigation = left_hand_navigation;
                }

                public String getMap() {
                    return map;
                }

                public void setMap(String map) {
                    this.map = map;
                }

                public String getJoin_road_files() {
                    return join_road_files;
                }

                public void setJoin_road_files(String join_road_files) {
                    this.join_road_files = join_road_files;
                }

                public String getRoads() {
                    return roads;
                }

                public void setRoads(String roads) {
                    this.roads = roads;
                }

                public String getBoundary() {
                    return boundary;
                }

                public void setBoundary(String boundary) {
                    this.boundary = boundary;
                }

                public String getMetric() {
                    return metric;
                }

                public void setMetric(String metric) {
                    this.metric = metric;
                }

                public List<RegionBeanX> getRegion() {
                    return region;
                }

                public void setRegion(List<RegionBeanX> region) {
                    this.region = region;
                }

                public static class RegionBeanX {
                    /**
                     * -map : no
                     * -name : aland
                     * -translate : name:fi=Ahvenanmaa;admin_level=3;entity=relation
                     * -type : srtm
                     * -srtm : no
                     * -hillshade : no
                     * -wiki : no
                     * -boundary : no
                     * region : [{"-type":"srtm","-name":"lapland","-translate":"Lapland;entity=relation"},{"-type":"srtm","-name":"northern-ostrobothnia","-translate":"name:en=Northern Ostrobothnia;entity=relation"}]
                     */

                    @SerializedName("-map")
                    private String map;
                    @SerializedName("-name")
                    private String name;
                    @SerializedName("-translate")
                    private String translate;
                    @SerializedName("-type")
                    private String type;
                    @SerializedName("-srtm")
                    private String srtm;
                    @SerializedName("-hillshade")
                    private String hillshade;
                    @SerializedName("-wiki")
                    private String wiki;
                    @SerializedName("-boundary")
                    private String boundary;
                    private List<RegionBean> region;

                    public String getMap() {
                        return map;
                    }

                    public void setMap(String map) {
                        this.map = map;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTranslate() {
                        return translate;
                    }

                    public void setTranslate(String translate) {
                        this.translate = translate;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getSrtm() {
                        return srtm;
                    }

                    public void setSrtm(String srtm) {
                        this.srtm = srtm;
                    }

                    public String getHillshade() {
                        return hillshade;
                    }

                    public void setHillshade(String hillshade) {
                        this.hillshade = hillshade;
                    }

                    public String getWiki() {
                        return wiki;
                    }

                    public void setWiki(String wiki) {
                        this.wiki = wiki;
                    }

                    public String getBoundary() {
                        return boundary;
                    }

                    public void setBoundary(String boundary) {
                        this.boundary = boundary;
                    }

                    public List<RegionBean> getRegion() {
                        return region;
                    }

                    public void setRegion(List<RegionBean> region) {
                        this.region = region;
                    }

                    public static class RegionBean {
                        /**
                         * -type : srtm
                         * -name : lapland
                         * -translate : Lapland;entity=relation
                         */

                        @SerializedName("-type")
                        private String type;
                        @SerializedName("-name")
                        private String name;
                        @SerializedName("-translate")
                        private String translate;

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getTranslate() {
                            return translate;
                        }

                        public void setTranslate(String translate) {
                            this.translate = translate;
                        }
                    }
                }
            }
        }
    }
}
