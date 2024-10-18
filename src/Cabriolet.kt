import model.Car
import java.awt.Color

class Cabriolet(color: Color,
                gosNomer: Int,
                model: String, countFlying: Int
): Car(color, gosNomer, model, countFlying) {
    var stateRoof: Boolean = false;

    override fun makeSignal() {
        println("Тихий звук")
    }
    fun changeStateRoof(){
        stateRoof = !stateRoof
    }

}