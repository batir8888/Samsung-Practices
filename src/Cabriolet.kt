import model.Car
import java.awt.Color

class Cabriolet(
    color: Color,
    gosNomer: Int,
    model: String
): Car(color, gosNomer, model) {
    var stateRoof: Boolean = false;

    override fun makeSignal() {
        println("Тихий звук")
    }
    fun changeStateRoof(){
        stateRoof = !stateRoof
    }

}