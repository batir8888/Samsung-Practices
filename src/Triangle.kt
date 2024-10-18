class Triangle(
    val base: Double,
    val height: Double
): Shape() {
    override fun getArea(): Double {
        return base * height / 2
    }
}