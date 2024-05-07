package com.example.touristpath.data

import com.example.touristpath.R

data class PathObject(
    val title: String,
    val description: String,
    val imageResId: Int,
    val easy: Boolean = false
)

val pathList = listOf(
    PathObject(
        "Giewont - Tatrzański Śpiący Rycerz",
        "Masyw Giewontu, dominujący nad Zakopanem, jest popularnym celem wycieczek. Szlak prowadzi przez Dolinę Strążyską, obok wodospadu Siklawica, i wymaga pokonania łańcuchów. Czas przejścia w obie strony to około 6 godzin. Pamiętaj o potencjalnym niebezpieczeństwie podczas burz.",
        R.drawable.giewont,
        easy = false
    ),

    PathObject(
        "Dolina Strążyska i Sarnia Skała",
        "Dolina Strążyska, idealna na spacery z rodziną, oferuje łatwy dostęp do wodospadu Siklawica. Z Polany Strążyskiej można wyruszyć na Sarnią Skałę, skąd rozpościerają się widoki na Giewont i okolicę. Wycieczka trwa około 50 minut.",
        R.drawable.strazyska,
        easy = true
    ),

    PathObject(
        "Nosal",
        "Nosal to szczyt oferujący znakomite widoki, w szczególności na zachód słońca. Wejście z Kuźnic zajmuje około 45 minut. Szlak jest relatywnie łatwy i dostępny dla większości turystów.",
        R.drawable.nosal,
        easy = true
    ),

    PathObject(
        "Hala Gąsienicowa i Czarny Staw Gąsienicowy",
        "Wizyta na Hali Gąsienicowej to doskonała okazja, by spróbować szarlotki w schronisku Murowaniec. Trasa z Kuźnic jest dobrze oznakowana i dostępna dla turystów.",
        R.drawable.gasienicowa,
        easy = false
    ),

    PathObject(
        "Szlak na Rysy",
        "Jedna z najbardziej wymagających tras w polskich Tatrach, prowadząca na Rysy. Szlak jest dobrze zabezpieczony, ale wymaga dobrej kondycji i zdolności wspinaczkowych. Czas przejścia to około 9,5 godziny w jednym kierunku.",
        R.drawable.rysy,
        easy = false
    ),

    PathObject(
        "Szlak przez Wołowiec do Starorobociańskiego Wierchu",
        "Trasa przez Wołowiec do Starorobociańskiego Wierchu jest kondycyjnie wymagająca, ale oferuje piękne widoki i mniejsze tłumy. Czas przejścia wynosi około 5 godzin.",
        R.drawable.wolowiec
    ),

    PathObject(
        "Trasy wokół Polany Chochołowskiej i Jarząbczych Szałasisk",
        "Oferują niemal zamkniętą pętlę o czasie przejścia około 4 godzin. Szlak papieski, będący częścią trasy, jest dodatkowo oznakowany i upamiętnia wizytę Jana Pawła II.",
        R.drawable.chocholowska,
        easy = true
    ),


    PathObject(
        "Z Palenicy Białczańskiej do Wodospadu Siklawica",
        "Szlak prowadzący przez Dolinę Roztoki do największego wodospadu w Polsce, idealny dla początkujących i rodzin z dziećmi. Trasa ta oferuje wspaniałe widoki oraz kontakt z tatrzańską przyrodą.",
        R.drawable.siklawica,
        easy = true
    ),

    PathObject(
        "Hala Gąsieniowa i Czarny Staw Gąsienicowy",
        "Popularna trasa z Zakopanego na Halę Gąsienicową i dalej do Czarnego Stawu Gąsienicowego. ,Szlak ten jest często wybierany ze względu na piękne krajobrazy i dostępność.",
        R.drawable.gasienicowa,
        easy = true
    ),

    PathObject(
        "Droga do Morskiego Oka",
        "Choć podejście może wydawać się mniej interesujące, samo Morskie Oko jest jednym z najpiękniejszych jezior w Tatrach, co czyni tę trasę wartą odwiedzenia.",
        R.drawable.morskie_oko,
        easy = true
    ),

    PathObject(
        "Szlak na Kościelec",
        "Jedna z najpiękniejszych tras w Tatrach, prowadząca przez Halę Gąsienicową na Kościelec, oferująca imponujące panoramy.",
        R.drawable.koscielec,
        easy = false
    ),

    PathObject(
        "Przełęcz Zawrat i Przełęcz Krzyżne",
        "Te dwie popularne przełęcze w Tatrach Wysokich oferują malownicze i ciekawe trasy, często uznawane za jedne z najpiękniejszych w Tatrach.",
        R.drawable.zawrat
    ),

    PathObject(
        "Dolina Kościeliska i Czerwone Wierchy",
        "Jedna z najciekawszych tras w Tatrach Zachodnich, szczególnie piękna jesienią, prowadząca przez malownicze tereny.",
        R.drawable.koscieliska,
        easy = false
    ),

    PathObject(
        "Kasprowy Wierch przez Myślenickie Turnie",
        "Popularny szczyt, na który można wejść pieszo lub wjechać kolejką, oferujący szerokie panoramy Tatr.",
        R.drawable.kasprowy
    ),

    PathObject(
        "Dolina Gąsienicowa i Schronisko Murowaniec",
        "Szlak prowadzący do jednej z najpiękniejszych dolin w Tatrach, z widokiem na tatrzańskie szczyty i możliwością odpoczynku w schronisku.",
        R.drawable.gasienicowa,
        easy = true
    ),

    PathObject(
        "Grześ, Rakoń i Wołowiec",
        "Popularne trio w Tatrach Zachodnich, często wybierane na początek tatrzańskich przygód ze względu na ich dostępność i piękne widoki.",
        R.drawable.grzes,
        easy = true
    )


)