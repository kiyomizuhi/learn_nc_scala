import java.util.Random

object RPG extends App {
  val random = new Random
  val monsterCount = 5
  val hero = new Hero(200, 30)
  var monsters = for (i <- 1 to monsterCount) yield new Monster(random.nextInt(120), random.nextInt(120), false)

  println("kaka")

  while (!monsters.isEmpty) {
    val monster = monsters.head
    val input = scala.io.StdIn.readLine("battle[1] or escape[0]")

    if (input == "1") {
      hero.attack(monster)
      println(s"h->m: ${hero.attackDamage}, m->h: ${monster.attackDamage}")
    } else {
      if (hero.escape(monster)) {
        println("succeeded in escape!")
      } else {
        println(s"failed to escape! m->h: ${monster.attackDamage}")
      }
    }
    println(s"present status: ${hero}, ${monster}")

    if (!hero.isAlive()) {
      println("you're dead")
      System.exit(0)
    } else if (!monster.isAlive || monster.isAwayFromHero) {
      if (!monster.isAwayFromHero) {
        println("defeated the monster. obtained its weapon")
        if (monster.attackDamage > hero.attackDamage) hero.attackDamage = monster.attackDamage
      }
      monsters = monsters.tail
      println(s"the num of the remaining monsters: ${monsters.length}")
      if (monsters.length > 0) {
        println("a new monster showed up")
      }
    }
  }

  println("cleared this game!")
  System.exit(0)
}

abstract class Creature(var hitPoint: Int, var attackDamage: Int) {
  def isAlive(): Boolean = this.hitPoint > 0
}

class Hero(_hitPoint: Int, _attackDamage: Int) extends Creature(_hitPoint, _attackDamage) {

  def attack(monster: Monster): Unit = {
    monster.hitPoint = monster.hitPoint - this.attackDamage
    this.hitPoint = this.hitPoint - monster.attackDamage
  }

  def escape(monster: Monster): Boolean = {
    val isEscape = RPG.random.nextInt(2) == 1
    if (!isEscape) {
      this.hitPoint = this.hitPoint - monster.attackDamage
    } else {
      monster.isAwayFromHero = true
    }
    isEscape
  }

  override def toString = s"Hero(体力:${hitPoint}, 攻撃力:${attackDamage})"

}

class Monster(_hitPoint: Int, _attackDamage: Int, var isAwayFromHero: Boolean)
  extends  Creature(_hitPoint, _attackDamage) {

  override def toString = s"Monster(体力: ${hitPoint}, 攻撃力:${attackDamage}, ヒーローから離れている:${isAwayFromHero})"

}