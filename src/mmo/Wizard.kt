package mmo

import kotlin.random.Random

class Wizard(health:Float,
             power:Float,
             private var mana:Float
) : Human(health, power), IDamageable {
    override fun attack(enemy: IDamageable) {
        if (this.mana >= 20)
        {
            val damage = this.power + this.power * Random.nextFloat()
            println("Маг атакует и наносит $damage урона!")
            enemy.takeDamage(damage)
            this.mana -= 20
        }
        else
        {
            val damage = this.power * Random.nextFloat()
            println("Маг атакует и наносит $damage урона!")
            enemy.takeDamage(damage)
        }
    }

    override fun heal() {
        if (this.mana >= 10)
        {
            val healAmount = this.mana * Random.nextFloat()
            this.health += healAmount
            println("Маг исцеляется на $healAmount здоровья!")
            this.mana -= 10
        }
    }

    override fun takeDamage(damage: Float) {
        this.health -= damage
        if (isAlive && this.health <= 0)
        {
            println("Маг погиб!")
            isAlive = false
            return
        }
        this.heal()
        println("Маг получил $damage урона! Осталось здоровья: $health")
    }
}