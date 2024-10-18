package model

import IFly
import ISwim
import java.awt.Color

open class Car(
    private var color: Color,
    val gosNomer: Int,
    private val model: String
): IFly, ISwim{
    companion object{
        var count:Int = 0 // статичная переменная

        fun countIncrease(){ // статичная функция
            count++
        }
    }

    open fun makeSignal(){
        println("Громкий звук")
        countIncrease()
    }
    fun reDraw(newColor: Color){
        this.color = newColor
    }

    // getter setter

    fun getColor():Color{
        return this.color
    }
    fun setColor(color: Color) {
        this.color = color
    }

    override fun toString(): String {
        return "Car(gosNomer=$gosNomer)"
    }

    override fun fly() {
        super.fly()
        // научил машину летать
    }

    override fun swim() {
        // научил машину плавать
    }
}