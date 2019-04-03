class SimuladoTernario {
	public static void main(String[] args){
		boolean c = false;
		String str = (c=!c) ? (c=!c) ? "Hello" : "hello" : (c=!c) ? "World":"world";
		System.out.println(str);
	}
}