package mmo

import kotlin.random.Random

class Knight(health: Float,
             power: Float,
             private var armor: Float
) : Human(health, power), IDamageable {
    override fun attack(enemy: IDamageable) {
        val damage = this.power + Random.nextInt(0, this.armor.toInt())
        println("Рыцарь атакует ${enemy.toString()} и наносит $damage урона!")
        enemy.takeDamage(damage)
    }

    override fun heal() {
        val healAmount = 10 + Random.nextInt(1, 32)
        this.health += healAmount
        println("Рыцарь восстанавливает $healAmount здоровья!")
    }

    override fun takeDamage(damage: Float) {
        if (this.armor > 0)
        {
            this.armor -= Random.nextFloat() * 5
        }
        val reducedDamage = if (this.armor > 0)
        {
            this.armor * Random.nextFloat()
        }
        else
        {
            damage
        }
        this.health -= reducedDamage

        if (isAlive && this.health <= 0)
        {
            println("Рыцарь погиб!")
            isAlive = false
            return
        }

        this.heal()
        println("Рыцарь получил $damage урона! Осталось здоровья: $health")
    }
}