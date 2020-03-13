package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread {

	private int id;
	private Semaphore semaforo;
	static int qtd = 100;
	boolean morre;
	
	public ThreadSemaforo(int id, Semaphore semaforo) {
	
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
	
		login();
		if (morre == false) {
			compra();
			if ( morre == false) {
				try {
					semaforo.acquire();
					validacao();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			}
		}
		
	}

	private void login() {
		
		int rdn = (int) ((Math.random()*1950)+50);
		if (rdn < 1000) {
			System.out.println("LOGIN NÂO CONCLUIDO " + id);
			morre = true;
		} 
	}

	private void compra() {

		int rdn = (int) ((Math.random()*2000)+1000);
		if (rdn < 2500) {
			System.out.println("Final de tempo de sessão " + id);
			morre = true;
		} 
	}

	private void validacao() {

		int rdn = (int) ((Math.random()*3)+1);
		if (qtd == 0) {
			
		} else {
			
			if (!(qtd < rdn)) {
				
				qtd = qtd - rdn;
				System.out.println("Foram vendidos " + rdn +
				" de ingressos para o comprador "+ id+ " e sobraram "+qtd);
				
			} else {
				
				System.out.println("O comprador " + id + " tentou comprar " + rdn +
					" ingressos mas não conseguiu");
			}
		}
	}
	
}
