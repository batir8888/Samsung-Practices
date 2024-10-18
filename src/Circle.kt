import java.lang.Math.pow
import kotlin.math.PI

class Circle(
    val radius: Double
): Shape() {
    override fun getArea(): Double {
        return PI * pow(radius, 2.0)
    }
}