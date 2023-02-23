package com.example.lessontexnopos.entity

object QuestionsList {

    fun getQuestion(): MutableList<Questions> {

        var sorawlar = mutableListOf<Questions>()
        sorawlar.add(Questions(
            1,
            "Uzbekistannin paytaxti ?",
            "Nukus",
            "Samarkand",
            "Qarshi",
            "Tashkent",
            4
        ))
        sorawlar.add(
            Questions(
            2,
            "Hazir qaysi jil ?",
            "2022",
            "2021",
            "2023",
            "2019",
            3
        )
        )
        sorawlar.add(
            Questions(
            3,
            "2+2*2 ?",
            "6",
            "8",
            "10",
            "4",
            1
        )
        )
        sorawlar.add(
            Questions(
                4,
                "Jer juzinde neshe okean bar?",
                "4",
                "5",
                "6",
                "3",
                2
            )
        )
        sorawlar.add(
            Questions(
                5,
                "Jer juzinde en uzin darya?",
                "Amazonka",
                "Yandzy",
                "Kizketken",
                "Nil",
                4
            )
        )

        return sorawlar
    }

}