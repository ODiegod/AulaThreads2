package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCassino;


public class Cassinao {
		public static void main(String[] args) {
			int permissoes =1;
			Semaphore semaforo = new Semaphore(permissoes);
			for (int i=0; i<10;i++) {
				Thread jog = new ThreadCassino(i,semaforo);
				jog.start();
			}
}
}
