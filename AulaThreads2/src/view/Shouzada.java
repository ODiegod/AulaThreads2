package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSemaforo;

public class Shouzada {

	public static void main(String[] args) {
		int permissao =1;
		Semaphore semaforo = new Semaphore(permissao);
		for(int id = 0; id<=300; id++) {
			
			Thread thread = new ThreadSemaforo(id, semaforo);
			thread.start();
		}
	}
}
