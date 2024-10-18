import model.Car
import java.awt.Color

class Gruzovik(color: Color,
               gosNomer: Int,
               model: String,
               var destination: Destination, countFlying: Int
): Car(color, gosNomer, model, countFlying) {

    // полиморфизм
    override fun makeSignal() {
        println("Very громкий звук")
    }
}