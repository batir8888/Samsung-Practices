import model.Car

class CustomComparator: Comparator<Car> {
    override fun compare(o1: Car?, o2: Car?): Int {
        if (o1?.gosNomer == o2?.gosNomer){
            return 0
        }
        else if (o1!!.gosNomer > o2!!.gosNomer){
            return 1
        }
        else{
            return -1
        }
    }
}