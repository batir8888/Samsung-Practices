import model.Car
import java.awt.Color

class Gruzovik(
    color: Color,
    gosNomer: Int,
    model: String,
    var destination: Destination
): Car(color, gosNomer, model) {

    // полиморфизм
    override fun makeSignal() {
        println("Very громкий звук")
    }
}