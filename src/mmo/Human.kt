package mmo

abstract class Human(
    var health: Float,
    protected val power: Float)
{
    open var isAlive = true
    abstract fun attack(enemy: IDamageable)
    abstract fun heal()
}