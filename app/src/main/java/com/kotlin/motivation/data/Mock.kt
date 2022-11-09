package com.kotlin.motivation.data

import com.kotlin.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int, val lang: String)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val emoticon = MotivationConstants.FILTER.EMOTICON
    private val light = MotivationConstants.FILTER.LIGHT

    private val pt = MotivationConstants.LANGUAGUE.PORTUGUESE
    private val en = MotivationConstants.LANGUAGUE.ENGLISH
    private val fr = MotivationConstants.LANGUAGUE.FRENCH

    private val listPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", emoticon, pt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", emoticon, pt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", emoticon, pt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            emoticon,
            pt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", emoticon, pt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            emoticon,
            pt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", light, pt),
        Phrase("Você perde todas as chances que você não aproveita.", light, pt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", light, pt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", light, pt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", light, pt),
        Phrase("Se você acredita, faz toda a diferença.", light, pt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", light, pt),
        Phrase("Not knowing it was impossible, he went there and did it.", emoticon, en),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            emoticon,
            en
        ),
        Phrase("When it's darker, we see more stars!", emoticon, en),
        Phrase(
            "Insanity is doing the same thing over and over and expecting a different result.",
            emoticon,
            en
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", emoticon, en),
        Phrase(
            "What can you do now that has the biggest impact on your success?",
            emoticon,
            en
        ),
        Phrase("The best way to predict the future is to invent it.", light, en),
        Phrase("You miss every chance you don't take.", light, en),
        Phrase("Failure is the condiment that gives the flavor of success.", light, en),
        Phrase("As long as we are not committed, there will be hesitation!", light, en),
        Phrase("If you don't know where you want to go, any path will do.", light, en),
        Phrase("If you believe, it makes all the difference.", light, en),
        Phrase("Risks must be taken, because the greatest danger is to risk nothing!", light, en),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", emoticon, fr),
        Phrase(
            "Vous n'êtes pas vaincu lorsque vous perdez, vous êtes vaincu lorsque vous abandonnez !",
            emoticon,
            fr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles !", emoticon, fr),
        Phrase(
            "La folie, c'est faire la même chose encore et encore et s'attendre à un résultat différent.",
            emoticon,
            fr
        ),
        Phrase(
            "Ne vous arrêtez pas lorsque vous êtes fatigué, arrêtez-vous lorsque vous avez terminé.",
            emoticon,
            fr
        ),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus d'impact sur votre réussite ?",
            emoticon,
            fr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", light, fr),
        Phrase("Vous ratez toutes les chances que vous ne saisissez pas.", light, fr),
        Phrase("L'échec est le condiment qui donne le goût du succès.", light, fr),
        Phrase("Tant qu'on ne s'engage pas, il y aura de l'hésitation !", light, fr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quel chemin fera l'affaire.",
            light,
            fr
        ),
        Phrase("Si vous y croyez, cela fait toute la différence.", light, fr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer !",
            light,
            fr
        )
    )

    fun getPhrase(type: Int, lang: String): String {
        val newList = listPhrase.filter {
            (it.categoryId == type || type == all) && it.lang == lang
        }
        val index = Random.nextInt(newList.size)
        return newList[index].description
    }
}