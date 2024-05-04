package com.example.touristpath.data

import com.example.touristpath.R

data class PathObject(
    val title: String,
    val description: String,
    val imageResId: Int = R.drawable.giewont
)

val pathList = listOf(
    PathObject(
        "Giewont - Tatrzański Śpiący Rycerz",
        "Masyw Giewontu, dominujący nad Zakopanem, jest popularnym celem wycieczek. Szlak prowadzi przez Dolinę Strążyską, obok wodospadu Siklawica, i wymaga pokonania łańcuchów. Czas przejścia w obie strony to około 6 godzin. Pamiętaj o potencjalnym niebezpieczeństwie podczas burz."
    ),

    PathObject(
        "Dolina Strążyska i Sarnia Skała",
        "Dolina Strążyska, idealna na spacery z rodziną, oferuje łatwy dostęp do wodospadu Siklawica. Z Polany Strążyskiej można wyruszyć na Sarnią Skałę, skąd rozpościerają się widoki na Giewont i okolicę. Wycieczka trwa około 50 minut."
    ),

    PathObject(
        "Nosal",
        "Nosal to szczyt oferujący znakomite widoki, w szczególności na zachód słońca. Wejście z Kuźnic zajmuje około 45 minut. Szlak jest relatywnie łatwy i dostępny dla większości turystów."
    ),

    PathObject(
        "Hala Gąsienicowa i Czarny Staw Gąsienicowy",
        "Wizyta na Hali Gąsienicowej to doskonała okazja, by spróbować szarlotki w schronisku Murowaniec. Trasa z Kuźnic jest dobrze oznakowana i dostępna dla turystów."
    ),

    PathObject(
        "Szlak na Rysy",
        "Jedna z najbardziej wymagających tras w polskich Tatrach, prowadząca na Rysy. Szlak jest dobrze zabezpieczony, ale wymaga dobrej kondycji i zdolności wspinaczkowych. Czas przejścia to około 9,5 godziny w jednym kierunku."
    ),

    PathObject(
        "Szlak przez Wołowiec do Starorobociańskiego Wierchu",
        "Trasa przez Wołowiec do Starorobociańskiego Wierchu jest kondycyjnie wymagająca, ale oferuje piękne widoki i mniejsze tłumy. Czas przejścia wynosi około 5 godzin."
    ),

    PathObject(
        "Trasy wokół Polany Chochołowskiej i Jarząbczych Szałasisk",
        "Oferują niemal zamkniętą pętlę o czasie przejścia około 4 godzin. Szlak papieski, będący częścią trasy, jest dodatkowo oznakowany i upamiętnia wizytę Jana Pawła II."
    ),


    PathObject(
        "Z Palenicy Białczańskiej do Wodospadu Siklawica",
        "Szlak prowadzący przez Dolinę Roztoki do największego wodospadu w Polsce, idealny dla początkujących i rodzin z dziećmi. Trasa ta oferuje wspaniałe widoki oraz kontakt z tatrzańską przyrodą."
    ),

    PathObject(
        "Hala Gąsieniowa i Czarny Staw Gąsienicowy",
        "Popularna trasa z Zakopanego na Halę Gąsienicową i dalej do Czarnego Stawu Gąsienicowego. Szlak ten jest często wybierany ze względu na piękne krajobrazy i dostępność."
    ),

    PathObject(
        "Droga do Morskiego Oka",
        "Choć podejście może wydawać się mniej interesujące, samo Morskie Oko jest jednym z najpiękniejszych jezior w Tatrach, co czyni tę trasę wartą odwiedzenia."
    ),

    PathObject(
        "Szlak na Rysy",
        "Prowadzący z nad Morskiego Oka, jest to szlak na najwyższy szczyt Polski, oferujący wyjątkowe widoki i wyzwania dla bardziej doświadczonych turystów."
    ),

    PathObject(
        "Szlak na Kościelec",
        "Jedna z najpiękniejszych tras w Tatrach, prowadząca przez Halę Gąsienicową na Kościelec, oferująca imponujące panoramy."
    ),

    PathObject(
        "Przełęcz Zawrat i Przełęcz Krzyżne",
        "Te dwie popularne przełęcze w Tatrach Wysokich oferują malownicze i ciekawe trasy, często uznawane za jedne z najpiękniejszych w Tatrach."
    ),

    PathObject(
        "Dolina Kościeliska i Czerwone Wierchy",
        "Jedna z najciekawszych tras w Tatrach Zachodnich, szczególnie piękna jesienią, prowadząca przez malownicze tereny."
    ),

    PathObject(
        "Kasprowy Wierch przez Myślenickie Turnie",
        "Popularny szczyt, na który można wejść pieszo lub wjechać kolejką, oferujący szerokie panoramy Tatr."
    ),

    PathObject(
        "Dolina Gąsienicowa i Schronisko Murowaniec",
        "Szlak prowadzący do jednej z najpiękniejszych dolin w Tatrach, z widokiem na tatrzańskie szczyty i możliwością odpoczynku w schronisku."
    ),

    PathObject(
        "Grześ, Rakoń i Wołowiec",
        "Popularne trio w Tatrach Zachodnich, często wybierane na początek tatrzańskich przygód ze względu na ich dostępność i piękne widoki."
    )


)