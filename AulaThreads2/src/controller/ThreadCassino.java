package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCassino extends Thread{
	private int jogador;
	private Semaphore semaforo;
	Random rnd = new Random();
	static int pos=0;
	
	public ThreadCassino (int jogador, Semaphore semaforo) {
		this.jogador = jogador;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		jogaDado();
		try {
			semaforo.acquire();
			resultado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

	private void jogaDado() {
		try {
			int res=0,res1=0,num;
			while (res<5){				
			num =rnd.nextInt(13);
			if (num == 7 || num == 11) {
				res1 = res+1;
				res = res1;
			}
				}
			sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

					}
	
	private void resultado() {
		pos++;
		System.out.println("O jogador "+jogador+" foi o "+pos+"°");
		switch (pos) {
		case 1:System.out.println("O jogador "+jogador+" ganhou R$5000,00");
			break;
		case 2:System.out.println("O jogador "+jogador+" ganhou R$4000,00");
			break;
		case 3:System.out.println("O jogador "+jogador+" ganhou R$3000,00");
			break;
		}
	}
}
