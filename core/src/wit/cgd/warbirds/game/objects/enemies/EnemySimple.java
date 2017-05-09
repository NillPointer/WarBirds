package wit.cgd.warbirds.game.objects.enemies;

import wit.cgd.warbirds.game.Assets;
import wit.cgd.warbirds.game.objects.Level;
import wit.cgd.warbirds.game.objects.Player;
import wit.cgd.warbirds.game.util.Constants;

public class EnemySimple extends AbstractEnemy{
	
	public EnemySimple(Level level) {
		super(level);
		init();
	}
	
	public void init() {
		dimension.set(1, 1);
		enemyType = "enemySimple";
		score = 2;

		// Center image on game object
		origin.set(dimension.x / 2, dimension.y / 2);
		timeShootDelay = 0;
		state = State.ACTIVE;
	}
	
	public void update(float deltaTime, Player player){
		super.update(deltaTime);
		if(health > 0){
			super.moveTowards(null);
			super.shootAt(null);
		}else{
			if(state == State.ACTIVE){
				state = State.DYING;
				animation = Assets.instance.enemySimple.animationDeath;
				setAnimation(animation);
			}
		}
	}

	@Override
	public void reset(){
		super.reset();
		health = Constants.ENEMY_SIMPLE_HEALTH;
		animation = Assets.instance.enemySimple.animationNormal;
		setAnimation(animation);
	}
}
