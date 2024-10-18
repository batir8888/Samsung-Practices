class Rectangle(
    val width: Double,
    val height: Double
): Shape() {
    override fun getArea(): Double {
        println("Площадь прямоугольника: ${width * height}")
        return width*height
    }
}