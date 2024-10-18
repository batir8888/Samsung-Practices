package mmo

fun readEntityParameters(name: String): List<Float> {
    println("Введите здоровье, силу и дополнительный параметр для $name:")
    return readln().split(" ").map { it.toFloat() }
}

fun main(){
    // Создание сущностей
    val wizardParams = readEntityParameters("Мага")
    val robotParams = readEntityParameters("Робота")
    val knightParams = readEntityParameters("Рыцаря")

    val wizard = Wizard(wizardParams[0], wizardParams[1], wizardParams[2])
    val robot = Robot(robotParams[0], robotParams[1], robotParams[2])
    val knight = Knight(knightParams[0], knightParams[1], knightParams[2])

    val entities = listOf<Human>(wizard, robot, knight)
    val names = listOf("Маг", "Робот", "Рыцарь")

    println("Введите порядок действий (формат: атакующий цель):")
    val actions = mutableListOf<Pair<Int, Int>>()
    while (true) {
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) break
        val indices = input.split(" ").map { it.toInt() }
        actions.add(Pair(indices[0], indices[1]))
    }

    // Игровой цикл
    for ((attackerIndex, targetIndex) in actions) {
        val attacker = entities[attackerIndex]
        val target = entities[targetIndex]

        if (!attacker.isAlive) {
            println("${names[attackerIndex]} не может атаковать, так как повержен!")
            continue
        }
        if (!target.isAlive) {
            println("${names[targetIndex]} уже повержен!")
            continue
        }

        attacker.attack(target as IDamageable)

        if (!target.isAlive) {
            println("${names[targetIndex]} повержен!")
            break
        }
    }

    // Вывод статистики
    println("\nСтатистика игры:")
    for (i in entities.indices) {
        val health = if (entities[i].health < 0) 0 else entities[i].health
        println("${names[i]} - $health hp")
    }
}