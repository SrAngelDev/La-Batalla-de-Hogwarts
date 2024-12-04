package srangeldev.models

/**
 * Representa un enemigo en la batalla.
 *
 * @property maxEnergy Energía máxima.
 * @property type Tipo de enemigo.
 */
class Enemy private constructor(
    var maxEnergy: Int,
    val type: Type,
) {
    val color: String
        get() {
            return when (type) {
                Type.INFERI1 -> "[💛]"
                Type.INFERI2 -> "[🧡]"
                Type.MORTIFAGO -> "[❤️]"
            }
        }

    companion object {
        fun random(): Enemy {
            val random = (1..100).random()
            return when {
                random <= 40 -> Enemy(50, Type.INFERI1)
                random <= 70 -> Enemy(50, Type.INFERI2)
                else -> {Enemy((100..150).random(), Type.MORTIFAGO,)}
            }
        }
    }

    val isAlive: Boolean
        get() = maxEnergy > 0

    override fun toString(): String {
        return "Enemigo(tipo=$type, Energía Máxima=$maxEnergy)"
    }

    enum class Type {
        INFERI1, INFERI2, MORTIFAGO
    }
}
