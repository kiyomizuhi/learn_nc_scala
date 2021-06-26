class RPG {

}

abstract class Creature(var hitPoint: Int, attackDamage: Int) {
  def isAlive(): Boolean = this.hitPoint > 0
}

class Hero(_hitPoint: Int, _attackDamage: Int)
  extends Creature(_hitPoint, _attackDamage) {
  def attack(monster: Monster): Unit = ???

  def escape(monster: Monster): Boolean = ???

  override def toString: String = s"Hero: = HP: ${_hitPoint}, DG: ${_attackDamage}"
}

class Monster(_hitPoint: Int, _attackDamage: Int, isAwayFromHero: Boolean)
  extends Creature(_hitPoint, _attackDamage) {

  override def toString: String = s"Hero: = HP: ${_hitPoint}, DG: ${_attackDamage}, AW: ${isAwayFromHero}}"
}