package com.kotlin.motivation.infra

class MotivationConstants private constructor() {

    object KEY {
        const val USER_NAME = "USER_NAME"
    }

    object FILTER {
        const val ALL = 1
        const val EMOTICON = 2
        const val LIGHT = 3
    }

    object LANGUAGUE {
        const val PORTUGUESE = "pt"
        const val ENGLISH = "en"
        const val FRENCH = "fr"
    }
}