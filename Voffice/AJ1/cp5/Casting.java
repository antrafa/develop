class Casting{
	public static void main(String[] args){
		int i = 127;
		byte b = (byte) i;

		System.out.println("Valor de i = " + i);
		System.out.println("Valor de b = " + b);

		i = 128;
		b = (byte) i;

		System.out.println("Valor de i = " + i);
		System.out.println("Valor de b = " + b);

		i = 129;
		b = (byte) i;

		System.out.println("Valor de i = " + i);
		System.out.println("Valor de b = " + b);
	}
}