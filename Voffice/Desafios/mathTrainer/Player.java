public class Player {
	
	int levelAnterior = 0, level = 1, score = 0;

	public void increaseScore(qt){
		this.score += qt;
	}

	public int getScore(){
		return this.score;
	}

	public void increaseLevel(qt){
		this.level += qt;
	}

	public int getLevel(){
		return this.level;
	}

	public void setLevelAnterior(lv){
		this.levelAnterior = lv;
	}

	public int getLevelAnterior(){
		return this.levelAnterior;
	}

}