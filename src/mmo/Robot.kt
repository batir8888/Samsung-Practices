package mmo

import kotlin.math.log
import kotlin.random.Random

class Robot(health: Float,
            power: Float,
            private var battery: Float
) : Human(health, power), IDamageable {
    override fun attack(enemy: IDamageable) {
        if (this.battery >= 10)
        {
            val damage = this.power * log((1 + this.battery * 10).toDouble(), 25.0).toFloat()
            println("Робот атакует и наносит $damage урона!")
            enemy.takeDamage(damage)
            this.battery -= 10
        }
        else
        {
            val damage = this.power
            println("Робот атакует и наносит $damage урона!")
            enemy.takeDamage(damage)
        }
    }

    override fun heal() {
        if (this.battery >= 5){
            val healAmount = this.battery * Random.nextFloat() / 5
            this.health += healAmount
            println("Робот восстанавливает $healAmount здоровья!")
        }
    }

    override fun takeDamage(damage: Float) {
        if (this.battery > 0)
        {
            this.health -= damage
            if (isAlive && this.health <= 0)
            {
                println("Робот погиб!")
                isAlive = false
                return
            }
            this.heal()
        }
        else
        {
            this.health -= damage
            if (isAlive && this.health <= 0)
            {
                println("Робот погиб!")
                isAlive = false
                return
            }
        }
    }
}